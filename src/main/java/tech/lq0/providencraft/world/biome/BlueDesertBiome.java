package tech.lq0.providencraft.world.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import tech.lq0.providencraft.init.BlockRegistry;

public class BlueDesertBiome {
    public static Biome blueDesertBiome;

    public static BiomeAmbience biomeAmbience;
    public static BiomeGenerationSettings.Builder generationSettings;
    public static MobSpawnInfo.Builder spawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();

    static {
        biomeAmbience = (new BiomeAmbience.Builder())
                .withSkyColor(0x7cb8ff)
                .setFogColor(0xc0d8ff)
                .setWaterColor(0x90f2f6)
                .setWaterFogColor(0x050533)
                .withGrassColor(0x8ea6f2)
                .withFoliageColor(0x869eea)
                .build();

        generationSettings = new BiomeGenerationSettings.Builder()
                .withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                        BlockRegistry.BLUE_SAND.get().getDefaultState(),
                        BlockRegistry.BLUE_SANDSTONE.get().getDefaultState(),
                        Blocks.STONE.getDefaultState())));

        generationSettings
                .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        Feature.FLOWER.withConfiguration(Features.Configs.DEAD_BUSH_CONFIG)
                                .withPlacement(Features.Placements.PATCH_PLACEMENT)
                                .withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.3D, 5, 3)))
                                        .func_242731_b(3))
                .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        Features.PATCH_CACTUS_DESERT.withPlacement(Features.Placements.PATCH_PLACEMENT))
                .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        Features.PATCH_SUGAR_CANE_DESERT.withPlacement(Features.Placements.PATCH_PLACEMENT)
                                .withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.2D, 3, 1))
                                        .func_242731_b(1)));

        DefaultBiomeFeatures.withCavesAndCanyons(generationSettings);
        DefaultBiomeFeatures.withOverworldOres(generationSettings);

        spawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 100, 1, 4));

        blueDesertBiome = (new Biome.Builder())
                .precipitation(Biome.RainType.NONE)
                .downfall(0.0f)
                .temperature(2.0f)
                .depth(0.15f)
                .scale(0.15f)
                .category(Biome.Category.DESERT)
                .withMobSpawnSettings(spawnInfo.copy())
                .withGenerationSettings(generationSettings.build())
                .setEffects(biomeAmbience)
                .build();
    }
}
