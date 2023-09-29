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
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

public class MistyChestplate extends ArmorItem {
    public static final String TAG_SET = "Set";
    public static final String TAG_SHIELD = "Shield";
    public static final String TAG_SHIELD_TIME = "ShieldTime";

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

            //生成护盾
            int maxCount = hasArmorSet(stack) ? 2 : 1;

            if (getShieldCount(stack) < maxCount) {
                if (player.ticksExisted % 20 == 0) {
                    setShieldTime(stack, Math.min(getShieldTime(stack) + 1, 60));
                }
            } else {
                setShieldTime(stack, 0);
            }

            if (getShieldTime(stack) >= 60) {
                setShieldTime(stack, 0);
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
                    new AttributeModifier(uuid, "pdc armor modifier", 10.0f + getShieldCount(stack) * 10.0f, AttributeModifier.Operation.ADDITION));
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

    public static void setShieldCount(ItemStack stack, int count) {
        ItemNBTTool.setInt(stack, TAG_SHIELD, Math.max(0, count));
    }

    public static int getShieldCount(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_SHIELD, 0);
    }

    public static void setShieldTime(ItemStack stack, int time) {
        ItemNBTTool.setInt(stack, TAG_SHIELD_TIME, time);
    }

    public static int getShieldTime(ItemStack stack) {
        return ItemNBTTool.getInt(stack, TAG_SHIELD_TIME, 0);
    }
}
