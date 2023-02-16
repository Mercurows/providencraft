package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

//Forked from MrCrayfish and TaC
public class NoChildRotatedHeadBox<T extends LivingEntity> extends RotatedHeadBox<T> {
    public NoChildRotatedHeadBox(double headSize, double headYOffset, double headZOffset, boolean rotatePitch, boolean rotateYaw) {
        super(headSize, headYOffset, headZOffset, rotatePitch, rotateYaw);
    }

    public NoChildRotatedHeadBox(double headWidth, double headHeight, double headYOffset, double headZOffset, boolean rotatePitch, boolean rotateYaw) {
        super(headWidth, headHeight, headYOffset, headZOffset, rotatePitch, rotateYaw);
    }

    @Nullable
    @Override
    public AxisAlignedBB getHeadshotBox(T entity) {
        if(entity.isChild()) return null;
        return super.getHeadshotBox(entity);
    }
}