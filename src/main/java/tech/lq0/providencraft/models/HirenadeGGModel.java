package tech.lq0.providencraft.models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.projectile.HirenadeGGEntity;

public class HirenadeGGModel extends EntityModel<HirenadeGGEntity> {
	private final ModelRenderer main;
	private final ModelRenderer body;
	private final ModelRenderer feet;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;

	public HirenadeGGModel() {
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 1.0F, -3.0F);
		main.addChild(body);
		body.setTextureOffset(0, 27).addBox(3.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(10, 28).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 8.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(40, 16).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 8.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(20, 19).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 18).addBox(-3.0F, 3.0F, -2.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(18, 28).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 6.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 27).addBox(4.0F, -4.0F, -2.0F, 1.0F, 6.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(4, 27).addBox(-4.0F, -4.0F, -4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		feet = new ModelRenderer(this);
		feet.setRotationPoint(0.0F, 1.0F, -3.0F);
		main.addChild(feet);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.1F, -3.75F, 13.0F);
		feet.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.7854F);
		cube_r1.setTextureOffset(0, 5).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.1F, 3.25F, 13.0F);
		feet.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.7854F);
		cube_r2.setTextureOffset(0, 18).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.1F, 2.5F, 9.0F);
		feet.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
		cube_r3.setTextureOffset(26, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.1F, -4.5F, 9.0F);
		feet.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
		cube_r4.setTextureOffset(28, 28).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(3.5F, -1.0F, 9.0F);
		feet.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
		cube_r5.setTextureOffset(36, 8).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(2.75F, -1.0F, 13.0F);
		feet.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
		cube_r6.setTextureOffset(20, 18).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-4.25F, -1.0F, 13.0F);
		feet.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.7854F);
		cube_r7.setTextureOffset(0, 22).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-3.5F, -1.0F, 9.0F);
		feet.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.7854F);
		cube_r8.setTextureOffset(36, 36).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
	}


	@Override
	public void setRotationAngles(HirenadeGGEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}