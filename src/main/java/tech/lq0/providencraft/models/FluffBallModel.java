package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.FluffBallEntity;

public class FluffBallModel extends EntityModel<FluffBallEntity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;

	public FluffBallModel() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 19.7862F, -0.4642F);
		bone.setTextureOffset(12, 11).addBox(-2.0F, 3.2138F, -1.5358F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -0.7862F, -2.5358F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(10, 16).addBox(-3.0F, -0.7862F, -1.5358F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 15).addBox(2.0F, -0.7862F, -1.5358F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 10).addBox(-2.0F, -1.7862F, -1.5358F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 2).addBox(2.0F, -1.7862F, -0.5358F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-4.0F, -1.7862F, -0.5358F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(14, 0).addBox(-2.0F, -2.7862F, -0.5358F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-3.5F, -0.6054F, -1.1066F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.4363F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(14, 2).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r1.setTextureOffset(6, 15).addBox(6.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(FluffBallEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}