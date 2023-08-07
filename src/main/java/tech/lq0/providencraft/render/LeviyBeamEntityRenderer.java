package tech.lq0.providencraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.tileentity.BeaconTileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.entity.LeviyBeamEntity;
import tech.lq0.providencraft.render.special.LeviyRenderer;

public class LeviyBeamEntityRenderer extends EntityRenderer<LeviyBeamEntity> {

    private final ResourceLocation TEXTURE = BeaconTileEntityRenderer.TEXTURE_BEACON_BEAM;

    protected LeviyBeamEntityRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(LeviyBeamEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LeviyBeamEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        float radius = entityIn.getRadius();
        float ticksExisted = entityIn.ticksExisted + partialTicks;
        float duration = entityIn.getDuration();

        float r = ease(0, radius, ticksExisted / duration);

        // 渲染光柱
        LeviyRenderer.renderBeamSegment(matrixStackIn,
                bufferIn,
                TEXTURE,
                partialTicks,
                1, entityIn.getEntityWorld().getGameTime(),
                0, 5000, new float[]{1, 0, 0},
                r, r + .5f, 1);
        matrixStackIn.pop();
        matrixStackIn.translate(.5f, 0, .5f);
    }


    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }
}
