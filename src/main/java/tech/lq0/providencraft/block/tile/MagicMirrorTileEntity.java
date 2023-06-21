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
                    item.setPosition(teleportPosX - 0.5f + direction.getXOffset() * -0.3f,
                            teleportPosY + 0.8f, teleportPosZ - 0.5f + direction.getZOffset() * -0.3f);
                    item.setMotion(direction.getXOffset() * -0.3f, direction.getYOffset() * -0.3f, direction.getZOffset() * -0.3f);
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

    //TODO 修正魔镜的判定范围
    private AxisAlignedBB getPortalAABB() {
        Direction direction = getBlockState().get(HorizontalBlock.HORIZONTAL_FACING);
        AxisAlignedBB aabb;
        if(direction == Direction.NORTH){
            aabb = new AxisAlignedBB(pos.add(0, 0.5, 0.5), pos.add(1, 2, 0.75));
        }else if(direction == Direction.SOUTH){
            aabb = new AxisAlignedBB(pos.add(0, 0.5, 0.5), pos.add(1,2, 0.25));
        }else if(direction == Direction.EAST){
            aabb = new AxisAlignedBB(pos.add(0.5, 0.5, 0), pos.add(0.75, 2, 1));
        }else {
            aabb = new AxisAlignedBB(pos.add(-0.3125, 0.5, -1), pos.add(0.25, 2, 1));
        }

        return aabb;
    }
}
