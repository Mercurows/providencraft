package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class OrangeTrackerModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer body_total;
	private final ModelRenderer body;
	private final ModelRenderer tracker;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer left_total;
	private final ModelRenderer left;
	private final ModelRenderer tracker2;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer right_total;
	private final ModelRenderer right;
	private final ModelRenderer tracker3;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public OrangeTrackerModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 1.0F, 0.0F);
		

		body_total = new ModelRenderer(this);
		body_total.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.addChild(body_total);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 20.0F, 0.0F);
		body_total.addChild(body);
		body.setTextureOffset(0, 2).addBox(-4.5F, -14.0F, -2.75F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-4.5F, -14.0F, 1.75F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(12, 9).addBox(-4.75F, -14.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(12, 4).addBox(3.75F, -14.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(18, 6).addBox(-1.5F, -14.75F, -2.75F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(18, 4).addBox(-1.5F, -13.25F, -2.75F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		tracker = new ModelRenderer(this);
		tracker.setRotationPoint(0.0F, -1.0F, 0.75F);
		body.addChild(tracker);
		tracker.setTextureOffset(12, 22).addBox(-1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		tracker.setTextureOffset(6, 22).addBox(-0.5F, -13.0F, -5.25F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		tracker.setTextureOffset(25, 5).addBox(-1.0F, -14.5F, -5.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.933F, -11.884F, -5.5F);
		tracker.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.0472F);
		cube_r1.setTextureOffset(0, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.933F, -11.884F, -5.5F);
		tracker.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.0472F);
		cube_r2.setTextureOffset(25, 2).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.1585F, -12.0425F, -4.5F);
		tracker.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -1.0472F);
		cube_r3.setTextureOffset(0, 22).addBox(-0.75F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-0.1585F, -12.0425F, -4.5F);
		tracker.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 1.0472F);
		cube_r4.setTextureOffset(22, 8).addBox(-1.25F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(left_total);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(-2.0F, 10.0F, 0.0F);
		left_total.addChild(left);
		left.setTextureOffset(10, 17).addBox(0.0F, -3.0F, -2.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(0, 17).addBox(0.0F, -3.0F, 1.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(6, 10).addBox(-0.75F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		left.setTextureOffset(0, 9).addBox(3.75F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		tracker2 = new ModelRenderer(this);
		tracker2.setRotationPoint(2.0F, 10.0F, 1.0F);
		left.addChild(tracker2);
		tracker2.setTextureOffset(18, 20).addBox(-1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		tracker2.setTextureOffset(18, 17).addBox(-0.5F, -13.0F, -5.25F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		tracker2.setTextureOffset(23, 24).addBox(-1.0F, -14.5F, -5.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.933F, -11.884F, -5.5F);
		tracker2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -1.0472F);
		cube_r5.setTextureOffset(23, 19).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-0.933F, -11.884F, -5.5F);
		tracker2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 1.0472F);
		cube_r6.setTextureOffset(23, 22).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.1585F, -12.0425F, -4.5F);
		tracker2.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -1.0472F);
		cube_r7.setTextureOffset(20, 0).addBox(-0.75F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-0.1585F, -12.0425F, -4.5F);
		tracker2.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 1.0472F);
		cube_r8.setTextureOffset(20, 14).addBox(-1.25F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(right_total);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(2.0F, 10.0F, 0.0F);
		right_total.addChild(right);
		right.setTextureOffset(10, 15).addBox(-4.0F, -3.0F, -2.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(0, 15).addBox(-4.0F, -3.0F, 1.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(6, 5).addBox(-0.25F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		right.setTextureOffset(0, 4).addBox(-4.75F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		tracker3 = new ModelRenderer(this);
		tracker3.setRotationPoint(-2.0F, 10.0F, 1.0F);
		right.addChild(tracker3);
		tracker3.setTextureOffset(12, 19).addBox(-1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		tracker3.setTextureOffset(18, 9).addBox(-0.5F, -13.0F, -5.25F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		tracker3.setTextureOffset(18, 23).addBox(-1.0F, -14.5F, -5.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-0.933F, -11.884F, -5.5F);
		tracker3.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 1.0472F);
		cube_r9.setTextureOffset(22, 12).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.933F, -11.884F, -5.5F);
		tracker3.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -1.0472F);
		cube_r10.setTextureOffset(22, 17).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-0.1585F, -12.0425F, -4.5F);
		tracker3.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 1.0472F);
		cube_r11.setTextureOffset(0, 19).addBox(-1.25F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.1585F, -12.0425F, -4.5F);
		tracker3.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -1.0472F);
		cube_r12.setTextureOffset(6, 19).addBox(-0.75F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	@ParametersAreNonnullByDefault
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.body_total.copyModelAngles(this.bipedBody);
		this.right_total.copyModelAngles(this.bipedRightLeg);
		this.left_total.copyModelAngles(this.bipedLeftLeg);
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}