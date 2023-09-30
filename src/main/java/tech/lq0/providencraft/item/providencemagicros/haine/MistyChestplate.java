package tech.lq0.providencraft.item.providencemagicros.haine;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.ArmorTool;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MistyChestplate extends ArmorItem {
    public static final String TAG_SET = "Set";
    public static final String TAG_SHIELD = "Shield";

    public MistyChestplate() {
        super(ModArmorMaterial.MAGICROS, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup).isImmuneToFire().setNoRepair()
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(new TranslationTextComponent("des.providencraft.misty_chestplate_1").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("des.providencraft.misty_chestplate_2").mergeStyle(TextFormatting.GRAY));
        if (hasArmorSet(stack)) {
            tooltip.add(new TranslationTextComponent("des.providencraft.magicros_set").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#E2B578"))));
        }

        TooltipTool.addLiverInfo(tooltip, Livers.HAINE);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            setArmorSet(stack, player);
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isRemote) {
            //生成护盾
            int maxCount = hasArmorSet(stack) ? 2 : 1;

            if (getShieldCount(stack) < maxCount) {
                if (player.ticksExisted % 20 == 0) {
                    setShieldTime(player, Math.min(getShieldTime(player) + 1, 60));
                }
            } else {
                setShieldTime(player, 0);

                if (getShieldCount(stack) > maxCount) {
                    setShieldCount(stack, maxCount);
                }
            }

            if (getShieldTime(player) >= 60) {
                setShieldTime(player, 0);
                setShieldCount(stack, getShieldCount(stack) + 1);
            }

            //空中抗性
            if (!player.isOnGround()) {
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 40, hasArmorSet(stack) ? 1 : 0, false, false));
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.MISTY_CHESTPLATE.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "pdc armor modifier", 7.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "pdc armor modifier", 20.0f + getShieldCount(stack) * 10.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "pdc armor modifier", hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @SubscribeEvent
    public static void mistyChestplateEvent(LivingDamageEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        ItemStack itemStack = livingEntity.getItemStackFromSlot(EquipmentSlotType.CHEST);
        float damage = event.getAmount();

        DamageSource source = event.getSource();

        if (!livingEntity.world.isRemote) {
            if (livingEntity instanceof PlayerEntity && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.MISTY_CHESTPLATE.get())) {

                if (source.isProjectile()) {
                    double rand = Math.random();

                    if (rand < .17) {
                        event.setCanceled(true);
                        return;
                    }
                }

                int maxDamage = hasArmorSet(itemStack) ? 8 : 5;

                int count = ItemNBTTool.getInt(itemStack, TAG_SHIELD, 0);

                if (count > 0) {
                    if (damage <= maxDamage) {
                        event.setCanceled(true);
                        return;
                    } else {
                        setShieldCount(itemStack, --count);
                    }
                }

                System.out.println(damage + " count= " + count);
            }
        }
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    public static void setArmorSet(ItemStack stack, PlayerEntity player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    public static void setShieldCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_SHIELD, Math.max(0, Math.min(hasArmorSet(stack) ? 2 : 1, count)));
    }

    public static int getShieldCount(ItemStack stack) {
        return Math.min(hasArmorSet(stack) ? 2 : 1, ItemNBTTool.getInt(stack, TAG_SHIELD, 0));
    }

    public static void setShieldTime(PlayerEntity player, int time) {
        player.getPersistentData().putInt("MistyTime", time);
    }

    public static int getShieldTime(PlayerEntity player) {
        return player.getPersistentData().getInt("MistyTime");
    }
}
