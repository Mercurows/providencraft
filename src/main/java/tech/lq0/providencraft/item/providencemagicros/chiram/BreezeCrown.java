package tech.lq0.providencraft.item.providencemagicros.chiram;

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
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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
public class BreezeCrown extends ArmorItem {
    public static final String TAG_HEALTH = "Health";
    public static final String TAG_SET = "Set";

    public BreezeCrown() {
        super(ModArmorMaterial.MAGICROS, EquipmentSlotType.HEAD, new Properties().group(ModGroup.itemgroup).isImmuneToFire().setNoRepair()
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(new TranslationTextComponent("des.providencraft.breeze_crown_1").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("des.providencraft.breeze_crown_2").mergeStyle(TextFormatting.GRAY));
        if (hasArmorSet(stack)) {
            tooltip.add(new TranslationTextComponent("des.providencraft.magicros_set").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#E2B578"))));
        }

        TooltipTool.addLiverInfo(tooltip, Livers.CHIRAM);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            setHealthAmount(stack, player);
            setArmorSet(stack, player);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.BREEZE_CROWN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "pdc armor modifier", 3.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, "pdc armor modifier", getAttackSpeedAmount(stack), AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "pdc armor modifier", hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    public static void setHealthAmount(ItemStack stack, PlayerEntity player) {
        ItemNBTTool.setFloat(stack, TAG_HEALTH, player.getHealth());
    }

    public static float getAttackSpeedAmount(ItemStack stack) {
        float times = hasArmorSet(stack) ? 0.025f : 0.02f;
        float max = hasArmorSet(stack) ? 1.5f : 1.0f;
        float min = hasArmorSet(stack) ? 0.4f : 0.2f;

        float spd = (getHealthAmount(stack) - 20) * times + min;
        return Math.min(max, Math.max(spd, min));
    }

    public static float getHealthAmount(ItemStack stack) {
        return ItemNBTTool.getFloat(stack, TAG_HEALTH, 0.0f);
    }

    public static void setArmorSet(ItemStack stack, PlayerEntity player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @SubscribeEvent
    public static void breezeCrownEvent(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        ItemStack itemStack = livingEntity.getItemStackFromSlot(EquipmentSlotType.HEAD);
        float damage = event.getAmount();

        if (damage > 0f) {
            if (!livingEntity.world.isRemote) {
                if (livingEntity instanceof PlayerEntity && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.BREEZE_CROWN.get())) {
                    PlayerEntity player = (PlayerEntity) livingEntity;
                    if (!player.getCooldownTracker().hasCooldown(ItemRegistry.BREEZE_CROWN.get())) {
                        int level = ArmorTool.hasArmorSet(player) ? 4 : 3;
                        int time = ArmorTool.hasArmorSet(player) ? 50 : 35;
                        player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 30, level, false, false));

                        player.hurtResistantTime = time;
                        player.getCooldownTracker().setCooldown(ItemRegistry.BREEZE_CROWN.get(), 160);
                    }
                }
            }
        }
    }
}
