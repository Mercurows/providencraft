package tech.lq0.providencraft.event;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.world.feature.structure.BlueDesertStructures;
import tech.lq0.providencraft.world.feature.structure.HaranoPlainsStructures;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void structureRegistry(final RegistryEvent.Register<Feature<?>> event) {
        event.getRegistry().register(BlueDesertStructures.BLUE_DESERT_WELL.setRegistryName(Utils.MOD_ID, "blue_desert_well"));
        event.getRegistry().register(HaranoPlainsStructures.HARANO_TENT.setRegistryName(Utils.MOD_ID, "harano_tent"));
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Utils.MOD_ID, "blue_desert_well"), BlueDesertStructures.BLUE_DESERT_WELL_FEATURE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Utils.MOD_ID, "harano_tent"), HaranoPlainsStructures.HARANO_TENT_FEATURE);
    }
}
