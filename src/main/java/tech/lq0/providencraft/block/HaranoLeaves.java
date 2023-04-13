package tech.lq0.providencraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HaranoLeaves extends LeavesBlock {
    public HaranoLeaves(){
        super(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F)
                .tickRandomly().sound(SoundType.PLANT).notSolid());
    }
}
