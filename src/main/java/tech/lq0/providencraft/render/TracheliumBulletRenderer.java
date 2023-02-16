package tech.lq0.providencraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.entity.TracheliumBulletEntity;

public class TracheliumBulletRenderer extends EntityRenderer<TracheliumBulletEntity> {
    public TracheliumBulletRenderer(EntityRendererManager renderManager){
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(TracheliumBulletEntity entity) {
        return null;
    }

    @Override
    public void render(TracheliumBulletEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light) {
        if(entity.ticksExisted <= 1) {
            return;
        }

        matrixStack.push();
        
        matrixStack.pop();
    }
}
