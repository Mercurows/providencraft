package tech.lq0.providencraft.models;// Made with Blockbench 4.2.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class LunaticBowModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer bow1;
    private final ModelRenderer bow2;

    public LunaticBowModel() {
        super(1.0f);
        textureWidth = 32;
        textureHeight = 32;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 0.0F, 0.0F);


        bow1 = new ModelRenderer(this);
        bow1.setRotationPoint(4.5F, -6.0F, -0.5F);
        main.addChild(bow1);
        setRotationAngle(bow1, 0.48F, 0.0F, 0.0F);
        bow1.setTextureOffset(6, 6).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bow1.setTextureOffset(0, 6).addBox(-0.5F, -4.5F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        bow1.setTextureOffset(0, 0).addBox(-0.5F, 2.5F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        bow1.setTextureOffset(8, 10).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        bow1.setTextureOffset(6, 0).addBox(-0.5F, 1.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        bow2 = new ModelRenderer(this);
        bow2.setRotationPoint(5.5F, -6.0F, 0.0F);
        main.addChild(bow2);
        setRotationAngle(bow2, -0.6101F, 0.0177F, -0.013F);
        bow2.setTextureOffset(11, 4).addBox(-0.5F, -1.0F, -1.75F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bow2.setTextureOffset(4, 13).addBox(-0.5F, -2.0F, -1.25F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bow2.setTextureOffset(12, 8).addBox(-0.5F, 1.0F, -1.25F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bow2.setTextureOffset(0, 12).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bow2.setTextureOffset(11, 0).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.main.copyModelAngles(this.bipedHead);
        matrixStack.push();
        matrixStack.scale(0.7f,0.7f,0.7f);
        matrixStack.translate(0.12f,-0.1f,0.0f);
        main.render(matrixStack, buffer, packedLight, packedOverlay);
        matrixStack.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}