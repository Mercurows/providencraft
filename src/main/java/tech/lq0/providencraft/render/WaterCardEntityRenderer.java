package tech.lq0.providencraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.WaterCardEntity;
import tech.lq0.providencraft.models.WaterCardEntityModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class WaterCardEntityRenderer extends EntityRenderer<WaterCardEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/water_card_entity_texture.png");
    private final EntityModel<WaterCardEntity> waterCardEntityEntityModel;

    public WaterCardEntityRenderer(EntityRendererManager manager) {
        super(manager);
        waterCardEntityEntityModel = new WaterCardEntityModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(WaterCardEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));

        matrixStackIn.translate(0.0f, -1.0f, 0.0f);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.waterCardEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.waterCardEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(WaterCardEntity entity) {
        return TEXTURE;
    }


}

