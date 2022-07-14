package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class KeroroIdolHelmetModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer total;
	private final ModelRenderer main;
	private final ModelRenderer left;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer shu;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer right;
	private final ModelRenderer bow2;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer shu2;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;

	public KeroroIdolHelmetModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		total = new ModelRenderer(this);
		total.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 0.0F, 0.0F);
		total.addChild(main);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(0.25F, 0.25F, 0.0F);
		main.addChild(left);
		

		bow = new ModelRenderer(this);
		bow.setRotationPoint(4.7025F, 0.3935F, 0.2F);
		left.addChild(bow);
		setRotationAngle(bow, 0.0F, 0.0F, -0.48F);
		bow.setTextureOffset(12, 15).addBox(2.6254F, -8.0891F, -0.45F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bow.setTextureOffset(18, 9).addBox(3.1396F, -7.6412F, -0.95F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.0544F, -0.0451F, -0.2F);
		bow.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
		cube_r1.setTextureOffset(6, 11).addBox(-3.4056F, -8.6297F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.2975F, 1.373F, 0.05F);
		bow.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.0472F);
		cube_r2.setTextureOffset(12, 9).addBox(-5.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.9898F, 2.8742F, 0.05F);
		bow.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.2182F);
		cube_r3.setTextureOffset(3, 23).addBox(5.0458F, -7.0908F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.4203F, 3.1359F, 0.05F);
		bow.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -1.5708F);
		cube_r4.setTextureOffset(17, 11).addBox(6.324F, 3.3937F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-1.1269F, 2.8742F, 0.05F);
		bow.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.2182F);
		cube_r5.setTextureOffset(22, 12).addBox(1.1671F, -8.6899F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-0.5574F, 3.1359F, 0.05F);
		bow.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 1.5708F);
		cube_r6.setTextureOffset(12, 0).addBox(-8.324F, -4.9942F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-0.4346F, 1.373F, 0.05F);
		bow.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -1.0472F);
		cube_r7.setTextureOffset(11, 6).addBox(6.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.4203F, -3.122F, 0.05F);
		bow.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 1.5708F);
		cube_r8.setTextureOffset(17, 14).addBox(-7.8682F, -4.3937F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.9898F, -2.8603F, 0.05F);
		bow.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.2182F);
		cube_r9.setTextureOffset(23, 5).addBox(1.974F, -8.7649F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.2975F, -1.3591F, 0.05F);
		bow.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -1.0472F);
		cube_r10.setTextureOffset(12, 12).addBox(6.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-0.5574F, -3.122F, 0.05F);
		bow.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -1.5708F);
		cube_r11.setTextureOffset(0, 13).addBox(5.8682F, 2.9942F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-1.1269F, -2.8603F, 0.05F);
		bow.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.2182F);
		cube_r12.setTextureOffset(9, 23).addBox(4.2388F, -7.1659F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-0.4346F, -1.3591F, 0.05F);
		bow.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, 1.0472F);
		cube_r13.setTextureOffset(6, 14).addBox(-5.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		shu = new ModelRenderer(this);
		shu.setRotationPoint(4.25F, 5.4825F, 0.4238F);
		left.addChild(shu);
		setRotationAngle(shu, 0.1745F, 0.0F, 0.0F);
		shu.setTextureOffset(22, 8).addBox(-0.5F, -9.3095F, 0.356F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.0F, -8.1224F, 2.3437F);
		shu.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.3491F, 0.0F, -0.2182F);
		cube_r14.setTextureOffset(21, 16).addBox(-0.0119F, -0.2363F, -0.0988F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.0F, -8.1224F, 2.3437F);
		shu.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.4363F, 0.0F, -0.2182F);
		cube_r15.setTextureOffset(16, 21).addBox(-0.0119F, -1.5298F, -0.1956F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.0F, -8.1224F, 2.3437F);
		shu.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0436F, 0.0F, -0.2182F);
		cube_r16.setTextureOffset(17, 17).addBox(-0.0119F, -1.3385F, -0.7662F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.0F, 0.9225F, -1.0939F);
		shu.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.7854F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(22, 0).addBox(-0.5F, -7.5532F, -5.0886F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.0F, 0.608F, -1.3366F);
		shu.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.3927F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(9, 18).addBox(-0.5F, -9.8104F, -2.2315F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		right = new ModelRenderer(this);
		right.setRotationPoint(-0.25F, 0.25F, 0.0F);
		main.addChild(right);
		

		bow2 = new ModelRenderer(this);
		bow2.setRotationPoint(-4.7025F, 0.3935F, 0.2F);
		right.addChild(bow2);
		setRotationAngle(bow2, 0.0F, 0.0F, 0.48F);
		bow2.setTextureOffset(10, 3).addBox(-4.6254F, -8.0891F, -0.45F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bow2.setTextureOffset(6, 3).addBox(-4.1396F, -7.6412F, -0.95F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0544F, -0.0451F, -0.2F);
		bow2.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -0.7854F);
		cube_r19.setTextureOffset(0, 0).addBox(1.4056F, -8.6297F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-0.2975F, 1.373F, 0.05F);
		bow2.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, -1.0472F);
		cube_r20.setTextureOffset(0, 3).addBox(3.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-0.9898F, 2.8742F, 0.05F);
		bow2.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 0.2182F);
		cube_r21.setTextureOffset(20, 20).addBox(-6.0458F, -7.0908F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-0.4203F, 3.1359F, 0.05F);
		bow2.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, 1.5708F);
		cube_r22.setTextureOffset(4, 17).addBox(-8.324F, 3.3937F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(1.1269F, 2.8742F, 0.05F);
		bow2.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -0.2182F);
		cube_r23.setTextureOffset(0, 21).addBox(-2.1671F, -8.6899F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.5574F, 3.1359F, 0.05F);
		bow2.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -1.5708F);
		cube_r24.setTextureOffset(5, 5).addBox(6.324F, -4.9942F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.4346F, 1.373F, 0.05F);
		bow2.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 1.0472F);
		cube_r25.setTextureOffset(6, 0).addBox(-8.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-0.4203F, -3.122F, 0.05F);
		bow2.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, -1.5708F);
		cube_r26.setTextureOffset(17, 7).addBox(5.8682F, -4.3937F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-0.9898F, -2.8603F, 0.05F);
		bow2.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, -0.2182F);
		cube_r27.setTextureOffset(6, 21).addBox(-2.974F, -8.7649F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-0.2975F, -1.3591F, 0.05F);
		bow2.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 1.0472F);
		cube_r28.setTextureOffset(0, 7).addBox(-8.9924F, -1.349F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(0.5574F, -3.122F, 0.05F);
		bow2.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, 1.5708F);
		cube_r29.setTextureOffset(6, 8).addBox(-7.8682F, 2.9942F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(1.1269F, -2.8603F, 0.05F);
		bow2.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, 0.2182F);
		cube_r30.setTextureOffset(12, 21).addBox(-5.2388F, -7.1659F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(0.4346F, -1.3591F, 0.05F);
		bow2.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -1.0472F);
		cube_r31.setTextureOffset(0, 10).addBox(3.2984F, -7.7471F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		shu2 = new ModelRenderer(this);
		shu2.setRotationPoint(-4.25F, 5.4825F, 0.4238F);
		right.addChild(shu2);
		setRotationAngle(shu2, 0.1745F, 0.0F, 0.0F);
		shu2.setTextureOffset(20, 3).addBox(-0.5F, -9.3095F, 0.356F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(0.0F, -8.1224F, 2.3437F);
		shu2.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.3491F, 0.0F, 0.2182F);
		cube_r32.setTextureOffset(18, 0).addBox(-0.9881F, -0.2363F, -0.0988F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(0.0F, -8.1224F, 2.3437F);
		shu2.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.4363F, 0.0F, 0.2182F);
		cube_r33.setTextureOffset(13, 18).addBox(-0.9881F, -1.5298F, -0.1956F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(0.0F, -8.1224F, 2.3437F);
		shu2.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0436F, 0.0F, 0.2182F);
		cube_r34.setTextureOffset(0, 16).addBox(-0.9881F, -1.3385F, -0.7662F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(0.0F, 0.9225F, -1.0939F);
		shu2.addChild(cube_r35);
		setRotationAngle(cube_r35, -0.7854F, 0.0F, 0.0F);
		cube_r35.setTextureOffset(3, 19).addBox(-0.5F, -7.5532F, -5.0886F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(0.0F, 0.608F, -1.3366F);
		shu2.addChild(cube_r36);
		setRotationAngle(cube_r36, -0.3927F, 0.0F, 0.0F);
		cube_r36.setTextureOffset(16, 3).addBox(-0.5F, -9.8104F, -2.2315F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	@ParametersAreNonnullByDefault
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.total.copyModelAngles(this.bipedHead);
		total.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}