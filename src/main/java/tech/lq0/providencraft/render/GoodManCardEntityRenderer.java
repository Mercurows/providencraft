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
import tech.lq0.providencraft.entity.GoodManCardEntity;
import tech.lq0.providencraft.models.GoodManCardModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class GoodManCardEntityRenderer extends EntityRenderer<GoodManCardEntity> {
    public static final ResourceLocation[] TEXTURE = new ResourceLocation[]{
            new ResourceLocation(Utils.MOD_ID, "textures/entity/good_man_card_gold_texture.png"),
            new ResourceLocation(Utils.MOD_ID, "textures/entity/good_man_card_diamond_texture.png"),
            new ResourceLocation(Utils.MOD_ID, "textures/entity/good_man_card_emerald_texture.png"),
            new ResourceLocation(Utils.MOD_ID, "textures/entity/good_man_card_red_texture.png"),
            new ResourceLocation(Utils.MOD_ID, "textures/entity/good_man_card_rainbow_texture.png")
    };
    private final EntityModel<GoodManCardEntity> goodManCardEntityEntityModel;

    public GoodManCardEntityRenderer(EntityRendererManager manager) {
        super(manager);
        goodManCardEntityEntityModel = new GoodManCardModel();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(GoodManCardEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));

        matrixStackIn.translate(0.0f, -1.3f, 0.0f);
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(0));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.goodManCardEntityEntityModel.getRenderType(this.getEntityTexture(entityIn)));
        this.goodManCardEntityEntityModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(GoodManCardEntity entity) {
        return TEXTURE[entity.getCardType()];
    }

}

