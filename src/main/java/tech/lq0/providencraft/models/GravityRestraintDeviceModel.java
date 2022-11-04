package tech.lq0.providencraft.models;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class GravityRestraintDeviceModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer bone;
    private final ModelRenderer cube_r1;

    public GravityRestraintDeviceModel() {
        super(1F);
        textureWidth = 16;
        textureHeight = 16;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 1.0F, 0.0F);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(-2.0F, 11.0F, 0.0F);
        main.addChild(bone);
        bone.setTextureOffset(0, 5).addBox(-0.5F, -9.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(3.5F, -9.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(6, 0).addBox(0.0F, -9.0F, 1.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 5).addBox(0.0F, -9.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 2).addBox(3.0F, -9.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(1.5F, -7.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(2.0F, -8.5F, -2.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
        cube_r1.setTextureOffset(6, 5).addBox(-1.0F, -1.0F, -0.6F, 2.0F, 2.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.main.copyModelAngles(this.bipedLeftLeg);
        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}