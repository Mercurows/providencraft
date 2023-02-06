package tech.lq0.providencraft.particle;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.vector.Vector3d;

import java.awt.*;

public class TracheliumParticle extends SpriteTexturedParticle {
    private double posX;
    private double posY;
    private double posZ;
    private boolean flag;

    protected TracheliumParticle(ClientWorld world, double x, double y, double z, Vector3d speed, Color color, float diameter) {
        super(world, x, y, z, speed.x, speed.y, speed.z);
        maxAge = 80;
        motionX = speed.x;
        motionY = speed.y;
        motionZ = speed.z;
        setColor(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F);
        this.setAlphaF(color.getAlpha());
        final float PARTICLE_SCALE_FOR_ONE_METRE = 0.3F;
        particleScale = PARTICLE_SCALE_FOR_ONE_METRE * diameter;
        this.canCollide = true;
    }

    protected TracheliumParticle(ClientWorld world, double x, double y, double z, Vector3d speed, Color color, float diameter,
                                 double posX, double posY, double posZ, boolean flag) {
        super(world, x, y, z, speed.x, speed.y, speed.z);
        maxAge = 30;
        motionX = speed.x;
        motionY = speed.y;
        motionZ = speed.z;
        setColor(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F);
        this.setAlphaF(color.getAlpha());
        final float PARTICLE_SCALE_FOR_ONE_METRE = 0.3F;
        particleScale = PARTICLE_SCALE_FOR_ONE_METRE * diameter;
        this.canCollide = false;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.flag = flag;
    }

    @Override
    public void tick() {
        if(flag){
            if(age < 10){
                setAlphaF(age / 10.0f);
            }else {
                setAlphaF(1.0f);
                double x = this.posX - this.prevPosX;
                double y = this.posY - this.prevPosY;
                double z = this.posZ - this.prevPosZ;

                double speed = (60 - age) / 10.0f;

                move(x / speed, y / speed, z / speed);
            }
        }
        super.tick();
    }



    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
