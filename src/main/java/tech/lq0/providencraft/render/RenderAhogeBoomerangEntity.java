package tech.lq0.providencraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.AhogeBoomerangEntity;
import tech.lq0.providencraft.models.AhogeBoomerangModel;

public class RenderAhogeBoomerangEntity extends EntityRenderer<AhogeBoomerangEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID ,"textures/entity/ahoge_boomerang_texture.png");
    private EntityModel<AhogeBoomerangEntity> ahogeBoomerangEntityModel;

    public RenderAhogeBoomerangEntity(EntityRendererManager manager) {
        super(manager);
        ahogeBoomerangEntityModel = new AhogeBoomerangModel();
    }

    @Override
    public void render(AhogeBoomerangEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.translate(0.0f,-1.3f,0.0f);
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(0));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.ahogeBoomerangEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.ahogeBoomerangEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(AhogeBoomerangEntity entity) {
        return TEXTURE;
    }


}

