package tech.lq0.providencraft.models;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class ReinaWingsModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer wing1;
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
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer wing2;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
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

	public ReinaWingsModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(2.25F, -10.0F, 3.5F);
		main.addChild(wing1);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0053F, -6.9929F, -0.9979F);
		wing1.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.2618F, 0.0F);
		cube_r1.setTextureOffset(23, 16).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(11.2769F, -3.1676F, -4.0427F);
		wing1.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 1.7453F, -0.0873F);
		cube_r2.setTextureOffset(19, 10).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(10.3095F, -9.0227F, -4.0427F);
		wing1.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 1.7453F, -0.2182F);
		cube_r3.setTextureOffset(12, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(10.6011F, -9.1417F, -2.9635F);
		wing1.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, -0.3054F);
		cube_r4.setTextureOffset(4, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(10.5343F, -9.1381F, -1.8363F);
		wing1.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 1.2654F, -0.3491F);
		cube_r5.setTextureOffset(7, 8).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(10.1319F, -8.9984F, -0.8087F);
		wing1.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.9163F, -0.3927F);
		cube_r6.setTextureOffset(11, 14).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(9.3151F, -8.6601F, -0.0334F);
		wing1.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.5236F, -0.3927F);
		cube_r7.setTextureOffset(15, 12).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(8.3331F, -8.2533F, 0.3799F);
		wing1.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.2182F, -0.3927F);
		cube_r8.setTextureOffset(16, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(7.3202F, -7.8337F, 0.5F);
		wing1.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -0.3927F);
		cube_r9.setTextureOffset(19, 15).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(6.1764F, -7.4174F, 0.5F);
		wing1.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.3054F);
		cube_r10.setTextureOffset(0, 20).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(4.7843F, -8.0787F, 0.5F);
		wing1.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2182F);
		cube_r11.setTextureOffset(8, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(3.7396F, -7.8709F, 0.5F);
		wing1.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.1745F);
		cube_r12.setTextureOffset(12, 22).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(2.6082F, -7.6985F, 0.4056F);
		wing1.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -0.1745F, -0.1309F);
		cube_r13.setTextureOffset(23, 3).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(1.459F, -8.0807F, 0.1252F);
		wing1.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -0.3491F, -0.0873F);
		cube_r14.setTextureOffset(16, 23).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.454F, -8.0228F, -0.2738F);
		wing1.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.4363F, -0.0436F);
		cube_r15.setTextureOffset(23, 19).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(-2.25F, -10.0F, 3.5F);
		main.addChild(wing2);
		

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-0.0053F, -6.9929F, -0.9979F);
		wing2.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.2618F, 0.0F);
		cube_r16.setTextureOffset(23, 7).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-11.2769F, -3.1676F, -4.0427F);
		wing2.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -1.7453F, 0.0873F);
		cube_r17.setTextureOffset(7, 16).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-10.3095F, -9.0227F, -4.0427F);
		wing2.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, -1.7453F, 0.2182F);
		cube_r18.setTextureOffset(0, 9).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-10.6011F, -9.1417F, -2.9635F);
		wing2.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, -1.5708F, 0.3054F);
		cube_r19.setTextureOffset(0, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-10.5343F, -9.1381F, -1.8363F);
		wing2.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, -1.2654F, 0.3491F);
		cube_r20.setTextureOffset(8, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-10.1319F, -8.9984F, -0.8087F);
		wing2.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, -0.9163F, 0.3927F);
		cube_r21.setTextureOffset(11, 7).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-9.3151F, -8.6601F, -0.0334F);
		wing2.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, -0.5236F, 0.3927F);
		cube_r22.setTextureOffset(3, 15).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-8.3331F, -8.2533F, 0.3799F);
		wing2.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, -0.2182F, 0.3927F);
		cube_r23.setTextureOffset(15, 6).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(-7.3202F, -7.8337F, 0.5F);
		wing2.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, 0.3927F);
		cube_r24.setTextureOffset(15, 18).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(-6.1764F, -7.4174F, 0.5F);
		wing2.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.3054F);
		cube_r25.setTextureOffset(19, 5).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-4.7843F, -8.0787F, 0.5F);
		wing2.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, 0.2182F);
		cube_r26.setTextureOffset(20, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-3.7396F, -7.8709F, 0.5F);
		wing2.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, 0.1745F);
		cube_r27.setTextureOffset(19, 20).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-2.6082F, -7.6985F, 0.4056F);
		wing2.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.1745F, 0.1309F);
		cube_r28.setTextureOffset(4, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-1.459F, -8.0807F, 0.1252F);
		wing2.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.3491F, 0.0873F);
		cube_r29.setTextureOffset(23, 10).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-0.454F, -8.0228F, -0.2738F);
		wing2.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.4363F, 0.0436F);
		cube_r30.setTextureOffset(23, 13).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}