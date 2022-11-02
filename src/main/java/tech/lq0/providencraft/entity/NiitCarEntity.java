package tech.lq0.providencraft.entity;

import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.*;
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

public class NiitCarEntity extends Entity {

    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYaw;
    private double lerpPitch;
    private int lerpSteps;
    private float deltaRotation;
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
        } else {
            setMotion(Vector3d.ZERO);
        }

        doBlockCollisions();

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

        float momentum = 0.85F;

        Vector3d vector3d = this.getMotion();
        this.setMotion(vector3d.x * momentum, vector3d.y + gravity, vector3d.z * momentum);
        this.deltaRotation *= momentum;
    }


    @Override
    public boolean canCollide(Entity entity) {
        double speed = getSpeed();
        if (speed > 10 && !isPassenger(entity)) {
            if (!entity.noClip && !this.noClip) {
                double xDiff = entity.getPosX() - this.getPosX();
                double zDiff = entity.getPosZ() - this.getPosZ();
                double maxDiff = MathHelper.absMax(xDiff, zDiff);
                if (maxDiff >= (double) 0.01F) {
                    maxDiff = MathHelper.sqrt(maxDiff);
                    xDiff = xDiff / maxDiff;
                    zDiff = zDiff / maxDiff;
                    double d3 = 1.0D / maxDiff;
                    if (d3 > 1.0D) {
                        d3 = 1.0D;
                    }

                    d3 *= 1 + speed * .5;

                    xDiff = xDiff * d3;
                    zDiff = zDiff * d3;
                    xDiff = xDiff * (double) 0.05F;
                    zDiff = zDiff * (double) 0.05F;
                    xDiff = xDiff * (double) (1.0F - this.entityCollisionReduction);
                    zDiff = zDiff * (double) (1.0F - this.entityCollisionReduction);

                    //往车头方向增加动量
                    Vector3d look = getLookVec();
                    xDiff += look.x * (speed / 8.0);
                    zDiff += look.z * (speed / 8.0);

                    if (!entity.isBeingRidden() && entity.hurtResistantTime <= 0) {
                        entity.addVelocity(xDiff, speed / 2.0, zDiff);
                        if (speed > 20) {
                            float damage = (float) Math.pow((speed / 16.0), 2);
                            if (getControllingPassenger() != null) {
                                entity.attackEntityFrom(new EntityDamageSource("niitcarCrash", getControllingPassenger()), damage);
                            }
                        }
                        entity.hurtResistantTime = 20;
                    }
                }
            }
        }
        return false;
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
            float f1 = (float) ((!this.isAlive() ? (double) 0.01F : this.getMountedYOffset()) + passenger.getYOffset());
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

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.world.isRemote && this.isAlive()) {
            if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS) && !(source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity) source.getTrueSource()).isCreative())) {
                this.entityDropItem(ItemRegistry.BLUE_SMALL_BALL.get());
            }
            this.remove();
        }
        return true;
    }

    @Override
    public Vector3d func_230268_c_(LivingEntity livingEntity) {
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
