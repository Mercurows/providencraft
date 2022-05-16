package tech.lq0.providencraft.models;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class SuccubusTailModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer bone;
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
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;

	public SuccubusTailModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 16.0F, 2.0F);
		main.addChild(bone);
		bone.setTextureOffset(4, 0).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(21, 4).addBox(-2.4606F, -8.0F, 2.2809F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 20).addBox(-6.3934F, -4.3954F, 2.2809F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 20).addBox(-7.8908F, -4.3954F, 3.4827F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(19, 15).addBox(-7.8908F, -5.6615F, 4.9915F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(18, 0).addBox(2.4377F, -9.7933F, 4.3471F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 9).addBox(4.5891F, -11.5291F, 4.3471F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(3.6578F, -15.0043F, 4.8471F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.48F);
		cube_r1.setTextureOffset(3, 9).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(4.9482F, -11.8279F, 4.8471F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3491F);
		cube_r2.setTextureOffset(0, 6).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(4.9482F, -10.2303F, 4.8471F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3491F);
		cube_r3.setTextureOffset(17, 12).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(4.5567F, -9.7425F, 4.8471F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.5672F);
		cube_r4.setTextureOffset(13, 17).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(3.7913F, -9.4057F, 4.8471F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.2618F);
		cube_r5.setTextureOffset(0, 18).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-1.2718F, -9.1239F, 4.8696F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.1309F, 0.0F);
		cube_r6.setTextureOffset(4, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(2.0539F, -9.3831F, 4.8518F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0302F, 0.041F, 0.1732F);
		cube_r7.setTextureOffset(18, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.6913F, -9.5409F, 5.0302F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0306F, 0.1719F, 0.1772F);
		cube_r8.setTextureOffset(10, 18).addBox(-0.051F, -0.583F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.6913F, -9.5409F, 5.0302F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.1745F, 0.0F);
		cube_r9.setTextureOffset(4, 7).addBox(-1.949F, -0.583F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-2.0891F, -9.6258F, 5.4915F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.0873F);
		cube_r10.setTextureOffset(16, 18).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-7.414F, -8.5746F, 5.4915F);
		bone.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2182F);
		cube_r11.setTextureOffset(8, 0).addBox(2.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-5.2346F, -8.9135F, 5.4915F);
		bone.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 1.0036F);
		cube_r12.setTextureOffset(19, 6).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-5.9249F, -8.3595F, 5.4915F);
		bone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, 0.7854F);
		cube_r13.setTextureOffset(7, 19).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-6.949F, -6.8104F, 5.4915F);
		bone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, 0.5236F);
		cube_r14.setTextureOffset(10, 11).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-6.9249F, -5.4027F, 4.9915F);
		bone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, 0.2618F);
		cube_r15.setTextureOffset(13, 19).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-6.8908F, -3.8954F, 5.3488F);
		bone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.8727F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(19, 17).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-6.8908F, -3.3954F, 4.4827F);
		bone.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.5236F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(19, 19).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-7.1945F, -3.8954F, 3.3599F);
		bone.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, -0.6109F, 0.0F);
		cube_r18.setTextureOffset(4, 20).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-6.0107F, -3.3954F, 3.2048F);
		bone.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.3927F, 0.0F);
		cube_r19.setTextureOffset(20, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-4.4537F, -3.7375F, 2.2809F);
		bone.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, -0.3491F);
		cube_r20.setTextureOffset(20, 10).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-0.6851F, -1.2279F, 2.7809F);
		bone.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, -0.8727F);
		cube_r21.setTextureOffset(20, 13).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-3.8901F, -5.6187F, 2.7809F);
		bone.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -1.1781F);
		cube_r22.setTextureOffset(9, 2).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-3.265F, -6.7956F, 2.7809F);
		bone.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -0.8727F);
		cube_r23.setTextureOffset(16, 20).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(-2.6436F, -7.317F, 2.7809F);
		bone.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -0.5236F);
		cube_r24.setTextureOffset(21, 1).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(-1.248F, -7.5F, 2.6065F);
		bone.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, -1.0908F, 0.0F);
		cube_r25.setTextureOffset(7, 21).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-0.6964F, -7.5F, 2.1228F);
		bone.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, -0.6109F, 0.0F);
		cube_r26.setTextureOffset(13, 21).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-0.5F, 3.2406F, 2.5F);
		main.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.0F, -0.48F);
		bone2.setTextureOffset(0, 0).addBox(4.0024F, -5.6446F, 3.8471F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(16, 14).addBox(2.4045F, -2.7145F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(16, 5).addBox(1.1112F, -4.1893F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(14, 11).addBox(5.6002F, -2.7145F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(13, 15).addBox(6.8935F, -4.1893F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 13).addBox(4.0024F, -10.6446F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(4.7801F, -9.3267F, 4.3471F);
		bone2.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, -0.48F);
		cube_r27.setTextureOffset(13, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(4.2246F, -9.3267F, 4.3471F);
		bone2.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 0.48F);
		cube_r28.setTextureOffset(13, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(5.0746F, -8.5177F, 4.3471F);
		bone2.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, -0.2182F);
		cube_r29.setTextureOffset(0, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(3.9301F, -8.5177F, 4.3471F);
		bone2.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, 0.2182F);
		cube_r30.setTextureOffset(14, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(6.8787F, -3.9552F, 4.3471F);
		bone2.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -0.3927F);
		cube_r31.setTextureOffset(7, 9).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(6.7699F, -5.1879F, 4.3471F);
		bone2.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, -0.6545F);
		cube_r32.setTextureOffset(9, 4).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(7.2291F, -4.4312F, 4.3471F);
		bone2.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -0.4363F);
		cube_r33.setTextureOffset(0, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(7.2105F, -3.0063F, 4.3471F);
		bone2.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, 0.5236F);
		cube_r34.setTextureOffset(7, 15).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(6.6925F, -2.4156F, 4.3471F);
		bone2.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -0.6545F);
		cube_r35.setTextureOffset(15, 2).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(5.4471F, -2.4049F, 4.3471F);
		bone2.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, 0.5672F);
		cube_r36.setTextureOffset(10, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(4.716F, -1.0025F, 4.3471F);
		bone2.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -0.6109F);
		cube_r37.setTextureOffset(4, 14).addBox(0.75F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(2.126F, -3.9552F, 4.3471F);
		bone2.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, 0.3927F);
		cube_r38.setTextureOffset(10, 7).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(2.2349F, -5.1879F, 4.3471F);
		bone2.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, 0.6545F);
		cube_r39.setTextureOffset(0, 11).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(1.7757F, -4.4312F, 4.3471F);
		bone2.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, 0.4363F);
		cube_r40.setTextureOffset(4, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(1.7942F, -3.0063F, 4.3471F);
		bone2.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, -0.5236F);
		cube_r41.setTextureOffset(16, 7).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(2.3123F, -2.4156F, 4.3471F);
		bone2.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, 0.6545F);
		cube_r42.setTextureOffset(10, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(3.5576F, -2.4049F, 4.3471F);
		bone2.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 0.0F, -0.5672F);
		cube_r43.setTextureOffset(16, 16).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(4.2887F, -1.0025F, 4.3471F);
		bone2.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.0F, 0.6109F);
		cube_r44.setTextureOffset(7, 17).addBox(-1.75F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 16.0F, 2.0F);
		main.addChild(bone3);
		

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-0.3029F, -18.4595F, 0.3471F);
		bone3.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.0F, -1.0472F);
		cube_r45.setTextureOffset(4, 12).addBox(2.25F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(-0.5F, -18.5F, 0.5F);
		bone3.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 0.0F, -1.0472F);
		cube_r46.setTextureOffset(13, 4).addBox(2.0F, 2.0F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r46.setTextureOffset(13, 6).addBox(-0.25F, 0.25F, 3.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -0.2618F);
		cube_r47.setTextureOffset(4, 3).addBox(6.5F, -13.75F, 4.3471F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.setTextureOffset(3, 5).addBox(6.25F, -15.25F, 4.3471F, 2.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		main.copyModelAngles(this.bipedBody);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}