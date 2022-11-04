package tech.lq0.providencraft.models;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class HiruHeadModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;

    public HiruHeadModel() {
        super(1.0f);
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(main, 0F, 0F, 0F);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(bone);
        setRotationAngle(bone, 0.0F, -1.5708F, 0.0F);
        bone.setTextureOffset(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(bone2);
        setRotationAngle(bone2, 0.0F, -1.5708F, 0.0F);
        bone2.setTextureOffset(0, 32).addBox(-9.0F, -10.0F, 6.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(0, 0).addBox(-9.0F, -10.0F, -8.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(6, 44).addBox(-9.0F, -12.0F, 4.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(15, 32).addBox(-9.0F, -14.0F, 2.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(6, 0).addBox(-9.0F, -14.0F, 0.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(10, 8).addBox(-9.0F, -14.0F, -2.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(27, 32).addBox(-9.0F, -14.0F, -4.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(0, 10).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(0, 44).addBox(-8.0F, -8.0F, -9.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);
        bone2.setTextureOffset(26, 41).addBox(-8.0F, -8.0F, 8.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);
        bone2.setTextureOffset(38, 35).addBox(-1.0F, -13.0F, -9.0F, 9.0F, 2.0F, 1.0F, 0.0F, false);
        bone2.setTextureOffset(38, 32).addBox(-1.0F, -13.0F, 8.0F, 9.0F, 2.0F, 1.0F, 0.0F, false);
        bone2.setTextureOffset(46, 38).addBox(8.0F, -13.0F, -8.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(18, 44).addBox(8.0F, -13.0F, 6.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(12, 44).addBox(-1.0F, -21.0182F, -6.7343F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, -22.6667F, -3.0555F);
        bone2.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(27, 32).addBox(-1.0F, -1.5F, 7.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, -22.2623F, 3.2006F);
        bone2.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.1745F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(0, 32).addBox(-1.0F, -0.5F, -10.0F, 2.0F, 1.0F, 11.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, -16.5F, -3.0F);
        bone2.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.2618F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(15, 32).addBox(-1.0F, -1.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-1.0F, -4.0F, -8.5F);
        bone2.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.2182F);
        cube_r4.setTextureOffset(34, 40).addBox(-1.0F, -4.0F, -0.5F, 2.0F, 8.0F, 1.0F, 0.0F, false);
        cube_r4.setTextureOffset(40, 40).addBox(-1.0F, -4.0F, 16.5F, 2.0F, 8.0F, 1.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
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