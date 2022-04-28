package tech.lq0.providencraft.models;// Made with Blockbench 4.2.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class HiruTentaclesModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer ttc1_1;
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
	private final ModelRenderer ttc1_2;
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
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer ttc2_1;
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
	private final ModelRenderer ttc2_2;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
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

	public HiruTentaclesModel() {
		super(1.0f);
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		ttc1_1 = new ModelRenderer(this);
		ttc1_1.setRotationPoint(-2.0F, -3.0F, 2.5F);
		main.addChild(ttc1_1);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.4361F, -17.4388F, 0.8415F);
		ttc1_1.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.1745F, 0.0F);
		cube_r1.setTextureOffset(12, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-11.1196F, -21.1904F, -4.9413F);
		ttc1_1.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.5153F, 0.0625F, -0.0249F);
		cube_r2.setTextureOffset(12, 24).addBox(-1.0F, -0.5F, -5.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(37, 27).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-11.0304F, -21.2841F, -4.8372F);
		ttc1_1.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.4293F, 0.1513F, -0.0119F);
		cube_r3.setTextureOffset(29, 37).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-11.0304F, -21.2841F, -4.8372F);
		ttc1_1.addChild(cube_r4);
		setRotationAngle(cube_r4, -1.3408F, 0.3263F, 0.0015F);
		cube_r4.setTextureOffset(37, 31).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-11.0304F, -21.379F, -4.8092F);
		ttc1_1.addChild(cube_r5);
		setRotationAngle(cube_r5, -1.2027F, 0.3232F, 0.0456F);
		cube_r5.setTextureOffset(0, 38).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-11.2F, -20.4732F, -4.7102F);
		ttc1_1.addChild(cube_r6);
		setRotationAngle(cube_r6, -1.0047F, 0.4404F, 0.1082F);
		cube_r6.setTextureOffset(21, 38).addBox(-0.75F, -1.25F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-10.8256F, -19.7863F, -4.146F);
		ttc1_1.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.848F, 0.5099F, 0.1573F);
		cube_r7.setTextureOffset(38, 24).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-10.4562F, -18.3849F, -2.8385F);
		ttc1_1.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.714F, 0.4442F, 0.1952F);
		cube_r8.setTextureOffset(12, 20).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-10.0731F, -17.7541F, -2.0275F);
		ttc1_1.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.5617F, -0.9506F, 0.8803F);
		cube_r9.setTextureOffset(20, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-9.5908F, -17.2916F, -1.1551F);
		ttc1_1.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.1595F, -0.8996F, 0.4111F);
		cube_r10.setTextureOffset(34, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-9.0625F, -17.043F, -0.6025F);
		ttc1_1.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.0656F, -0.7371F, 0.3423F);
		cube_r11.setTextureOffset(34, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-8.5683F, -16.9579F, -0.1812F);
		ttc1_1.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.0131F, -0.5231F, 0.1804F);
		cube_r12.setTextureOffset(24, 34).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-7.8802F, -16.8946F, 0.1908F);
		ttc1_1.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -0.3927F, 0.0873F);
		cube_r13.setTextureOffset(34, 34).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-6.6957F, -16.8915F, 0.5462F);
		ttc1_1.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -0.2182F, 0.0F);
		cube_r14.setTextureOffset(22, 2).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-4.9053F, -16.9855F, 0.878F);
		ttc1_1.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.1309F, -0.0873F);
		cube_r15.setTextureOffset(6, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-4.5867F, -16.9905F, 1.0F);
		ttc1_1.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.1309F);
		cube_r16.setTextureOffset(8, 2).addBox(0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		ttc1_2 = new ModelRenderer(this);
		ttc1_2.setRotationPoint(2.0F, -3.0F, 2.5F);
		main.addChild(ttc1_2);
		

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.4361F, -17.4388F, 0.8415F);
		ttc1_2.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -0.1745F, 0.0F);
		cube_r17.setTextureOffset(16, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(11.1196F, -21.1904F, -4.9413F);
		ttc1_2.addChild(cube_r18);
		setRotationAngle(cube_r18, -1.5153F, -0.0625F, 0.0249F);
		cube_r18.setTextureOffset(0, 24).addBox(-1.0F, -0.5F, -5.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r18.setTextureOffset(36, 0).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(11.0304F, -21.2841F, -4.8372F);
		ttc1_2.addChild(cube_r19);
		setRotationAngle(cube_r19, -1.4293F, -0.1513F, 0.0119F);
		cube_r19.setTextureOffset(37, 5).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(11.0304F, -21.2841F, -4.8372F);
		ttc1_2.addChild(cube_r20);
		setRotationAngle(cube_r20, -1.3408F, -0.3263F, -0.0015F);
		cube_r20.setTextureOffset(9, 37).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(11.0304F, -21.379F, -4.8092F);
		ttc1_2.addChild(cube_r21);
		setRotationAngle(cube_r21, -1.2027F, -0.3232F, -0.0456F);
		cube_r21.setTextureOffset(37, 9).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(11.2F, -20.4732F, -4.7102F);
		ttc1_2.addChild(cube_r22);
		setRotationAngle(cube_r22, -1.0047F, -0.4404F, -0.1082F);
		cube_r22.setTextureOffset(37, 13).addBox(-1.25F, -1.25F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(10.8256F, -19.7863F, -4.146F);
		ttc1_2.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.848F, -0.5099F, -0.1573F);
		cube_r23.setTextureOffset(15, 37).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(10.4562F, -18.3849F, -2.8385F);
		ttc1_2.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.714F, -0.4442F, -0.1952F);
		cube_r24.setTextureOffset(6, 18).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(10.0731F, -17.7541F, -2.0275F);
		ttc1_2.addChild(cube_r25);
		setRotationAngle(cube_r25, -0.5617F, 0.9506F, -0.8803F);
		cube_r25.setTextureOffset(18, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(9.5908F, -17.2916F, -1.1551F);
		ttc1_2.addChild(cube_r26);
		setRotationAngle(cube_r26, -0.1595F, 0.8996F, -0.4111F);
		cube_r26.setTextureOffset(32, 28).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(9.0625F, -17.043F, -0.6025F);
		ttc1_2.addChild(cube_r27);
		setRotationAngle(cube_r27, -0.0656F, 0.7371F, -0.3423F);
		cube_r27.setTextureOffset(30, 32).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(8.5683F, -16.9579F, -0.1812F);
		ttc1_2.addChild(cube_r28);
		setRotationAngle(cube_r28, -0.0131F, 0.5231F, -0.1804F);
		cube_r28.setTextureOffset(14, 33).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(7.8802F, -16.8946F, 0.1908F);
		ttc1_2.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.3927F, -0.0873F);
		cube_r29.setTextureOffset(4, 34).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(6.6957F, -16.8915F, 0.5462F);
		ttc1_2.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.2182F, 0.0F);
		cube_r30.setTextureOffset(0, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(4.9053F, -16.9855F, 0.878F);
		ttc1_2.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.1309F, 0.0873F);
		cube_r31.setTextureOffset(20, 10).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(4.5867F, -16.9905F, 1.0F);
		ttc1_2.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, 0.1309F);
		cube_r32.setTextureOffset(0, 8).addBox(-3.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		ttc2_1 = new ModelRenderer(this);
		ttc2_1.setRotationPoint(-3.685F, -15.615F, 3.0F);
		main.addChild(ttc2_1);
		setRotationAngle(ttc2_1, 0.0F, -0.2182F, 0.0F);
		ttc2_1.setTextureOffset(16, 0).addBox(0.1518F, -1.1226F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-6.865F, 9.4637F, -3.0299F);
		ttc2_1.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.508F, 0.5781F, -2.4224F);
		cube_r33.setTextureOffset(18, 22).addBox(-2.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r33.setTextureOffset(28, 26).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(-7.2855F, 8.9848F, -3.3868F);
		ttc2_1.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.6313F, 0.4361F, -2.1703F);
		cube_r34.setTextureOffset(16, 29).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(-7.6358F, 8.3514F, -3.6675F);
		ttc2_1.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.6979F, 0.3011F, -1.9863F);
		cube_r35.setTextureOffset(4, 30).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(-8.1779F, 6.6569F, -4.0518F);
		ttc2_1.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.7308F, 0.1866F, -1.8505F);
		cube_r36.setTextureOffset(14, 8).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(-8.5539F, 4.8426F, -4.2735F);
		ttc2_1.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.7447F, 0.0985F, -1.7526F);
		cube_r37.setTextureOffset(30, 14).addBox(-1.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(-8.4527F, 5.0493F, -4.194F);
		ttc2_1.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.7486F, -0.05F, -1.5926F);
		cube_r38.setTextureOffset(26, 30).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(-8.4192F, 4.3693F, -4.0878F);
		ttc2_1.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.7228F, -0.261F, -1.4882F);
		cube_r39.setTextureOffset(10, 31).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-8.2916F, 3.6942F, -3.8401F);
		ttc2_1.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.6497F, -0.4275F, -1.2733F);
		cube_r40.setTextureOffset(0, 32).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(-8.0328F, 3.1093F, -3.4873F);
		ttc2_1.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.5299F, -0.574F, -1.0253F);
		cube_r41.setTextureOffset(32, 2).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(-7.9234F, 2.8896F, -3.3434F);
		ttc2_1.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.3888F, -0.6713F, -0.7845F);
		cube_r42.setTextureOffset(32, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(-6.3661F, 1.8692F, -2.0242F);
		ttc2_1.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.1247F, -0.7454F, -0.5138F);
		cube_r43.setTextureOffset(14, 12).addBox(-1.5F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(-5.9445F, 1.5509F, -1.3699F);
		ttc2_1.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0474F, -0.598F, -0.48F);
		cube_r44.setTextureOffset(32, 10).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(-5.3006F, 1.1692F, -0.8709F);
		ttc2_1.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0666F, -0.4808F, -0.445F);
		cube_r45.setTextureOffset(20, 32).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(-4.9811F, 1.0039F, -0.6676F);
		ttc2_1.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0204F, -0.3097F, -0.3436F);
		cube_r46.setTextureOffset(32, 24).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(-3.8051F, 0.6755F, -0.2704F);
		ttc2_1.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.029F, -0.2167F, -0.2193F);
		cube_r47.setTextureOffset(0, 16).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(-1.065F, 0.615F, 0.0F);
		ttc2_1.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, -0.1745F);
		cube_r48.setTextureOffset(0, 4).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		ttc2_2 = new ModelRenderer(this);
		ttc2_2.setRotationPoint(3.685F, -15.615F, 3.0F);
		main.addChild(ttc2_2);
		setRotationAngle(ttc2_2, 0.0F, 0.2182F, 0.0F);
		ttc2_2.setTextureOffset(8, 6).addBox(-2.1518F, -1.1226F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(6.865F, 9.4637F, -3.0299F);
		ttc2_2.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.508F, -0.5781F, 2.4224F);
		cube_r49.setTextureOffset(22, 6).addBox(0.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r49.setTextureOffset(24, 20).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(7.2855F, 8.9848F, -3.3868F);
		ttc2_2.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.6313F, -0.4361F, 2.1703F);
		cube_r50.setTextureOffset(24, 24).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(7.6358F, 8.3514F, -3.6675F);
		ttc2_2.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.6979F, -0.3011F, 1.9863F);
		cube_r51.setTextureOffset(18, 25).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(8.1779F, 6.6569F, -4.0518F);
		ttc2_2.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.7308F, -0.1866F, 1.8505F);
		cube_r52.setTextureOffset(8, 10).addBox(-0.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(8.5539F, 4.8426F, -4.2735F);
		ttc2_2.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.7447F, -0.0985F, 1.7526F);
		cube_r53.setTextureOffset(26, 12).addBox(0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(8.4527F, 5.0493F, -4.194F);
		ttc2_2.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.7486F, 0.05F, 1.5926F);
		cube_r54.setTextureOffset(26, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(8.4192F, 4.3693F, -4.0878F);
		ttc2_2.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.7228F, 0.261F, 1.4882F);
		cube_r55.setTextureOffset(0, 27).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(8.2916F, 3.6942F, -3.8401F);
		ttc2_2.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.6497F, 0.4275F, 1.2733F);
		cube_r56.setTextureOffset(12, 27).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(8.0328F, 3.1093F, -3.4873F);
		ttc2_2.addChild(cube_r57);
		setRotationAngle(cube_r57, 0.5299F, 0.574F, 1.0253F);
		cube_r57.setTextureOffset(28, 0).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(7.9234F, 2.8896F, -3.3434F);
		ttc2_2.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.3888F, 0.6713F, 0.7845F);
		cube_r58.setTextureOffset(28, 4).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(6.3661F, 1.8692F, -2.0242F);
		ttc2_2.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.1247F, 0.7454F, 0.5138F);
		cube_r59.setTextureOffset(0, 12).addBox(-0.5F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(5.9445F, 1.5509F, -1.3699F);
		ttc2_2.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0474F, 0.598F, 0.48F);
		cube_r60.setTextureOffset(28, 8).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(5.3006F, 1.1692F, -0.8709F);
		ttc2_2.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0666F, 0.4808F, 0.445F);
		cube_r61.setTextureOffset(22, 28).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(4.9811F, 1.0039F, -0.6676F);
		ttc2_2.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0204F, 0.3097F, 0.3436F);
		cube_r62.setTextureOffset(28, 22).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(3.8051F, 0.6755F, -0.2704F);
		ttc2_2.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.029F, 0.2167F, 0.2193F);
		cube_r63.setTextureOffset(6, 14).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(1.065F, 0.615F, 0.0F);
		ttc2_2.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0F, 0.0F, 0.1745F);
		cube_r64.setTextureOffset(0, 0).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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