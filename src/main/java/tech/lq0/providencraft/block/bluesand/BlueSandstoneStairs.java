package tech.lq0.providencraft.block.bluesand;

import net.minecraft.block.StairsBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import tech.lq0.providencraft.init.BlockRegistry;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BlueSandstoneStairs extends StairsBlock {
    public BlueSandstoneStairs(){
        super(() -> BlockRegistry.BLUE_SANDSTONE.get().getDefaultState(), Properties.from(BlockRegistry.BLUE_SANDSTONE.get()));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.blue_sandstone_stairs")).mergeStyle(TextFormatting.GRAY));
    }
}
