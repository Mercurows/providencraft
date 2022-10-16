package tech.lq0.providencraft.entity;

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
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;


public class GoodManCardEntity extends ProjectileItemEntity {
    private static final DataParameter<Integer> CARD_TYPE = EntityDataManager.createKey(GoodManCardEntity.class, DataSerializers.VARINT);

    private int type;

    public GoodManCardEntity(EntityType<? extends GoodManCardEntity> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
        this.dataManager.register(CARD_TYPE, 0);
        setCardType(0);
    }


    public GoodManCardEntity(World world, LivingEntity entity, int type) {
        super(EntityRegistry.GOOD_MAN_CARD_ENTITY.get(), entity, world);
        this.dataManager.register(CARD_TYPE, type);
        setCardType(type);
    }

    @ParametersAreNonnullByDefault
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        if (entity instanceof LivingEntity) {
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), CardType.getById(this.type).getDamage());
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
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("type", this.type);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setCardType(compound.getInt("type"));
    }

    public int getCardType() {
        return this.dataManager.get(CARD_TYPE);
    }

    public void setCardType(int type) {
        type = type > 4 || type < 0 ? 0 : type;
        this.type = type;
        this.dataManager.set(CARD_TYPE, type);
    }

    @Override
    @Nonnull
    protected Item getDefaultItem() {
        return ItemRegistry.GOOD_MAN_CARD.get();
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

    public enum CardType {
        GOLD("gold", 3),
        DIAMOND("diamond", 7),
        EMERALD("emerald", 12),
        RED("red", 18),
        RAINBOW("rainbow", 50);

        private final String name;
        private final int damage;

        CardType(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public static CardType getById(int id) {
            CardType[] types = values();
            if (id < 0 || id >= types.length) {
                id = 0;
            }
            return types[id];
        }
    }
}
