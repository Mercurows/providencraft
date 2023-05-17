package tech.lq0.providencraft.entity.projectile;

import io.netty.buffer.Unpooled;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


public class ShuRinoKenEntity extends ProjectileItemEntity {
    private static final DataParameter<Integer> MAX_TIME = EntityDataManager.createKey(ShuRinoKenEntity.class, DataSerializers.VARINT);
    private int maxTime = 200;

    public ShuRinoKenEntity(EntityType<? extends ShuRinoKenEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public ShuRinoKenEntity(World world, LivingEntity entity) {
        super(EntityRegistry.SHU_RINO_KEN_ENTITY.get(), entity, world);
    }

    public ShuRinoKenEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.SHU_RINO_KEN_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        if (entity instanceof LivingEntity) {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 6.0f);
            entity.hurtResistantTime = 0;
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(MAX_TIME, 200);
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        this.setMaxTime(compound.getShort("MaxTime"));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putShort("MaxTime", (short)this.getMaxTime());
    }

    @Override
    public void tick() {
        super.tick();
        --this.maxTime;
        if(this.getMaxTime() <= 0){
            this.remove();
        }else {
            if (this.world.isRemote) {
                this.world.addParticle(ParticleTypes.CRIT, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @ParametersAreNonnullByDefault
    protected void onImpact(RayTraceResult p_70227_1_) {
        super.onImpact(p_70227_1_);
        if (!this.world.isRemote) {
            this.remove();
        }
    }

    @Override
    @Nonnull
    protected Item getDefaultItem() {
        return ItemRegistry.SHU_RINO_KEN.get().asItem();
    }

    @Override
    @Nonnull
    public IPacket<?> createSpawnPacket() {
        PacketBuffer pack = new PacketBuffer(Unpooled.buffer());
        pack.writeDouble(getPosX());
        pack.writeDouble(getPosY());
        pack.writeDouble(getPosZ());
        pack.writeInt(getEntityId());
        pack.writeUniqueId(getUniqueID());

        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
