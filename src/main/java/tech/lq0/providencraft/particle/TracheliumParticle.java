package tech.lq0.providencraft.particle;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.vector.Vector3d;

import java.awt.*;

public class TracheliumParticle extends SpriteTexturedParticle {
    protected TracheliumParticle(ClientWorld world, double x, double y, double z, Vector3d speed, Color color, float diameter) {
        super(world, x, y, z, speed.x, speed.y, speed.z);
        maxAge = 40;
        motionX = speed.x;
        motionY = speed.y;
        motionZ = speed.z;
        setColor(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F);
        this.setAlphaF(color.getAlpha());
        final float PARTICLE_SCALE_FOR_ONE_METRE = 0.3F;
        particleScale = PARTICLE_SCALE_FOR_ONE_METRE * diameter;
        this.canCollide = false;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
