package tech.lq0.providencraft.models;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PdCLogoModel extends Model {
    private final ModelRenderer main;

    public PdCLogoModel() {
        super(RenderType::getEntitySolid);
        textureWidth = 32;
        textureHeight = 32;

        main = new ModelRenderer(this);
        main.setRotationPoint(-0.0603F, 10.7052F, 0.0F);
        main.setTextureOffset(16, 11).addBox(-0.9397F, 11.2948F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 25).addBox(0.0603F, 10.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 9).addBox(-0.9397F, 9.2948F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(14, 9).addBox(1.0603F, 8.2948F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(25, 15).addBox(-0.9397F, 7.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(15, 25).addBox(-2.9397F, 6.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 24).addBox(-1.9397F, 0.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 23).addBox(-3.9397F, -0.7052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(15, 23).addBox(-5.9397F, -1.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(5, 23).addBox(-4.9397F, -2.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(22, 12).addBox(-2.9397F, -3.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(15, 21).addBox(-2.9397F, -10.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(20, 14).addBox(-2.9397F, -12.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(8, 16).addBox(-0.9397F, -15.6052F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(10, 20).addBox(1.0603F, -12.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 10).addBox(1.0603F, -10.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 8).addBox(3.0603F, -9.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 6).addBox(-4.9397F, -9.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(5, 21).addBox(-5.9397F, -11.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 2).addBox(4.0603F, -11.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 4).addBox(-7.9397F, -10.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(20, 17).addBox(6.0603F, -10.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 7).addBox(-8.9397F, -9.6052F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 5).addBox(8.0603F, -9.6052F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(10, 0).addBox(-0.9397F, -7.6052F, -0.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 0).addBox(-1.9397F, -9.6052F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 7).addBox(-1.9397F, -13.6052F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(10, 22).addBox(1.0603F, -3.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(22, 0).addBox(3.0603F, -2.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 22).addBox(4.0603F, -1.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(21, 21).addBox(2.0603F, -0.6052F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 9).addBox(1.0603F, 0.3948F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(24, 19).addBox(1.0603F, 6.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(4, 11).addBox(0.0603F, 1.2948F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 11).addBox(-5.9397F, -0.7052F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(10, 5).addBox(5.0603F, -0.7052F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(10, 24).addBox(3.0603F, 5.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(5, 25).addBox(-4.9397F, 5.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 20).addBox(-6.9397F, 7.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(5, 19).addBox(5.0603F, 7.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(13, 18).addBox(7.0603F, 6.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 5).addBox(7.0603F, 4.2948F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(8, 14).addBox(9.0603F, 3.3948F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(14, 7).addBox(10.0603F, 2.3948F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 18).addBox(11.0603F, 1.3948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(16, 0).addBox(12.0603F, -0.6052F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 3).addBox(13.0603F, -1.6052F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 3).addBox(-10.9397F, 4.2948F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(8, 12).addBox(-11.9397F, 3.3948F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(14, 5).addBox(-12.9397F, 2.3948F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(16, 3).addBox(-12.9397F, 1.3948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(15, 15).addBox(-13.9397F, -0.6052F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(0, 26).addBox(-13.9397F, -1.6052F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(18, 19).addBox(-8.9397F, 6.2948F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 24).addBox(-1.9397F, 10.2948F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 22).addBox(-2.9397F, 9.2948F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(26, 17).addBox(-3.9397F, 8.2948F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        main.setTextureOffset(10, 26).addBox(-1.9397F, 8.2948F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
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