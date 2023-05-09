package tech.lq0.providencraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.world.biome.BlueDesertBiome;
import tech.lq0.providencraft.world.biome.HaranoPlainsBiome;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegistry {

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().register(BlueDesertBiome.blueDesertBiome.setRegistryName(new ResourceLocation(Utils.MOD_ID, "blue_desert")));
        event.getRegistry().register(HaranoPlainsBiome.haranoPlainsBiome.setRegistryName(new ResourceLocation(Utils.MOD_ID, "harano_plains")));
    }
}
