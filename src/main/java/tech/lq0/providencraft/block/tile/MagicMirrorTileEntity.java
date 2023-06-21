package tech.lq0.providencraft.block.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import tech.lq0.providencraft.init.TileEntityRegistry;

import java.util.List;

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
        if(this.world != null) {
            if (world.getTileEntity(new BlockPos(teleportPosX, teleportPosY, teleportPosZ)) == null
                    || !(world.getTileEntity(new BlockPos(teleportPosX, teleportPosY, teleportPosZ)) instanceof MagicMirrorTileEntity)) {
                bind = false;
                return;
            }

            Direction direction = getBlockState().get(HorizontalBlock.HORIZONTAL_FACING);
            AxisAlignedBB axisAlignedBB = getPortalAABB();

            if (!bind) {
                return;
            }

            List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, axisAlignedBB);
            if (!world.isRemote) {
                for (ItemEntity item : items) {
                    BlockState aimBlockState = world.getBlockState(new BlockPos(teleportPosX, teleportPosY, teleportPosZ));
                    Direction aimDirection = aimBlockState.get(HorizontalBlock.HORIZONTAL_FACING);

                    item.setPosition(teleportPosX + 0.5f + aimDirection.getXOffset() * 0.3f,
                            teleportPosY + 0.8f, teleportPosZ + 0.5f + aimDirection.getZOffset() * 0.3f);
                    item.setMotion(aimDirection.getXOffset() * 0.2f, aimDirection.getYOffset() * 0.2f, aimDirection.getZOffset() * 0.2f);
                }
            }
        }

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

    private AxisAlignedBB getPortalAABB() {
        Direction direction = getBlockState().get(HorizontalBlock.HORIZONTAL_FACING);
        AxisAlignedBB aabb;

        if(direction == Direction.NORTH){
            aabb = new AxisAlignedBB(new Vector3d(pos.getX(), pos.getY() + 0.5, pos.getZ() + 0.5), new Vector3d(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 0.25));
        }else if(direction == Direction.SOUTH){
            aabb = new AxisAlignedBB(new Vector3d(pos.getX(), pos.getY() + 0.5, pos.getZ() + 0.5), new Vector3d(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 0.75));
        }else if(direction == Direction.EAST){
            aabb = new AxisAlignedBB(new Vector3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ()), new Vector3d(pos.getX() + 0.75, pos.getY() + 2, pos.getZ() + 1));
        }else {
            aabb = new AxisAlignedBB(new Vector3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ()), new Vector3d(pos.getX() + 0.25, pos.getY() + 2, pos.getZ() + 1));
        }
        return aabb;
    }
}
