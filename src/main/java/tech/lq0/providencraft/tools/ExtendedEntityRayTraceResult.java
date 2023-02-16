package tech.lq0.providencraft.tools;

import tech.lq0.providencraft.entity.TracheliumBulletEntity;

public class ExtendedEntityRayTraceResult extends TracheliumBulletEntity.EntityResult {
    private final boolean headshot;

    public ExtendedEntityRayTraceResult(TracheliumBulletEntity.EntityResult result) {
        super(result.getEntity(), result.getHitPos(), result.isHeadshot());
        this.headshot = result.isHeadshot();
    }

    public boolean isHeadshot() {
        return this.headshot;
    }
}
