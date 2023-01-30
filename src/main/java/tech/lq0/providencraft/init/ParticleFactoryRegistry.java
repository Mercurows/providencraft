package tech.lq0.providencraft.init;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.particle.TentacleParticleFactory;
import tech.lq0.providencraft.particle.TracheliumParticleFactory;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleFactoryRegistry {
    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.TENTACLE_PARTICLE.get(), TentacleParticleFactory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.TRACHELIUM_PARTICLE.get(), TracheliumParticleFactory::new);
    }
}
