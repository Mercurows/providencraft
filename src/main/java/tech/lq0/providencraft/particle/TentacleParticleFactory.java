package tech.lq0.providencraft.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;

public class TentacleParticleFactory implements IParticleFactory<TentacleParticleData> {
    private final IAnimatedSprite sprites;

    public TentacleParticleFactory(IAnimatedSprite sprite) {
        this.sprites = sprite;
    }

    @Override
    public Particle makeParticle(TentacleParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        TentacleParticle particle = new TentacleParticle(worldIn, x, y, z, typeIn.getSpeed(), typeIn.getColor(), typeIn.getDiameter());
        particle.selectSpriteRandomly(sprites);
        return particle;
    }
}
