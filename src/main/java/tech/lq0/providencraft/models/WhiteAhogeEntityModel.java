package tech.lq0.providencraft.models;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.WhiteAhogeEntity;

public class WhiteAhogeEntityModel extends EntityModel<WhiteAhogeEntity> {
    private final ModelRenderer main;

    public WhiteAhogeEntityModel() {
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.0F, 0.0F);
        main.setTextureOffset(19, 20).addBox(-1.0F, -1.0F, -8.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 17).addBox(-3.0F, -1.0F, -7.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 8).addBox(-5.0F, -1.0F, -6.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 15).addBox(-6.0F, -1.0F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 19).addBox(-7.0F, -1.0F, -4.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 10).addBox(-8.0F, -1.0F, -3.1F, 9.0F, 1.0F, 2.0F, 0.0F, false);
        main.setTextureOffset(0, 4).addBox(-8.0F, -1.0F, -1.1F, 8.0F, 1.0F, 3.0F, 0.0F, false);
        main.setTextureOffset(20, 10).addBox(-7.0F, -1.0F, 1.9F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 13).addBox(-7.0F, -1.0F, 2.9F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 2).addBox(-6.0F, -1.0F, 3.9F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, 4.9F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(19, 4).addBox(-3.0F, -1.0F, 5.9F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 21).addBox(-1.0F, -1.0F, 6.9F, 4.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(WhiteAhogeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}