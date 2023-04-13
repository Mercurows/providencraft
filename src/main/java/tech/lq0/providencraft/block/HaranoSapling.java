package tech.lq0.providencraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import tech.lq0.providencraft.block.trees.HaranoTree;

public class HaranoSapling extends SaplingBlock {
    public HaranoSapling(){
        super(new HaranoTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT));
    }
}
