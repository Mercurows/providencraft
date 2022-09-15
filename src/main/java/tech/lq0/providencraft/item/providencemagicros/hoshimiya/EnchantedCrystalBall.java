package tech.lq0.providencraft.item.providencemagicros.hoshimiya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
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
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class EnchantedCrystalBall extends Item {
    public EnchantedCrystalBall() {
        super(new Properties().maxStackSize(1).rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            if (worldIn.isThundering()) {
                playerIn.sendStatusMessage(new TranslationTextComponent("crystal_ball_weather_thunder").mergeStyle(TextFormatting.YELLOW), true);
            } else if (worldIn.isRaining()) {
                playerIn.sendStatusMessage(new TranslationTextComponent("crystal_ball_weather_rain").mergeStyle(TextFormatting.AQUA), true);
            } else {
                playerIn.sendStatusMessage(new TranslationTextComponent("crystal_ball_weather_clear").mergeStyle(TextFormatting.GREEN), true);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity playerIn = (PlayerEntity) entityIn;
            if (worldIn.isThundering()) {
                playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 2,true,false));
                playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 300, 1,true,false));
                playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 0,true,false));
            } else if (worldIn.isRaining()) {
                playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 300, 1,true,false));
                playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 0,true,false));
            } else {
                playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 0,true,false));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("crystal_ball_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("enchanted_crystal_ball_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.EKIRA);
    }
}
