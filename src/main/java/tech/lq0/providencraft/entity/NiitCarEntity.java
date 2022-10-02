package tech.lq0.providencraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class NiitCarEntity extends HorseEntity {
    public NiitCarEntity(EntityType<? extends HorseEntity> type, World worldIn) {
        super(type, worldIn);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MAX_HEALTH);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MOVEMENT_SPEED);
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected SoundEvent getAngrySound() {
        return null;
    }

    @Override
    public void travel(Vector3d travelVector) {
        //这个是抄的逻辑，没改(mojmaps)
//        if (this.isAlive()) {
//            if (this.isVehicle && this.canBeControlledByRider()) {
//                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
//                this.yRot = livingentity.yRot;
//                this.yRotO = this.yRot;
//                this.xRot = livingentity.xRot * 0.5F;
//                this.setRot(this.yRot, this.xRot);
//                this.yBodyRot = this.yRot;
//                this.yHeadRot = this.yBodyRot;
//                float f = livingentity.xxa * 0.5F;
//                float f1 = livingentity.zza;
//                if (f1 <= 0.0F) {
//                    f1 *= 0.25F;
//                    this.gallopSoundCounter = 0;
//                }
//
//                if (this.onGround && this.playerJumpPendingScale == 0.0F && this.isStanding()) {
//                    f = 0.0F;
//                    f1 = 0.0F;
//                }
//
//                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
//                    double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
//                    double d1;
//                    if (this.hasEffect(Effects.JUMP)) {
//                        d1 = d0 + (double)((float)(this.getEffect(Effects.JUMP).getAmplifier() + 1) * 0.1F);
//                    } else {
//                        d1 = d0;
//                    }
//
//                    Vector3d vector3d = this.getDeltaMovement();
//                    this.setDeltaMovement(vector3d.x, d1, vector3d.z);
//                    this.setIsJumping(true);
//                    this.hasImpulse = true;
//                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
//                    if (f1 > 0.0F) {
//                        float f2 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F));
//                        float f3 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F));
//                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
//                    }
//
//                    this.playerJumpPendingScale = 0.0F;
//                }
//
//                this.flyingSpeed = this.getSpeed() * 0.1F;
//                if (this.isControlledByLocalInstance()) {
//                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
//                    super.travel(new Vector3d((double)f, p_213352_1_.y, (double)f1));
//                } else if (livingentity instanceof PlayerEntity) {
//                    this.setDeltaMovement(Vector3d.ZERO);
//                }
//
//                if (this.onGround) {
//                    this.playerJumpPendingScale = 0.0F;
//                    this.setIsJumping(false);
//                }
//
//                this.calculateEntityAnimation(this, false);
//            } else {
//                this.flyingSpeed = 0.02F;
//                super.travel(p_213352_1_);
//            }
//        }
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        this.mountTo(p_230254_1_);
        return ActionResultType.func_233537_a_(!this.world.isRemote);
    }

    @Override
    public boolean isTame() {
        Entity entity = this.getControllingPassenger();
        return entity instanceof PlayerEntity;
    }
}
