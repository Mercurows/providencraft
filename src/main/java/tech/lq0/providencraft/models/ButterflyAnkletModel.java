package tech.lq0.providencraft.models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ButterflyAnkletModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer left;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer right;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer left_total;
	private final ModelRenderer right_total;

	public ButterflyAnkletModel() {
		super(1.0f);
		textureWidth = 16;
		textureHeight = 16;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 1.0F, 0.0F);

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 12.0F, 0.0F);

		left = new ModelRenderer(this);
		left.setRotationPoint(-2.0F, 12.0F, 0.5F);
		main.addChild(left_total);
		left_total.addChild(left);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(1.15F, -4.0F, 2.5F);
		left.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.4363F, 0.0F);
		cube_r1.setTextureOffset(0, 8).addBox(-2.5F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(2.85F, -4.0F, 2.5F);
		left.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.4363F, 0.0F);
		cube_r2.setTextureOffset(8, 0).addBox(-1.5F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);

		right = new ModelRenderer(this);
		right.setRotationPoint(-2.0F, 12.0F, 0.5F);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 12.0F, 0.0F);
		main.addChild(right_total);
		right_total.addChild(right);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.15F, -4.0F, 2.5F);
		right.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.4363F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(2.85F, -4.0F, 2.5F);
		right.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.4363F, 0.0F);
		cube_r4.setTextureOffset(0, 4).addBox(-1.5F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		left_total.copyModelAngles(bipedLeftLeg);
		right_total.copyModelAngles(bipedRightLeg);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}