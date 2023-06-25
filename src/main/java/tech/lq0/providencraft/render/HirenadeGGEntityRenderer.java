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
import tech.lq0.providencraft.entity.projectile.HirenadeGGEntity;
import tech.lq0.providencraft.models.HirenadeGGModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class HirenadeGGEntityRenderer extends EntityRenderer<HirenadeGGEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/hirenade_gg_texture.png");
    private final EntityModel<HirenadeGGEntity> hirenadeGGEntityEntityModel;

    public HirenadeGGEntityRenderer(EntityRendererManager manager) {
        super(manager);
        hirenadeGGEntityEntityModel = new HirenadeGGModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(HirenadeGGEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.scale(0.5f,0.5f,0.5f);
        matrixStackIn.translate(-1.5f, 0.5f, 0);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
        matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90.0F));


        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.hirenadeGGEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.hirenadeGGEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(HirenadeGGEntity entity) {
        return TEXTURE;
    }

}

