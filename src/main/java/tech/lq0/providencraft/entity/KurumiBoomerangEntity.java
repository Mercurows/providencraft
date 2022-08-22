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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


public class KurumiBoomerangEntity extends AbstractArrowEntity {

    public KurumiBoomerangEntity(EntityType<? extends KurumiBoomerangEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public KurumiBoomerangEntity(World world, LivingEntity entity) {
        super(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), entity, world);
    }

    public KurumiBoomerangEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        if (entity instanceof LivingEntity) {
            float damage = 1.0f;
            if(entity instanceof PigEntity || entity instanceof PiglinEntity ||
                    entity instanceof PiglinBruteEntity || entity instanceof ZombifiedPiglinEntity ||
            entity instanceof HoglinEntity || entity instanceof ZoglinEntity){
                damage = 15.0f;
            }
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getEntity()), damage);
        }
    }

    @ParametersAreNonnullByDefault
    protected void onImpact(RayTraceResult p_70227_1_) {
        super.onImpact(p_70227_1_);
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
    protected ItemStack getArrowStack() {
        return ItemRegistry.KURUMI_BOOMERANG.get().getDefaultInstance();
    }
}
