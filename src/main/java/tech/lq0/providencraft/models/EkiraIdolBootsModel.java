package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class EkiraIdolBootsModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer left_total;
    private final ModelRenderer left;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer ring;
    private final ModelRenderer right_total;
    private final ModelRenderer right;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;

    public EkiraIdolBootsModel() {
        super(1.0f);
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 1.0F, 0.0F);


        left_total = new ModelRenderer(this);
        left_total.setRotationPoint(0.0F, 24.0F, 0.0F);
        main.addChild(left_total);


        left = new ModelRenderer(this);
        left.setRotationPoint(-2.0F, 11.5F, 0.0F);
        left_total.addChild(left);
        left.setTextureOffset(0, 6).addBox(-0.5F, -0.25F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        left.setTextureOffset(27, 0).addBox(0.0F, -0.25F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(26, 11).addBox(-0.5F, -0.25F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(23, 26).addBox(0.0F, -0.25F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(26, 13).addBox(0.0F, -1.75F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(18, 4).addBox(-0.5F, -2.0F, -4.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        left.setTextureOffset(16, 16).addBox(-0.75F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        left.setTextureOffset(16, 8).addBox(3.75F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        left.setTextureOffset(22, 16).addBox(-0.5F, -4.0F, -2.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        left.setTextureOffset(11, 24).addBox(-0.5F, -4.0F, 2.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(2.75F, -3.25F, -3.0F);
        left.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.3927F);
        cube_r1.setTextureOffset(30, 4).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(1.25F, -3.25F, -3.0F);
        left.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3927F);
        cube_r2.setTextureOffset(29, 2).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        ring = new ModelRenderer(this);
        ring.setRotationPoint(0.0F, 0.0F, 0.0F);
        left.addChild(ring);
        ring.setTextureOffset(32, 1).addBox(-0.25F, -6.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        ring.setTextureOffset(40, 0).addBox(3.75F, -6.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        ring.setTextureOffset(33, 7).addBox(0.75F, -6.0F, -2.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        ring.setTextureOffset(34, 9).addBox(0.75F, -6.0F, 2.25F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        right_total = new ModelRenderer(this);
        right_total.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(right_total);


        right = new ModelRenderer(this);
        right.setRotationPoint(2.0F, 11.5F, 0.0F);
        right_total.addChild(right);
        right.setTextureOffset(0, 0).addBox(-4.5F, -0.25F, -4.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        right.setTextureOffset(26, 21).addBox(-4.0F, -0.25F, 1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(23, 24).addBox(-4.5F, -0.25F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(26, 19).addBox(-4.0F, -0.25F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(0, 25).addBox(-4.0F, -1.75F, -5.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(15, 0).addBox(-4.5F, -2.0F, -4.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        right.setTextureOffset(10, 12).addBox(-0.25F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        right.setTextureOffset(0, 12).addBox(-4.75F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        right.setTextureOffset(22, 8).addBox(-4.5F, -4.0F, -2.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
        right.setTextureOffset(0, 20).addBox(-4.5F, -4.0F, 2.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-2.75F, -3.25F, -3.0F);
        right.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3927F);
        cube_r3.setTextureOffset(0, 28).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-1.25F, -3.25F, -3.0F);
        right.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.3927F);
        cube_r4.setTextureOffset(0, 31).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);
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