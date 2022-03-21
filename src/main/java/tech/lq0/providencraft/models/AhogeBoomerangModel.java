package tech.lq0.providencraft.models;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.AhogeBoomerangEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class AhogeBoomerangModel extends EntityModel<AhogeBoomerangEntity> {
    private final ModelRenderer bb_main;

    public AhogeBoomerangModel() {
        textureWidth = 64;
        textureHeight = 64;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);


        ModelRenderer bone = new ModelRenderer(this);
        bone.setRotationPoint(8.0F, 0.0F, -8.0F);
        bb_main.addChild(bone);
        bone.setTextureOffset(30, 27).addBox(-10.0F, -1.0F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(0, 8).addBox(-12.0F, -1.0F, 8.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
        bone.setTextureOffset(0, 2).addBox(-9.0F, -1.0F, 9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(7, 31).addBox(-14.0F, -1.0F, 10.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone.setTextureOffset(23, 15).addBox(-13.0F, -1.0F, 9.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone.setTextureOffset(16, 21).addBox(-6.0F, -1.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone.setTextureOffset(30, 22).addBox(-5.0F, -1.0F, 11.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(0, 21).addBox(-4.0F, -1.0F, 10.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone.setTextureOffset(30, 11).addBox(-3.0F, -1.0F, 10.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(14, 27).addBox(-2.0F, -1.0F, 9.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(0, 27).addBox(-1.0F, -1.0F, 8.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(11, 8).addBox(-10.0F, -1.0F, 10.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        bone.setTextureOffset(0, 16).addBox(-9.0F, -1.0F, 12.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

        ModelRenderer bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(8.0F, 0.0F, -8.0F);
        bb_main.addChild(bone2);
        bone2.setTextureOffset(24, 26).addBox(-7.0F, -1.0F, 6.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone2.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
        bone2.setTextureOffset(0, 0).addBox(-9.0F, -1.0F, 6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        bone2.setTextureOffset(30, 16).addBox(-3.0F, -1.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone2.setTextureOffset(9, 20).addBox(-4.0F, -1.0F, 2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone2.setTextureOffset(19, 7).addBox(-11.0F, -1.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone2.setTextureOffset(8, 26).addBox(-12.0F, -1.0F, 1.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone2.setTextureOffset(19, 0).addBox(-13.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
        bone2.setTextureOffset(26, 6).addBox(-14.0F, -1.0F, 2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone2.setTextureOffset(26, 0).addBox(-15.0F, -1.0F, 3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone2.setTextureOffset(23, 21).addBox(-16.0F, -1.0F, 4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone2.setTextureOffset(11, 0).addBox(-7.0F, -1.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        bone2.setTextureOffset(14, 15).addBox(-10.0F, -1.0F, 0.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(AhogeBoomerangEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        bb_main.rotateAngleX = limbSwing;
        bb_main.rotateAngleY = netHeadYaw;
        bb_main.rotateAngleZ = headPitch;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}