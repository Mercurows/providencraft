package tech.lq0.providencraft.event;

import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.world.biome.BlueDesertBiome;
import tech.lq0.providencraft.world.biome.HaranoPlainsBiome;
import tech.lq0.providencraft.world.feature.structure.BlueDesertStructures;
import tech.lq0.providencraft.world.feature.structure.HaranoPlainsStructures;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void worldGenRuns(final BiomeLoadingEvent event){
        if(event.getName().equals(BlueDesertBiome.blueDesertBiome.getRegistryName())){
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> BlueDesertStructures.BLUE_DESERT_WELL_FEATURE);
        }else if(event.getName().equals(HaranoPlainsBiome.haranoPlainsBiome.getRegistryName())){
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES)
                    .add(() -> HaranoPlainsStructures.HARANO_TENT_FEATURE);
        }
    }
}
