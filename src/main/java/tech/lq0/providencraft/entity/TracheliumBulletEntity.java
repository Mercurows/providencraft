package tech.lq0.providencraft.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.entity.boundingbox.BoundingBoxManager;
import tech.lq0.providencraft.entity.boundingbox.IHeadBox;
import tech.lq0.providencraft.tools.ExtendedEntityRayTraceResult;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class TracheliumBulletEntity extends Entity implements IEntityAdditionalSpawnData {
    private static final Predicate<Entity> PROJECTILE_TARGETS = input -> input != null && input.canBeCollidedWith() && !input.isSpectator();
    private static final Predicate<BlockState> IGNORE_LEAVES = input -> input != null && input.getBlock() instanceof LeavesBlock;


    protected LivingEntity shooter;
    protected int shooterId;
    protected EntitySize size;
    protected int maxLife;
    protected float bulletDamage;
    protected EffectInstance[] effectInstances;
    protected int bulletType;

    public TracheliumBulletEntity(EntityType<? extends Entity> type, World world){
        super(type, world);
    }

    public TracheliumBulletEntity(EntityType<? extends Entity> type, World world, LivingEntity shooter, int bulletType) {
        this(type, world);
        this.shooterId = shooter.getEntityId();
        this.shooter = shooter;
        this.size = new EntitySize(0.2f, 0.2f, false);
        this.maxLife = 600;
        this.bulletType = bulletType;

        Vector3d dir = this.getVectorFromRotation(shooter.rotationPitch, shooter.rotationYaw);
        double speed = 100.0;
        this.setMotion(dir.x * speed, dir.y * speed, dir.z * speed);
        this.updateHeading();

        double posX = shooter.lastTickPosX + (shooter.getPosX() - shooter.lastTickPosX) / 2.0;
        double posY = shooter.lastTickPosY + (shooter.getPosY() - shooter.lastTickPosY) / 2.0 + shooter.getEyeHeight();
        double posZ = shooter.lastTickPosZ + (shooter.getPosZ() - shooter.lastTickPosZ) / 2.0;
        this.setPosition(posX, posY, posZ);
    }

    //Forked from MrCrayfish and TaC
    public void updateHeading() {
        float f = MathHelper.sqrt(this.getMotion().getX() * this.getMotion().getX() + this.getMotion().getZ() * this.getMotion().getZ());
        this.rotationYaw = (float) (MathHelper.atan2(this.getMotion().getX(), this.getMotion().getZ()) * (180D / Math.PI));
        this.rotationPitch = (float) (MathHelper.atan2(this.getMotion().getY(), (double) f) * (180D / Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    private Vector3d getVectorFromRotation(float pitch, float yaw) {
        float f = MathHelper.cos(-yaw * 0.017453292F - (float) Math.PI);
        float f1 = MathHelper.sin(-yaw * 0.017453292F - (float) Math.PI);
        float f2 = -MathHelper.cos(-pitch * 0.017453292F);
        float f3 = MathHelper.sin(-pitch * 0.017453292F);
        return new Vector3d(f1 * f2, f3, f * f2);
    }

    @Override
    public void tick() {
        super.tick();
        this.updateHeading();

        if(!this.world.isRemote()) {
            Vector3d startVec = this.getPositionVec();
            Vector3d endVec = startVec.add(this.getMotion());
            RayTraceResult result = rayTraceBlocks(this.world, new RayTraceContext(startVec, endVec, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this), IGNORE_LEAVES);

            if(result.getType() != RayTraceResult.Type.MISS) {
                endVec = result.getHitVec();
            }

            List<EntityResult> hitEntities = null;

            EntityResult entityResult = this.findEntityOnPath(startVec, endVec);
            if(entityResult != null) {
                hitEntities = Collections.singletonList(entityResult);
            }

            if(hitEntities != null) {
                result = new ExtendedEntityRayTraceResult(entityResult);
                if(((EntityRayTraceResult) result).getEntity() instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) ((EntityRayTraceResult) result).getEntity();

                    if(this.shooter instanceof PlayerEntity && !((PlayerEntity) this.shooter).canAttackPlayer(player)) {
                        result = null;
                    }
                }
                if(result != null) {
                    this.onHit(result);
                }
            }
            else {
                this.onHit(result);
            }
        }

        double nextPosX = this.getPosX() + this.getMotion().getX();
        double nextPosY = this.getPosY() + this.getMotion().getY();
        double nextPosZ = this.getPosZ() + this.getMotion().getZ();
        this.setPosition(nextPosX, nextPosY, nextPosZ);

        if(this.ticksExisted >= this.maxLife) {
            this.remove();
        }
    }

    @Nullable
    protected EntityResult findEntityOnPath(Vector3d startVec, Vector3d endVec) {
        Vector3d hitVec = null;
        Entity hitEntity = null;
        boolean headshot = false;
        List<Entity> entities = this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox().expand(this.getMotion()).grow(1.0), PROJECTILE_TARGETS);
        double closestDistance = Double.MAX_VALUE;
        for(Entity entity : entities) {
            if(!entity.equals(this.shooter)) {
                EntityResult result = this.getHitResult(entity, startVec, endVec);
                if(result == null) {
                    continue;
                }

                Vector3d hitPos = result.getHitPos();
                double distanceToHit = startVec.distanceTo(hitPos);
                if(distanceToHit < closestDistance) {
                    hitVec = hitPos;
                    hitEntity = entity;
                    closestDistance = distanceToHit;
                    headshot = result.isHeadshot();
                }
            }
        }
        return hitEntity != null ? new EntityResult(hitEntity, hitVec, headshot) : null;
    }

    private void onHit(RayTraceResult result) {
        if(result instanceof BlockRayTraceResult) {
            BlockRayTraceResult blockRayTraceResult = (BlockRayTraceResult) result;
            if(blockRayTraceResult.getType() == RayTraceResult.Type.MISS) {
                return;
            }

            BlockPos pos = blockRayTraceResult.getPos();
            BlockState state = this.world.getBlockState(pos);
            Block block = state.getBlock();

            if(block.getRegistryName().getPath().contains("_button")) {
                return;
            }

            this.remove();
            return;
        }

        if(result instanceof ExtendedEntityRayTraceResult) {
            ExtendedEntityRayTraceResult entityRayTraceResult = (ExtendedEntityRayTraceResult) result;
            Entity entity = entityRayTraceResult.getEntity();
            if(entity.getEntityId() == this.shooterId) {
                return;
            }

            if(!entity.isAlive()) {
                entity.hurtResistantTime = 0;
            } else if(entity.isAlive()) {
                this.onHitEntity(entity, entityRayTraceResult.isHeadshot());

                this.remove();
                entity.hurtResistantTime = 0;
            }
        }
    }

    private static <T> T performRayTrace(RayTraceContext context, BiFunction<RayTraceContext, BlockPos, T> hitFunction, Function<RayTraceContext, T> missFactory) {
        Vector3d startVec = context.getStartVec();
        Vector3d endVec = context.getEndVec();
        if (!startVec.equals(endVec)) {
            double startX = MathHelper.lerp(-0.0000001, endVec.x, startVec.x);
            double startY = MathHelper.lerp(-0.0000001, endVec.y, startVec.y);
            double startZ = MathHelper.lerp(-0.0000001, endVec.z, startVec.z);
            double endX = MathHelper.lerp(-0.0000001, startVec.x, endVec.x);
            double endY = MathHelper.lerp(-0.0000001, startVec.y, endVec.y);
            double endZ = MathHelper.lerp(-0.0000001, startVec.z, endVec.z);
            int blockX = MathHelper.floor(endX);
            int blockY = MathHelper.floor(endY);
            int blockZ = MathHelper.floor(endZ);
            BlockPos.Mutable mutablePos = new BlockPos.Mutable(blockX, blockY, blockZ);
            T t = hitFunction.apply(context, mutablePos);
            if (t != null) {
                return t;
            }

            double deltaX = startX - endX;
            double deltaY = startY - endY;
            double deltaZ = startZ - endZ;
            int signX = MathHelper.signum(deltaX);
            int signY = MathHelper.signum(deltaY);
            int signZ = MathHelper.signum(deltaZ);
            double d9 = signX == 0 ? Double.MAX_VALUE : (double) signX / deltaX;
            double d10 = signY == 0 ? Double.MAX_VALUE : (double) signY / deltaY;
            double d11 = signZ == 0 ? Double.MAX_VALUE : (double) signZ / deltaZ;
            double d12 = d9 * (signX > 0 ? 1.0D - MathHelper.frac(endX) : MathHelper.frac(endX));
            double d13 = d10 * (signY > 0 ? 1.0D - MathHelper.frac(endY) : MathHelper.frac(endY));
            double d14 = d11 * (signZ > 0 ? 1.0D - MathHelper.frac(endZ) : MathHelper.frac(endZ));

            while (d12 <= 1.0D || d13 <= 1.0D || d14 <= 1.0D) {
                if (d12 < d13) {
                    if (d12 < d14) {
                        blockX += signX;
                        d12 += d9;
                    } else {
                        blockZ += signZ;
                        d14 += d11;
                    }
                } else if (d13 < d14) {
                    blockY += signY;
                    d13 += d10;
                } else {
                    blockZ += signZ;
                    d14 += d11;
                }

                T t1 = hitFunction.apply(context, mutablePos.setPos(blockX, blockY, blockZ));
                if (t1 != null) {
                    return t1;
                }
            }

        }
        return missFactory.apply(context);
    }

    private static BlockRayTraceResult rayTraceBlocks(World world, RayTraceContext context, Predicate<BlockState> ignorePredicate) {
        return performRayTrace(context, (rayTraceContext, blockPos) -> {
            BlockState blockState = world.getBlockState(blockPos);
            if(ignorePredicate.test(blockState)) return null;
            FluidState fluidState = world.getFluidState(blockPos);
            Vector3d startVec = rayTraceContext.getStartVec();
            Vector3d endVec = rayTraceContext.getEndVec();
            VoxelShape blockShape = rayTraceContext.getBlockShape(blockState, world, blockPos);
            BlockRayTraceResult blockResult = world.rayTraceBlocks(startVec, endVec, blockPos, blockShape, blockState);
            VoxelShape fluidShape = rayTraceContext.getFluidShape(fluidState, world, blockPos);
            BlockRayTraceResult fluidResult = fluidShape.rayTrace(startVec, endVec, blockPos);
            double blockDistance = blockResult == null ? Double.MAX_VALUE : rayTraceContext.getStartVec().squareDistanceTo(blockResult.getHitVec());
            double fluidDistance = fluidResult == null ? Double.MAX_VALUE : rayTraceContext.getStartVec().squareDistanceTo(fluidResult.getHitVec());
            return blockDistance <= fluidDistance ? blockResult : fluidResult;
        }, (rayTraceContext) -> {
            Vector3d Vector3d = rayTraceContext.getStartVec().subtract(rayTraceContext.getEndVec());
            return BlockRayTraceResult.createMiss(rayTraceContext.getEndVec(), Direction.getFacingFromVector(Vector3d.x, Vector3d.y, Vector3d.z), new BlockPos(rayTraceContext.getEndVec()));
        });
    }

    protected void onHitEntity(Entity entity, boolean headshot) {
        float damage = this.getDamage();
        if(headshot) {
            damage = this.getCriticalDamage(damage);
        }

        DamageSource source = new IndirectEntityDamageSource("trachelium_bullet", this, shooter).setProjectile().setDamageIsAbsolute();
        entity.attackEntityFrom(source, damage);

        if(entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (this.effectInstances != null) {
                for (EffectInstance instance : effectInstances) {
                    livingEntity.addPotionEffect(instance);
                }
            }
        }
    }

    @Nullable
    private EntityResult getHitResult(Entity entity, Vector3d startVec, Vector3d endVec) {
        double expandHeight = entity instanceof PlayerEntity && !entity.isCrouching() ? 0.0625 : 0.0;
        AxisAlignedBB boundingBox = entity.getBoundingBox();
        if(entity instanceof ServerPlayerEntity && this.shooter != null) {
            int ping = (int) Math.floor((((ServerPlayerEntity) this.shooter).ping / 1000.0) * 20.0 + 0.5);
            boundingBox = BoundingBoxManager.getBoundingBox((PlayerEntity) entity, ping);
        }
        boundingBox = boundingBox.expand(0, expandHeight, 0);

        Vector3d hitPos = boundingBox.rayTrace(startVec, endVec).orElse(null);
        Vector3d grownHitPos = boundingBox.grow(0.1, 0, 0.1).rayTrace(startVec, endVec).orElse(null);
        if(hitPos == null && grownHitPos != null) {
            RayTraceResult raytraceresult = rayTraceBlocks(this.world, new RayTraceContext(startVec, grownHitPos, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this), IGNORE_LEAVES);
            if(raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                return null;
            }
            hitPos = grownHitPos;
        }

        boolean headshot = false;
        if(entity instanceof LivingEntity) {
            IHeadBox<LivingEntity> headshotBox = (IHeadBox<LivingEntity>) BoundingBoxManager.getHeadshotBoxes(entity.getType());
            if(headshotBox != null) {
                AxisAlignedBB box = headshotBox.getHeadshotBox((LivingEntity) entity);
                if(box != null) {
                    box = box.offset(boundingBox.getCenter().x, boundingBox.minY, boundingBox.getCenter().z);
                    Optional<Vector3d> headshotHitPos = box.rayTrace(startVec, endVec);
                    if(!headshotHitPos.isPresent()) {
                        box = box.grow(0.1, 0, 0.1);
                        headshotHitPos = box.rayTrace(startVec, endVec);
                    }
                    if(headshotHitPos.isPresent() && (hitPos == null || headshotHitPos.get().distanceTo(hitPos) < 0.5)) {
                        hitPos = headshotHitPos.get();
                        headshot = true;
                    }
                }
            }
        }

        if(hitPos == null) {
            return null;
        }

        return new EntityResult(entity, hitPos, headshot);
    }

    public LivingEntity getShooter() {
        return shooter;
    }

    public void setShooter(LivingEntity shooter) {
        this.shooter = shooter;
    }

    public int getShooterId() {
        return shooterId;
    }

    public void setShooterId(int shooterId) {
        this.shooterId = shooterId;
    }

    public EntitySize getSize() {
        return size;
    }

    public void setSize(EntitySize size) {
        this.size = size;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public float getDamage() {
        float damage = this.getBulletDamage();
        damage *= ((float) this.getMaxLife() - (float) (this.ticksExisted - 1)) / (float) this.getMaxLife();
        return Math.max(0.0f,  damage);
    }

    public float getBulletDamage(){
        return this.bulletDamage;
    }

    public void setBulletDamage(float bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public EffectInstance[] getEffectInstances() {
        return effectInstances;
    }

    public void setEffectInstances(EffectInstance[] effectInstances) {
        this.effectInstances = effectInstances;
    }

    protected void teleportToHitPoint(RayTraceResult rayTraceResult) {
        Vector3d hitResult = rayTraceResult.getHitVec();
        this.setPosition(hitResult.x, hitResult.y, hitResult.z);
    }

    private float getCriticalDamage(float damage) {
        return damage * 2.0f;
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        this.maxLife = compound.getInt("MaxLife");
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("MaxLife", this.maxLife);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeInt(this.shooterId);
        buffer.writeVarInt(this.maxLife);
        buffer.writeInt(this.bulletType);
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {
        this.shooterId = additionalData.readInt();
        this.maxLife = additionalData.readVarInt();
        this.bulletType = additionalData.readInt();
        this.size = new EntitySize(0.5f, 0.5f, false);
    }

    //Forked from MrCrayfish
    public static class EntityResult {
        private Entity entity;
        private Vector3d hitVec;
        private boolean headshot;

        public EntityResult(Entity entity, Vector3d hitVec, boolean headshot) {
            this.entity = entity;
            this.hitVec = hitVec;
            this.headshot = headshot;
        }

        public Entity getEntity() {
            return this.entity;
        }

        public Vector3d getHitPos() {
            return this.hitVec;
        }

        public boolean isHeadshot() {
            return this.headshot;
        }
    }
}
