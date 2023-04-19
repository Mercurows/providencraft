package tech.lq0.providencraft.block.bluesand;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SlabBlock;
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

public class BlueSandstoneSlab extends SlabBlock {
    public BlueSandstoneSlab(){
        super(AbstractBlock.Properties.from(BlockRegistry.BLUE_SANDSTONE.get()));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.blue_sandstone_slab")).mergeStyle(TextFormatting.GRAY));
    }
}
