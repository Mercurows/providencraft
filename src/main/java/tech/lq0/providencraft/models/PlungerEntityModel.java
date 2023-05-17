package tech.lq0.providencraft.models;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.projectile.PlungerEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class PlungerEntityModel extends EntityModel<PlungerEntity> {
    private final ModelRenderer group2;
    private final ModelRenderer group;
    private final ModelRenderer group3;
    private final ModelRenderer handle;

    public PlungerEntityModel() {
        textureWidth = 64;
        textureHeight = 64;

        group2 = new ModelRenderer(this);
        group2.setRotationPoint(2.0F, 20.0F, 0.0F);


        group = new ModelRenderer(this);
        group.setRotationPoint(0.0F, 0.0F, 0.0F);
        group2.addChild(group);
        group.setTextureOffset(0, 18).addBox(4.0F, -3.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        group.setTextureOffset(0, 26).addBox(5.0F, -4.0F, -3.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        group.setTextureOffset(24, 22).addBox(5.0F, -4.0F, 2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        group.setTextureOffset(18, 17).addBox(5.0F, -4.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        group.setTextureOffset(16, 12).addBox(5.0F, 1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        group.setTextureOffset(20, 22).addBox(6.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        group.setTextureOffset(16, 22).addBox(6.0F, -4.0F, 3.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        group.setTextureOffset(20, 4).addBox(7.0F, -4.0F, 4.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        group.setTextureOffset(10, 19).addBox(7.0F, -4.0F, -5.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
        group.setTextureOffset(8, 12).addBox(6.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        group.setTextureOffset(10, 5).addBox(7.0F, -6.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        group.setTextureOffset(0, 11).addBox(6.0F, 2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        group.setTextureOffset(0, 4).addBox(7.0F, 3.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);

        group3 = new ModelRenderer(this);
        group3.setRotationPoint(1.5F, -7.0F, 3.5F);
        group2.addChild(group3);
        group3.setTextureOffset(10, 4).addBox(5.5F, 2.0F, -7.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        group3.setTextureOffset(0, 8).addBox(5.5F, 2.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        group3.setTextureOffset(0, 6).addBox(5.5F, 9.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        group3.setTextureOffset(0, 4).addBox(5.5F, 9.0F, -7.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        handle = new ModelRenderer(this);
        handle.setRotationPoint(0.0F, 0.0F, 0.0F);
        group2.addChild(handle);
        handle.setTextureOffset(0, 0).addBox(-19.0F, -2.0F, -1.0F, 23.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void setRotationAngles(PlungerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    @ParametersAreNonnullByDefault
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        group2.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}