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
import tech.lq0.providencraft.entity.projectile.BloodCrystalEntity;
import tech.lq0.providencraft.models.BloodCrystalModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class BloodCrystalEntityRenderer extends EntityRenderer<BloodCrystalEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/blood_crystal_texture.png");
    private final EntityModel<BloodCrystalEntity> bloodCrystalEntityEntityModel;

    public BloodCrystalEntityRenderer(EntityRendererManager manager) {
        super(manager);
        bloodCrystalEntityEntityModel = new BloodCrystalModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(BloodCrystalEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));

        matrixStackIn.translate(0.2f, -2.0f, 0.4f);
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(0));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.bloodCrystalEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.bloodCrystalEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(BloodCrystalEntity entity) {
        return TEXTURE;
    }


}

