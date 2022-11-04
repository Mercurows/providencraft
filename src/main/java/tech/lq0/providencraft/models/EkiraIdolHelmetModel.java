package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class EkiraIdolHelmetModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer total;
    private final ModelRenderer main;
    private final ModelRenderer helmet;
    private final ModelRenderer bow;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer shu;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer kou;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;

    public EkiraIdolHelmetModel() {
        super(1.0f);
        textureWidth = 16;
        textureHeight = 16;

        total = new ModelRenderer(this);
        total.setRotationPoint(0.0F, 24.0F, 0.0F);


        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 0.0F, 0.0F);
        total.addChild(main);


        helmet = new ModelRenderer(this);
        helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(helmet);


        bow = new ModelRenderer(this);
        bow.setRotationPoint(4.4727F, -8.2429F, 0.45F);
        helmet.addChild(bow);
        setRotationAngle(bow, 0.0F, 0.0F, 0.7418F);
        bow.setTextureOffset(9, 1).addBox(-1.9727F, -0.2571F, -0.45F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bow.setTextureOffset(4, 3).addBox(-0.0409F, -0.7394F, -0.45F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0273F, -0.0071F, -0.2F);
        bow.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.1309F);
        cube_r1.setTextureOffset(3, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-3.9659F, -0.8094F, 0.05F);
        bow.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.2618F);
        cube_r2.setTextureOffset(4, 0).addBox(4.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-0.8774F, -0.4812F, 0.05F);
        bow.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.2618F);
        cube_r3.setTextureOffset(8, 8).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        shu = new ModelRenderer(this);
        shu.setRotationPoint(0.0F, 0.0F, 0.0F);
        helmet.addChild(shu);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(4.25F, -4.5F, 0.0F);
        shu.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.0873F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(5, 5).addBox(-0.75F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(4.0F, -4.5F, 0.5F);
        shu.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.3011F, 0.0522F, -0.1666F);
        cube_r5.setTextureOffset(0, 6).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        kou = new ModelRenderer(this);
        kou.setRotationPoint(0.25F, 0.0F, 0.0F);
        helmet.addChild(kou);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-4.5F, -5.5F, 0.0F);
        kou.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.3927F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-4.5F, -6.5F, 0.0F);
        kou.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.3927F, 0.0F, 0.0F);
        cube_r7.setTextureOffset(0, 3).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.total.copyModelAngles(this.bipedHead);
        total.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}