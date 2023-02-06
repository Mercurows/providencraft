package tech.lq0.providencraft.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;

public class TracheliumParticleFactory implements IParticleFactory<TracheliumParticleData> {
    private final IAnimatedSprite sprites;

    public TracheliumParticleFactory(IAnimatedSprite sprite) {
        this.sprites = sprite;
    }

    @Override
    public Particle makeParticle(TracheliumParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        TracheliumParticle particle = new TracheliumParticle(worldIn, x, y, z, typeIn.getSpeed(), typeIn.getColor(), typeIn.getDiameter(), typeIn.posX, typeIn.posY, typeIn.posZ, typeIn.flag);
        particle.selectSpriteRandomly(sprites);
        return particle;
    }
}
