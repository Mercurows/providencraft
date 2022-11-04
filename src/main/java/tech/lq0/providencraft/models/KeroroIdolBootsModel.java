package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class KeroroIdolBootsModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer left;
    private final ModelRenderer right;
    private final ModelRenderer left_total;
    private final ModelRenderer right_total;

    public KeroroIdolBootsModel() {
        super(1.0f);
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 1.0F, 0.0F);

        left_total = new ModelRenderer(this);
        left_total.setRotationPoint(0.0F, 24.0F, 0.0F);

        left = new ModelRenderer(this);
        left.setRotationPoint(-2.0F, 12.5F, -0.5F);
        left.setTextureOffset(0, 6).addBox(-0.5F, -0.25F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        left.setTextureOffset(16, 14).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        left.setTextureOffset(14, 6).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        left.setTextureOffset(30, 12).addBox(0.0F, -0.25F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(28, 29).addBox(-0.5F, -0.25F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(0, 23).addBox(-0.5F, -4.0F, 2.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(30, 10).addBox(0.0F, -0.25F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(28, 3).addBox(-0.5F, -2.0F, -5.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(0, 20).addBox(-1.0F, -2.0F, -4.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
        left.setTextureOffset(18, 26).addBox(-1.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
        left.setTextureOffset(24, 10).addBox(4.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
        left.setTextureOffset(0, 28).addBox(-0.5F, -4.0F, -2.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(8, 12).addBox(1.0F, -4.25F, -2.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        left_total.addChild(left);

        right_total = new ModelRenderer(this);
        right_total.setRotationPoint(0.0F, 24.0F, 0.0F);

        right = new ModelRenderer(this);
        right.setRotationPoint(2.0F, 12.5F, -0.5F);
        right.setTextureOffset(0, 0).addBox(-4.5F, -0.25F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        right.setTextureOffset(8, 13).addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        right.setTextureOffset(0, 12).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        right.setTextureOffset(12, 28).addBox(-4.0F, -0.25F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(29, 0).addBox(-4.5F, -0.25F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(22, 21).addBox(-4.5F, -4.0F, 2.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(15, 3).addBox(-4.0F, -0.25F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(24, 26).addBox(-4.5F, -2.0F, -5.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(15, 0).addBox(-5.0F, -2.0F, -4.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
        right.setTextureOffset(22, 3).addBox(0.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
        right.setTextureOffset(12, 21).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
        right.setTextureOffset(24, 17).addBox(-4.5F, -4.0F, -2.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(0, 12).addBox(-3.0F, -4.25F, -2.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        right_total.addChild(right);

        main.addChild(left_total);
        main.addChild(right_total);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.left_total.copyModelAngles(this.bipedLeftLeg);
        this.right_total.copyModelAngles(this.bipedRightLeg);
        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}