package tech.lq0.providencraft.item.providencefirst.ayelet;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
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

public class SleepRoulette extends Item {
    public SleepRoulette() {
        super(new Properties().group(ModGroup.itemgroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote && !worldIn.isDaytime()) {
            int random = (int) (Math.random() * 10) + 1;
            if (random > 6) {
                playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 1200, 2));
                playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 1200, 2));
                playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1200, 2));
                playerIn.sendStatusMessage(new TranslationTextComponent("des.providencraft.sleep_roulette.awake").mergeStyle(TextFormatting.GOLD), true);
            } else {
                playerIn.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 1200, 0));
                playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1200, 0));
                playerIn.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 1200, 0));
                playerIn.sendStatusMessage(new TranslationTextComponent("des.providencraft.sleep_roulette.asleep").mergeStyle(TextFormatting.GRAY), true);
            }
            playerIn.getCooldownTracker().setCooldown(itemStack.getItem(), 1800);
            return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
        }
        return new ActionResult<>(ActionResultType.FAIL, itemStack);
    }


    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.sleep_roulette.func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("des.providencraft.sleep_roulette_1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.sleep_roulette_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.sleep_roulette_3")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.sleep_roulette_4")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.AYELET);
    }
}
