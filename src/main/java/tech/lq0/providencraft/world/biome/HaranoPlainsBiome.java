package tech.lq0.providencraft.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import tech.lq0.providencraft.world.feature.Features;

public class HaranoPlainsBiome {
    public static Biome haranoPlainsBiome;

    public static BiomeAmbience biomeAmbience;
    public static BiomeGenerationSettings.Builder generationSettings;
    public static MobSpawnInfo.Builder spawnInfo;

    static {
        biomeAmbience = (new BiomeAmbience.Builder())
                .withSkyColor(0x83bcff)
                .setFogColor(0xc0d8ff)
                .setWaterColor(0x4ca0e8)
                .setWaterFogColor(0x050533)
                .withGrassColor(0xfbb671)
                .withFoliageColor(0xfbd269)
                .build();

        generationSettings = new BiomeGenerationSettings.Builder()
                .withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                        Blocks.GRASS_BLOCK.getDefaultState(),
                        Blocks.DIRT.getDefaultState(),
                        Blocks.STONE.getDefaultState())));

        generationSettings
                .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        Feature.TREE.withConfiguration(Features.HARANO_TREE.config)
                                .withPlacement(net.minecraft.world.gen.feature.Features.Placements.HEIGHTMAP_PLACEMENT)
                                .withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))))
                .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        Feature.RANDOM_PATCH.withConfiguration(net.minecraft.world.gen.feature.Features.Configs.GRASS_PATCH_CONFIG)
                                .withPlacement(net.minecraft.world.gen.feature.Features.Placements.PATCH_PLACEMENT)
                                .withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 4))));

        DefaultBiomeFeatures.withCavesAndCanyons(generationSettings);
        DefaultBiomeFeatures.withOverworldOres(generationSettings);

        spawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

        spawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.MOOSHROOM, 90, 4, 8));
        spawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 1, 2));
        spawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 100, 1, 2));
        spawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 2, 2));
        spawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 10, 1, 2));

        haranoPlainsBiome = (new Biome.Builder())
                .precipitation(Biome.RainType.NONE)
                .downfall(0.0f)
                .temperature(1.4f)
                .depth(0.3f)
                .scale(0.05f)
                .category(Biome.Category.PLAINS)
                .withMobSpawnSettings(spawnInfo.copy())
                .withGenerationSettings(generationSettings.build())
                .setEffects(biomeAmbience)
                .build();
    }
}
