package tech.lq0.providencraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class TracheliumBulletEntity extends Entity implements IEntityAdditionalSpawnData {
    protected LivingEntity shooter;
    protected int shooterId;
    protected EntitySize size;
    protected int maxLife;
    protected float damage;
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

    //from TaC
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
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public EffectInstance[] getEffectInstances() {
        return effectInstances;
    }

    public void setEffectInstances(EffectInstance[] effectInstances) {
        this.effectInstances = effectInstances;
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
        return null;
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {

    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {

    }
}
