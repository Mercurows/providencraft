package tech.lq0.providencraft.item.providencemagicros.hoshimiya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class CrystalBall extends Item {
    public CrystalBall() {
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            if (worldIn.isThundering()) {
                playerIn.sendStatusMessage(new TranslationTextComponent("crystal_ball_weather_thunder").mergeStyle(TextFormatting.YELLOW), false);
            } else if (worldIn.isRaining()) {
                playerIn.sendStatusMessage(new TranslationTextComponent("crystal_ball_weather_rain").mergeStyle(TextFormatting.AQUA), false);
            } else {
                playerIn.sendStatusMessage(new TranslationTextComponent("crystal_ball_weather_clear").mergeStyle(TextFormatting.GREEN), false);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("crystal_ball_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("crystal_ball_des")).mergeStyle(TextFormatting.GRAY));
    }
}
