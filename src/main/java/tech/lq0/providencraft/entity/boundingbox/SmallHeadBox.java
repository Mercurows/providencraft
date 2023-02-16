package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

//Forked from MrCrayfish and TaC
public class SmallHeadBox<T extends LivingEntity> extends HeadshotBox<T> {
    protected double scale;
    protected double headYOffsetScale;

    public SmallHeadBox(double headSize, double headYOffset, double scale, double headYOffsetScale) {
        super(headSize, headYOffset);
        this.scale = scale;
        this.headYOffsetScale = headYOffsetScale;
    }

    public SmallHeadBox(double headWidth, double headHeight, double headYOffset, double scale, double headYOffsetScale) {
        super(headWidth, headHeight, headYOffset);
        this.scale = scale;
        this.headYOffsetScale = headYOffsetScale;
    }

    @Nullable
    @Override
    public AxisAlignedBB getHeadshotBox(T entity) {
        AxisAlignedBB headBox = super.getHeadshotBox(entity);
        if(headBox != null && entity.isChild()) {
            return new AxisAlignedBB(headBox.minX * this.scale, headBox.minY * this.headYOffsetScale, headBox.minZ * this.scale, headBox.maxX * this.scale, headBox.maxY * (this.headYOffsetScale + 0.065), headBox.maxZ * this.scale);
        }
        return headBox;
    }
}
