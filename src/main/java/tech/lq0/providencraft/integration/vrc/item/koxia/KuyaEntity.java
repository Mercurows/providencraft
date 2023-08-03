package tech.lq0.providencraft.integration.vrc.item.koxia;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;

public class KuyaEntity extends ProjectileItemEntity {
    private static final DataParameter<Integer> FUSE = EntityDataManager.createKey(KuyaEntity.class, DataSerializers.VARINT);
    private int fuse = 100;

    public KuyaEntity(EntityType<? extends KuyaEntity> type, World world){
        super(type, world);
    }

    public KuyaEntity(World world, LivingEntity entity){
        super(VirtuaRealCraftRegistry.KUYA_ENTITY.get(), entity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return VirtuaRealCraftRegistry.KUYA.get();
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FUSE, 80);
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
                explode(this);
            }
        } else {
            if (this.world.isRemote) {
                this.world.addParticle(ParticleTypes.FIREWORK, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(!world.isRemote) {
            if (result.getType() == RayTraceResult.Type.BLOCK) {
                BlockRayTraceResult blockResult = (BlockRayTraceResult) result;

                //From TaC
                Direction direction = blockResult.getFace();
                switch (direction.getAxis()) {
                    case X:
                        this.setMotion(this.getMotion().mul(-0.5, 0.75, 0.75));
                        break;
                    case Y:
                        this.setMotion(this.getMotion().mul(0.75, -0.25, 0.75));
                        if (this.getMotion().getY() < this.getGravityVelocity()) {
                            this.setMotion(this.getMotion().mul(1, 0, 1));
                        }
                        break;
                    case Z:
                        this.setMotion(this.getMotion().mul(0.75, 0.75, -0.5));
                        break;
                }
            } else {
                this.remove();
                explode(this);
            }
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
        explode(this);
    }

    public static void explode(Entity entity) {
        World world = entity.world;
        if(world.isRemote()) {
            return;
        }

        ((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, entity.getPosX(), entity.getPosY(), entity.getPosZ(), 10, 1.0D, 0.0D, 0.0D, 0.1);
        ((ServerWorld) world).spawnParticle(ParticleTypes.HEART, entity.getPosX(), entity.getPosY(), entity.getPosZ(), 30,3.0D, 3.0D, 3.0D, 0.2);

        entity.playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 2.0F, 1.0f);

        AreaEffectCloudEntity areaEffectCloud = new AreaEffectCloudEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ());
        areaEffectCloud.addEffect(new EffectInstance(Effects.SPEED, 100, 0));
        areaEffectCloud.addEffect(new EffectInstance(Effects.REGENERATION, 100, 2));
        areaEffectCloud.addEffect(new EffectInstance(Effects.INSTANT_HEALTH, 100, 0));
        areaEffectCloud.setRadius(10.0f);
        areaEffectCloud.setDuration(180);
        areaEffectCloud.setRadiusPerTick(-0.05f);

        world.addEntity(areaEffectCloud);
    }
}
