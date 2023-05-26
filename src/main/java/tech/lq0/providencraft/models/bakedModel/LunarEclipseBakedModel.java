package tech.lq0.providencraft.models.bakedModel;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.data.IModelData;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class LunarEclipseBakedModel implements IBakedModel {
    private IBakedModel existingModel;

    public LunarEclipseBakedModel(IBakedModel existingModel) {
        this.existingModel = existingModel;
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        throw new AssertionError("IForgeBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        return this.existingModel.getQuads(state, side, rand);
    }

    @Override
    public boolean isAmbientOcclusion() {
        return this.existingModel.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return this.existingModel.isGui3d();
    }

    @Override
    public boolean isSideLit() {
        return this.existingModel.isSideLit();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return true;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.existingModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return this.existingModel.getOverrides();
    }

    @Override
    public IBakedModel handlePerspective(ItemCameraTransforms.TransformType cameraTransformType, MatrixStack mat) {
        if (cameraTransformType == ItemCameraTransforms.TransformType.GUI) {
            ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
            IBakedModel model = renderer.getItemModelMesher().getModelManager()
                    .getModel(new ModelResourceLocation("providencraft:lunar_eclipse_inventory", "inventory"));

            //TODO 修改正确的材质
            return renderer.getItemModelMesher().getItemModel(ItemRegistry.LUNATIC_BOW.get());
        }
        return this.existingModel.handlePerspective(cameraTransformType, mat);
    }
}
