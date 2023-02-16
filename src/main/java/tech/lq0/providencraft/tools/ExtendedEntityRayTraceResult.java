package tech.lq0.providencraft.tools;

import net.minecraft.util.math.EntityRayTraceResult;
import tech.lq0.providencraft.entity.TracheliumBulletEntity;

//Forked from MrCrayfish and TaC
public class ExtendedEntityRayTraceResult extends EntityRayTraceResult {
    private final boolean headshot;

    public ExtendedEntityRayTraceResult(TracheliumBulletEntity.EntityResult result) {
        super(result.getEntity(), result.getHitPos());
        this.headshot = result.isHeadshot();
    }

    public boolean isHeadshot() {
        return this.headshot;
    }
}
