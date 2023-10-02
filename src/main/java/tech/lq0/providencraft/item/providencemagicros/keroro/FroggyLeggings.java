package tech.lq0.providencraft.item.providencemagicros.keroro;

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
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FroggyLeggings extends ArmorItem {
    public static final String TAG_SET = "Set";

    public FroggyLeggings() {
        super(ModArmorMaterial.MAGICROS, EquipmentSlotType.LEGS, new Properties().group(ModGroup.itemgroup).isImmuneToFire().setNoRepair()
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(new TranslationTextComponent("des.providencraft.froggy_leggings_1").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("des.providencraft.froggy_leggings_2").mergeStyle(TextFormatting.GRAY));
        if (hasArmorSet(stack)) {
            tooltip.add(new TranslationTextComponent("des.providencraft.magicros_set").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#E2B578"))));
        }

        TooltipTool.addLiverInfo(tooltip, Livers.KERORO);
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
            setArmorSet(stack, player);

            boolean set = hasArmorSet(stack);

            if (player.isSneaking()) {
                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 40, set ? 2 : 1, false, false));
            }

            //净化
            if (player.isSwimming() || world.isRaining() || set) {
                int time = set ? 300 : 600;

                List<EffectInstance> effectList = new ArrayList<>(player.getActivePotionEffects());

                if (player.ticksExisted % time == 0) {
                    if (!effectList.isEmpty()) {
                        for (EffectInstance effectInstance : effectList) {
                            if (effectInstance.getPotion().getEffectType().equals(EffectType.HARMFUL)) {
                                player.removePotionEffect(effectInstance.getPotion());
                                break;
                            }
                        }
                    }
                }
            }

            //生命恢复
            if (player.isSwimming() || world.isRaining()) {
                if (player.ticksExisted % 40 == 0) {
                    player.heal(1);
                }

                player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 300, 0, false, false));
            }
        }
    }

    @SubscribeEvent
    public static void froggyJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();

        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            if (player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemRegistry.FROGGY_LEGGINGS.get()) {
                Vector3d base = player.getMotion().add(0, 0.275, 0);

                if (player.isSprinting()) {
                    float f1 = player.rotationYaw * ((float) Math.PI / 180F);
                    base = base.add(-MathHelper.sin(f1) * 0.45F, 0.0D, MathHelper.cos(f1) * 0.45F);
                }

                player.setMotion(base);
            }
        }
    }

    @SubscribeEvent
    public static void froggyDamage(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            ItemStack stack = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            String type = event.getSource().damageType;

            if (stack.getItem() == ItemRegistry.FROGGY_LEGGINGS.get()) {
                if (type.equals(DamageSource.FALL.damageType)) {
                    event.setCanceled(true);
                }

                if (hasArmorSet(stack)) {
                    if (type.equals(DamageSource.IN_FIRE.damageType) || type.equals(DamageSource.ON_FIRE.damageType)
                            || type.equals(DamageSource.LAVA.damageType) || type.equals(DamageSource.HOT_FLOOR.damageType)) {
                        event.setCanceled(true);
                    }
                }
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
        UUID uuid = new UUID(ItemRegistry.FROGGY_LEGGINGS.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "pdc armor modifier", 6.0f, AttributeModifier.Operation.ADDITION));
            map.put(ForgeMod.SWIM_SPEED.get(),
                    new AttributeModifier(uuid, "pdc armor modifier", 0.4f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "pdc armor modifier", hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
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
}
