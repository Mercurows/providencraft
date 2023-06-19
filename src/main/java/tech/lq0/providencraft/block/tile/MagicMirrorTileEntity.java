package tech.lq0.providencraft.block.tile;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import tech.lq0.providencraft.init.TileEntityRegistry;

public class MagicMirrorTileEntity extends TileEntity implements ITickableTileEntity {
    public MagicMirrorTileEntity(){
        super(TileEntityRegistry.MAGIC_MIRROR.get());
    }

    @Override
    public void tick() {
        //TODO 编写魔镜TileEntity的传送功能
    }
}
