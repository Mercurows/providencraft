package tech.lq0.providencraft.block.tile;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.lq0.providencraft.init.TileEntityRegistry;

public class MagicMirrorTileEntity extends TileEntity implements ITickableTileEntity {
    private RegistryKey<World> registryKey;
    private BlockPos teleportPos;

    public MagicMirrorTileEntity(){
        super(TileEntityRegistry.MAGIC_MIRROR.get());
    }

    @Override
    public void tick() {
        //TODO 编写魔镜TileEntity的传送功能


    }

    public RegistryKey<World> getRegistryKey() {
        return registryKey;
    }

    public void setRegistryKey(RegistryKey<World> registryKey) {
        this.registryKey = registryKey;
    }

    public BlockPos getTeleportPos() {
        return teleportPos;
    }

    public void setTeleportPos(BlockPos teleportPos) {
        this.teleportPos = teleportPos;
    }
}
