package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShieldItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Hayamen extends ShieldItem {
    public Hayamen() {
        super(new Properties().maxDamage(1520).group(ModGroup.itemgroup).setNoRepair().rarity(Rarity.RARE));
        DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("hayamen_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("hayamen_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("hayamen_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        playerIn.setActiveHand(handIn);
        if (playerIn.isSneaking() && itemstack.getDamage() < itemstack.getMaxDamage() - 100) {
            playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 400, 4));
            playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 400, 4));
            playerIn.addPotionEffect(new EffectInstance(Effects.SATURATION, 400, 1));
            itemstack.damageItem(100, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
        }

        return ActionResult.resultConsume(itemstack);
    }

}
