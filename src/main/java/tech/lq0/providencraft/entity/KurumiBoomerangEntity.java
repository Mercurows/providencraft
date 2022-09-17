package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;


public class KurumiBoomerangEntity extends AbstractArrowEntity {

    private boolean dealtDamage;
    public int flyingTicks = 0, inGroundTicks = 0;

    public KurumiBoomerangEntity(EntityType<? extends KurumiBoomerangEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public KurumiBoomerangEntity(World world, LivingEntity entity) {
        super(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), entity, world);
    }

    public KurumiBoomerangEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @Override
    public void tick() {
        if (this.timeInGround > 1) {
            //first time hit ground
            if (!this.dealtDamage) {
                this.playSound(SoundRegistry.WHY_NOT_DIE.get(), 0.5F, 1.0F);
            }
            this.dealtDamage = true;
            inGroundTicks++;
        } else {
            flyingTicks++;
        }
        super.tick();
    }

    @Nullable
    @ParametersAreNonnullByDefault
    protected EntityRayTraceResult rayTraceEntities(Vector3d startVec, Vector3d endVec) {
        return this.dealtDamage ? null : super.rayTraceEntities(startVec, endVec);
    }

    @Override
    @Nullable
    protected SoundEvent getHitEntitySound() {
        return null;
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult rayTraceResult) {
        Entity target = rayTraceResult.getEntity();
        if (target instanceof LivingEntity) {
            float damage = 1.0f;
            if (target instanceof PigEntity || target instanceof PiglinEntity ||
                    target instanceof PiglinBruteEntity || target instanceof ZombifiedPiglinEntity ||
                    target instanceof HoglinEntity || target instanceof ZoglinEntity) {
                damage = 15.0f;
            }
            this.dealtDamage = true;
            Entity attacker = this.func_234616_v_() == null ? this : this.func_234616_v_();
            if (target.attackEntityFrom(DamageSource.causeThrownDamage(this, attacker), damage)) {
                if (target.getType() == EntityType.ENDERMAN) {
                    return;
                }
                this.arrowHit((LivingEntity) target);
            }
        }
        this.setMotion(this.getMotion().mul(-0.01D, -0.1D, -0.01D));
        this.playSound(SoundRegistry.HOW_HOLD_BLOOD.get(), 0.5F, 1.0F);
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

    @Override
    @Nonnull
    protected ItemStack getArrowStack() {
        return ItemRegistry.KURUMI_BOOMERANG.get().getDefaultInstance();
    }

    @ParametersAreNonnullByDefault
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        this.dealtDamage = compound.getBoolean("DealtDamage");
    }

    @ParametersAreNonnullByDefault
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("DealtDamage", this.dealtDamage);
    }

    @Override
    protected float getWaterDrag() {
        return 0.99F;
    }
}
