package tech.lq0.providencraft.event;

import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.world.biome.BlueDesertBiome;
import tech.lq0.providencraft.world.feature.structure.BlueDesertStructures;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void worldGenRuns(final BiomeLoadingEvent event){
        if(event.getName().equals(BlueDesertBiome.blueDesertBiome.getRegistryName())){
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> BlueDesertStructures.BLUE_DESERT_WELL_FEATURE);
        }
    }
}
