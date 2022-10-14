package tech.lq0.providencraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.tile.PointsStoreTileEntity;
import tech.lq0.providencraft.models.PdCLogoModel;

@OnlyIn(Dist.CLIENT)
public class PointsStoreTileEntityRenderer extends TileEntityRenderer<PointsStoreTileEntity> {
    public static final RenderMaterial TEXTURE = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation(Utils.MOD_ID, "textures/entity/pdc_logo_texture.png"));
    private final PdCLogoModel model = new PdCLogoModel();

    public PointsStoreTileEntityRenderer(TileEntityRendererDispatcher dispatcher){
        super(dispatcher);
    }

    @Override
    public void render(PointsStoreTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.5f, 1.3f ,0.5f);
        matrixStackIn.scale(0.4f,0.4f,0.4f);
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0f));

        matrixStackIn.rotate(Vector3f.YP.rotationDegrees((tileEntityIn.ticks + partialTicks) * 5));
        IVertexBuilder ivertexbuilder = TEXTURE.getBuffer(bufferIn, RenderType::getEntitySolid);
        this.model.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn, 255.0F, 255.0F, 255.0F, 1.0F);
        matrixStackIn.pop();
    }


}
