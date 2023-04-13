package tech.lq0.providencraft.block.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import tech.lq0.providencraft.world.feature.Features;

import javax.annotation.Nullable;
import java.util.Random;

public class HaranoTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return Features.HARANO_TREE;
    }
}
