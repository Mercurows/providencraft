package tech.lq0.providencraft.world.feature.structure;

import net.minecraft.util.Mirror;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import tech.lq0.providencraft.Utils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class HaranoPlainsStructures {
    public static final Feature<NoFeatureConfig> HARANO_TENT = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
        @Override
        @ParametersAreNonnullByDefault
        public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
            int ci = pos.getX();
            int ck = pos.getZ();
            RegistryKey<World> dimensionType = reader.getWorld().getDimensionKey();
            if(dimensionType != World.OVERWORLD){
                return false;
            }

            if(rand.nextInt(400) <= 1){
                int i = ci + rand.nextInt(16);
                int k = ck + rand.nextInt(16);
                int j = reader.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);
                Rotation rotation = Rotation.values()[rand.nextInt(3)];
                Mirror mirror = Mirror.values()[rand.nextInt(2)];

                BlockPos spawnPos = new BlockPos(i, j - 1, k);
                Template template = reader.getWorld().getStructureTemplateManager()
                        .getTemplateDefaulted(new ResourceLocation(Utils.MOD_ID, "harano_plains/harano_tent"));
                if(template == null){
                    return false;
                }
                template.func_237144_a_(reader, spawnPos, new PlacementSettings().setRotation(rotation).setMirror(mirror)
                        .addProcessor(BlockIgnoreStructureProcessor.AIR).setChunk(null).setIgnoreEntities(false), rand);

            }
            return true;
        }
    };

    public static final ConfiguredFeature<?, ?> HARANO_TENT_FEATURE = HARANO_TENT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
}
