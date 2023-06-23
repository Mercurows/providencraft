package tech.lq0.providencraft.block.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.init.TileEntityRegistry;

import java.util.List;

public class MagicMirrorTileEntity extends TileEntity implements ITickableTileEntity {
    private String dimension = "null";
    private int teleportPosX;
    private int teleportPosY;
    private int teleportPosZ;
    private boolean bind;

    public MagicMirrorTileEntity(){
        super(TileEntityRegistry.MAGIC_MIRROR.get());
    }

    @Override
    public void tick() {
        //TODO 修复跨维度传送的问题
        if(this.world != null) {
            if(world.isRemote){
                return;
            }

            String location = dimension;
            if(dimension.equals("null") || dimension.equals("")){
                return;
            }

            ResourceLocation resLocation = new ResourceLocation(location);
            RegistryKey<World> registryKey = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, resLocation);
            ServerWorld toWorld = ((ServerWorld) this.world).getServer().getWorld(registryKey);
            if(toWorld == null){
                return;
            }

            //检测传送位置是否存在魔镜
            if(world == toWorld) {
                if (world.getTileEntity(new BlockPos(teleportPosX, teleportPosY, teleportPosZ)) == null
                        || !(world.getTileEntity(new BlockPos(teleportPosX, teleportPosY, teleportPosZ)) instanceof MagicMirrorTileEntity)) {
                    setBind(false);
                    return;
                }
            }else {
                if (toWorld.getTileEntity(new BlockPos(teleportPosX, teleportPosY, teleportPosZ)) == null
                        || !(toWorld.getTileEntity(new BlockPos(teleportPosX, teleportPosY, teleportPosZ)) instanceof MagicMirrorTileEntity)) {
                    setBind(false);
                    return;
                }
            }

            AxisAlignedBB axisAlignedBB = getPortalAABB();

            if (!isBind()) {
                return;
            }

            List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, axisAlignedBB);
            if (!world.isRemote) {
                for (ItemEntity item : items) {
                    BlockState aimBlockState = toWorld.getBlockState(new BlockPos(teleportPosX, teleportPosY, teleportPosZ));
                    if(aimBlockState.getBlock() != BlockRegistry.MAGIC_MIRROR_BLOCK.get()){
                        return;
                    }
                    Direction aimDirection = aimBlockState.get(HorizontalBlock.HORIZONTAL_FACING);

                    if(!item.getTags().contains("providencraft_teleport")) {
                        item.addTag("providencraft_teleport");
                        if(toWorld != this.world){
                            System.out.println(toWorld.getDimensionKey().getLocation());
                            //TODO 修复跨维度传送问题

//                            item.changeDimension(toWorld);
                        }

                        item.setPosition(teleportPosX + 0.6f + aimDirection.getXOffset() * 0.3f,
                                teleportPosY + 1f, teleportPosZ + 0.6f + aimDirection.getZOffset() * 0.3f);
                        item.setMotion(aimDirection.getXOffset() * 0.2f, aimDirection.getYOffset() * 0.2f, aimDirection.getZOffset() * 0.2f);

                        new Object() {
                            private int ticks = 0;
                            private float waitTicks;

                            public void start(int waitTicks) {
                                this.waitTicks = waitTicks;
                                MinecraftForge.EVENT_BUS.register(this);
                            }

                            @SubscribeEvent
                            public void tick(TickEvent.ServerTickEvent event) {
                                if (event.phase == TickEvent.Phase.END) {
                                    this.ticks++;
                                    if (this.ticks >= this.waitTicks) {
                                        run();
                                    }
                                }
                            }

                            private void run() {
                                item.removeTag("providencraft_teleport");
                                MinecraftForge.EVENT_BUS.unregister(this);
                            }
                        }.start((int) 2);
                    }

                }
            }
        }

    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public BlockPos getTeleportPos() {
        markDirty();
        if(isBind()) {
            return new BlockPos(teleportPosX, teleportPosY, teleportPosZ);
        }else {
            return null;
        }
    }

    public void setTeleportPos(BlockPos teleportPos, String dimension) {
        this.teleportPosX = teleportPos.getX();
        this.teleportPosY = teleportPos.getY();
        this.teleportPosZ = teleportPos.getZ();
        this.dimension = dimension;
        markDirty();
    }

    public boolean isBind() {
        markDirty();
        return bind;
    }

    public void setBind(boolean bind) {
        this.bind = bind;
        markDirty();
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        teleportPosX = nbt.getInt("teleportPosX");
        teleportPosY = nbt.getInt("teleportPosY");
        teleportPosZ = nbt.getInt("teleportPosZ");
        bind = nbt.getBoolean("bind");
        dimension = nbt.getString("dimension");
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("teleportPosX", teleportPosX);
        compound.putInt("teleportPosY", teleportPosY);
        compound.putInt("teleportPosZ", teleportPosZ);
        compound.putBoolean("bind", bind);
        compound.putString("dimension", dimension);
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
