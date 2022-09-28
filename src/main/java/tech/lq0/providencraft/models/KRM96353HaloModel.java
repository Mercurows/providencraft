package tech.lq0.providencraft.models;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3f;

public class KRM96353HaloModel<T extends LivingEntity> extends BipedModel<T> {
	private int degree = 0;

	private final ModelRenderer main;
	private final ModelRenderer body;
	private final ModelRenderer halo;
	private final ModelRenderer rgb;
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
	private final ModelRenderer outer;
	private final ModelRenderer dev1;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer dev2;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer dev3;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer dev4;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer od;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer od2;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer od3;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer od4;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;

	public KRM96353HaloModel() {
		super(1.0f);
		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);


		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 28.0F, 0.0F);
		main.addChild(body);


		halo = new ModelRenderer(this);
		halo.setRotationPoint(0.0F, -3.75F, 0.0F);
		body.addChild(halo);


		rgb = new ModelRenderer(this);
		rgb.setRotationPoint(0.0F, -30.9863F, 14.0F);
		halo.addChild(rgb);
		rgb.setTextureOffset(40, 6).addBox(-4.0F, -20.0137F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);
		rgb.setTextureOffset(20, 18).addBox(-4.0F, 15.9863F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-16.7309F, 6.8071F, 0.0F);
		rgb.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 1.1781F);
		cube_r1.setTextureOffset(0, 6).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-12.8052F, 12.6822F, 0.0F);
		rgb.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
		cube_r2.setTextureOffset(0, 12).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-6.9302F, 16.6078F, 0.0F);
		rgb.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3927F);
		cube_r3.setTextureOffset(0, 18).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(16.7309F, 6.8071F, 0.0F);
		rgb.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -1.1781F);
		cube_r4.setTextureOffset(20, 0).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(12.8052F, 12.6822F, 0.0F);
		rgb.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
		cube_r5.setTextureOffset(20, 6).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(6.9302F, 16.6078F, 0.0F);
		rgb.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.3927F);
		cube_r6.setTextureOffset(20, 12).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(6.9302F, -16.6352F, 0.0F);
		rgb.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.3927F);
		cube_r7.setTextureOffset(0, 24).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(12.8052F, -12.7096F, 0.0F);
		rgb.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
		cube_r8.setTextureOffset(20, 24).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(16.7309F, -6.8345F, 0.0F);
		rgb.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 1.1781F);
		cube_r9.setTextureOffset(0, 30).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(18.1094F, 0.0957F, 0.0F);
		rgb.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 1.5708F);
		cube_r10.setTextureOffset(20, 30).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-18.1094F, 0.0957F, 0.0F);
		rgb.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -1.5708F);
		cube_r11.setTextureOffset(0, 36).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-16.7309F, -6.8345F, 0.0F);
		rgb.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -1.1781F);
		cube_r12.setTextureOffset(20, 36).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-12.8052F, -12.7096F, 0.0F);
		rgb.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -0.7854F);
		cube_r13.setTextureOffset(40, 0).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-6.9302F, -16.6352F, 0.0F);
		rgb.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -0.3927F);
		cube_r14.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		outer = new ModelRenderer(this);
		outer.setRotationPoint(0.0F, 0.0F, 0.0F);
		halo.addChild(outer);


		dev1 = new ModelRenderer(this);
		dev1.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(dev1);


		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-16.0F, -49.0F, 12.0F);
		dev1.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -0.7854F);
		cube_r15.setTextureOffset(71, 12).addBox(-2.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r15.setTextureOffset(46, 75).addBox(-2.0F, 7.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r15.setTextureOffset(69, 25).addBox(-3.0F, 4.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r15.setTextureOffset(16, 59).addBox(-4.0F, 1.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r15.setTextureOffset(54, 65).addBox(-3.0F, -6.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r15.setTextureOffset(33, 51).addBox(-4.0F, -4.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r15.setTextureOffset(18, 42).addBox(-4.0F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-17.2839F, -44.8309F, 12.0F);
		dev1.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -1.4399F);
		cube_r16.setTextureOffset(28, 73).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-13.2451F, -48.8697F, 12.0F);
		dev1.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -0.1309F);
		cube_r17.setTextureOffset(0, 75).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-13.9769F, -51.1905F, 12.5F);
		dev1.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -0.48F);
		cube_r18.setTextureOffset(14, 64).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-20.2974F, -44.2321F, 12.5F);
		dev1.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -1.0908F);
		cube_r19.setTextureOffset(65, 33).addBox(-1.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		dev2 = new ModelRenderer(this);
		dev2.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(dev2);


		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(16.0F, -49.0F, 12.0F);
		dev2.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 0.7854F);
		cube_r20.setTextureOffset(57, 70).addBox(0.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.setTextureOffset(38, 75).addBox(0.0F, 7.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r20.setTextureOffset(69, 19).addBox(-1.0F, 4.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r20.setTextureOffset(0, 59).addBox(-2.0F, 1.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r20.setTextureOffset(65, 45).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.setTextureOffset(48, 48).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.setTextureOffset(0, 42).addBox(-2.0F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(17.2839F, -44.8309F, 12.0F);
		dev2.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 1.4399F);
		cube_r21.setTextureOffset(67, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(13.2451F, -48.8697F, 12.0F);
		dev2.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, 0.1309F);
		cube_r22.setTextureOffset(72, 4).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(13.9769F, -51.1905F, 12.5F);
		dev2.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, 0.48F);
		cube_r23.setTextureOffset(63, 50).addBox(-2.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(20.2974F, -44.2321F, 12.5F);
		dev2.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, 1.0908F);
		cube_r24.setTextureOffset(0, 64).addBox(-3.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		dev3 = new ModelRenderer(this);
		dev3.setRotationPoint(-16.4086F, -13.5057F, 12.2727F);
		outer.addChild(dev3);


		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.4086F, 1.0057F, -0.2727F);
		dev3.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.7854F);
		cube_r25.setTextureOffset(37, 70).addBox(-2.0F, 6.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r25.setTextureOffset(73, 61).addBox(-2.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r25.setTextureOffset(68, 65).addBox(-3.0F, -7.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r25.setTextureOffset(58, 10).addBox(-4.0F, -4.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r25.setTextureOffset(40, 65).addBox(-3.0F, 4.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r25.setTextureOffset(18, 48).addBox(-4.0F, 2.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r25.setTextureOffset(40, 12).addBox(-4.0F, -1.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-0.8753F, -3.1635F, -0.2727F);
		dev3.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, 1.4399F);
		cube_r26.setTextureOffset(47, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(3.1635F, 0.8753F, -0.2727F);
		dev3.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, 0.1309F);
		cube_r27.setTextureOffset(70, 56).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(2.4317F, 3.1962F, 0.2273F);
		dev3.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 0.48F);
		cube_r28.setTextureOffset(60, 0).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-3.8888F, -3.7622F, 0.2273F);
		dev3.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, 1.0908F);
		cube_r29.setTextureOffset(29, 61).addBox(-1.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		dev4 = new ModelRenderer(this);
		dev4.setRotationPoint(16.4086F, -13.5057F, 12.2727F);
		outer.addChild(dev4);


		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-0.4086F, 1.0057F, -0.2727F);
		dev4.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -0.7854F);
		cube_r30.setTextureOffset(0, 70).addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r30.setTextureOffset(60, 6).addBox(0.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r30.setTextureOffset(28, 67).addBox(-1.0F, -7.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r30.setTextureOffset(32, 56).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r30.setTextureOffset(65, 39).addBox(-1.0F, 4.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r30.setTextureOffset(0, 48).addBox(-2.0F, 2.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r30.setTextureOffset(37, 39).addBox(-2.0F, -1.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(0.8753F, -3.1635F, -0.2727F);
		dev4.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -1.4399F);
		cube_r31.setTextureOffset(10, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-3.1635F, 0.8753F, -0.2727F);
		dev4.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, -0.1309F);
		cube_r32.setTextureOffset(20, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-2.4317F, 3.1962F, 0.2273F);
		dev4.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -0.48F);
		cube_r33.setTextureOffset(45, 59).addBox(-2.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(3.8888F, -3.7622F, 0.2273F);
		dev4.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, -1.0908F);
		cube_r34.setTextureOffset(59, 59).addBox(-3.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		od = new ModelRenderer(this);
		od.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(od);
		od.setTextureOffset(33, 45).addBox(-3.0F, -55.0F, 11.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		od.setTextureOffset(54, 75).addBox(-1.0F, -51.0F, 11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(-5.6071F, -52.5094F, 12.5F);
		od.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -0.1745F);
		cube_r35.setTextureOffset(55, 27).addBox(-2.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(5.1147F, -52.5963F, 12.5F);
		od.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, 0.1745F);
		cube_r36.setTextureOffset(55, 21).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		od2 = new ModelRenderer(this);
		od2.setRotationPoint(0.0F, -31.0F, 14.0F);
		outer.addChild(od2);
		setRotationAngle(od2, 0.0F, 0.0F, -1.5708F);
		od2.setTextureOffset(40, 30).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		od2.setTextureOffset(18, 75).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(-5.6071F, -21.5094F, -1.5F);
		od2.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -0.1745F);
		cube_r37.setTextureOffset(48, 53).addBox(-2.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(5.1147F, -21.5963F, -1.5F);
		od2.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, 0.1745F);
		cube_r38.setTextureOffset(55, 15).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		od3 = new ModelRenderer(this);
		od3.setRotationPoint(0.0F, -31.0F, 14.0F);
		outer.addChild(od3);
		setRotationAngle(od3, 0.0F, 0.0F, 1.5708F);
		od3.setTextureOffset(40, 24).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		od3.setTextureOffset(10, 75).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(5.6071F, -21.5094F, -1.5F);
		od3.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, 0.1745F);
		cube_r39.setTextureOffset(0, 53).addBox(-3.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-5.1147F, -21.5963F, -1.5F);
		od3.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, -0.1745F);
		cube_r40.setTextureOffset(16, 53).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		od4 = new ModelRenderer(this);
		od4.setRotationPoint(0.0F, -31.0F, 14.0F);
		outer.addChild(od4);
		setRotationAngle(od4, 0.0F, 0.0F, -3.1416F);
		od4.setTextureOffset(40, 18).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		od4.setTextureOffset(74, 0).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(5.6071F, -21.5094F, -1.5F);
		od4.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, 0.1745F);
		cube_r41.setTextureOffset(52, 36).addBox(-3.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(-5.1147F, -21.5963F, -1.5F);
		od4.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, -0.1745F);
		cube_r42.setTextureOffset(52, 42).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		if (degree == 360) {
			degree = 0;
		}
		degree++;

		this.main.copyModelAngles(this.bipedBody);
		matrixStack.push();
		matrixStack.scale(0.5f,0.5f,0.5f);

		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.pop();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}