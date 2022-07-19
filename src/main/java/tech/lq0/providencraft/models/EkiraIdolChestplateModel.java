package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class EkiraIdolChestplateModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer body_total;
	private final ModelRenderer body;
	private final ModelRenderer ling;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer middle;
	private final ModelRenderer up;
	private final ModelRenderer ling2;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer outer;
	private final ModelRenderer outer1;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer outer2;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer dress;
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
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer outer_dress;
	private final ModelRenderer outer_dress1;
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
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer outer_dress2;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer cube_r68;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer tie;
	private final ModelRenderer cube_r84;
	private final ModelRenderer right_total;
	private final ModelRenderer right;
	private final ModelRenderer rightup;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer left_total;
	private final ModelRenderer left;
	private final ModelRenderer leftup;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;

	public EkiraIdolChestplateModel() {
		super(1.0f);
		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 1.0F, 0.0F);
		

		body_total = new ModelRenderer(this);
		body_total.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.addChild(body_total);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 11.0F, 0.0F);
		body_total.addChild(body);
		

		ling = new ModelRenderer(this);
		ling.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(ling);
		ling.setTextureOffset(0, 16).addBox(-7.0F, -13.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		ling.setTextureOffset(15, 4).addBox(2.0F, -13.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		ling.setTextureOffset(12, 50).addBox(-5.75F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(67, 29).addBox(-2.5382F, -10.9732F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(46, 33).addBox(2.75F, -13.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(46, 17).addBox(-0.25F, -13.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(42, 7).addBox(-5.75F, -13.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(66, 33).addBox(0.5382F, -10.9732F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(29, 3).addBox(-4.0F, -12.0F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		ling.setTextureOffset(30, 23).addBox(-3.0F, -11.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(3.0254F, -10.6488F, -2.5F);
		ling.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.7418F);
		cube_r1.setTextureOffset(12, 44).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.951F, -10.9115F, -2.5F);
		ling.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.7418F);
		cube_r2.setTextureOffset(22, 38).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-3.0254F, -10.6488F, -2.5F);
		ling.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.7418F);
		cube_r3.setTextureOffset(12, 52).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-1.951F, -10.9115F, -2.5F);
		ling.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.7418F);
		cube_r4.setTextureOffset(52, 15).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		middle = new ModelRenderer(this);
		middle.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(middle);
		middle.setTextureOffset(28, 25).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		middle.setTextureOffset(26, 20).addBox(-4.0F, -5.0F, 1.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		middle.setTextureOffset(34, 35).addBox(-4.75F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		middle.setTextureOffset(34, 28).addBox(3.75F, -5.0F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		up = new ModelRenderer(this);
		up.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(up);
		up.setTextureOffset(0, 8).addBox(-3.5F, -12.0F, -2.5F, 7.0F, 7.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(0, 0).addBox(-3.5F, -12.0F, 1.5F, 7.0F, 7.0F, 1.0F, 0.0F, false);
		up.setTextureOffset(22, 25).addBox(-4.5F, -12.0F, -2.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		up.setTextureOffset(12, 25).addBox(3.5F, -12.0F, -2.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);

		ling2 = new ModelRenderer(this);
		ling2.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(ling2);
		ling2.setTextureOffset(57, 35).addBox(-2.0F, -13.5F, -2.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		ling2.setTextureOffset(36, 0).addBox(-2.0F, -14.0F, 1.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-2.0305F, -13.1176F, 0.0F);
		ling2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
		cube_r5.setTextureOffset(0, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(2.0305F, -13.1176F, 0.0F);
		ling2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
		cube_r6.setTextureOffset(22, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		outer = new ModelRenderer(this);
		outer.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(outer);
		outer.setTextureOffset(41, 35).addBox(-3.0F, -10.0F, 1.75F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		outer.setTextureOffset(65, 42).addBox(1.0F, -7.0F, 1.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		outer.setTextureOffset(65, 17).addBox(-3.0F, -7.0F, 1.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		outer1 = new ModelRenderer(this);
		outer1.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(outer1);
		outer1.setTextureOffset(59, 0).addBox(2.0F, -12.0F, -2.75F, 3.0F, 6.0F, 1.0F, 0.0F, false);
		outer1.setTextureOffset(24, 67).addBox(1.0F, -10.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		outer1.setTextureOffset(6, 32).addBox(4.0F, -12.0F, -1.75F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		outer1.setTextureOffset(24, 60).addBox(3.0F, -12.0F, 1.75F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(4.7418F, -5.1635F, 0.5F);
		outer1.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.2618F);
		cube_r7.setTextureOffset(34, 13).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(2.5F, -5.1635F, 2.4918F);
		outer1.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.2618F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(12, 55).addBox(0.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(2.5F, -5.1635F, -2.4918F);
		outer1.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.2618F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(48, 10).addBox(-0.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.5F, -5.1635F, -2.7418F);
		outer1.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.2618F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(15, 70).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		outer2 = new ModelRenderer(this);
		outer2.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(outer2);
		outer2.setTextureOffset(38, 58).addBox(-5.0F, -12.0F, -2.75F, 3.0F, 6.0F, 1.0F, 0.0F, false);
		outer2.setTextureOffset(67, 5).addBox(-2.0F, -10.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		outer2.setTextureOffset(0, 26).addBox(-5.0F, -12.0F, -1.75F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		outer2.setTextureOffset(46, 59).addBox(-5.0F, -12.0F, 1.75F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-4.7418F, -5.1635F, 0.5F);
		outer2.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 0.2618F);
		cube_r11.setTextureOffset(27, 31).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-2.5F, -5.1635F, 2.4918F);
		outer2.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.2618F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(12, 21).addBox(-2.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-2.5F, -5.1635F, -2.4918F);
		outer2.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.2618F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(18, 25).addBox(-2.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-1.5F, -5.1635F, -2.7418F);
		outer2.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.2618F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(70, 12).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		dress = new ModelRenderer(this);
		dress.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(dress);
		dress.setTextureOffset(14, 18).addBox(-4.5F, -3.0F, -2.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(16, 13).addBox(-4.5F, -3.0F, 1.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(56, 45).addBox(3.5F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		dress.setTextureOffset(56, 50).addBox(-4.5F, -3.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		dress.setTextureOffset(16, 11).addBox(-4.5F, -0.327F, -2.9836F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(16, 9).addBox(-4.5F, -0.327F, 1.9836F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(56, 40).addBox(3.9836F, -0.327F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		dress.setTextureOffset(56, 15).addBox(-4.9836F, -0.327F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		dress.setTextureOffset(65, 64).addBox(-5.0F, 0.5F, -2.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(61, 65).addBox(-5.0F, 0.5F, 1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(65, 49).addBox(4.0F, 0.5F, 1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		dress.setTextureOffset(65, 44).addBox(4.0F, 0.5F, -2.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(4.9115F, 1.9533F, -1.5F);
		dress.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -0.3054F);
		cube_r15.setTextureOffset(43, 65).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r15.setTextureOffset(39, 65).addBox(-0.5F, -1.5F, 2.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(5.0706F, 1.8212F, 0.0F);
		dress.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.4363F);
		cube_r16.setTextureOffset(30, 60).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-4.9115F, 1.9533F, 1.5F);
		dress.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 0.3054F);
		cube_r17.setTextureOffset(66, 11).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r17.setTextureOffset(66, 24).addBox(-0.5F, -1.5F, -3.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-5.0706F, 1.8212F, 0.0F);
		dress.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, 0.4363F);
		cube_r18.setTextureOffset(52, 60).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(4.0F, 2.0634F, 2.7364F);
		dress.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.1745F, 0.0F, 0.0F);
		cube_r19.setTextureOffset(51, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r19.setTextureOffset(29, 66).addBox(-8.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(3.0F, 1.9533F, 2.9115F);
		dress.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.3054F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(47, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r20.setTextureOffset(66, 36).addBox(-6.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.0F, 1.7727F, 3.1197F);
		dress.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.48F, 0.0F, 0.0F);
		cube_r21.setTextureOffset(42, 42).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(-3.0F, 1.9533F, -2.9115F);
		dress.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.3054F, 0.0F, 0.0F);
		cube_r22.setTextureOffset(55, 66).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r22.setTextureOffset(66, 59).addBox(5.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-4.0F, 2.0634F, -2.7364F);
		dress.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.1745F, 0.0F, 0.0F);
		cube_r23.setTextureOffset(66, 54).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r23.setTextureOffset(67, 0).addBox(7.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.0F, 1.7727F, -3.1197F);
		dress.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.48F, 0.0F, 0.0F);
		cube_r24.setTextureOffset(45, 19).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(-4.2418F, -1.1635F, 0.0F);
		dress.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.2618F);
		cube_r25.setTextureOffset(43, 1).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(4.2418F, -1.1635F, 0.0F);
		dress.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, -0.2618F);
		cube_r26.setTextureOffset(16, 44).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-0.5F, -1.1635F, 2.2418F);
		dress.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.2618F, 0.0F, 0.0F);
		cube_r27.setTextureOffset(15, 15).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-0.5F, -1.1635F, -2.2418F);
		dress.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.2618F, 0.0F, 0.0F);
		cube_r28.setTextureOffset(16, 0).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, 0.0F, false);

		outer_dress = new ModelRenderer(this);
		outer_dress.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(outer_dress);
		

		outer_dress1 = new ModelRenderer(this);
		outer_dress1.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer_dress.addChild(outer_dress1);
		outer_dress1.setTextureOffset(29, 5).addBox(1.0F, -4.25F, 2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		outer_dress1.setTextureOffset(59, 7).addBox(4.25F, -4.25F, -1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		outer_dress1.setTextureOffset(16, 46).addBox(4.25F, -2.75F, 1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		outer_dress1.setTextureOffset(69, 47).addBox(5.8458F, 8.9811F, 4.5422F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(1.7046F, 1.7044F, 4.234F);
		outer_dress1.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, -0.2182F);
		cube_r29.setTextureOffset(69, 44).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(2.8712F, 3.6823F, 5.3133F);
		outer_dress1.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -0.2618F);
		cube_r30.setTextureOffset(28, 46).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(4.2273F, 5.3118F, 5.2601F);
		outer_dress1.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -0.3927F);
		cube_r31.setTextureOffset(8, 65).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(5.9746F, 7.6616F, 5.0422F);
		outer_dress1.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, 1.309F);
		cube_r32.setTextureOffset(48, 25).addBox(-2.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(5.5979F, 5.7917F, 5.0422F);
		outer_dress1.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -0.48F);
		cube_r33.setTextureOffset(69, 50).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(6.9492F, 8.3422F, 4.4571F);
		outer_dress1.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, -0.2182F);
		cube_r34.setTextureOffset(12, 65).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(6.0844F, 5.0246F, 4.4571F);
		outer_dress1.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -0.3491F);
		cube_r35.setTextureOffset(69, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(5.6447F, 2.6105F, 3.8078F);
		outer_dress1.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, -0.7418F);
		cube_r36.setTextureOffset(44, 47).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(7.0614F, 5.4398F, 3.8078F);
		outer_dress1.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -0.2618F);
		cube_r37.setTextureOffset(4, 62).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(7.9742F, 4.6615F, 2.25F);
		outer_dress1.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -0.6109F);
		cube_r38.setTextureOffset(0, 52).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(7.9719F, 6.0076F, 2.9924F);
		outer_dress1.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -0.3491F);
		cube_r39.setTextureOffset(40, 52).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(7.2457F, 4.2441F, 2.9924F);
		outer_dress1.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, -0.5236F);
		cube_r40.setTextureOffset(46, 53).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(5.036F, 1.5834F, 2.9924F);
		outer_dress1.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, -0.6109F);
		cube_r41.setTextureOffset(52, 54).addBox(0.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(6.9169F, 3.0452F, 2.25F);
		outer_dress1.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, -0.48F);
		cube_r42.setTextureOffset(70, 9).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(7.5177F, 2.7598F, 1.5F);
		outer_dress1.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 0.0F, -0.5672F);
		cube_r43.setTextureOffset(7, 70).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(5.4773F, -0.0936F, 2.25F);
		outer_dress1.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.0F, -0.3927F);
		cube_r44.setTextureOffset(20, 65).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(5.8479F, -0.2633F, 1.5F);
		outer_dress1.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.0F, -0.48F);
		cube_r45.setTextureOffset(62, 37).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(6.0935F, -0.4889F, 1.5F);
		outer_dress1.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 0.0F, -0.6109F);
		cube_r46.setTextureOffset(62, 12).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(6.0788F, 0.1802F, 0.0F);
		outer_dress1.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -0.48F);
		cube_r47.setTextureOffset(35, 65).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(3.0F, -1.5939F, 2.9053F);
		outer_dress1.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.48F, 0.0F, 0.0F);
		cube_r48.setTextureOffset(16, 60).addBox(-2.0F, -1.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(4.5F, 0.3981F, 3.4959F);
		outer_dress1.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.3491F, 0.0F, 0.0F);
		cube_r49.setTextureOffset(65, 19).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(3.5F, 2.4168F, 4.7772F);
		outer_dress1.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.3491F, 0.0F, 0.0F);
		cube_r50.setTextureOffset(50, 48).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(3.5F, 1.8304F, 4.8301F);
		outer_dress1.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.6109F, 0.0F, 0.0F);
		cube_r51.setTextureOffset(11, 70).addBox(-1.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(5.5058F, 3.883F, 4.4571F);
		outer_dress1.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.0F, -0.7418F);
		cube_r52.setTextureOffset(64, 69).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(4.5F, 2.6569F, 4.4552F);
		outer_dress1.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.4363F, 0.0F, 0.0F);
		cube_r53.setTextureOffset(55, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		outer_dress2 = new ModelRenderer(this);
		outer_dress2.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer_dress.addChild(outer_dress2);
		outer_dress2.setTextureOffset(6, 26).addBox(-5.0F, -4.25F, 2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		outer_dress2.setTextureOffset(0, 57).addBox(-5.25F, -4.25F, -1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		outer_dress2.setTextureOffset(22, 36).addBox(-5.25F, -2.75F, 1.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		outer_dress2.setTextureOffset(56, 50).addBox(-6.8458F, 8.9811F, 4.5422F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(-1.7046F, 1.7044F, 4.234F);
		outer_dress2.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, 0.0F, 0.2182F);
		cube_r54.setTextureOffset(56, 40).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(-2.8712F, 3.6823F, 5.3133F);
		outer_dress2.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, 0.0F, 0.2618F);
		cube_r55.setTextureOffset(0, 16).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(-4.2273F, 5.3118F, 5.2601F);
		outer_dress2.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.0F, 0.0F, 0.3927F);
		cube_r56.setTextureOffset(34, 28).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(-5.9746F, 7.6616F, 5.0422F);
		outer_dress2.addChild(cube_r57);
		setRotationAngle(cube_r57, 0.0F, 0.0F, -1.309F);
		cube_r57.setTextureOffset(46, 40).addBox(-1.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(-5.5979F, 5.7917F, 5.0422F);
		outer_dress2.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.0F, 0.48F);
		cube_r58.setTextureOffset(58, 55).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(-6.9492F, 8.3422F, 4.4571F);
		outer_dress2.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0F, 0.0F, 0.2182F);
		cube_r59.setTextureOffset(62, 24).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(-6.0844F, 5.0246F, 4.4571F);
		outer_dress2.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, 0.0F, 0.3491F);
		cube_r60.setTextureOffset(0, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(-5.6447F, 2.6105F, 3.8078F);
		outer_dress2.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.0F, 0.7418F);
		cube_r61.setTextureOffset(0, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(-7.0614F, 5.4398F, 3.8078F);
		outer_dress2.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0F, 0.0F, 0.2618F);
		cube_r62.setTextureOffset(0, 36).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(-7.9742F, 4.6615F, 2.25F);
		outer_dress2.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.0F, 0.0F, 0.6109F);
		cube_r63.setTextureOffset(0, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(-7.9719F, 6.0076F, 2.9924F);
		outer_dress2.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0F, 0.0F, 0.3491F);
		cube_r64.setTextureOffset(35, 14).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setRotationPoint(-7.2457F, 4.2441F, 2.9924F);
		outer_dress2.addChild(cube_r65);
		setRotationAngle(cube_r65, 0.0F, 0.0F, 0.5236F);
		cube_r65.setTextureOffset(16, 36).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setRotationPoint(-5.036F, 1.5834F, 2.9924F);
		outer_dress2.addChild(cube_r66);
		setRotationAngle(cube_r66, 0.0F, 0.0F, 0.6109F);
		cube_r66.setTextureOffset(38, 42).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setRotationPoint(-6.9169F, 3.0452F, 2.25F);
		outer_dress2.addChild(cube_r67);
		setRotationAngle(cube_r67, 0.0F, 0.0F, 0.48F);
		cube_r67.setTextureOffset(4, 68).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setRotationPoint(-7.5177F, 2.7598F, 1.5F);
		outer_dress2.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.0F, 0.0F, 0.5672F);
		cube_r68.setTextureOffset(68, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setRotationPoint(-5.4773F, -0.0936F, 2.25F);
		outer_dress2.addChild(cube_r69);
		setRotationAngle(cube_r69, 0.0F, 0.0F, 0.3927F);
		cube_r69.setTextureOffset(62, 55).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setRotationPoint(-5.8479F, -0.2633F, 1.5F);
		outer_dress2.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.0F, 0.0F, 0.48F);
		cube_r70.setTextureOffset(58, 60).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setRotationPoint(-6.0935F, -0.4889F, 1.5F);
		outer_dress2.addChild(cube_r71);
		setRotationAngle(cube_r71, 0.0F, 0.0F, 0.6109F);
		cube_r71.setTextureOffset(0, 62).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setRotationPoint(-6.0788F, 0.1802F, 0.0F);
		outer_dress2.addChild(cube_r72);
		setRotationAngle(cube_r72, 0.0F, 0.0F, 0.48F);
		cube_r72.setTextureOffset(62, 60).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setRotationPoint(-3.0F, -1.5939F, 2.9053F);
		outer_dress2.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.48F, 0.0F, 0.0F);
		cube_r73.setTextureOffset(8, 60).addBox(-1.0F, -1.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setRotationPoint(-4.5F, 0.3981F, 3.4959F);
		outer_dress2.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.3491F, 0.0F, 0.0F);
		cube_r74.setTextureOffset(63, 29).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r75 = new ModelRenderer(this);
		cube_r75.setRotationPoint(-3.5F, 2.4168F, 4.7772F);
		outer_dress2.addChild(cube_r75);
		setRotationAngle(cube_r75, 0.3491F, 0.0F, 0.0F);
		cube_r75.setTextureOffset(22, 44).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setRotationPoint(-3.5F, 1.8304F, 4.8301F);
		outer_dress2.addChild(cube_r76);
		setRotationAngle(cube_r76, 0.6109F, 0.0F, 0.0F);
		cube_r76.setTextureOffset(69, 19).addBox(0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setRotationPoint(-5.5058F, 3.883F, 4.4571F);
		outer_dress2.addChild(cube_r77);
		setRotationAngle(cube_r77, 0.0F, 0.0F, 0.7418F);
		cube_r77.setTextureOffset(69, 22).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setRotationPoint(-4.5F, 2.6569F, 4.4552F);
		outer_dress2.addChild(cube_r78);
		setRotationAngle(cube_r78, 0.4363F, 0.0F, 0.0F);
		cube_r78.setTextureOffset(0, 46).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(-2.5F, -1.2784F, -3.0417F);
		outer_dress.addChild(bow);
		setRotationAngle(bow, -0.2618F, 0.0F, 0.3054F);
		bow.setTextureOffset(22, 57).addBox(-2.0F, -1.4716F, -0.4583F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setRotationPoint(0.0F, -0.4716F, -0.2083F);
		bow.addChild(cube_r79);
		setRotationAngle(cube_r79, 0.0F, 0.0F, 0.7854F);
		cube_r79.setTextureOffset(26, 40).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setRotationPoint(0.75F, 1.2784F, 0.0417F);
		bow.addChild(cube_r80);
		setRotationAngle(cube_r80, 0.0F, 0.0F, -0.3491F);
		cube_r80.setTextureOffset(49, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setRotationPoint(-0.75F, 1.2784F, 0.0417F);
		bow.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.0F, 0.0F, 0.3491F);
		cube_r81.setTextureOffset(34, 50).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setRotationPoint(1.0F, 1.0284F, 0.0417F);
		bow.addChild(cube_r82);
		setRotationAngle(cube_r82, 0.0F, 0.0F, 0.3927F);
		cube_r82.setTextureOffset(32, 38).addBox(-1.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setRotationPoint(-1.0F, 1.0284F, 0.0417F);
		bow.addChild(cube_r83);
		setRotationAngle(cube_r83, 0.0F, 0.0F, -0.3927F);
		cube_r83.setTextureOffset(59, 20).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		tie = new ModelRenderer(this);
		tie.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(tie);
		tie.setTextureOffset(16, 65).addBox(-0.5F, -12.0F, -3.25F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		tie.setTextureOffset(59, 22).addBox(-1.0F, -13.0F, -3.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setRotationPoint(0.0F, -8.0F, -2.75F);
		tie.addChild(cube_r84);
		setRotationAngle(cube_r84, 0.0F, 0.0F, 0.7854F);
		cube_r84.setTextureOffset(12, 42).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 1.0F, 0.0F);
		main.addChild(right_total);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_total.addChild(right);
		

		rightup = new ModelRenderer(this);
		rightup.setRotationPoint(5.0F, 9.0F, 0.0F);
		right.addChild(rightup);
		rightup.setTextureOffset(0, 21).addBox(-8.0F, -12.75F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(32, 42).addBox(-8.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(42, 24).addBox(-4.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(16, 55).addBox(-4.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(6, 55).addBox(-8.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(54, 25).addBox(-8.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(46, 54).addBox(-4.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(22, 52).addBox(-8.75F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(53, 20).addBox(-4.25F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setRotationPoint(-6.0F, -0.75F, 2.25F);
		rightup.addChild(cube_r85);
		setRotationAngle(cube_r85, 0.0F, 1.5708F, 0.0F);
		cube_r85.setTextureOffset(34, 52).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r85.setTextureOffset(42, 9).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setRotationPoint(-6.0F, -0.75F, -2.25F);
		rightup.addChild(cube_r86);
		setRotationAngle(cube_r86, 0.0F, -1.5708F, 0.0F);
		cube_r86.setTextureOffset(52, 10).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r86.setTextureOffset(6, 42).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r87 = new ModelRenderer(this);
		cube_r87.setRotationPoint(-6.0F, 0.25F, 2.0F);
		rightup.addChild(cube_r87);
		setRotationAngle(cube_r87, 0.0F, 1.5708F, 0.0F);
		cube_r87.setTextureOffset(54, 30).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r87.setTextureOffset(28, 55).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setRotationPoint(-6.0F, 0.25F, -2.0F);
		rightup.addChild(cube_r88);
		setRotationAngle(cube_r88, 0.0F, -1.5708F, 0.0F);
		cube_r88.setTextureOffset(40, 53).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r88.setTextureOffset(52, 55).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 1.0F, 0.0F);
		main.addChild(left_total);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_total.addChild(left);
		

		leftup = new ModelRenderer(this);
		leftup.setRotationPoint(-5.0F, 9.0F, 0.0F);
		left.addChild(leftup);
		leftup.setTextureOffset(14, 20).addBox(4.0F, -12.75F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(26, 38).addBox(7.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(36, 5).addBox(3.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(51, 35).addBox(3.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(50, 49).addBox(7.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(28, 50).addBox(7.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(6, 50).addBox(3.5F, -1.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(44, 48).addBox(7.75F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(38, 47).addBox(3.25F, -2.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setRotationPoint(6.0F, -0.75F, 2.25F);
		leftup.addChild(cube_r89);
		setRotationAngle(cube_r89, 0.0F, -1.5708F, 0.0F);
		cube_r89.setTextureOffset(48, 28).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r89.setTextureOffset(0, 38).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setRotationPoint(6.0F, -0.75F, -2.25F);
		leftup.addChild(cube_r90);
		setRotationAngle(cube_r90, 0.0F, 1.5708F, 0.0F);
		cube_r90.setTextureOffset(49, 0).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r90.setTextureOffset(16, 36).addBox(-0.5F, -11.25F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setRotationPoint(6.0F, 0.25F, 2.0F);
		leftup.addChild(cube_r91);
		setRotationAngle(cube_r91, 0.0F, -1.5708F, 0.0F);
		cube_r91.setTextureOffset(16, 50).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r91.setTextureOffset(0, 52).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setRotationPoint(6.0F, 0.25F, -2.0F);
		leftup.addChild(cube_r92);
		setRotationAngle(cube_r92, 0.0F, 1.5708F, 0.0F);
		cube_r92.setTextureOffset(50, 43).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r92.setTextureOffset(52, 5).addBox(-0.5F, -8.25F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.body_total.copyModelAngles(this.bipedBody);
		this.right_total.copyModelAngles(this.bipedRightArm);
		this.left_total.copyModelAngles(this.bipedLeftArm);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}