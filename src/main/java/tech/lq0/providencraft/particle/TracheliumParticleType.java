package tech.lq0.providencraft.particle;

import com.mojang.serialization.Codec;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.vector.Vector3d;

import java.awt.*;

public class TracheliumParticleType extends ParticleType<TracheliumParticleData> {
    public TracheliumParticleType() {
        super(false, TracheliumParticleData.DESERIALIZER);
    }

    @Override
    public Codec<TracheliumParticleData> func_230522_e_() {
        return Codec.unit(new TracheliumParticleData(new Vector3d(0, 0, 0), new Color(0), 0));
    }
}
