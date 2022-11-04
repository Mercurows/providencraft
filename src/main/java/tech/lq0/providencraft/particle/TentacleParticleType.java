package tech.lq0.providencraft.particle;

import com.mojang.serialization.Codec;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.vector.Vector3d;

import java.awt.*;

public class TentacleParticleType extends ParticleType<TentacleParticleData> {
    public TentacleParticleType() {
        super(false, TentacleParticleData.DESERIALIZER);
    }

    @Override
    public Codec<TentacleParticleData> func_230522_e_() {
        return Codec.unit(new TentacleParticleData(new Vector3d(0, 0, 0), new Color(0), 0));
    }
}
