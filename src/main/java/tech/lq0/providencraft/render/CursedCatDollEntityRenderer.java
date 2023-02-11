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
import tech.lq0.providencraft.entity.CursedCatDollEntity;
import tech.lq0.providencraft.models.CursedCatDollModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class CursedCatDollEntityRenderer extends EntityRenderer<CursedCatDollEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/cursed_cat_doll_texture.png");
    private final EntityModel<CursedCatDollEntity> cursedCatDollEntityEntityModel;

    public CursedCatDollEntityRenderer(EntityRendererManager manager) {
        super(manager);
        cursedCatDollEntityEntityModel = new CursedCatDollModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(CursedCatDollEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));

        matrixStackIn.translate(0.0f, -1.0f, 0.0f);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.cursedCatDollEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.cursedCatDollEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(CursedCatDollEntity entity) {
        return TEXTURE;
    }

}

