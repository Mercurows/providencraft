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
import tech.lq0.providencraft.entity.projectile.ShuRinoKenEntity;
import tech.lq0.providencraft.models.ShuRinoKenEntityModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ShuRinoKenEntityRenderer extends EntityRenderer<ShuRinoKenEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/shu_rino_ken_texture.png");
    private final EntityModel<ShuRinoKenEntity> shuRinoKenEntityEntityModel;

    public ShuRinoKenEntityRenderer(EntityRendererManager manager) {
        super(manager);
        shuRinoKenEntityEntityModel = new ShuRinoKenEntityModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(ShuRinoKenEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));

        matrixStackIn.translate(0.0f, -1.3f, 0.0f);
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(0));

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.shuRinoKenEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.shuRinoKenEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(ShuRinoKenEntity entity) {
        return TEXTURE;
    }
}

