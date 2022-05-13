package tech.lq0.providencraft.models;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class FrogCrownModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;

	public FrogCrownModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -8.5F, 0.0F);
		main.addChild(bone2);
		bone2.setTextureOffset(0, 5).addBox(-4.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(2.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(8, 5).addBox(-2.0F, -0.5F, 2.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(8, 0).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(0, 24).addBox(-3.0F, -0.5F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(23, 20).addBox(2.0F, -0.5F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(23, 8).addBox(2.0F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(3, 23).addBox(-3.0F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.9393F, 0.0F, -2.3536F);
		bone2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.setTextureOffset(12, 3).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(3.0607F, 0.0F, -2.2322F);
		bone2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.setTextureOffset(9, 22).addBox(-2.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.9393F, 0.0F, 2.3536F);
		bone2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.7854F, 0.0F);
		cube_r3.setTextureOffset(20, 15).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(3.0607F, 0.0F, 2.2322F);
		bone2.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.setTextureOffset(13, 22).addBox(-2.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-2.9393F, 0.0F, 2.3536F);
		bone2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.7854F, 0.0F);
		cube_r5.setTextureOffset(21, 18).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-3.0607F, 0.0F, 2.2322F);
		bone2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.7854F, 0.0F);
		cube_r6.setTextureOffset(17, 22).addBox(1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-3.0607F, 0.0F, -2.2322F);
		bone2.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.7854F, 0.0F);
		cube_r7.setTextureOffset(21, 22).addBox(1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-2.9393F, 0.0F, -2.3536F);
		bone2.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.7854F, 0.0F);
		cube_r8.setTextureOffset(22, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -8.0F, 0.0F);
		main.addChild(bone);
		bone.setTextureOffset(17, 18).addBox(-4.0F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(11, 18).addBox(3.0F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(5, 16).addBox(3.0F, -2.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(15, 14).addBox(-4.0F, -2.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(22, 5).addBox(-4.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 22).addBox(3.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(15, 18).addBox(-0.6F, -5.0F, 3.05F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(5, 10).addBox(-0.6F, -5.0F, -3.95F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-3.25F, -2.5F, 3.25F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.7854F, 0.0F);
		cube_r9.setTextureOffset(9, 8).addBox(0.5F, 0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r9.setTextureOffset(18, 6).addBox(0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-3.0732F, -3.5F, 3.0732F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.7854F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(0.25F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-3.25F, -2.5F, -3.25F);
		bone.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -0.7854F, 0.0F);
		cube_r11.setTextureOffset(0, 10).addBox(0.5F, 0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r11.setTextureOffset(19, 9).addBox(0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-3.0732F, -3.5F, -3.0732F);
		bone.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -0.7854F, 0.0F);
		cube_r12.setTextureOffset(0, 2).addBox(0.25F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(3.25F, -2.5F, -3.25F);
		bone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.7854F, 0.0F);
		cube_r13.setTextureOffset(5, 12).addBox(-1.5F, 0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r13.setTextureOffset(4, 20).addBox(-1.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(3.0732F, -3.5F, -3.0732F);
		bone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.7854F, 0.0F);
		cube_r14.setTextureOffset(0, 5).addBox(-1.25F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(3.0732F, -3.5F, 3.0732F);
		bone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.7854F, 0.0F);
		cube_r15.setTextureOffset(0, 7).addBox(-1.25F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(3.25F, -2.5F, 3.25F);
		bone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, -0.7854F, 0.0F);
		cube_r16.setTextureOffset(10, 13).addBox(-1.5F, 0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r16.setTextureOffset(20, 12).addBox(-1.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-0.1F, -2.5F, -3.45F);
		bone.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -1.5708F, 0.0F);
		cube_r17.setTextureOffset(0, 18).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-0.1F, -1.5F, -3.45F);
		bone.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, -1.5708F, 0.0F);
		cube_r18.setTextureOffset(0, 14).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-0.6F, -2.5F, 3.55F);
		bone.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, -1.5708F, 0.0F);
		cube_r19.setTextureOffset(14, 9).addBox(-0.5F, 0.5F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-0.1F, -2.5F, 3.55F);
		bone.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, -1.5708F, 0.0F);
		cube_r20.setTextureOffset(18, 1).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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