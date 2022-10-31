package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nullable;
import java.util.List;

// TODO 实现妮头车创人功能
public class NiitCarEntity extends Entity {

    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYaw;
    private double lerpPitch;
    private int lerpSteps;
    private float deltaRotation;
    private float momentum;
    private boolean leftInputDown;
    private boolean rightInputDown;
    private boolean forwardInputDown;
    private boolean backInputDown;

    public NiitCarEntity(EntityType<? extends Entity> type, World worldIn) {
        super(type, worldIn);
        this.stepHeight = 1.0F;

    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            prevPosX = getPosX();
            prevPosY = getPosY();
            prevPosZ = getPosZ();
        }

        super.tick();
        tickLerp();

        if (this.canPassengerSteer()) {
            updateMotion();
            if (world.isRemote) {
                controlCar();
            }
            move(MoverType.SELF, getMotion());
            doBlockCollisions();
        } else {
            setMotion(Vector3d.ZERO);
        }

//        {
//            //开创
//            List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox().grow(2F, -0.01F, 2F), (e) -> true);
//            if (!list.isEmpty()) {
//                for (Entity entity : list) {
//                    if (!entity.isPassenger(this)) {
//                        if (entity instanceof NiitCarEntity) {
//                            if (entity.getBoundingBox().minY < this.getBoundingBox().maxY) {
//                                super.applyEntityCollision(entity);
//                            }
//                        } else {
//                            //super.applyEntityCollision(entity);
//                            if (!this.isRidingSameEntity(entity)) {
//                                if (!entity.noClip && !this.noClip) {
//                                    double d0 = entity.getPosX() - this.getPosX();
//                                    double d1 = entity.getPosZ() - this.getPosZ();
//                                    double d2 = MathHelper.absMax(d0, d1);
//                                    if (d2 >= (double) 0.01F) {
//                                        d2 = MathHelper.sqrt(d2);
//                                        d0 = d0 / d2;
//                                        d1 = d1 / d2;
//                                        double d3 = 1.0D / d2;
//                                        if (d3 > 1.0D) {
//                                            d3 = 1.0D;
//                                        }
//
//                                        d0 = d0 * d3;
//                                        d1 = d1 * d3;
//                                        d0 = d0 * (double) 0.05F;
//                                        d1 = d1 * (double) 0.05F;
//                                        d0 = d0 * (double) (1.0F - this.entityCollisionReduction);
//                                        d1 = d1 * (double) (1.0F - this.entityCollisionReduction);
//
//                                        if (!entity.isBeingRidden()) {
//                                            entity.addVelocity(d0 + getPosX() - lastTickPosX, 0.0D, d1 + getPosZ() - lastTickPosZ);
//                                        }
//                                    }
//
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }

        //读取键盘输入
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null) {
            Entity riding = player.getRidingEntity();
            if (riding == this) {
                updateInputs(player.movementInput.leftKeyDown, player.movementInput.rightKeyDown, player.movementInput.forwardKeyDown, player.movementInput.backKeyDown);
            }
        }
    }

    public double getSpeed() {
        float motX = (float) ((getPosX() - lastTickPosX) * 20);
        float motZ = (float) ((getPosZ() - lastTickPosZ) * 20);
        return Math.sqrt(motX * motX + motZ * motZ) * 3.6;
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : list.get(0);
    }

    private void controlCar() {
        if (this.isBeingRidden()) {
            float f = 0.0F;
            if (this.leftInputDown) {
                this.deltaRotation -= 1;
            }

            if (this.rightInputDown) {
                this.deltaRotation += 1;
            }

            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown) {
                f += 0.0F;
            }

            this.rotationYaw += this.deltaRotation;
            if (this.forwardInputDown) {
                if (Minecraft.getInstance().player != null && Minecraft.getInstance().player.isSprinting()) {
                    f += 0.1666666666666666666;
                } else {
                    f += 0.0833333333333333333;
                }
            }

            if (this.backInputDown) {
                f -= 0.02F;
            }

            this.setMotion(this.getMotion().add(MathHelper.sin(-this.rotationYaw * ((float) Math.PI / 180F)) * f, 0.0D, MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F)) * f));
        }
    }


    private void updateMotion() {
        double gravity = this.hasNoGravity() ? 0.0D : (double) -0.06F;

        this.momentum = 0.85F;

        Vector3d vector3d = this.getMotion();
        this.setMotion(vector3d.x * momentum, vector3d.y + gravity, vector3d.z * momentum);
        this.deltaRotation *= momentum;
    }


    @Override
    public boolean canCollide(Entity entity) {
        return (entity.canBeCollidedWith() || entity.canBePushed()) && !isPassenger(entity);
    }

    @Override
    public PushReaction getPushReaction() {
        return PushReaction.IGNORE;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    @Override
    public void applyEntityCollision(Entity entityIn) {
        if (entityIn instanceof NiitCarEntity) {
            if (entityIn.getBoundingBox().minY < this.getBoundingBox().maxY) {
                super.applyEntityCollision(entityIn);
            }
        } else if (entityIn.getBoundingBox().minY <= this.getBoundingBox().minY) {
            super.applyEntityCollision(entityIn);
        }
    }

    private void tickLerp() {
        if (this.canPassengerSteer()) {
            this.lerpSteps = 0;
            this.setPacketCoordinates(this.getPosX(), this.getPosY(), this.getPosZ());
        }

        if (this.lerpSteps > 0) {
            double d0 = this.getPosX() + (this.lerpX - this.getPosX()) / (double) this.lerpSteps;
            double d1 = this.getPosY() + (this.lerpY - this.getPosY()) / (double) this.lerpSteps;
            double d2 = this.getPosZ() + (this.lerpZ - this.getPosZ()) / (double) this.lerpSteps;
            double d3 = MathHelper.wrapDegrees(this.lerpYaw - (double) this.rotationYaw);
            this.rotationYaw = (float) ((double) this.rotationYaw + d3 / (double) this.lerpSteps);
            this.rotationPitch = (float) ((double) this.rotationPitch + (this.lerpPitch - (double) this.rotationPitch) / (double) this.lerpSteps);
            --this.lerpSteps;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void updateInputs(boolean leftInputDown, boolean rightInputDown, boolean forwardInputDown, boolean backInputDown) {
        this.leftInputDown = leftInputDown;
        this.rightInputDown = rightInputDown;
        this.forwardInputDown = forwardInputDown;
        this.backInputDown = backInputDown;
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if (this.isPassenger(passenger)) {
            float f = 0.0F;
            float f1 = (float) ((this.removed ? (double) 0.01F : this.getMountedYOffset()) + passenger.getYOffset());
            if (this.getPassengers().size() > 1) {
                int i = this.getPassengers().indexOf(passenger);
                if (i == 0) {
                    f = 0.2F;
                } else {
                    f = -0.6F;
                }

                if (passenger instanceof AnimalEntity) {
                    f = (float) ((double) f + 0.2D);
                }
            }

            Vector3d vector3d = (new Vector3d(f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            passenger.setPosition(this.getPosX() + vector3d.x, this.getPosY() + (double) f1, this.getPosZ() + vector3d.z);
            passenger.rotationYaw += this.deltaRotation;
            passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
            this.applyYawToEntity(passenger);
            if (passenger instanceof AnimalEntity && this.getPassengers().size() > 1) {
                int j = passenger.getEntityId() % 2 == 0 ? 90 : 270;
                passenger.setRenderYawOffset(((AnimalEntity) passenger).renderYawOffset + (float) j);
                passenger.setRotationYawHead(passenger.getRotationYawHead() + (float) j);
            }

        }
    }

    protected void applyYawToEntity(Entity entityToUpdate) {
        entityToUpdate.setRenderYawOffset(this.rotationYaw);
        float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);

        //最大左右旋转角度：±10°（船为±105°）
        float f1 = MathHelper.clamp(f, -3.0F, 3.0F);

        //模拟A/D键按下
        if (f > 2) {
            rightInputDown = true;
        } else if (f < -2) {
            leftInputDown = true;
        }

        //使光标缓慢归位
        f1 *= 0.985;
        entityToUpdate.prevRotationYaw += f1 - f;
        entityToUpdate.rotationYaw += f1 - f;
        entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
    }

    @Override
    protected boolean canFitPassenger(Entity passenger) {
        return this.getPassengers().size() < 2;
    }


    public ActionResultType processInitialInteract(PlayerEntity player, Hand hand) {
        if (player.isSecondaryUseActive()) {
            return ActionResultType.PASS;
        } else if (player.getRidingEntity() != this) {
            if (!this.world.isRemote) {
                return player.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.SUCCESS;
            } else {
                return ActionResultType.SUCCESS;
            }
        } else {
            return ActionResultType.PASS;
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public double getMountedYOffset() {
        return 1;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.world.isRemote && !this.removed) {
            if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS) && !(source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity) source.getTrueSource()).isCreative())) {
                this.entityDropItem(ItemRegistry.BLUE_SMALL_BALL.get());
            }
            this.remove();
        }
        return true;
    }

    @Override
    public Vector3d func_230268_c_(LivingEntity livingEntity) {
        Vector3d vector3d = func_233559_a_(this.getWidth() * MathHelper.SQRT_2, livingEntity.getWidth(), this.rotationYaw);
        double d0 = this.getPosX() + vector3d.x;
        double d1 = this.getPosZ() + vector3d.z;
        BlockPos blockpos = new BlockPos(d0, this.getBoundingBox().maxY, d1);
        BlockPos blockpos1 = blockpos.down();
        if (!this.world.hasWater(blockpos1)) {
            double d2 = (double) blockpos.getY() + this.world.func_242403_h(blockpos);
            double d3 = (double) blockpos.getY() + this.world.func_242403_h(blockpos1);

            for (Pose pose : livingEntity.getAvailablePoses()) {
                Vector3d vector3d1 = TransportationHelper.func_242381_a(this.world, d0, d2, d1, livingEntity, pose);
                if (vector3d1 != null) {
                    livingEntity.setPose(pose);
                    return vector3d1;
                }

                Vector3d vector3d2 = TransportationHelper.func_242381_a(this.world, d0, d3, d1, livingEntity, pose);
                if (vector3d2 != null) {
                    livingEntity.setPose(pose);
                    return vector3d2;
                }
            }
        }

        return super.func_230268_c_(livingEntity);
    }

    @Override
    public Direction getAdjustedHorizontalFacing() {
        return this.getHorizontalFacing().rotateY();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void applyOrientationToEntity(Entity entityToUpdate) {
        this.applyYawToEntity(entityToUpdate);
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        this.lerpX = x;
        this.lerpY = y;
        this.lerpZ = z;
        this.lerpYaw = yaw;
        this.lerpPitch = pitch;
        this.lerpSteps = 10;
    }

    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);
        if (this.canPassengerSteer() && this.lerpSteps > 0) {
            this.lerpSteps = 0;
            this.setPositionAndRotation(this.lerpX, this.lerpY, this.lerpZ, (float) this.lerpYaw, (float) this.lerpPitch);
        }
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

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
