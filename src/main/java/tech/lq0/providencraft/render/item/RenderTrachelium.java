package tech.lq0.providencraft.render.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;
import tech.lq0.providencraft.models.item.TracheliumEmptyModel;
import tech.lq0.providencraft.models.item.TracheliumModel;

public class RenderTrachelium extends GeoItemRenderer<Trachelium> {
    public RenderTrachelium() {
        super(new TracheliumModel());
    }

    @Override
    public void func_239207_a_(ItemStack itemStack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int combinedLightIn, int p_239207_6_) {
        if(p_239207_2_ == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || p_239207_2_ == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND) {
            this.setModel(new TracheliumModel());
        }else {
            this.setModel(new TracheliumEmptyModel());
        }
        this.render((Trachelium) itemStack.getItem(), matrixStack, bufferIn, combinedLightIn, itemStack);
    }


}
