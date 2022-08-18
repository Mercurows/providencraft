package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


public class DaifukuSyrupEntity extends ProjectileItemEntity {

    public DaifukuSyrupEntity(EntityType<? extends DaifukuSyrupEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public DaifukuSyrupEntity(World world, LivingEntity entity) {
        super(EntityRegistry.DAIFUKU_SYRUP_ENTITY.get(), entity, world);
    }

    public DaifukuSyrupEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.DAIFUKU_SYRUP_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        if (entity instanceof LivingEntity) {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getEntity()), 2.5f);
            int random = (int)(Math.random() * 10 + 1);
            if(random == 1){
                entity.setFire(10);
            }else{
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 9));
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
        return ItemRegistry.DAIFUKU_SYRUP.get().asItem();
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
