package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
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
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;


public class SatouKnife extends SwordItem {
    public SatouKnife() {
        super(ItemTier.IRON, 0, -1.0f, new Properties().defaultMaxDamage(321).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;
            if (player.isSneaking() && !player.isCreative() && stack.getDamage() < stack.getMaxDamage() - 10) {
                stack.damageItem(10, player, (playerEntity) -> playerEntity.sendBreakAnimation(player.getActiveHand()));
                player.heal(2.0f);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity && isSelected) {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.isSneaking()) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 20, 3));
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 20, 0));
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 20, 3));
            }
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.satou_knife")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.satou_knife.func")).mergeStyle(TextFormatting.AQUA));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }
}
