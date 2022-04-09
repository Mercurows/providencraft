package tech.lq0.providencraft.models;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class ElectricHornModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer bone;
    private final ModelRenderer bone2;

    public ElectricHornModel() {
        super(1.0f);
        textureWidth = 32;
        textureHeight = 32;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.0F, 0.0F);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, -3.0F, 0.0F);
        main.addChild(bone);
        bone.setTextureOffset(6, 0).addBox(4.0F, -15.0F, -1.0F, 1.0F, 15.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(0, 22).addBox(5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(18, 3).addBox(5.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(10, 16).addBox(5.0F, -4.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(12, 8).addBox(5.0F, -10.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(12, 19).addBox(6.0F, -6.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(18, 17).addBox(4.5F, -14.5F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(6, 17).addBox(3.0F, -7.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -3.0F, 0.0F);
        main.addChild(bone2);
        bone2.setTextureOffset(0, 0).addBox(-5.0F, -15.0F, -1.0F, 1.0F, 15.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(16, 21).addBox(-6.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(18, 0).addBox(-7.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(16, 6).addBox(-8.0F, -4.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(12, 0).addBox(-6.0F, -10.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(18, 13).addBox(-7.0F, -6.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(18, 9).addBox(-5.5F, -14.5F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        bone2.setTextureOffset(0, 17).addBox(-4.0F, -7.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
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