package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;

//Forked from MrCrayfish and TaC
public class RotatedHeadBox <T extends LivingEntity> extends HeadshotBox<T> {
    protected double headZOffset;
    protected boolean rotatePitch;
    protected boolean rotateYaw;

    public RotatedHeadBox(double headSize, double headYOffset, double headZOffset, boolean rotatePitch, boolean rotateYaw) {
        super(headSize, headSize, headYOffset);
        this.headZOffset = headZOffset;
        this.rotatePitch = rotatePitch;
        this.rotateYaw = rotateYaw;
    }

    public RotatedHeadBox(double headWidth, double headHeight, double headYOffset, double headZOffset, boolean rotatePitch, boolean rotateYaw) {
        super(headWidth, headHeight, headYOffset);
        this.headZOffset = headZOffset;
        this.rotatePitch = rotatePitch;
        this.rotateYaw = rotateYaw;
    }

    @Nullable
    @Override
    public AxisAlignedBB getHeadshotBox(T entity) {
        AxisAlignedBB headBox = super.getHeadshotBox(entity);
        if(headBox != null) {
            headBox = headBox.offset(Vector3d.fromPitchYaw(this.rotatePitch ? entity.rotationPitch : 0.0F, this.rotateYaw ? entity.renderYawOffset : 0.0F).normalize().scale(this.headZOffset * 0.0625));
            return headBox;
        }
        return null;
    }
}