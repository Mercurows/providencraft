package tech.lq0.providencraft.entity.projectile;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


public class BloodCrystalEntity extends ProjectileItemEntity {

    public BloodCrystalEntity(EntityType<? extends BloodCrystalEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public BloodCrystalEntity(World world, LivingEntity entity) {
        super(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), entity, world);
    }

    public BloodCrystalEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        Entity entity = p_213868_1_.getEntity();
        if (entity instanceof LivingEntity) {
            if(entity instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) entity;
                Entity shooter = this.func_234616_v_();
                if(shooter != null) {
                    if (player.isOnSameTeam(shooter)) {
                        player.heal(4.0f);
                    } else if(player.getTeam() == null && shooter.getTeam() == null){
                        player.heal(4.0f);
                    } else {
                        player.attackEntityFrom(new IndirectEntityDamageSource("blood_crystal", player, shooter).setProjectile(), 4.0f);
                        player.hurtResistantTime = 0;
                    }
                }else {
                    player.attackEntityFrom(DamageSourceRegistry.BLOOD_CRYSTAL, 4.0f);
                    player.hurtResistantTime = 0;
                }
            }
            else {
                entity.attackEntityFrom(new IndirectEntityDamageSource("blood_crystal", entity, this.func_234616_v_()).setProjectile(), 4.0f);
                entity.hurtResistantTime = 0;
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
        return ItemRegistry.WORLD_PEACE_STAFF.get().asItem();
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
