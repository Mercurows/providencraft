package tech.lq0.providencraft.block.tile;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.lq0.providencraft.init.TileEntityRegistry;

public class MagicMirrorTileEntity extends TileEntity implements ITickableTileEntity {
    private RegistryKey<World> registryKey;
    private int teleportPosX;
    private int teleportPosY;
    private int teleportPosZ;
    private boolean bind;

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
        if(isBind()) {
            return new BlockPos(teleportPosX, teleportPosY, teleportPosZ);
        }else {
            return null;
        }
    }

    public void setTeleportPos(BlockPos teleportPos) {
        this.teleportPosX = teleportPos.getX();
        this.teleportPosY = teleportPos.getY();
        this.teleportPosZ = teleportPos.getZ();
        setBind(true);
        markDirty();
    }

    public boolean isBind() {
        return bind;
    }

    public void setBind(boolean bind) {
        this.bind = bind;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        teleportPosX = nbt.getInt("teleportPosX");
        teleportPosY = nbt.getInt("teleportPosY");
        teleportPosZ = nbt.getInt("teleportPosZ");
        bind = nbt.getBoolean("bind");
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("teleportPosX", teleportPosX);
        compound.putInt("teleportPosY", teleportPosY);
        compound.putInt("teleportPosZ", teleportPosZ);
        compound.putBoolean("bind", bind);
        return super.write(compound);
    }
}
