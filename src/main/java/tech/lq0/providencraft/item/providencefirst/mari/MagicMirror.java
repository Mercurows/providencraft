package tech.lq0.providencraft.item.providencefirst.mari;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
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

public class MagicMirror extends Item {
    public MagicMirror() {
        super(new Properties().group(ModGroup.itemgroup).maxDamage(136));
    }

    private final Effect[][] EFFECT = {
            {Effects.STRENGTH, Effects.WEAKNESS},
            {Effects.SPEED, Effects.SLOWNESS},
            {Effects.SLOW_FALLING, Effects.LEVITATION},
            {Effects.NIGHT_VISION, Effects.NAUSEA},
            {Effects.HASTE, Effects.MINING_FATIGUE},
            {Effects.SATURATION, Effects.HUNGER},
            {Effects.INVISIBILITY, Effects.BLINDNESS},
            {Effects.REGENERATION, Effects.WITHER}
    };

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        for (Effect[] effect : EFFECT) {
            if (playerIn.isPotionActive(effect[0])) {
                playerIn.removePotionEffect(effect[0]);
                playerIn.addPotionEffect(new EffectInstance(effect[1], 600, 1));
            } else if (playerIn.isPotionActive(effect[1])) {
                playerIn.removePotionEffect(effect[1]);
                playerIn.addPotionEffect(new EffectInstance(effect[0], 600, 1));
            }
        }
        playerIn.getCooldownTracker().setCooldown(itemStack.getItem(), 100);
        itemStack.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));

        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_mirror_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_mirror_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MARI);
    }
}
