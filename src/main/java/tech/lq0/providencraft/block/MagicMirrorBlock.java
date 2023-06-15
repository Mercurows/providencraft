package tech.lq0.providencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MagicMirrorBlock extends Block {
    public MagicMirrorBlock() {
        super(Properties.create(Material.GLASS).hardnessAndResistance(5.0f).sound(SoundType.GLASS));
    }
}
