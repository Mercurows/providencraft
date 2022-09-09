package tech.lq0.providencraft.item.providenceOI.miya;

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
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class TailPen extends SwordItem {
    public TailPen() {
        super(ItemTier.WOOD, 8, -2.5f, new Properties().setNoRepair().defaultMaxDamage(723).rarity(Rarity.EPIC).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.TAIL_PEN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, "tail pen modifier", 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(uuid, "tail pen modifier", 0.5f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;
            int random = (int) (Math.random() * 99 + 1);
            if (random > 90) {
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
            } else if (random > 80) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 100, 2));
            } else if (random > 70) {
                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 2));
            } else if (random > 60) {
                target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300, 3));
            } else if (random > 50) {
                target.addPotionEffect(new EffectInstance(Effects.WITHER, 300, 3));
            } else if (random > 40) {
                target.addPotionEffect(new EffectInstance(Effects.POISON, 300, 3));
            } else if (random > 30) {
                target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 300, 3));
            } else if (random > 20) {
                target.addPotionEffect(target.isEntityUndead() ? new EffectInstance(Effects.INSTANT_HEALTH, 10, 3)
                        : new EffectInstance(Effects.INSTANT_DAMAGE, 10, 3));
            } else if (random > 10) {
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 100, 2));
            } else {
                player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100, 2));
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("tail_pen_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("tail_pen_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MIYA);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && stack.getDamage() < stack.getMaxDamage() && entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.ticksExisted % 20 == 0) {
                stack.damageItem(-1, player, (playerEntity) -> playerEntity.sendBreakAnimation(player.getActiveHand()));
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
