package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;


public class WaterCardEntity extends ProjectileItemEntity {
    private int strength = 1;

    public WaterCardEntity(EntityType<? extends WaterCardEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public WaterCardEntity(World world, LivingEntity entity) {
        super(EntityRegistry.WATER_CARD_ENTITY.get(), entity, world);
    }

    public WaterCardEntity(World world, LivingEntity entity, int strength) {
        super(EntityRegistry.WATER_CARD_ENTITY.get(), entity, world);
        this.strength = strength;
    }


    public WaterCardEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.WATER_CARD_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (result.getType() == RayTraceResult.Type.ENTITY && func_234616_v_() != null) {
            Entity entity = result.getEntity();
            if (!Objects.equals(entity, this.func_234616_v_()) && entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                if (!(livingEntity instanceof ArmorStandEntity)) {
                    livingEntity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 1.0f);
                    Vector3d vector3d = this.getMotion().mul(1.0D, 0.0D, 1.0D).normalize().scale(2.0D * this.strength);
                    if (vector3d.lengthSquared() > 0.0D) {
                        livingEntity.addVelocity(vector3d.x, 0.1D, vector3d.z);
                    }
                }
            }
        }
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
        return ItemRegistry.DUEL_WATER_GUN.get().asItem();
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
