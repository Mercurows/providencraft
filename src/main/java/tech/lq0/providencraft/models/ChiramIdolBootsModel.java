package tech.lq0.providencraft.models;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class ChiramIdolBootsModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer left;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer right;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer left_total;
    private final ModelRenderer right_total;

    public ChiramIdolBootsModel() {
        super(1.0f);
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 1.0F, 0.0F);

        left_total = new ModelRenderer(this);
        left_total.setRotationPoint(0.0F, 24.0F, 0.0F);

        left = new ModelRenderer(this);
        left.setRotationPoint(-2.0F, 12.5F, -1.0F);
        left.setTextureOffset(14, 15).addBox(-0.5F, -1.0F, -4.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
        left.setTextureOffset(0, 7).addBox(-0.5F, -2.0F, -4.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
        left.setTextureOffset(31, 0).addBox(0.5F, -2.0F, 1.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        left.setTextureOffset(25, 7).addBox(-0.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);
        left.setTextureOffset(24, 20).addBox(3.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);
        left.setTextureOffset(32, 7).addBox(0.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(31, 22).addBox(0.0F, -4.0F, 2.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(32, 31).addBox(0.0F, -1.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(8, 20).addBox(-1.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        left.setTextureOffset(0, 19).addBox(4.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        left.setTextureOffset(0, 7).addBox(-0.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(32, 10).addBox(0.0F, -5.0F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(0, 4).addBox(2.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(16, 8).addBox(4.25F, -4.25F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(4.75F, -1.25F, 1.5F);
        left.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.48F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(16, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(4.75F, -1.25F, -0.5F);
        left.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.48F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(16, 3).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(4.75F, -3.5F, -0.5F);
        left.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.6545F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(8, 21).addBox(-0.5F, -1.0F, 1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(8, 23).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(4.75F, -3.5F, 1.5F);
        left.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.6545F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(16, 22).addBox(-0.5F, -1.0F, -2.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r4.setTextureOffset(0, 23).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(2.0F, -2.3467F, -2.5381F);
        left.addChild(cube_r5);
        setRotationAngle(cube_r5, -1.2217F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(28, 28).addBox(-2.5F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(1.5F, -1.7681F, -3.618F);
        left.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.7418F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(11, 29).addBox(-2.0F, -0.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

        left_total.addChild(left);

        right_total = new ModelRenderer(this);
        right_total.setRotationPoint(0.0F, 24.0F, 0.0F);

        right = new ModelRenderer(this);
        right.setRotationPoint(2.0F, 12.5F, -1.0F);
        right.setTextureOffset(0, 14).addBox(-4.5F, -1.0F, -4.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
        right.setTextureOffset(0, 0).addBox(-4.5F, -2.0F, -4.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
        right.setTextureOffset(0, 30).addBox(-3.5F, -2.0F, 1.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        right.setTextureOffset(24, 0).addBox(-0.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);
        right.setTextureOffset(17, 22).addBox(-4.5F, -4.0F, -2.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);
        right.setTextureOffset(22, 31).addBox(-4.0F, -4.0F, -2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(31, 19).addBox(-4.0F, -4.0F, 2.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(10, 32).addBox(-4.0F, -1.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(16, 8).addBox(0.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        right.setTextureOffset(16, 1).addBox(-5.0F, -5.0F, -2.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        right.setTextureOffset(0, 2).addBox(-1.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(16, 20).addBox(-4.0F, -5.0F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(0, 0).addBox(-4.5F, -5.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(14, 15).addBox(-5.25F, -4.25F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-4.75F, -1.25F, 1.5F);
        right.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.48F, 0.0F, 0.0F);
        cube_r7.setTextureOffset(0, 9).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-4.75F, -1.25F, -0.5F);
        right.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.48F, 0.0F, 0.0F);
        cube_r8.setTextureOffset(0, 14).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-4.75F, -3.5F, -0.5F);
        right.addChild(cube_r9);
        setRotationAngle(cube_r9, -0.6545F, 0.0F, 0.0F);
        cube_r9.setTextureOffset(16, 11).addBox(-0.5F, -1.0F, 1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r9.setTextureOffset(0, 21).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-4.75F, -3.5F, 1.5F);
        right.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.6545F, 0.0F, 0.0F);
        cube_r10.setTextureOffset(0, 19).addBox(-0.5F, -1.0F, -2.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r10.setTextureOffset(8, 19).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-2.0F, -2.3467F, -2.5381F);
        right.addChild(cube_r11);
        setRotationAngle(cube_r11, -1.2217F, 0.0F, 0.0F);
        cube_r11.setTextureOffset(0, 27).addBox(-2.5F, -1.0F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-1.5F, -1.7681F, -3.618F);
        right.addChild(cube_r12);
        setRotationAngle(cube_r12, -0.7418F, 0.0F, 0.0F);
        cube_r12.setTextureOffset(28, 15).addBox(-3.0F, -0.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

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