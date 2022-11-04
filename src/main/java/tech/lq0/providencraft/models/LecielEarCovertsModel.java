package tech.lq0.providencraft.models;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class LecielEarCovertsModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer left;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer right;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;

    public LecielEarCovertsModel() {
        super(1.0f);
        textureWidth = 16;
        textureHeight = 16;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.0F, 0.0F);


        left = new ModelRenderer(this);
        left.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(left);
        left.setTextureOffset(0, 4).addBox(3.75F, -5.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(5.1137F, -1.6728F, -1.4054F);
        left.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.3927F, 0.0F, -0.6981F);
        cube_r1.setTextureOffset(11, 8).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(5.2565F, -1.5026F, -1.1609F);
        left.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.7418F, 0.0F, -0.6981F);
        cube_r2.setTextureOffset(7, 11).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(4.1853F, -7.2806F, -2.0F);
        left.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.0167F, 0.0403F, -0.393F);
        cube_r3.setTextureOffset(4, 10).addBox(-0.7513F, -1.6781F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(4.1853F, -7.2806F, -2.0F);
        left.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.5729F, 0.0433F, -0.131F);
        cube_r4.setTextureOffset(10, 0).addBox(-0.9453F, -1.088F, 0.0147F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r4.setTextureOffset(5, 7).addBox(-0.9553F, -0.2446F, 0.552F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(4.1853F, -7.2806F, -2.0F);
        left.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.5615F, 0.0433F, -0.131F);
        cube_r5.setTextureOffset(0, 10).addBox(-0.9553F, -1.088F, -1.0147F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r5.setTextureOffset(6, 4).addBox(-0.9453F, -0.2446F, -1.552F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(4.1853F, -7.2806F, -2.0F);
        left.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.0057F, 0.0433F, -0.131F);
        cube_r6.setTextureOffset(6, 0).addBox(-0.9353F, -0.7194F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(4.6428F, -2.234F, -0.5F);
        left.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, -0.6981F);
        cube_r7.setTextureOffset(8, 9).addBox(-1.0F, -1.0F, -1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        right = new ModelRenderer(this);
        right.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(right);
        right.setTextureOffset(0, 0).addBox(-4.75F, -5.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-5.2565F, -1.5026F, -1.1609F);
        right.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.7418F, 0.0F, 0.6981F);
        cube_r8.setTextureOffset(9, 6).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-5.1137F, -1.6728F, -1.4054F);
        right.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.3927F, 0.0F, 0.6981F);
        cube_r9.setTextureOffset(9, 3).addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-4.6428F, -2.234F, -0.5F);
        right.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, 0.6981F);
        cube_r10.setTextureOffset(0, 8).addBox(0.0F, -1.0F, -1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.main.copyModelAngles(this.bipedHead);
        main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}