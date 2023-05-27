package tech.lq0.providencraft.models;// Made with Blockbench 4.7.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class MaidCostumeModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer body_total;
	private final ModelRenderer body;
	private final ModelRenderer ling;
	private final ModelRenderer middle;
	private final ModelRenderer up;
	private final ModelRenderer cube_r1;
	private final ModelRenderer ling2;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer outer;
	private final ModelRenderer outer1;
	private final ModelRenderer huabian;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer outer2;
	private final ModelRenderer huabian2;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer bone5;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer huabian3;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer dress;
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
	private final ModelRenderer bone6;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer outer_dress;
	private final ModelRenderer tie;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer right_total;
	private final ModelRenderer right;
	private final ModelRenderer rightup;
	private final ModelRenderer cube_r92;
	private final ModelRenderer cube_r93;
	private final ModelRenderer cube_r94;
	private final ModelRenderer cube_r95;
	private final ModelRenderer left_total;
	private final ModelRenderer left;
	private final ModelRenderer leftup;
	private final ModelRenderer cube_r96;
	private final ModelRenderer cube_r97;
	private final ModelRenderer cube_r98;
	private final ModelRenderer cube_r99;

	public MaidCostumeModel() {
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
		

		middle = new ModelRenderer(this);
		middle.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(middle);
		

		up = new ModelRenderer(this);
		up.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(up);
		up.setTextureOffset(24, 12).addBox(-4.1F, -10.0F, -2.7F, 8.2F, 5.0F, 5.2F, 0.0F, false);
		up.setTextureOffset(88, 19).addBox(-4.55F, -12.0F, -2.1F, 1.05F, 6.8F, 4.2F, 0.0F, false);
		up.setTextureOffset(78, 19).addBox(3.5F, -12.0F, -2.1F, 1.05F, 6.8F, 4.2F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -8.875F, -2.75F);
		up.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
		cube_r1.setTextureOffset(70, 13).addBox(0.75F, 0.725F, -0.05F, 0.5F, 0.55F, 0.1F, 0.0F, false);
		cube_r1.setTextureOffset(70, 13).addBox(-0.25F, -0.275F, -0.05F, 0.5F, 0.55F, 0.1F, 0.0F, false);

		ling2 = new ModelRenderer(this);
		ling2.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(ling2);
		ling2.setTextureOffset(28, 10).addBox(-2.0F, -13.0F, -2.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		ling2.setTextureOffset(30, 22).addBox(-2.0F, -14.0F, 1.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.0305F, -13.1176F, 0.0F);
		ling2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.4363F);
		cube_r2.setTextureOffset(47, 46).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.0305F, -13.1176F, 0.0F);
		ling2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.4363F);
		cube_r3.setTextureOffset(48, 24).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		outer = new ModelRenderer(this);
		outer.setRotationPoint(0.0F, -0.25F, 0.0F);
		body.addChild(outer);
		

		outer1 = new ModelRenderer(this);
		outer1.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(outer1);
		outer1.setTextureOffset(44, 57).addBox(3.0F, -12.0F, -2.95F, 1.0F, 7.0F, 1.2F, 0.0F, false);
		outer1.setTextureOffset(69, 57).addBox(-4.5F, -5.0F, -2.95F, 9.0F, 2.0F, 5.7F, 0.0F, false);
		outer1.setTextureOffset(70, 34).addBox(3.0F, -12.25F, -2.95F, 1.0F, 0.25F, 5.7F, 0.0F, false);
		outer1.setTextureOffset(59, 59).addBox(3.0F, -12.0F, 1.75F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		huabian = new ModelRenderer(this);
		huabian.setRotationPoint(3.0F, -5.8F, -3.15F);
		outer1.addChild(huabian);
		huabian.setTextureOffset(24, 38).addBox(1.0F, -1.5F, 0.0F, 0.9F, 0.95F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(39, 25).addBox(1.0F, 0.0F, 0.0F, 0.8F, 0.85F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(1, 75).addBox(1.0F, -3.2F, 0.0F, 1.0F, 0.95F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(32, 28).addBox(1.0F, -4.8F, 0.0F, 1.15F, 0.95F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(27, 27).addBox(1.0F, -6.45F, 0.0F, 1.3F, 0.9F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(0, 0).addBox(1.4F, -6.65F, 0.0F, 0.95F, 0.2F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(39, 10).addBox(1.0F, -2.35F, 0.25F, 0.75F, 0.95F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(40, 0).addBox(1.0F, -0.65F, 0.25F, 0.65F, 0.95F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(34, 28).addBox(1.0F, -4.05F, 0.25F, 0.85F, 1.05F, 0.25F, 0.0F, false);
		huabian.setTextureOffset(38, 11).addBox(1.0F, -5.55F, 0.25F, 0.95F, 0.85F, 0.25F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(2.5366F, -6.5284F, 0.425F);
		huabian.addChild(cube_r4);
		setRotationAngle(cube_r4, -1.5708F, 0.0F, -1.3963F);
		cube_r4.setTextureOffset(0, 0).addBox(-1.025F, -0.025F, -0.425F, 1.55F, 0.45F, 0.35F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.4739F, -6.3292F, 6.35F);
		huabian.addChild(cube_r5);
		setRotationAngle(cube_r5, -1.5708F, 0.0F, -0.5236F);
		cube_r5.setTextureOffset(22, 29).addBox(-0.475F, 2.8F, -0.125F, 1.85F, 1.0F, 0.25F, 0.0F, false);
		cube_r5.setTextureOffset(11, 75).addBox(-0.475F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(1.5306F, -6.381F, 0.425F);
		huabian.addChild(cube_r6);
		setRotationAngle(cube_r6, -1.5708F, 0.0F, -0.5236F);
		cube_r6.setTextureOffset(12, 28).addBox(-0.625F, -2.375F, -0.325F, 2.15F, 1.3F, 0.25F, 0.0F, false);
		cube_r6.setTextureOffset(38, 86).addBox(-0.425F, -0.375F, -0.325F, 1.65F, 0.8F, 0.25F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(1.875F, -6.55F, 0.125F);
		huabian.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.5236F);
		cube_r7.setTextureOffset(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.5F, -2.5F, 0.45F);
		huabian.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(0.9F, -4.15F, 5.4F, 0.95F, 0.2F, 0.25F, 0.0F, false);
		bone.setTextureOffset(26, 16).addBox(0.5F, -3.95F, 5.4F, 1.3F, 0.9F, 0.25F, 0.0F, false);
		bone.setTextureOffset(37, 10).addBox(0.5F, -3.05F, 5.15F, 0.95F, 0.85F, 0.25F, 0.0F, false);
		bone.setTextureOffset(36, 79).addBox(0.5F, -2.3F, 5.4F, 1.15F, 0.95F, 0.25F, 0.0F, false);
		bone.setTextureOffset(47, 88).addBox(0.5F, -1.55F, 5.15F, 1.2F, 1.05F, 0.25F, 0.0F, false);
		bone.setTextureOffset(11, 104).addBox(0.5F, -0.7F, 5.4F, 1.0F, 0.95F, 0.25F, 0.0F, false);
		bone.setTextureOffset(33, 38).addBox(0.5F, 0.15F, 5.15F, 0.75F, 0.95F, 0.25F, 0.0F, false);
		bone.setTextureOffset(40, 3).addBox(0.5F, 1.85F, 5.15F, 0.65F, 0.95F, 0.25F, 0.0F, false);
		bone.setTextureOffset(14, 37).addBox(0.5F, 1.0F, 5.4F, 0.9F, 0.95F, 0.25F, 0.0F, false);
		bone.setTextureOffset(32, 79).addBox(0.5F, 2.5F, 5.4F, 0.8F, 0.85F, 0.25F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(2.0366F, -4.0284F, 5.225F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.5708F, 0.0F, -1.3963F);
		cube_r8.setTextureOffset(0, 0).addBox(-1.025F, -0.025F, 0.075F, 1.55F, 0.45F, 0.35F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(1.375F, -4.05F, 5.525F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -0.5236F);
		cube_r9.setTextureOffset(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.0306F, -3.881F, 5.225F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 1.5708F, 0.0F, -0.5236F);
		cube_r10.setTextureOffset(18, 97).addBox(-0.425F, -0.375F, 0.075F, 1.65F, 0.8F, 0.25F, 0.0F, false);
		cube_r10.setTextureOffset(73, 51).addBox(-0.625F, -2.375F, 0.075F, 2.15F, 1.3F, 0.25F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.9739F, -3.8292F, -0.7F);
		bone.addChild(cube_r11);
		setRotationAngle(cube_r11, 1.5708F, 0.0F, -0.5236F);
		cube_r11.setTextureOffset(12, 30).addBox(-0.475F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, 0.0F, false);

		outer2 = new ModelRenderer(this);
		outer2.setRotationPoint(0.0F, 0.0F, 0.0F);
		outer.addChild(outer2);
		outer2.setTextureOffset(56, 18).addBox(-4.0F, -12.0F, -2.95F, 1.0F, 7.0F, 1.2F, 0.0F, false);
		outer2.setTextureOffset(20, 10).addBox(-4.0F, -12.25F, -2.95F, 1.0F, 0.25F, 5.7F, 0.0F, false);
		outer2.setTextureOffset(58, 26).addBox(-4.0F, -12.0F, 1.75F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		huabian2 = new ModelRenderer(this);
		huabian2.setRotationPoint(-3.0F, -5.8F, -3.15F);
		outer2.addChild(huabian2);
		huabian2.setTextureOffset(14, 36).addBox(-1.9F, -1.5F, 0.0F, 0.9F, 0.95F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(25, 39).addBox(-1.8F, 0.0F, 0.0F, 0.8F, 0.85F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(32, 30).addBox(-2.0F, -3.2F, 0.0F, 1.0F, 0.95F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(1, 77).addBox(-2.15F, -4.8F, 0.0F, 1.15F, 0.95F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(19, 25).addBox(-2.3F, -6.45F, 0.0F, 1.3F, 0.9F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(0, 0).addBox(-2.35F, -6.65F, 0.0F, 0.95F, 0.2F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(31, 38).addBox(-1.75F, -2.35F, 0.25F, 0.75F, 0.95F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(33, 39).addBox(-1.65F, -0.65F, 0.25F, 0.65F, 0.95F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(43, 81).addBox(-1.85F, -4.05F, 0.25F, 0.85F, 1.05F, 0.25F, 0.0F, false);
		huabian2.setTextureOffset(14, 35).addBox(-1.95F, -5.55F, 0.25F, 0.95F, 0.85F, 0.25F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-2.5366F, -6.5284F, 0.425F);
		huabian2.addChild(cube_r12);
		setRotationAngle(cube_r12, -1.5708F, 0.0F, 1.3963F);
		cube_r12.setTextureOffset(0, 0).addBox(-0.525F, -0.025F, -0.425F, 1.55F, 0.45F, 0.35F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-1.4739F, -6.3292F, 6.35F);
		huabian2.addChild(cube_r13);
		setRotationAngle(cube_r13, -1.5708F, 0.0F, 0.5236F);
		cube_r13.setTextureOffset(42, 77).addBox(-1.375F, 2.8F, -0.125F, 1.85F, 1.0F, 0.25F, 0.0F, false);
		cube_r13.setTextureOffset(0, 30).addBox(-1.175F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-1.5306F, -6.381F, 0.425F);
		huabian2.addChild(cube_r14);
		setRotationAngle(cube_r14, -1.5708F, 0.0F, 0.5236F);
		cube_r14.setTextureOffset(24, 22).addBox(-1.525F, -2.375F, -0.325F, 2.15F, 1.3F, 0.25F, 0.0F, false);
		cube_r14.setTextureOffset(52, 85).addBox(-1.225F, -0.375F, -0.325F, 1.65F, 0.8F, 0.25F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-1.875F, -6.55F, 0.125F);
		huabian2.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, 0.5236F);
		cube_r15.setTextureOffset(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-0.5F, -2.5F, 0.45F);
		huabian2.addChild(bone2);
		bone2.setTextureOffset(0, 0).addBox(-1.85F, -4.15F, 5.4F, 0.95F, 0.2F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(3, 0).addBox(-1.8F, -3.95F, 5.4F, 1.3F, 0.9F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(34, 30).addBox(-1.45F, -3.05F, 5.15F, 0.95F, 0.85F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(28, 28).addBox(-1.65F, -2.3F, 5.4F, 1.15F, 0.95F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(37, 94).addBox(-1.7F, -1.55F, 5.15F, 1.2F, 1.05F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(29, 100).addBox(-1.5F, -0.7F, 5.4F, 1.0F, 0.95F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(26, 38).addBox(-1.25F, 0.15F, 5.15F, 0.75F, 0.95F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(31, 39).addBox(-1.15F, 1.85F, 5.15F, 0.65F, 0.95F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(43, 75).addBox(-1.4F, 1.0F, 5.4F, 0.9F, 0.95F, 0.25F, 0.0F, false);
		bone2.setTextureOffset(39, 22).addBox(-1.3F, 2.5F, 5.4F, 0.8F, 0.85F, 0.25F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-2.0366F, -4.0284F, 5.225F);
		bone2.addChild(cube_r16);
		setRotationAngle(cube_r16, 1.5708F, 0.0F, 1.3963F);
		cube_r16.setTextureOffset(0, 0).addBox(-0.525F, -0.025F, 0.075F, 1.55F, 0.45F, 0.35F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-1.375F, -4.05F, 5.525F);
		bone2.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 0.5236F);
		cube_r17.setTextureOffset(0, 0).addBox(-0.475F, -0.2F, -0.125F, 0.95F, 0.4F, 0.25F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-1.0306F, -3.881F, 5.225F);
		bone2.addChild(cube_r18);
		setRotationAngle(cube_r18, 1.5708F, 0.0F, 0.5236F);
		cube_r18.setTextureOffset(40, 96).addBox(-1.225F, -0.375F, 0.075F, 1.65F, 0.8F, 0.25F, 0.0F, false);
		cube_r18.setTextureOffset(0, 4).addBox(-1.525F, -2.375F, 0.075F, 2.15F, 1.3F, 0.25F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-0.9739F, -3.8292F, -0.7F);
		bone2.addChild(cube_r19);
		setRotationAngle(cube_r19, 1.5708F, 0.0F, 0.5236F);
		cube_r19.setTextureOffset(26, 29).addBox(-1.175F, 4.7F, -0.125F, 1.65F, 0.9F, 0.25F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -0.4713F, -3.9911F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.4014F, 0.0F, 0.0F);
		bone3.setTextureOffset(38, 110).addBox(3.3545F, -3.1794F, 0.1574F, 0.5591F, 4.6962F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(14, 95).addBox(3.9135F, -2.0612F, 0.1574F, 0.1677F, 2.4599F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(6, 96).addBox(2.5158F, -3.1794F, 0.1574F, 0.8386F, 6.0939F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(4, 96).addBox(-3.3545F, -3.1794F, 0.1574F, 0.8386F, 6.0939F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(8, 96).addBox(-3.9135F, -3.1794F, 0.1574F, 0.5591F, 4.6962F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(24, 73).addBox(-4.0812F, -2.0612F, 0.1574F, 0.1677F, 2.4599F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(72, 99).addBox(-2.5158F, -3.1794F, -0.0662F, 5.0317F, 6.653F, 0.3914F, 0.0F, false);
		bone3.setTextureOffset(37, 73).addBox(-1.9568F, 3.4736F, -0.0662F, 3.9135F, 0.2795F, 0.3914F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(1.5179F, 2.2203F, -0.0843F);
		bone3.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, 2.138F);
		cube_r20.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(1.2339F, 2.4499F, -0.0843F);
		bone3.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, 2.8798F);
		cube_r21.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(0.8666F, 2.4198F, -0.0843F);
		bone3.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -2.618F);
		cube_r22.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(0.6394F, 2.1178F, -0.0843F);
		bone3.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -1.7017F);
		cube_r23.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.7568F, 1.7529F, -0.0843F);
		bone3.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -0.6981F);
		cube_r24.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(1.0967F, 1.6193F, -0.0843F);
		bone3.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.0436F);
		cube_r25.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(1.4353F, 1.7346F, -0.0843F);
		bone3.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, 0.6981F);
		cube_r26.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(1.7118F, 2.2442F, -0.0843F);
		bone3.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, 1.2654F);
		cube_r27.setTextureOffset(24, 77).addBox(-0.3546F, 0.141F, -0.0294F, 0.5192F, 0.098F, 0.0589F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(1.7963F, 2.4319F, -0.0843F);
		bone3.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 0.9599F);
		cube_r28.setTextureOffset(24, 77).addBox(-0.1171F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(1.7624F, 1.8269F, -0.1869F);
		bone3.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -0.5236F);
		

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-0.3477F, -0.2822F, 0.1026F);
		bone5.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, -0.6981F);
		cube_r29.setTextureOffset(18, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-0.0091F, -0.3975F, 0.1026F);
		bone5.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -0.0436F);
		cube_r30.setTextureOffset(19, 74).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(0.3308F, -0.264F, 0.1026F);
		bone5.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, 0.6981F);
		cube_r31.setTextureOffset(26, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(0.4481F, 0.1009F, 0.1026F);
		bone5.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, 1.7017F);
		cube_r32.setTextureOffset(22, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(0.221F, 0.403F, 0.1026F);
		bone5.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, 2.618F);
		cube_r33.setTextureOffset(24, 76).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(-0.4303F, 0.2035F, 0.1026F);
		bone5.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, -2.138F);
		cube_r34.setTextureOffset(24, 77).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(-0.1464F, 0.433F, 0.1026F);
		bone5.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -2.8798F);
		cube_r35.setTextureOffset(24, 77).addBox(-0.1646F, 0.141F, -0.0294F, 0.2817F, 0.098F, 0.0589F, 0.0F, false);

		huabian3 = new ModelRenderer(this);
		huabian3.setRotationPoint(0.0F, 0.587F, 5.5495F);
		bone3.addChild(huabian3);
		huabian3.setTextureOffset(56, 107).addBox(-1.1182F, 2.8866F, -5.2802F, 1.6772F, 1.1741F, 0.2795F, 0.0F, false);
		huabian3.setTextureOffset(38, 122).addBox(1.789F, 2.8866F, -5.2802F, 0.7268F, 0.8945F, 0.2795F, 0.0F, false);
		huabian3.setTextureOffset(32, 121).addBox(2.5102F, 1.8859F, -5.2802F, 0.5591F, 1.3418F, 0.2795F, 0.0F, false);
		huabian3.setTextureOffset(64, 99).addBox(0.3914F, 3.1662F, -5.7834F, 1.5654F, 1.1182F, 0.5032F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(4.5988F, -1.1892F, -5.5318F);
		huabian3.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, -1.7017F);
		cube_r36.setTextureOffset(61, 119).addBox(0.8945F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(4.5988F, -1.1892F, -5.5318F);
		huabian3.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -1.4399F);
		cube_r37.setTextureOffset(24, 119).addBox(-0.6709F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(4.2434F, 0.8677F, -5.5318F);
		huabian3.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -1.2654F);
		cube_r38.setTextureOffset(55, 115).addBox(-0.3914F, -0.8386F, -0.2516F, 1.1181F, 1.2182F, 0.5032F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(3.6899F, 2.6071F, -5.42F);
		huabian3.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -0.7854F);
		cube_r39.setTextureOffset(56, 104).addBox(-1.0063F, -1.0063F, -0.3634F, 1.3418F, 1.3536F, 0.5032F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(2.7926F, 3.1091F, -5.1405F);
		huabian3.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, 0.7854F);
		cube_r40.setTextureOffset(69, 102).addBox(-0.2795F, -0.1118F, -0.1398F, 0.5591F, 0.7827F, 0.2795F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(4.1577F, -1.9105F, -5.1405F);
		huabian3.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, -0.1309F);
		cube_r41.setTextureOffset(69, 92).addBox(-0.5311F, -1.7331F, -0.1398F, 0.7268F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(4.1577F, -1.9105F, -5.1405F);
		huabian3.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, -0.0436F);
		cube_r42.setTextureOffset(26, 121).addBox(-0.5311F, -0.3354F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(4.1473F, -0.5084F, -5.1405F);
		huabian3.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 0.0F, 0.0873F);
		cube_r43.setTextureOffset(68, 80).addBox(-0.5311F, -0.1677F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(3.5501F, 1.9362F, -5.1405F);
		huabian3.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.0F, 0.2618F);
		cube_r44.setTextureOffset(59, 104).addBox(-0.4752F, -1.0063F, -0.1398F, 0.8386F, 1.4536F, 0.2795F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		huabian3.addChild(bone4);
		bone4.setTextureOffset(63, 101).addBox(-1.9568F, 3.1662F, -5.7834F, 1.5654F, 1.1182F, 0.5032F, 0.0F, false);
		bone4.setTextureOffset(30, 121).addBox(-3.0693F, 1.8859F, -5.2802F, 0.5591F, 1.3418F, 0.2795F, 0.0F, false);
		bone4.setTextureOffset(69, 90).addBox(-2.5158F, 2.8866F, -5.2802F, 0.7268F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-3.5501F, 1.9362F, -5.1405F);
		bone4.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.0F, -0.2618F);
		cube_r45.setTextureOffset(52, 107).addBox(-0.3634F, -1.0063F, -0.1398F, 0.8386F, 1.4536F, 0.2795F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(-4.1473F, -0.5084F, -5.1405F);
		bone4.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 0.0F, -0.0873F);
		cube_r46.setTextureOffset(68, 79).addBox(-0.3075F, -0.1677F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(-4.1577F, -1.9105F, -5.1405F);
		bone4.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, 0.0436F);
		cube_r47.setTextureOffset(68, 78).addBox(-0.3075F, -0.3354F, -0.1398F, 0.8386F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(-4.1577F, -1.9105F, -5.1405F);
		bone4.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, 0.1309F);
		cube_r48.setTextureOffset(69, 91).addBox(-0.1957F, -1.7331F, -0.1398F, 0.7268F, 0.8945F, 0.2795F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(-2.7926F, 3.1091F, -5.1405F);
		bone4.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, -0.7854F);
		cube_r49.setTextureOffset(69, 99).addBox(-0.2795F, -0.1118F, -0.1398F, 0.5591F, 0.7827F, 0.2795F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(-3.6899F, 2.6071F, -5.42F);
		bone4.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.0F, 0.7854F);
		cube_r50.setTextureOffset(36, 107).addBox(-0.3354F, -1.0063F, -0.3634F, 1.3418F, 1.3536F, 0.5032F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(-4.2434F, 0.8677F, -5.5318F);
		bone4.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.0F, 1.2654F);
		cube_r51.setTextureOffset(49, 115).addBox(-0.7268F, -0.8386F, -0.2516F, 1.1181F, 1.2182F, 0.5032F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(-4.5988F, -1.1892F, -5.5318F);
		bone4.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.0F, 1.4399F);
		cube_r52.setTextureOffset(33, 118).addBox(-0.3354F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(-4.5988F, -1.1892F, -5.5318F);
		bone4.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, 0.0F, 1.7017F);
		cube_r53.setTextureOffset(30, 119).addBox(-1.9009F, -0.5591F, -0.2516F, 1.0063F, 0.7827F, 0.5032F, 0.0F, false);

		dress = new ModelRenderer(this);
		dress.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(dress);
		dress.setTextureOffset(3, 70).addBox(-4.6F, -3.3F, -2.6F, 9.2F, 1.3F, 1.1F, 0.0F, false);
		dress.setTextureOffset(75, 4).addBox(-4.6F, -3.3F, 1.5F, 9.2F, 1.3F, 1.1F, 0.0F, false);
		dress.setTextureOffset(87, 43).addBox(3.5F, -3.3F, -2.0F, 1.1F, 1.3F, 4.0F, 0.0F, false);
		dress.setTextureOffset(44, 0).addBox(-4.6F, -3.3F, -2.0F, 1.1F, 1.3F, 4.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(4.5F, 1.7F, -2.0F);
		dress.addChild(cube_r54);
		setRotationAngle(cube_r54, -0.2618F, 0.0F, -0.2618F);
		cube_r54.setTextureOffset(14, 53).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		cube_r54.setTextureOffset(17, 61).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(4.5F, 1.7F, 2.0F);
		dress.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.2618F, 0.0F, -0.2618F);
		cube_r55.setTextureOffset(61, 0).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r55.setTextureOffset(0, 54).addBox(-0.5F, -2.0F, -1.5F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(-4.5F, 1.7F, 2.0F);
		dress.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.2618F, 0.0F, 0.2618F);
		cube_r56.setTextureOffset(55, 6).addBox(-0.5F, -2.0F, -0.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r56.setTextureOffset(25, 63).addBox(-0.5F, -2.0F, -1.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(-4.5F, 1.7F, -2.0F);
		dress.addChild(cube_r57);
		setRotationAngle(cube_r57, -0.2618F, 0.0F, 0.2618F);
		cube_r57.setTextureOffset(8, 53).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		cube_r57.setTextureOffset(0, 62).addBox(0.5F, -2.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(4.9115F, 1.1533F, -1.5F);
		dress.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.0F, -0.3054F);
		cube_r58.setTextureOffset(13, 61).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r58.setTextureOffset(9, 61).addBox(-0.5F, -1.5F, 2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(5.0706F, 1.0212F, 0.0F);
		dress.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0F, 0.0F, -0.4363F);
		cube_r59.setTextureOffset(20, 54).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(-4.9115F, 1.1533F, 1.5F);
		dress.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, 0.0F, 0.3054F);
		cube_r60.setTextureOffset(62, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r60.setTextureOffset(21, 62).addBox(-0.5F, -1.5F, -3.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(-5.0706F, 1.0212F, 0.0F);
		dress.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.0F, 0.4363F);
		cube_r61.setTextureOffset(54, 52).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(4.0F, 1.2634F, 2.7364F);
		dress.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.1745F, 0.0F, 0.0F);
		cube_r62.setTextureOffset(5, 61).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r62.setTextureOffset(29, 63).addBox(-8.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(3.0F, 1.1533F, 2.9115F);
		dress.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.3054F, 0.0F, 0.0F);
		cube_r63.setTextureOffset(60, 12).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, 0.0F, false);
		cube_r63.setTextureOffset(54, 60).addBox(-6.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(0.0F, 0.9727F, 3.1197F);
		dress.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.48F, 0.0F, 0.0F);
		cube_r64.setTextureOffset(72, 42).addBox(-2.5F, -1.5F, -0.75F, 5.0F, 6.6F, 1.25F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setRotationPoint(-3.0F, 1.1533F, -2.9115F);
		dress.addChild(cube_r65);
		setRotationAngle(cube_r65, -0.3054F, 0.0F, 0.0F);
		cube_r65.setTextureOffset(60, 49).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, 0.0F, false);
		cube_r65.setTextureOffset(60, 19).addBox(5.5F, -1.5F, -0.5F, 1.0F, 6.3F, 1.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setRotationPoint(-4.0F, 1.2634F, -2.7364F);
		dress.addChild(cube_r66);
		setRotationAngle(cube_r66, -0.1745F, 0.0F, 0.0F);
		cube_r66.setTextureOffset(61, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r66.setTextureOffset(61, 33).addBox(7.5F, -1.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setRotationPoint(0.0F, 0.9727F, -3.1197F);
		dress.addChild(cube_r67);
		setRotationAngle(cube_r67, -0.48F, 0.0F, 0.0F);
		cube_r67.setTextureOffset(0, 33).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 6.6F, 1.25F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setRotationPoint(-4.2418F, -1.1635F, 0.0F);
		dress.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.0F, 0.0F, 0.2618F);
		cube_r68.setTextureOffset(46, 18).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setRotationPoint(4.2418F, -1.1635F, 0.0F);
		dress.addChild(cube_r69);
		setRotationAngle(cube_r69, 0.0F, 0.0F, -0.2618F);
		cube_r69.setTextureOffset(47, 38).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setRotationPoint(-0.5F, -1.1635F, 2.2418F);
		dress.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.2618F, 0.0F, 0.0F);
		cube_r70.setTextureOffset(21, 0).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setRotationPoint(-0.5F, -1.1635F, -2.2418F);
		dress.addChild(cube_r71);
		setRotationAngle(cube_r71, -0.2618F, 0.0F, 0.0F);
		cube_r71.setTextureOffset(0, 25).addBox(-4.0F, -1.0F, -0.5F, 9.0F, 2.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-4.5F, 1.7F, -2.0F);
		dress.addChild(bone6);
		

		cube_r72 = new ModelRenderer(this);
		cube_r72.setRotationPoint(0.225F, 0.815F, 0.1F);
		bone6.addChild(cube_r72);
		setRotationAngle(cube_r72, -0.2618F, 0.0F, 0.2618F);
		cube_r72.setTextureOffset(108, 66).addBox(-0.475F, -1.9F, -0.475F, 0.95F, 5.7F, 1.9F, 0.0F, false);
		cube_r72.setTextureOffset(117, 45).addBox(0.475F, -1.9F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setRotationPoint(0.225F, 0.815F, 3.9F);
		bone6.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.2618F, 0.0F, 0.2618F);
		cube_r73.setTextureOffset(101, 89).addBox(-0.475F, -1.9F, -0.475F, 1.9F, 5.7F, 0.95F, 0.0F, false);
		cube_r73.setTextureOffset(117, 38).addBox(-0.475F, -1.9F, -1.425F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setRotationPoint(8.775F, 0.815F, 3.9F);
		bone6.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.2618F, 0.0F, -0.2618F);
		cube_r74.setTextureOffset(117, 78).addBox(-1.425F, -1.9F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);
		cube_r74.setTextureOffset(79, 87).addBox(-0.475F, -1.9F, -1.425F, 0.95F, 5.7F, 1.9F, 0.0F, false);

		cube_r75 = new ModelRenderer(this);
		cube_r75.setRotationPoint(8.775F, 0.815F, 0.1F);
		bone6.addChild(cube_r75);
		setRotationAngle(cube_r75, -0.2618F, 0.0F, -0.2618F);
		cube_r75.setTextureOffset(85, 87).addBox(-0.475F, -1.9F, -0.475F, 0.95F, 5.7F, 1.9F, 0.0F, false);
		cube_r75.setTextureOffset(94, 96).addBox(-1.425F, -1.9F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setRotationPoint(4.5F, 0.124F, -0.9637F);
		bone6.addChild(cube_r76);
		setRotationAngle(cube_r76, -0.48F, 0.0F, 0.0F);
		cube_r76.setTextureOffset(66, 70).addBox(-2.375F, -1.425F, -0.475F, 4.75F, 6.27F, 1.1875F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setRotationPoint(4.5F, 0.124F, 4.9637F);
		bone6.addChild(cube_r77);
		setRotationAngle(cube_r77, 0.48F, 0.0F, 0.0F);
		cube_r77.setTextureOffset(89, 67).addBox(-2.375F, -1.425F, -0.7125F, 4.75F, 6.27F, 1.1875F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setRotationPoint(7.35F, 0.2956F, 4.7659F);
		bone6.addChild(cube_r78);
		setRotationAngle(cube_r78, 0.3054F, 0.0F, 0.0F);
		cube_r78.setTextureOffset(116, 94).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, 0.0F, false);
		cube_r78.setTextureOffset(86, 95).addBox(-6.175F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setRotationPoint(8.3F, 0.4002F, 4.5996F);
		bone6.addChild(cube_r79);
		setRotationAngle(cube_r79, 0.1745F, 0.0F, 0.0F);
		cube_r79.setTextureOffset(118, 71).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);
		cube_r79.setTextureOffset(100, 96).addBox(-8.075F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setRotationPoint(9.1659F, 0.2956F, 3.425F);
		bone6.addChild(cube_r80);
		setRotationAngle(cube_r80, 0.0F, 0.0F, -0.3054F);
		cube_r80.setTextureOffset(112, 100).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);
		cube_r80.setTextureOffset(120, 84).addBox(-0.475F, -1.425F, -3.325F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setRotationPoint(9.3171F, 0.1701F, 2.0F);
		bone6.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.0F, 0.0F, -0.4363F);
		cube_r81.setTextureOffset(108, 74).addBox(-0.475F, -1.425F, -0.95F, 0.95F, 5.7F, 1.9F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setRotationPoint(8.3F, 0.4002F, -0.5996F);
		bone6.addChild(cube_r82);
		setRotationAngle(cube_r82, -0.1745F, 0.0F, 0.0F);
		cube_r82.setTextureOffset(118, 64).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);
		cube_r82.setTextureOffset(118, 52).addBox(-8.075F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setRotationPoint(7.35F, 0.2956F, -0.7659F);
		bone6.addChild(cube_r83);
		setRotationAngle(cube_r83, -0.3054F, 0.0F, 0.0F);
		cube_r83.setTextureOffset(116, 87).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, 0.0F, false);
		cube_r83.setTextureOffset(90, 95).addBox(-6.175F, -1.425F, -0.475F, 0.95F, 5.985F, 0.95F, 0.0F, false);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setRotationPoint(-0.1659F, 0.2956F, 0.575F);
		bone6.addChild(cube_r84);
		setRotationAngle(cube_r84, 0.0F, 0.0F, 0.3054F);
		cube_r84.setTextureOffset(120, 32).addBox(-0.475F, -1.425F, -0.475F, 0.95F, 5.7F, 0.95F, 0.0F, false);
		cube_r84.setTextureOffset(104, 98).addBox(-0.475F, -1.425F, 2.375F, 0.95F, 5.7F, 0.95F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setRotationPoint(-0.3171F, 0.1701F, 2.0F);
		bone6.addChild(cube_r85);
		setRotationAngle(cube_r85, 0.0F, 0.0F, 0.4363F);
		cube_r85.setTextureOffset(91, 87).addBox(-0.475F, -1.425F, -0.95F, 0.95F, 5.7F, 1.9F, 0.0F, false);

		outer_dress = new ModelRenderer(this);
		outer_dress.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(outer_dress);
		

		tie = new ModelRenderer(this);
		tie.setRotationPoint(0.0F, -1.0F, 0.0F);
		body.addChild(tie);
		tie.setTextureOffset(85, 36).addBox(-0.5F, -11.5F, -3.3F, 1.0F, 1.0F, 1.05F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setRotationPoint(-0.933F, -9.384F, -2.75F);
		tie.addChild(cube_r86);
		setRotationAngle(cube_r86, 0.0F, 0.0F, 0.5236F);
		cube_r86.setTextureOffset(70, 8).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.75F, 1.0F, 0.0F, false);

		cube_r87 = new ModelRenderer(this);
		cube_r87.setRotationPoint(0.933F, -9.384F, -2.75F);
		tie.addChild(cube_r87);
		setRotationAngle(cube_r87, 0.0F, 0.0F, -0.5236F);
		cube_r87.setTextureOffset(96, 13).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.75F, 1.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setRotationPoint(1.0F, -11.0F, -2.75F);
		tie.addChild(cube_r88);
		setRotationAngle(cube_r88, 0.0F, 0.0F, -0.1309F);
		cube_r88.setTextureOffset(70, 29).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setRotationPoint(-0.8165F, -10.4495F, -2.75F);
		tie.addChild(cube_r89);
		setRotationAngle(cube_r89, 0.0F, 0.0F, -0.2618F);
		cube_r89.setTextureOffset(70, 25).addBox(-1.15F, -0.5F, -0.5F, 2.15F, 0.75F, 1.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setRotationPoint(0.9614F, -10.4107F, -2.75F);
		tie.addChild(cube_r90);
		setRotationAngle(cube_r90, 0.0F, 0.0F, 0.2618F);
		cube_r90.setTextureOffset(70, 27).addBox(-1.15F, -0.5F, -0.5F, 2.15F, 0.75F, 1.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setRotationPoint(-1.0F, -11.0F, -2.75F);
		tie.addChild(cube_r91);
		setRotationAngle(cube_r91, 0.0F, 0.0F, 0.1309F);
		cube_r91.setTextureOffset(92, 35).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 2.0F, 0.0F);
		main.addChild(right_total);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_total.addChild(right);
		

		rightup = new ModelRenderer(this);
		rightup.setRotationPoint(5.0F, 9.0F, 0.0F);
		right.addChild(rightup);
		rightup.setTextureOffset(0, 28).addBox(-8.0F, -12.25F, -2.0F, 4.0F, 0.5F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(16, 45).addBox(-8.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(6, 45).addBox(-4.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(38, 50).addBox(-4.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rightup.setTextureOffset(28, 50).addBox(-8.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setRotationPoint(-6.0F, -6.0F, 2.0F);
		rightup.addChild(cube_r92);
		setRotationAngle(cube_r92, 0.0F, 1.5708F, 0.0F);
		cube_r92.setTextureOffset(51, 1).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r93 = new ModelRenderer(this);
		cube_r93.setRotationPoint(-6.0F, -6.0F, -2.0F);
		rightup.addChild(cube_r93);
		setRotationAngle(cube_r93, 0.0F, -1.5708F, 0.0F);
		cube_r93.setTextureOffset(44, 52).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r94 = new ModelRenderer(this);
		cube_r94.setRotationPoint(-6.0F, -10.0F, -2.25F);
		rightup.addChild(cube_r94);
		setRotationAngle(cube_r94, 0.0F, -1.5708F, 0.0F);
		cube_r94.setTextureOffset(41, 42).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r95 = new ModelRenderer(this);
		cube_r95.setRotationPoint(-6.0F, -10.0F, 2.25F);
		rightup.addChild(cube_r95);
		setRotationAngle(cube_r95, 0.0F, 1.5708F, 0.0F);
		cube_r95.setTextureOffset(45, 5).addBox(-0.4F, -2.0F, -2.0F, 0.9F, 4.0F, 4.0F, 0.0F, false);

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 2.0F, 0.0F);
		main.addChild(left_total);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_total.addChild(left);
		

		leftup = new ModelRenderer(this);
		leftup.setRotationPoint(-5.0F, 9.0F, 0.0F);
		left.addChild(leftup);
		leftup.setTextureOffset(26, 5).addBox(4.0F, -12.25F, -2.0F, 4.0F, 0.5F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(31, 42).addBox(7.75F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(38, 1).addBox(3.25F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(0, 49).addBox(3.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		leftup.setTextureOffset(47, 31).addBox(7.5F, -8.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r96 = new ModelRenderer(this);
		cube_r96.setRotationPoint(6.0F, -6.0F, 2.0F);
		leftup.addChild(cube_r96);
		setRotationAngle(cube_r96, 0.0F, -1.5708F, 0.0F);
		cube_r96.setTextureOffset(22, 49).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r97 = new ModelRenderer(this);
		cube_r97.setRotationPoint(6.0F, -6.0F, -2.0F);
		leftup.addChild(cube_r97);
		setRotationAngle(cube_r97, 0.0F, 1.5708F, 0.0F);
		cube_r97.setTextureOffset(50, 13).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r98 = new ModelRenderer(this);
		cube_r98.setRotationPoint(6.0F, -10.0F, -2.25F);
		leftup.addChild(cube_r98);
		setRotationAngle(cube_r98, 0.0F, 1.5708F, 0.0F);
		cube_r98.setTextureOffset(25, 38).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r99 = new ModelRenderer(this);
		cube_r99.setRotationPoint(6.0F, -10.0F, 2.25F);
		leftup.addChild(cube_r99);
		setRotationAngle(cube_r99, 0.0F, -1.5708F, 0.0F);
		cube_r99.setTextureOffset(0, 41).addBox(-0.5F, -2.0F, -2.0F, 0.9F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
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