package tech.lq0.providencraft.models;// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.BloodCrystalEntity;

public class BloodCrystalModel extends EntityModel<BloodCrystalEntity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public BloodCrystalModel() {
		textureWidth = 4;
		textureHeight = 4;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(1, 0).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-0.5F, -1.6F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -2.3562F, 0.0F);
		cube_r1.setTextureOffset(1, 0).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.setTextureOffset(1, 0).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(1, 0).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(BloodCrystalEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}