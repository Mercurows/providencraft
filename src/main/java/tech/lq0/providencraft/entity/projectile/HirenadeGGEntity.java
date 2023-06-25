package tech.lq0.providencraft.entity.projectile;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SExplosionPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.particle.TentacleParticleData;

import java.awt.*;

public class HirenadeGGEntity extends ProjectileItemEntity {
    private static final DataParameter<Integer> FUSE = EntityDataManager.createKey(HirenadeGGEntity.class, DataSerializers.VARINT);
    private int fuse = 12000;

    public HirenadeGGEntity(EntityType<? extends HirenadeGGEntity> type, World world){
        super(type, world);
    }

    public HirenadeGGEntity(World world, LivingEntity entity){
        super(EntityRegistry.HIRENADE_GG_ENTITY.get(), entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.HIRENADE_GG.get().asItem();
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FUSE, 12000);
    }

    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    public void tick() {
        super.tick();
        --this.fuse;
        if (this.fuse <= 0) {
            this.remove();
            if (!this.world.isRemote) {
                explode(this, 5.0f);
            }
        } else {
            if (this.world.isRemote && this.ticksExisted % 4 == 0) {
                this.world.addParticle(new TentacleParticleData(new Vector3d(0.0f, 0.0f, 0.0f),
                                new Color(255, 255, 255, 50), 0.3f),
                        this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(!world.isRemote) {
            this.remove();
            explode(this, 5.0f);
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        this.setFuse(compound.getShort("Fuse"));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putShort("Fuse", (short)this.getFuse());
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        PacketBuffer pack = new PacketBuffer(Unpooled.buffer());
        pack.writeDouble(getPosX());
        pack.writeDouble(getPosY());
        pack.writeDouble(getPosZ());
        pack.writeInt(getEntityId());
        pack.writeUniqueId(getUniqueID());

        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public int getFuse() {
        return fuse;
    }

    public void setFuse(int fuse) {
        this.fuse = fuse;
    }

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        explode(this, 5.0f);
    }

    public static void explode(Entity entity, float radius) {
        World world = entity.world;
        if(world.isRemote()) {
            return;
        }

        Explosion explosion = new Explosion(world, entity, null, null, entity.getPosX(), entity.getPosY(), entity.getPosZ(), radius, false, Explosion.Mode.NONE);

        if(net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion)) {
            return;
        }

        explosion.doExplosionA();
        explosion.doExplosionB(true);

        explosion.clearAffectedBlockPositions();

        for(ServerPlayerEntity player : ((ServerWorld) world).getPlayers()) {
            if(player.getDistanceSq(entity.getPosX(), entity.getPosY(), entity.getPosZ()) < 1024) {
                player.connection.sendPacket(new SExplosionPacket(entity.getPosX(), entity.getPosY(), entity.getPosZ(), radius, explosion.getAffectedBlockPositions(), explosion.getPlayerKnockbackMap().get(player)));
            }
        }
    }

}
