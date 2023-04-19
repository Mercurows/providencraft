package tech.lq0.providencraft.block.bluesand;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BlueSand extends SandBlock {
    public BlueSand(){
        super(6844335, AbstractBlock.Properties.create(Material.SAND, MaterialColor.BLUE_TERRACOTTA).hardnessAndResistance(0.5F).sound(SoundType.SAND));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.blue_sand")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.offset(facing));
        return plant.getBlock() == Blocks.CACTUS || plant.getBlock() == Blocks.DEAD_BUSH || plant.getBlock() == Blocks.SUGAR_CANE;
    }
}
