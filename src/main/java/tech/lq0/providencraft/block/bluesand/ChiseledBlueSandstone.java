package tech.lq0.providencraft.block.bluesand;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class ChiseledBlueSandstone extends Block {
    public ChiseledBlueSandstone(){
        super(Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(0.8F));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.chiseled_blue_sandstone")).mergeStyle(TextFormatting.GRAY));
    }
}
