package tech.lq0.providencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CommunicationTable extends Block {
    public CommunicationTable() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(2));
    }
}
