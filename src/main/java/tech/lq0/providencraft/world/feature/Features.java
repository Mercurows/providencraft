package tech.lq0.providencraft.world.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import tech.lq0.providencraft.init.BlockRegistry;

public class Features {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> HARANO_TREE = register("harano_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockRegistry.HARANO_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BlockRegistry.HARANO_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242253_a(2, 3), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(7, 4, 0),
                    new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
