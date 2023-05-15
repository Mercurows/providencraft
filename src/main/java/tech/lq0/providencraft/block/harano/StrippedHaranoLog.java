package tech.lq0.providencraft.block.harano;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
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

public class StrippedHaranoLog extends RotatedPillarBlock {
    public StrippedHaranoLog(){
        super(Properties.create(Material.WOOD, (state) -> MaterialColor.RED_TERRACOTTA).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.stripped_harano_log")).mergeStyle(TextFormatting.GRAY));
    }
}
