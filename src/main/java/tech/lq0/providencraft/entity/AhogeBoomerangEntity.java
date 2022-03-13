package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;


public class AhogeBoomerangEntity extends ProjectileItemEntity {

   public AhogeBoomerangEntity(EntityType<? extends AhogeBoomerangEntity> p_i50159_1_, World p_i50159_2_) {
      super(p_i50159_1_, p_i50159_2_);
   }

   public AhogeBoomerangEntity(World world, LivingEntity entity) {
      super(EntityRegistry.AHOGE_BOOMERANG_ENTITY.get(), entity, world);
   }

   public AhogeBoomerangEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
      super(EntityRegistry.AHOGE_BOOMERANG_ENTITY.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
   }

   protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
      super.onEntityHit(p_213868_1_);
      Entity entity = p_213868_1_.getEntity();
      if(!(entity instanceof PlayerEntity)) {
         entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getEntity()), 10.0f);
      }
   }

   protected void onImpact(RayTraceResult p_70227_1_) {
      super.onImpact(p_70227_1_);
      if (!this.world.isRemote) {
         this.remove();
      }
   }

   @Override
   protected Item getDefaultItem() {
      return ItemRegistry.RED_AHOGE_BOOMERANG.get().asItem();
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
}
