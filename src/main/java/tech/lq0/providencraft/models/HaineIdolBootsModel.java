package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class HaineIdolBootsModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer left_total;
    private final ModelRenderer left;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer right_total;
    private final ModelRenderer right;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;

    public HaineIdolBootsModel() {
        super(1.0f);
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 1.0F, 0.0F);


        left_total = new ModelRenderer(this);
        left_total.setRotationPoint(0.0F, 24.0F, 0.0F);
        main.addChild(left_total);


        left = new ModelRenderer(this);
        left.setRotationPoint(-2.0F, 11.0F, 0.0F);
        left_total.addChild(left);
        left.setTextureOffset(0, 6).addBox(-0.5F, 0.0F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        left.setTextureOffset(18, 14).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        left.setTextureOffset(9, 13).addBox(3.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        left.setTextureOffset(27, 13).addBox(0.0F, 0.0F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(21, 24).addBox(-0.5F, 0.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(10, 22).addBox(0.0F, -1.0F, 1.5F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        left.setTextureOffset(22, 6).addBox(0.0F, -1.5F, 1.5F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        left.setTextureOffset(10, 25).addBox(0.0F, -1.0F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(22, 9).addBox(0.0F, -1.5F, -4.5F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        left.setTextureOffset(0, 27).addBox(0.0F, -1.75F, -2.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(4.5F, -0.889F, 1.6879F);
        left.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.9599F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(0, 6).addBox(-0.5F, 0.0F, -0.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(4.5F, -0.5F, 0.5F);
        left.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.6109F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(0, 8).addBox(-0.5F, -1.0F, -0.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(4.5F, -1.75F, 1.0F);
        left.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.2182F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(9, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        right_total = new ModelRenderer(this);
        right_total.setRotationPoint(0.0F, 24.0F, 0.0F);
        main.addChild(right_total);


        right = new ModelRenderer(this);
        right.setRotationPoint(2.0F, 11.0F, 0.0F);
        right_total.addChild(right);
        right.setTextureOffset(0, 0).addBox(-4.5F, 0.0F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        right.setTextureOffset(13, 5).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        right.setTextureOffset(0, 12).addBox(-4.5F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
        right.setTextureOffset(20, 26).addBox(-4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(20, 22).addBox(-4.5F, 0.0F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(22, 3).addBox(-4.0F, -1.0F, 1.5F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        right.setTextureOffset(0, 21).addBox(-4.0F, -1.5F, 1.5F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        right.setTextureOffset(0, 24).addBox(-4.0F, -1.0F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(15, 0).addBox(-4.0F, -1.5F, -4.5F, 4.0F, 1.0F, 2.0F, 0.0F, false);
        right.setTextureOffset(25, 0).addBox(-4.0F, -1.75F, -2.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-4.5F, -0.889F, 1.6879F);
        right.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.9599F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -0.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-4.5F, -0.5F, 0.5F);
        right.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.6109F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(0, 2).addBox(-0.5F, -1.0F, -0.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-4.5F, -1.75F, 1.0F);
        right.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.2182F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(0, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
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