package tech.lq0.providencraft.block.harano;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
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

public class HaranoTrapDoor extends TrapDoorBlock {
    public HaranoTrapDoor(){
        super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.RED_TERRACOTTA).hardnessAndResistance(3.0F)
                .sound(SoundType.WOOD).notSolid().setAllowsSpawn((state, reader, pos, entityType) -> false));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.harano_trapdoor")).mergeStyle(TextFormatting.GRAY));
    }
}
