package tech.lq0.providencraft.block.harano;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PressurePlateBlock;
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

public class HaranoPressurePlate extends PressurePlateBlock {
    public HaranoPressurePlate() {
        super(Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                .hardnessAndResistance(0.5f).doesNotBlockMovement().sound(SoundType.WOOD));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.harano_pressure_plate")).mergeStyle(TextFormatting.GRAY));
    }
}
