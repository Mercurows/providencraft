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
import tech.lq0.providencraft.entity.projectile.KurumiBoomerangEntity;
import tech.lq0.providencraft.models.KurumiBoomerangModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class KurumiBoomerangEntityRenderer extends EntityRenderer<KurumiBoomerangEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/kurumi_boomerang_texture.png");
    private final EntityModel<KurumiBoomerangEntity> kurumiBoomerangEntityEntityModel;

    public KurumiBoomerangEntityRenderer(EntityRendererManager manager) {
        super(manager);
        kurumiBoomerangEntityEntityModel = new KurumiBoomerangModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(KurumiBoomerangEntity projectile, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(projectile, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, projectile.prevRotationYaw, projectile.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, projectile.prevRotationPitch, projectile.rotationPitch)));

        matrixStackIn.translate(0.0f, -0.85f, 0.0f);

        int rotateSpeed = 60;

        if (projectile.inGroundTicks == 0) {
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((projectile.flyingTicks + partialTicks) * rotateSpeed));
        } else {
            double base = projectile.flyingTicks * rotateSpeed;
            double pitch = Math.abs(projectile.rotationPitch);
            double endTick = (float) (0.0148148148 * pitch * pitch - 2.664 * pitch + 140);

            double x = projectile.inGroundTicks + partialTicks;
            if (x > endTick) {
                x = endTick;
            }
            double extraDegree = (float) (-1800.0 / Math.pow(endTick, 2) * x * x + (3600.0 / (endTick)) * x);

            matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) (base + extraDegree)));
        }

        matrixStackIn.scale(0.7f, 0.7f, 0.7f);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.kurumiBoomerangEntityEntityModel.getRenderType(this.getEntityTexture(projectile)));
        this.kurumiBoomerangEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(KurumiBoomerangEntity kurumiBoomerangEntity) {
        return TEXTURE;
    }
}

