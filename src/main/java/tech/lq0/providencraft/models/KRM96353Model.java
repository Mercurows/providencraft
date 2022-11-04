package tech.lq0.providencraft.models;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class KRM96353Model<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer body;
    private final ModelRenderer wing1;
    private final ModelRenderer bx;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer bz;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer fs;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer fx;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer wing2;
    private final ModelRenderer bx2;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer bz2;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer fs2;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer cube_r34;
    private final ModelRenderer cube_r35;
    private final ModelRenderer cube_r36;
    private final ModelRenderer cube_r37;
    private final ModelRenderer fx2;
    private final ModelRenderer cube_r38;
    private final ModelRenderer cube_r39;
    private final ModelRenderer cube_r40;
    private final ModelRenderer cube_r41;
    private final ModelRenderer cube_r42;
    private final ModelRenderer halo;
    private final ModelRenderer rgb;
    private final ModelRenderer rgb_cube_63_r1;
    private final ModelRenderer rgb_cube_62_r1;
    private final ModelRenderer rgb_cube_61_r1;
    private final ModelRenderer rgb_cube_60_r1;
    private final ModelRenderer rgb_cube_59_r1;
    private final ModelRenderer rgb_cube_58_r1;
    private final ModelRenderer rgb_cube_57_r1;
    private final ModelRenderer rgb_cube_56_r1;
    private final ModelRenderer rgb_cube_55_r1;
    private final ModelRenderer rgb_cube_54_r1;
    private final ModelRenderer rgb_cube_53_r1;
    private final ModelRenderer rgb_cube_52_r1;
    private final ModelRenderer rgb_cube_51_r1;
    private final ModelRenderer rgb_cube_50_r1;
    private final ModelRenderer rgb_cube_49_r1;
    private final ModelRenderer rgb_cube_48_r1;
    private final ModelRenderer rgb_cube_47_r1;
    private final ModelRenderer rgb_cube_46_r1;
    private final ModelRenderer rgb_cube_45_r1;
    private final ModelRenderer rgb_cube_44_r1;
    private final ModelRenderer rgb_cube_43_r1;
    private final ModelRenderer rgb_cube_42_r1;
    private final ModelRenderer rgb_cube_41_r1;
    private final ModelRenderer rgb_cube_40_r1;
    private final ModelRenderer rgb_cube_39_r1;
    private final ModelRenderer rgb_cube_38_r1;
    private final ModelRenderer rgb_cube_37_r1;
    private final ModelRenderer rgb_cube_36_r1;
    private final ModelRenderer rgb_cube_35_r1;
    private final ModelRenderer rgb_cube_34_r1;
    private final ModelRenderer rgb_cube_33_r1;
    private final ModelRenderer rgb_cube_32_r1;
    private final ModelRenderer rgb_cube_31_r1;
    private final ModelRenderer rgb_cube_30_r1;
    private final ModelRenderer rgb_cube_29_r1;
    private final ModelRenderer rgb_cube_28_r1;
    private final ModelRenderer rgb_cube_27_r1;
    private final ModelRenderer rgb_cube_26_r1;
    private final ModelRenderer rgb_cube_25_r1;
    private final ModelRenderer rgb_cube_24_r1;
    private final ModelRenderer rgb_cube_23_r1;
    private final ModelRenderer rgb_cube_22_r1;
    private final ModelRenderer rgb_cube_21_r1;
    private final ModelRenderer rgb_cube_20_r1;
    private final ModelRenderer rgb_cube_19_r1;
    private final ModelRenderer rgb_cube_18_r1;
    private final ModelRenderer rgb_cube_17_r1;
    private final ModelRenderer rgb_cube_16_r1;
    private final ModelRenderer rgb_cube_15_r1;
    private final ModelRenderer rgb_cube_14_r1;
    private final ModelRenderer rgb_cube_13_r1;
    private final ModelRenderer rgb_cube_12_r1;
    private final ModelRenderer rgb_cube_11_r1;
    private final ModelRenderer rgb_cube_10_r1;
    private final ModelRenderer rgb_cube_9_r1;
    private final ModelRenderer rgb_cube_8_r1;
    private final ModelRenderer rgb_cube_7_r1;
    private final ModelRenderer rgb_cube_6_r1;
    private final ModelRenderer rgb_cube_5_r1;
    private final ModelRenderer rgb_cube_4_r1;
    private final ModelRenderer rgb_cube_3_r1;
    private final ModelRenderer rgb_cube_2_r1;
    private final ModelRenderer rgb_cube_1_r1;
    private final ModelRenderer outer;
    private final ModelRenderer dev1;
    private final ModelRenderer cube_r43;
    private final ModelRenderer cube_r44;
    private final ModelRenderer cube_r45;
    private final ModelRenderer cube_r46;
    private final ModelRenderer cube_r47;
    private final ModelRenderer dev2;
    private final ModelRenderer cube_r48;
    private final ModelRenderer cube_r49;
    private final ModelRenderer cube_r50;
    private final ModelRenderer cube_r51;
    private final ModelRenderer cube_r52;
    private final ModelRenderer dev3;
    private final ModelRenderer cube_r53;
    private final ModelRenderer cube_r54;
    private final ModelRenderer cube_r55;
    private final ModelRenderer cube_r56;
    private final ModelRenderer cube_r57;
    private final ModelRenderer dev4;
    private final ModelRenderer cube_r58;
    private final ModelRenderer cube_r59;
    private final ModelRenderer cube_r60;
    private final ModelRenderer cube_r61;
    private final ModelRenderer cube_r62;
    private final ModelRenderer od;
    private final ModelRenderer cube_r63;
    private final ModelRenderer cube_r64;
    private final ModelRenderer od2;
    private final ModelRenderer cube_r65;
    private final ModelRenderer cube_r66;
    private final ModelRenderer od3;
    private final ModelRenderer cube_r67;
    private final ModelRenderer cube_r68;
    private final ModelRenderer od4;
    private final ModelRenderer cube_r69;
    private final ModelRenderer cube_r70;

    public KRM96353Model() {
        super(1.0f);
        textureWidth = 256;
        textureHeight = 256;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 28.0F, 0.0F);
        main.addChild(body);


        wing1 = new ModelRenderer(this);
        wing1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(wing1);


        bx = new ModelRenderer(this);
        bx.setRotationPoint(5.8799F, -4.1941F, 7.0F);
        wing1.addChild(bx);
        setRotationAngle(bx, 0.0F, -0.2182F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(1.4447F, 14.0497F, 1.7663F);
        bx.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.2182F, 0.0F, -0.1309F);
        cube_r1.setTextureOffset(59, 166).addBox(1.5641F, 2.3449F, -0.5222F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r1.setTextureOffset(75, 165).addBox(0.5641F, 0.3449F, -0.5222F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r1.setTextureOffset(89, 122).addBox(-0.4359F, -1.6551F, -0.5222F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r1.setTextureOffset(84, 133).addBox(-1.4359F, -3.6551F, -0.5222F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r1.setTextureOffset(68, 149).addBox(-2.4359F, -5.6551F, -0.5222F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(4.4579F, 13.5276F, 2.1992F);
        bx.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.2182F, 0.0F, -0.1309F);
        cube_r2.setTextureOffset(91, 87).addBox(0.5F, 12.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r2.setTextureOffset(51, 162).addBox(0.0F, 9.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r2.setTextureOffset(28, 121).addBox(-0.5F, -5.5F, -1.0F, 4.0F, 15.0F, 2.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(4.9324F, -2.0212F, 1.7663F);
        bx.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.2182F, 0.0F, -0.1309F);
        cube_r3.setTextureOffset(46, 165).addBox(-0.5F, 0.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-0.6249F, -2.0958F, 1.0325F);
        bx.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.1309F);
        cube_r4.setTextureOffset(67, 166).addBox(4.5F, 10.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r4.setTextureOffset(74, 104).addBox(4.5F, 4.0F, -2.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
        cube_r4.setTextureOffset(12, 159).addBox(3.5F, 3.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        cube_r4.setTextureOffset(6, 149).addBox(2.5F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-1.6249F, -2.0958F, 1.0325F);
        bx.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, -0.1309F);
        cube_r5.setTextureOffset(0, 129).addBox(1.5F, -8.0F, -1.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
        cube_r5.setTextureOffset(10, 106).addBox(-1.5F, -10.0F, -1.0F, 3.0F, 21.0F, 2.0F, 0.0F, false);

        bz = new ModelRenderer(this);
        bz.setRotationPoint(15.5939F, -6.3931F, 7.3619F);
        wing1.addChild(bz);
        setRotationAngle(bz, 0.0F, 0.0F, -0.3491F);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(3.0761F, 3.2876F, -0.1175F);
        bz.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.1745F, -0.1309F);
        cube_r6.setTextureOffset(31, 146).addBox(-0.3469F, -10.1156F, -2.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
        cube_r6.setTextureOffset(63, 131).addBox(-2.3469F, -13.1156F, -2.0F, 2.0F, 11.0F, 3.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(2.901F, 9.3436F, -0.7081F);
        bz.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.1745F, -0.1309F);
        cube_r7.setTextureOffset(84, 104).addBox(-1.0F, 0.5856F, -0.6207F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(2.901F, 9.3436F, -0.7081F);
        bz.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.1745F, -0.1309F);
        cube_r8.setTextureOffset(40, 133).addBox(-1.5F, -8.097F, -1.2509F, 3.0F, 9.0F, 3.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-0.3399F, -4.9527F, 0.29F);
        bz.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.1745F, -0.1309F);
        cube_r9.setTextureOffset(63, 158).addBox(-1.0F, -2.5F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        cube_r9.setTextureOffset(69, 158).addBox(-3.0F, -2.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-11.7977F, 2.1033F, 0.7958F);
        bz.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, -0.1309F);
        cube_r10.setTextureOffset(8, 142).addBox(3.5F, -8.0F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);

        fs = new ModelRenderer(this);
        fs.setRotationPoint(0.0F, 0.0F, 0.0F);
        wing1.addChild(fs);
        fs.setTextureOffset(89, 113).addBox(21.8408F, -30.9445F, 7.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(24.2986F, -37.8278F, 8.5F);
        fs.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, 0.3054F);
        cube_r11.setTextureOffset(80, 151).addBox(1.0F, -4.5F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(31.0F, -36.0F, 8.5F);
        fs.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, -0.2618F);
        cube_r12.setTextureOffset(55, 83).addBox(-8.0F, 1.0F, -1.5F, 9.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r12.setTextureOffset(0, 91).addBox(-9.0F, -1.0F, -1.5F, 18.0F, 2.0F, 3.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(25.9294F, -43.7274F, 6.5F);
        fs.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0F, 0.0F, -0.829F);
        cube_r13.setTextureOffset(75, 122).addBox(-5.0F, 3.0F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(56, 97).addBox(-7.0F, 2.0F, -1.5F, 9.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(79, 92).addBox(-8.0F, -5.9F, -0.5F, 5.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r13.setTextureOffset(92, 106).addBox(-9.0F, -2.9F, -0.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r13.setTextureOffset(39, 93).addBox(-9.0F, 1.0F, -1.5F, 10.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(18, 162).addBox(14.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(88, 97).addBox(-14.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(82, 126).addBox(3.0F, -5.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(0, 101).addBox(-10.0F, -5.0F, -1.5F, 13.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r13.setTextureOffset(0, 80).addBox(-12.0F, -2.0F, -1.5F, 26.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(25.3435F, -31.6758F, 8.0F);
        fs.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0F, 0.0F, 0.4363F);
        cube_r14.setTextureOffset(79, 142).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(26.121F, -30.8724F, 8.0F);
        fs.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, -0.3054F);
        cube_r15.setTextureOffset(65, 94).addBox(-1.5F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(27.3976F, -28.6478F, 7.5F);
        fs.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.0F, 0.2182F);
        cube_r16.setTextureOffset(84, 162).addBox(5.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r16.setTextureOffset(89, 109).addBox(-9.0F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r16.setTextureOffset(29, 103).addBox(-7.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, 0.0F, false);

        fx = new ModelRenderer(this);
        fx.setRotationPoint(-4.0F, 12.0F, 4.0F);
        wing1.addChild(fx);


        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(36.5F, -15.5F, 7.5F);
        fx.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 0.0F, 0.7854F);
        cube_r17.setTextureOffset(0, 162).addBox(-10.5F, 6.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r17.setTextureOffset(53, 156).addBox(-8.5F, 5.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r17.setTextureOffset(73, 128).addBox(-6.5F, 5.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        cube_r17.setTextureOffset(78, 116).addBox(2.5F, 5.95F, 0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r17.setTextureOffset(78, 119).addBox(2.5F, 5.95F, -1.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r17.setTextureOffset(91, 162).addBox(12.5F, 6.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r17.setTextureOffset(56, 121).addBox(2.5F, 5.5F, -0.5F, 10.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r17.setTextureOffset(59, 101).addBox(-3.5F, 5.5F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(37.8277F, -13.8352F, 12.3571F);
        fx.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0752F, -0.5187F, 0.2418F);
        cube_r18.setTextureOffset(79, 86).addBox(4.75F, -1.75F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r18.setTextureOffset(39, 153).addBox(-10.25F, -2.5F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r18.setTextureOffset(20, 112).addBox(-7.25F, -1.75F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(31.3969F, -14.0635F, 8.299F);
        fx.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.2605F, -0.4595F, -0.1485F);
        cube_r19.setTextureOffset(85, 130).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(27.6612F, -7.3683F, 9.0F);
        fx.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.0F, 0.0F, 1.1345F);
        cube_r20.setTextureOffset(38, 145).addBox(7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r20.setTextureOffset(48, 108).addBox(-3.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(26.0769F, -12.1758F, 9.0F);
        fx.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.0F, 0.0F, 1.3963F);
        cube_r21.setTextureOffset(18, 106).addBox(-2.5F, -0.5F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r21.setTextureOffset(91, 93).addBox(-3.5F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r21.setTextureOffset(68, 153).addBox(-1.5F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

        wing2 = new ModelRenderer(this);
        wing2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(wing2);


        bx2 = new ModelRenderer(this);
        bx2.setRotationPoint(-5.8799F, -4.1941F, 7.0F);
        wing2.addChild(bx2);
        setRotationAngle(bx2, 0.0F, 0.2182F, 0.0F);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-1.4447F, 14.0497F, 1.7663F);
        bx2.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.2182F, 0.0F, 0.1309F);
        cube_r22.setTextureOffset(189, 92).addBox(-2.5641F, 2.3449F, -0.5222F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r22.setTextureOffset(247, 71).addBox(-2.5641F, 0.3449F, -0.5222F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r22.setTextureOffset(245, 77).addBox(-2.5641F, -1.6551F, -0.5222F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r22.setTextureOffset(237, 73).addBox(-2.5641F, -3.6551F, -0.5222F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r22.setTextureOffset(196, 75).addBox(-2.5641F, -5.6551F, -0.5222F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(-4.4579F, 13.5276F, 2.1992F);
        bx2.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.2182F, 0.0F, 0.1309F);
        cube_r23.setTextureOffset(195, 90).addBox(-2.5F, 12.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r23.setTextureOffset(244, 63).addBox(-3.0F, 9.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r23.setTextureOffset(201, 42).addBox(-3.5F, -5.5F, -1.0F, 4.0F, 15.0F, 2.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(-4.9324F, -2.0212F, 1.7663F);
        bx2.addChild(cube_r24);
        setRotationAngle(cube_r24, -0.2182F, 0.0F, 0.1309F);
        cube_r24.setTextureOffset(183, 91).addBox(-0.5F, 0.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(0.6249F, -2.0958F, 1.0325F);
        bx2.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0F, 0.0F, 0.1309F);
        cube_r25.setTextureOffset(248, 52).addBox(-6.5F, 10.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r25.setTextureOffset(178, 72).addBox(-6.5F, 4.0F, -2.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
        cube_r25.setTextureOffset(184, 81).addBox(-4.5F, 3.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        cube_r25.setTextureOffset(219, 71).addBox(-3.5F, 0.0F, -1.0F, 1.0F, 11.0F, 2.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setRotationPoint(1.6249F, -2.0958F, 1.0325F);
        bx2.addChild(cube_r26);
        setRotationAngle(cube_r26, 0.0F, 0.0F, 0.1309F);
        cube_r26.setTextureOffset(177, 47).addBox(-3.5F, -8.0F, -1.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
        cube_r26.setTextureOffset(157, 32).addBox(-1.5F, -10.0F, -1.0F, 3.0F, 21.0F, 2.0F, 0.0F, false);

        bz2 = new ModelRenderer(this);
        bz2.setRotationPoint(-15.5939F, -6.3931F, 7.3619F);
        wing2.addChild(bz2);
        setRotationAngle(bz2, 0.0F, 0.0F, 0.3491F);


        cube_r27 = new ModelRenderer(this);
        cube_r27.setRotationPoint(-3.0761F, 3.2876F, -0.1175F);
        bz2.addChild(cube_r27);
        setRotationAngle(cube_r27, 0.0F, -0.1745F, 0.1309F);
        cube_r27.setTextureOffset(211, 71).addBox(-0.6531F, -10.1156F, -2.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
        cube_r27.setTextureOffset(210, 57).addBox(0.3469F, -13.1156F, -2.0F, 2.0F, 11.0F, 3.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setRotationPoint(-2.901F, 9.3436F, -0.7081F);
        bz2.addChild(cube_r28);
        setRotationAngle(cube_r28, 0.0F, -0.1745F, 0.1309F);
        cube_r28.setTextureOffset(194, 82).addBox(-1.0F, 0.5856F, -0.6207F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        cube_r29 = new ModelRenderer(this);
        cube_r29.setRotationPoint(-2.901F, 9.3436F, -0.7081F);
        bz2.addChild(cube_r29);
        setRotationAngle(cube_r29, 0.0F, -0.1745F, 0.1309F);
        cube_r29.setTextureOffset(165, 55).addBox(-1.5F, -8.097F, -1.2509F, 3.0F, 9.0F, 3.0F, 0.0F, false);

        cube_r30 = new ModelRenderer(this);
        cube_r30.setRotationPoint(0.3399F, -4.9527F, 0.29F);
        bz2.addChild(cube_r30);
        setRotationAngle(cube_r30, 0.0F, -0.1745F, 0.1309F);
        cube_r30.setTextureOffset(157, 76).addBox(0.0F, -2.5F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
        cube_r30.setTextureOffset(202, 82).addBox(1.0F, -2.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        cube_r31 = new ModelRenderer(this);
        cube_r31.setRotationPoint(11.7977F, 2.1033F, 0.7958F);
        bz2.addChild(cube_r31);
        setRotationAngle(cube_r31, 0.0F, 0.0F, 0.1309F);
        cube_r31.setTextureOffset(222, 13).addBox(-9.5F, -8.0F, -1.0F, 6.0F, 5.0F, 2.0F, 0.0F, false);

        fs2 = new ModelRenderer(this);
        fs2.setRotationPoint(0.0F, 0.0F, 0.0F);
        wing2.addChild(fs2);
        fs2.setTextureOffset(242, 0).addBox(-24.8408F, -30.9445F, 7.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r32 = new ModelRenderer(this);
        cube_r32.setRotationPoint(-24.2986F, -37.8278F, 8.5F);
        fs2.addChild(cube_r32);
        setRotationAngle(cube_r32, 0.0F, 0.0F, -0.3054F);
        cube_r32.setTextureOffset(169, 75).addBox(-3.0F, -4.5F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        cube_r33 = new ModelRenderer(this);
        cube_r33.setRotationPoint(-31.0F, -36.0F, 8.5F);
        fs2.addChild(cube_r33);
        setRotationAngle(cube_r33, 0.0F, 0.0F, 0.2618F);
        cube_r33.setTextureOffset(211, 39).addBox(-1.0F, 1.0F, -1.5F, 9.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r33.setTextureOffset(157, 12).addBox(-9.0F, -1.0F, -1.5F, 18.0F, 2.0F, 3.0F, 0.0F, false);

        cube_r34 = new ModelRenderer(this);
        cube_r34.setRotationPoint(-25.9294F, -43.7274F, 6.5F);
        fs2.addChild(cube_r34);
        setRotationAngle(cube_r34, 0.0F, 0.0F, 0.829F);
        cube_r34.setTextureOffset(230, 61).addBox(1.0F, 3.0F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(212, 3).addBox(-2.0F, 2.0F, -1.5F, 9.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(233, 3).addBox(3.0F, -5.9F, -0.5F, 5.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r34.setTextureOffset(248, 43).addBox(7.0F, -2.9F, -0.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r34.setTextureOffset(196, 14).addBox(-1.0F, 1.0F, -1.5F, 10.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(234, 86).addBox(-16.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(244, 3).addBox(12.0F, -1.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(185, 64).addBox(-6.0F, -5.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(157, 22).addBox(-3.0F, -5.0F, -1.5F, 13.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r34.setTextureOffset(157, 0).addBox(-14.0F, -2.0F, -1.5F, 26.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r35 = new ModelRenderer(this);
        cube_r35.setRotationPoint(-25.3435F, -31.6758F, 8.0F);
        fs2.addChild(cube_r35);
        setRotationAngle(cube_r35, 0.0F, 0.0F, -0.4363F);
        cube_r35.setTextureOffset(234, 23).addBox(-4.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r36 = new ModelRenderer(this);
        cube_r36.setRotationPoint(-26.121F, -30.8724F, 8.0F);
        fs2.addChild(cube_r36);
        setRotationAngle(cube_r36, 0.0F, 0.0F, 0.3054F);
        cube_r36.setTextureOffset(212, 0).addBox(-4.5F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r37 = new ModelRenderer(this);
        cube_r37.setRotationPoint(-27.3976F, -28.6478F, 7.5F);
        fs2.addChild(cube_r37);
        setRotationAngle(cube_r37, 0.0F, 0.0F, -0.2182F);
        cube_r37.setTextureOffset(245, 8).addBox(-7.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r37.setTextureOffset(187, 88).addBox(7.0F, 0.0F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        cube_r37.setTextureOffset(186, 24).addBox(-5.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, 0.0F, false);

        fx2 = new ModelRenderer(this);
        fx2.setRotationPoint(4.0F, 12.0F, 4.0F);
        wing2.addChild(fx2);


        cube_r38 = new ModelRenderer(this);
        cube_r38.setRotationPoint(-36.5F, -15.5F, 7.5F);
        fx2.addChild(cube_r38);
        setRotationAngle(cube_r38, 0.0F, 0.0F, -0.7854F);
        cube_r38.setTextureOffset(242, 83).addBox(8.5F, 6.5F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r38.setTextureOffset(174, 81).addBox(6.5F, 5.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
        cube_r38.setTextureOffset(227, 68).addBox(3.5F, 5.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        cube_r38.setTextureOffset(228, 0).addBox(-8.5F, 5.95F, 0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r38.setTextureOffset(230, 65).addBox(-8.5F, 5.95F, -1.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r38.setTextureOffset(205, 39).addBox(-15.5F, 6.0F, -0.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r38.setTextureOffset(213, 43).addBox(-12.5F, 5.5F, -0.5F, 10.0F, 3.0F, 1.0F, 0.0F, false);
        cube_r38.setTextureOffset(213, 51).addBox(-2.5F, 5.5F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r39 = new ModelRenderer(this);
        cube_r39.setRotationPoint(-37.8277F, -13.8352F, 12.3571F);
        fx2.addChild(cube_r39);
        setRotationAngle(cube_r39, 0.0752F, 0.5187F, -0.2418F);
        cube_r39.setTextureOffset(231, 27).addBox(-9.75F, -1.75F, -1.0F, 5.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r39.setTextureOffset(232, 39).addBox(4.25F, -2.5F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r39.setTextureOffset(177, 34).addBox(-4.75F, -1.75F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r40 = new ModelRenderer(this);
        cube_r40.setRotationPoint(-31.3969F, -14.0635F, 8.299F);
        fx2.addChild(cube_r40);
        setRotationAngle(cube_r40, 0.2605F, 0.4595F, 0.1485F);
        cube_r40.setTextureOffset(238, 15).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r41 = new ModelRenderer(this);
        cube_r41.setRotationPoint(-27.6612F, -7.3683F, 9.0F);
        fx2.addChild(cube_r41);
        setRotationAngle(cube_r41, 0.0F, 0.0F, -1.1345F);
        cube_r41.setTextureOffset(181, 68).addBox(-13.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r41.setTextureOffset(177, 42).addBox(-7.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r42 = new ModelRenderer(this);
        cube_r42.setRotationPoint(-26.0769F, -12.1758F, 9.0F);
        fx2.addChild(cube_r42);
        setRotationAngle(cube_r42, 0.0F, 0.0F, -1.3963F);
        cube_r42.setTextureOffset(186, 22).addBox(-0.5F, -0.5F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        cube_r42.setTextureOffset(247, 28).addBox(1.5F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r42.setTextureOffset(233, 7).addBox(-2.5F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

        halo = new ModelRenderer(this);
        halo.setRotationPoint(0.0F, -3.75F, 0.0F);
        body.addChild(halo);


        rgb = new ModelRenderer(this);
        rgb.setRotationPoint(0.0F, -30.9863F, 14.0F);
        halo.addChild(rgb);
        rgb.setTextureOffset(0, 200).addBox(-1.0F, -20.0137F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_63_r1 = new ModelRenderer(this);
        rgb_cube_63_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_63_r1);
        setRotationAngle(rgb_cube_63_r1, 0.0F, 0.0F, -6.185F);
        rgb_cube_63_r1.setTextureOffset(60, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_62_r1 = new ModelRenderer(this);
        rgb_cube_62_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_62_r1);
        setRotationAngle(rgb_cube_62_r1, 0.0F, 0.0F, -6.0868F);
        rgb_cube_62_r1.setTextureOffset(40, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_61_r1 = new ModelRenderer(this);
        rgb_cube_61_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_61_r1);
        setRotationAngle(rgb_cube_61_r1, 0.0F, 0.0F, -5.9887F);
        rgb_cube_61_r1.setTextureOffset(20, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_60_r1 = new ModelRenderer(this);
        rgb_cube_60_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_60_r1);
        setRotationAngle(rgb_cube_60_r1, 0.0F, 0.0F, -5.8905F);
        rgb_cube_60_r1.setTextureOffset(0, 248).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_59_r1 = new ModelRenderer(this);
        rgb_cube_59_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_59_r1);
        setRotationAngle(rgb_cube_59_r1, 0.0F, 0.0F, -5.7923F);
        rgb_cube_59_r1.setTextureOffset(180, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_58_r1 = new ModelRenderer(this);
        rgb_cube_58_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_58_r1);
        setRotationAngle(rgb_cube_58_r1, 0.0F, 0.0F, -5.6941F);
        rgb_cube_58_r1.setTextureOffset(160, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_57_r1 = new ModelRenderer(this);
        rgb_cube_57_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_57_r1);
        setRotationAngle(rgb_cube_57_r1, 0.0F, 0.0F, -5.596F);
        rgb_cube_57_r1.setTextureOffset(140, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_56_r1 = new ModelRenderer(this);
        rgb_cube_56_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_56_r1);
        setRotationAngle(rgb_cube_56_r1, 0.0F, 0.0F, -5.4978F);
        rgb_cube_56_r1.setTextureOffset(120, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_55_r1 = new ModelRenderer(this);
        rgb_cube_55_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_55_r1);
        setRotationAngle(rgb_cube_55_r1, 0.0F, 0.0F, -5.3996F);
        rgb_cube_55_r1.setTextureOffset(100, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_54_r1 = new ModelRenderer(this);
        rgb_cube_54_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_54_r1);
        setRotationAngle(rgb_cube_54_r1, 0.0F, 0.0F, -5.3014F);
        rgb_cube_54_r1.setTextureOffset(80, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_53_r1 = new ModelRenderer(this);
        rgb_cube_53_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_53_r1);
        setRotationAngle(rgb_cube_53_r1, 0.0F, 0.0F, -5.2033F);
        rgb_cube_53_r1.setTextureOffset(60, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_52_r1 = new ModelRenderer(this);
        rgb_cube_52_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_52_r1);
        setRotationAngle(rgb_cube_52_r1, 0.0F, 0.0F, -5.1051F);
        rgb_cube_52_r1.setTextureOffset(40, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_51_r1 = new ModelRenderer(this);
        rgb_cube_51_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_51_r1);
        setRotationAngle(rgb_cube_51_r1, 0.0F, 0.0F, -5.0069F);
        rgb_cube_51_r1.setTextureOffset(20, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_50_r1 = new ModelRenderer(this);
        rgb_cube_50_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_50_r1);
        setRotationAngle(rgb_cube_50_r1, 0.0F, 0.0F, -4.9087F);
        rgb_cube_50_r1.setTextureOffset(0, 240).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_49_r1 = new ModelRenderer(this);
        rgb_cube_49_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_49_r1);
        setRotationAngle(rgb_cube_49_r1, 0.0F, 0.0F, -4.8106F);
        rgb_cube_49_r1.setTextureOffset(180, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_48_r1 = new ModelRenderer(this);
        rgb_cube_48_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_48_r1);
        setRotationAngle(rgb_cube_48_r1, 0.0F, 0.0F, -4.7124F);
        rgb_cube_48_r1.setTextureOffset(160, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_47_r1 = new ModelRenderer(this);
        rgb_cube_47_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_47_r1);
        setRotationAngle(rgb_cube_47_r1, 0.0F, 0.0F, -4.6142F);
        rgb_cube_47_r1.setTextureOffset(140, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_46_r1 = new ModelRenderer(this);
        rgb_cube_46_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_46_r1);
        setRotationAngle(rgb_cube_46_r1, 0.0F, 0.0F, -4.516F);
        rgb_cube_46_r1.setTextureOffset(120, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_45_r1 = new ModelRenderer(this);
        rgb_cube_45_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_45_r1);
        setRotationAngle(rgb_cube_45_r1, 0.0F, 0.0F, -4.4179F);
        rgb_cube_45_r1.setTextureOffset(100, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_44_r1 = new ModelRenderer(this);
        rgb_cube_44_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_44_r1);
        setRotationAngle(rgb_cube_44_r1, 0.0F, 0.0F, -4.3197F);
        rgb_cube_44_r1.setTextureOffset(80, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_43_r1 = new ModelRenderer(this);
        rgb_cube_43_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_43_r1);
        setRotationAngle(rgb_cube_43_r1, 0.0F, 0.0F, -4.2215F);
        rgb_cube_43_r1.setTextureOffset(60, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_42_r1 = new ModelRenderer(this);
        rgb_cube_42_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_42_r1);
        setRotationAngle(rgb_cube_42_r1, 0.0F, 0.0F, -4.1233F);
        rgb_cube_42_r1.setTextureOffset(40, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_41_r1 = new ModelRenderer(this);
        rgb_cube_41_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_41_r1);
        setRotationAngle(rgb_cube_41_r1, 0.0F, 0.0F, -4.0252F);
        rgb_cube_41_r1.setTextureOffset(20, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_40_r1 = new ModelRenderer(this);
        rgb_cube_40_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_40_r1);
        setRotationAngle(rgb_cube_40_r1, 0.0F, 0.0F, -3.927F);
        rgb_cube_40_r1.setTextureOffset(0, 232).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_39_r1 = new ModelRenderer(this);
        rgb_cube_39_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_39_r1);
        setRotationAngle(rgb_cube_39_r1, 0.0F, 0.0F, -3.8288F);
        rgb_cube_39_r1.setTextureOffset(180, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_38_r1 = new ModelRenderer(this);
        rgb_cube_38_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_38_r1);
        setRotationAngle(rgb_cube_38_r1, 0.0F, 0.0F, -3.7306F);
        rgb_cube_38_r1.setTextureOffset(160, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_37_r1 = new ModelRenderer(this);
        rgb_cube_37_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_37_r1);
        setRotationAngle(rgb_cube_37_r1, 0.0F, 0.0F, -3.6325F);
        rgb_cube_37_r1.setTextureOffset(140, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_36_r1 = new ModelRenderer(this);
        rgb_cube_36_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_36_r1);
        setRotationAngle(rgb_cube_36_r1, 0.0F, 0.0F, -3.5343F);
        rgb_cube_36_r1.setTextureOffset(120, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_35_r1 = new ModelRenderer(this);
        rgb_cube_35_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_35_r1);
        setRotationAngle(rgb_cube_35_r1, 0.0F, 0.0F, -3.4361F);
        rgb_cube_35_r1.setTextureOffset(100, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_34_r1 = new ModelRenderer(this);
        rgb_cube_34_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_34_r1);
        setRotationAngle(rgb_cube_34_r1, 0.0F, 0.0F, -3.3379F);
        rgb_cube_34_r1.setTextureOffset(80, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_33_r1 = new ModelRenderer(this);
        rgb_cube_33_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_33_r1);
        setRotationAngle(rgb_cube_33_r1, 0.0F, 0.0F, -3.2398F);
        rgb_cube_33_r1.setTextureOffset(60, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_32_r1 = new ModelRenderer(this);
        rgb_cube_32_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_32_r1);
        setRotationAngle(rgb_cube_32_r1, 0.0F, 0.0F, -3.1416F);
        rgb_cube_32_r1.setTextureOffset(40, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_31_r1 = new ModelRenderer(this);
        rgb_cube_31_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_31_r1);
        setRotationAngle(rgb_cube_31_r1, 0.0F, 0.0F, -3.0434F);
        rgb_cube_31_r1.setTextureOffset(20, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_30_r1 = new ModelRenderer(this);
        rgb_cube_30_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_30_r1);
        setRotationAngle(rgb_cube_30_r1, 0.0F, 0.0F, -2.9452F);
        rgb_cube_30_r1.setTextureOffset(0, 224).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_29_r1 = new ModelRenderer(this);
        rgb_cube_29_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_29_r1);
        setRotationAngle(rgb_cube_29_r1, 0.0F, 0.0F, -2.8471F);
        rgb_cube_29_r1.setTextureOffset(180, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_28_r1 = new ModelRenderer(this);
        rgb_cube_28_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_28_r1);
        setRotationAngle(rgb_cube_28_r1, 0.0F, 0.0F, -2.7489F);
        rgb_cube_28_r1.setTextureOffset(160, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_27_r1 = new ModelRenderer(this);
        rgb_cube_27_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_27_r1);
        setRotationAngle(rgb_cube_27_r1, 0.0F, 0.0F, -2.6507F);
        rgb_cube_27_r1.setTextureOffset(140, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_26_r1 = new ModelRenderer(this);
        rgb_cube_26_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_26_r1);
        setRotationAngle(rgb_cube_26_r1, 0.0F, 0.0F, -2.5525F);
        rgb_cube_26_r1.setTextureOffset(120, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_25_r1 = new ModelRenderer(this);
        rgb_cube_25_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_25_r1);
        setRotationAngle(rgb_cube_25_r1, 0.0F, 0.0F, -2.4544F);
        rgb_cube_25_r1.setTextureOffset(100, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_24_r1 = new ModelRenderer(this);
        rgb_cube_24_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_24_r1);
        setRotationAngle(rgb_cube_24_r1, 0.0F, 0.0F, -2.3562F);
        rgb_cube_24_r1.setTextureOffset(80, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_23_r1 = new ModelRenderer(this);
        rgb_cube_23_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_23_r1);
        setRotationAngle(rgb_cube_23_r1, 0.0F, 0.0F, -2.258F);
        rgb_cube_23_r1.setTextureOffset(60, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_22_r1 = new ModelRenderer(this);
        rgb_cube_22_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_22_r1);
        setRotationAngle(rgb_cube_22_r1, 0.0F, 0.0F, -2.1598F);
        rgb_cube_22_r1.setTextureOffset(40, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_21_r1 = new ModelRenderer(this);
        rgb_cube_21_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_21_r1);
        setRotationAngle(rgb_cube_21_r1, 0.0F, 0.0F, -2.0617F);
        rgb_cube_21_r1.setTextureOffset(20, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_20_r1 = new ModelRenderer(this);
        rgb_cube_20_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_20_r1);
        setRotationAngle(rgb_cube_20_r1, 0.0F, 0.0F, -1.9635F);
        rgb_cube_20_r1.setTextureOffset(0, 216).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_19_r1 = new ModelRenderer(this);
        rgb_cube_19_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_19_r1);
        setRotationAngle(rgb_cube_19_r1, 0.0F, 0.0F, -1.8653F);
        rgb_cube_19_r1.setTextureOffset(180, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_18_r1 = new ModelRenderer(this);
        rgb_cube_18_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_18_r1);
        setRotationAngle(rgb_cube_18_r1, 0.0F, 0.0F, -1.7671F);
        rgb_cube_18_r1.setTextureOffset(160, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_17_r1 = new ModelRenderer(this);
        rgb_cube_17_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_17_r1);
        setRotationAngle(rgb_cube_17_r1, 0.0F, 0.0F, -1.669F);
        rgb_cube_17_r1.setTextureOffset(140, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_16_r1 = new ModelRenderer(this);
        rgb_cube_16_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_16_r1);
        setRotationAngle(rgb_cube_16_r1, 0.0F, 0.0F, -1.5708F);
        rgb_cube_16_r1.setTextureOffset(120, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_15_r1 = new ModelRenderer(this);
        rgb_cube_15_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_15_r1);
        setRotationAngle(rgb_cube_15_r1, 0.0F, 0.0F, -1.4726F);
        rgb_cube_15_r1.setTextureOffset(100, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_14_r1 = new ModelRenderer(this);
        rgb_cube_14_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_14_r1);
        setRotationAngle(rgb_cube_14_r1, 0.0F, 0.0F, -1.3744F);
        rgb_cube_14_r1.setTextureOffset(80, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_13_r1 = new ModelRenderer(this);
        rgb_cube_13_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_13_r1);
        setRotationAngle(rgb_cube_13_r1, 0.0F, 0.0F, -1.2763F);
        rgb_cube_13_r1.setTextureOffset(60, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_12_r1 = new ModelRenderer(this);
        rgb_cube_12_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_12_r1);
        setRotationAngle(rgb_cube_12_r1, 0.0F, 0.0F, -1.1781F);
        rgb_cube_12_r1.setTextureOffset(40, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_11_r1 = new ModelRenderer(this);
        rgb_cube_11_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_11_r1);
        setRotationAngle(rgb_cube_11_r1, 0.0F, 0.0F, -1.0799F);
        rgb_cube_11_r1.setTextureOffset(20, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_10_r1 = new ModelRenderer(this);
        rgb_cube_10_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_10_r1);
        setRotationAngle(rgb_cube_10_r1, 0.0F, 0.0F, -0.9817F);
        rgb_cube_10_r1.setTextureOffset(0, 208).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_9_r1 = new ModelRenderer(this);
        rgb_cube_9_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_9_r1);
        setRotationAngle(rgb_cube_9_r1, 0.0F, 0.0F, -0.8836F);
        rgb_cube_9_r1.setTextureOffset(180, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_8_r1 = new ModelRenderer(this);
        rgb_cube_8_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_8_r1);
        setRotationAngle(rgb_cube_8_r1, 0.0F, 0.0F, -0.7854F);
        rgb_cube_8_r1.setTextureOffset(160, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_7_r1 = new ModelRenderer(this);
        rgb_cube_7_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_7_r1);
        setRotationAngle(rgb_cube_7_r1, 0.0F, 0.0F, -0.6872F);
        rgb_cube_7_r1.setTextureOffset(140, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_6_r1 = new ModelRenderer(this);
        rgb_cube_6_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_6_r1);
        setRotationAngle(rgb_cube_6_r1, 0.0F, 0.0F, -0.589F);
        rgb_cube_6_r1.setTextureOffset(120, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_5_r1 = new ModelRenderer(this);
        rgb_cube_5_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_5_r1);
        setRotationAngle(rgb_cube_5_r1, 0.0F, 0.0F, -0.4909F);
        rgb_cube_5_r1.setTextureOffset(100, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_4_r1 = new ModelRenderer(this);
        rgb_cube_4_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_4_r1);
        setRotationAngle(rgb_cube_4_r1, 0.0F, 0.0F, -0.3927F);
        rgb_cube_4_r1.setTextureOffset(80, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_3_r1 = new ModelRenderer(this);
        rgb_cube_3_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_3_r1);
        setRotationAngle(rgb_cube_3_r1, 0.0F, 0.0F, -0.2945F);
        rgb_cube_3_r1.setTextureOffset(60, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_2_r1 = new ModelRenderer(this);
        rgb_cube_2_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_2_r1);
        setRotationAngle(rgb_cube_2_r1, 0.0F, 0.0F, -0.1963F);
        rgb_cube_2_r1.setTextureOffset(40, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rgb_cube_1_r1 = new ModelRenderer(this);
        rgb_cube_1_r1.setRotationPoint(0.0F, -0.0137F, 0.0F);
        rgb.addChild(rgb_cube_1_r1);
        setRotationAngle(rgb_cube_1_r1, 0.0F, 0.0F, -0.0982F);
        rgb_cube_1_r1.setTextureOffset(20, 200).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        outer = new ModelRenderer(this);
        outer.setRotationPoint(0.0F, 0.0F, 0.0F);
        halo.addChild(outer);


        dev1 = new ModelRenderer(this);
        dev1.setRotationPoint(0.0F, 0.0F, 0.0F);
        outer.addChild(dev1);


        cube_r43 = new ModelRenderer(this);
        cube_r43.setRotationPoint(-16.0F, -49.0F, 12.0F);
        dev1.addChild(cube_r43);
        setRotationAngle(cube_r43, 0.0F, 0.0F, -0.7854F);
        cube_r43.setTextureOffset(71, 12).addBox(-2.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r43.setTextureOffset(46, 75).addBox(-2.0F, 7.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r43.setTextureOffset(69, 25).addBox(-3.0F, 4.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r43.setTextureOffset(16, 59).addBox(-4.0F, 1.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r43.setTextureOffset(54, 65).addBox(-3.0F, -6.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r43.setTextureOffset(33, 51).addBox(-4.0F, -4.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r43.setTextureOffset(18, 42).addBox(-4.0F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r44 = new ModelRenderer(this);
        cube_r44.setRotationPoint(-17.2839F, -44.8309F, 12.0F);
        dev1.addChild(cube_r44);
        setRotationAngle(cube_r44, 0.0F, 0.0F, -1.4399F);
        cube_r44.setTextureOffset(28, 73).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r45 = new ModelRenderer(this);
        cube_r45.setRotationPoint(-13.2451F, -48.8697F, 12.0F);
        dev1.addChild(cube_r45);
        setRotationAngle(cube_r45, 0.0F, 0.0F, -0.1309F);
        cube_r45.setTextureOffset(0, 75).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r46 = new ModelRenderer(this);
        cube_r46.setRotationPoint(-13.9769F, -51.1905F, 12.5F);
        dev1.addChild(cube_r46);
        setRotationAngle(cube_r46, 0.0F, 0.0F, -0.48F);
        cube_r46.setTextureOffset(14, 64).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r47 = new ModelRenderer(this);
        cube_r47.setRotationPoint(-20.2974F, -44.2321F, 12.5F);
        dev1.addChild(cube_r47);
        setRotationAngle(cube_r47, 0.0F, 0.0F, -1.0908F);
        cube_r47.setTextureOffset(65, 33).addBox(-1.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        dev2 = new ModelRenderer(this);
        dev2.setRotationPoint(0.0F, 0.0F, 0.0F);
        outer.addChild(dev2);


        cube_r48 = new ModelRenderer(this);
        cube_r48.setRotationPoint(16.0F, -49.0F, 12.0F);
        dev2.addChild(cube_r48);
        setRotationAngle(cube_r48, 0.0F, 0.0F, 0.7854F);
        cube_r48.setTextureOffset(57, 70).addBox(0.0F, -8.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r48.setTextureOffset(38, 75).addBox(0.0F, 7.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r48.setTextureOffset(69, 19).addBox(-1.0F, 4.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r48.setTextureOffset(0, 59).addBox(-2.0F, 1.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r48.setTextureOffset(65, 45).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r48.setTextureOffset(48, 48).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r48.setTextureOffset(0, 42).addBox(-2.0F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r49 = new ModelRenderer(this);
        cube_r49.setRotationPoint(17.2839F, -44.8309F, 12.0F);
        dev2.addChild(cube_r49);
        setRotationAngle(cube_r49, 0.0F, 0.0F, 1.4399F);
        cube_r49.setTextureOffset(67, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r50 = new ModelRenderer(this);
        cube_r50.setRotationPoint(13.2451F, -48.8697F, 12.0F);
        dev2.addChild(cube_r50);
        setRotationAngle(cube_r50, 0.0F, 0.0F, 0.1309F);
        cube_r50.setTextureOffset(72, 4).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r51 = new ModelRenderer(this);
        cube_r51.setRotationPoint(13.9769F, -51.1905F, 12.5F);
        dev2.addChild(cube_r51);
        setRotationAngle(cube_r51, 0.0F, 0.0F, 0.48F);
        cube_r51.setTextureOffset(63, 50).addBox(-2.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r52 = new ModelRenderer(this);
        cube_r52.setRotationPoint(20.2974F, -44.2321F, 12.5F);
        dev2.addChild(cube_r52);
        setRotationAngle(cube_r52, 0.0F, 0.0F, 1.0908F);
        cube_r52.setTextureOffset(0, 64).addBox(-3.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        dev3 = new ModelRenderer(this);
        dev3.setRotationPoint(-16.4086F, -13.5057F, 12.2727F);
        outer.addChild(dev3);


        cube_r53 = new ModelRenderer(this);
        cube_r53.setRotationPoint(0.4086F, 1.0057F, -0.2727F);
        dev3.addChild(cube_r53);
        setRotationAngle(cube_r53, 0.0F, 0.0F, 0.7854F);
        cube_r53.setTextureOffset(37, 70).addBox(-2.0F, 6.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r53.setTextureOffset(73, 61).addBox(-2.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r53.setTextureOffset(68, 65).addBox(-3.0F, -7.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r53.setTextureOffset(58, 10).addBox(-4.0F, -4.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r53.setTextureOffset(40, 65).addBox(-3.0F, 4.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r53.setTextureOffset(18, 48).addBox(-4.0F, 2.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r53.setTextureOffset(40, 12).addBox(-4.0F, -1.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r54 = new ModelRenderer(this);
        cube_r54.setRotationPoint(-0.8753F, -3.1635F, -0.2727F);
        dev3.addChild(cube_r54);
        setRotationAngle(cube_r54, 0.0F, 0.0F, 1.4399F);
        cube_r54.setTextureOffset(47, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r55 = new ModelRenderer(this);
        cube_r55.setRotationPoint(3.1635F, 0.8753F, -0.2727F);
        dev3.addChild(cube_r55);
        setRotationAngle(cube_r55, 0.0F, 0.0F, 0.1309F);
        cube_r55.setTextureOffset(70, 56).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r56 = new ModelRenderer(this);
        cube_r56.setRotationPoint(2.4317F, 3.1962F, 0.2273F);
        dev3.addChild(cube_r56);
        setRotationAngle(cube_r56, 0.0F, 0.0F, 0.48F);
        cube_r56.setTextureOffset(60, 0).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r57 = new ModelRenderer(this);
        cube_r57.setRotationPoint(-3.8888F, -3.7622F, 0.2273F);
        dev3.addChild(cube_r57);
        setRotationAngle(cube_r57, 0.0F, 0.0F, 1.0908F);
        cube_r57.setTextureOffset(29, 61).addBox(-1.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        dev4 = new ModelRenderer(this);
        dev4.setRotationPoint(16.4086F, -13.5057F, 12.2727F);
        outer.addChild(dev4);


        cube_r58 = new ModelRenderer(this);
        cube_r58.setRotationPoint(-0.4086F, 1.0057F, -0.2727F);
        dev4.addChild(cube_r58);
        setRotationAngle(cube_r58, 0.0F, 0.0F, -0.7854F);
        cube_r58.setTextureOffset(0, 70).addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r58.setTextureOffset(60, 6).addBox(0.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        cube_r58.setTextureOffset(28, 67).addBox(-1.0F, -7.0F, -1.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r58.setTextureOffset(32, 56).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
        cube_r58.setTextureOffset(65, 39).addBox(-1.0F, 4.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r58.setTextureOffset(0, 48).addBox(-2.0F, 2.0F, -1.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
        cube_r58.setTextureOffset(37, 39).addBox(-2.0F, -1.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r59 = new ModelRenderer(this);
        cube_r59.setRotationPoint(0.8753F, -3.1635F, -0.2727F);
        dev4.addChild(cube_r59);
        setRotationAngle(cube_r59, 0.0F, 0.0F, -1.4399F);
        cube_r59.setTextureOffset(10, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r60 = new ModelRenderer(this);
        cube_r60.setRotationPoint(-3.1635F, 0.8753F, -0.2727F);
        dev4.addChild(cube_r60);
        setRotationAngle(cube_r60, 0.0F, 0.0F, -0.1309F);
        cube_r60.setTextureOffset(20, 70).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r61 = new ModelRenderer(this);
        cube_r61.setRotationPoint(-2.4317F, 3.1962F, 0.2273F);
        dev4.addChild(cube_r61);
        setRotationAngle(cube_r61, 0.0F, 0.0F, -0.48F);
        cube_r61.setTextureOffset(45, 59).addBox(-2.5F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r62 = new ModelRenderer(this);
        cube_r62.setRotationPoint(3.8888F, -3.7622F, 0.2273F);
        dev4.addChild(cube_r62);
        setRotationAngle(cube_r62, 0.0F, 0.0F, -1.0908F);
        cube_r62.setTextureOffset(59, 59).addBox(-3.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        od = new ModelRenderer(this);
        od.setRotationPoint(0.0F, 0.0F, 0.0F);
        outer.addChild(od);
        od.setTextureOffset(33, 45).addBox(-3.0F, -55.0F, 11.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
        od.setTextureOffset(54, 75).addBox(-1.0F, -51.0F, 11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r63 = new ModelRenderer(this);
        cube_r63.setRotationPoint(-5.6071F, -52.5094F, 12.5F);
        od.addChild(cube_r63);
        setRotationAngle(cube_r63, 0.0F, 0.0F, -0.1745F);
        cube_r63.setTextureOffset(55, 27).addBox(-2.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r64 = new ModelRenderer(this);
        cube_r64.setRotationPoint(5.1147F, -52.5963F, 12.5F);
        od.addChild(cube_r64);
        setRotationAngle(cube_r64, 0.0F, 0.0F, 0.1745F);
        cube_r64.setTextureOffset(55, 21).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        od2 = new ModelRenderer(this);
        od2.setRotationPoint(0.0F, -31.0F, 14.0F);
        outer.addChild(od2);
        setRotationAngle(od2, 0.0F, 0.0F, -1.5708F);
        od2.setTextureOffset(40, 30).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
        od2.setTextureOffset(18, 75).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r65 = new ModelRenderer(this);
        cube_r65.setRotationPoint(-5.6071F, -21.5094F, -1.5F);
        od2.addChild(cube_r65);
        setRotationAngle(cube_r65, 0.0F, 0.0F, -0.1745F);
        cube_r65.setTextureOffset(48, 53).addBox(-2.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r66 = new ModelRenderer(this);
        cube_r66.setRotationPoint(5.1147F, -21.5963F, -1.5F);
        od2.addChild(cube_r66);
        setRotationAngle(cube_r66, 0.0F, 0.0F, 0.1745F);
        cube_r66.setTextureOffset(55, 15).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        od3 = new ModelRenderer(this);
        od3.setRotationPoint(0.0F, -31.0F, 14.0F);
        outer.addChild(od3);
        setRotationAngle(od3, 0.0F, 0.0F, 1.5708F);
        od3.setTextureOffset(40, 24).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
        od3.setTextureOffset(10, 75).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r67 = new ModelRenderer(this);
        cube_r67.setRotationPoint(5.6071F, -21.5094F, -1.5F);
        od3.addChild(cube_r67);
        setRotationAngle(cube_r67, 0.0F, 0.0F, 0.1745F);
        cube_r67.setTextureOffset(0, 53).addBox(-3.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r68 = new ModelRenderer(this);
        cube_r68.setRotationPoint(-5.1147F, -21.5963F, -1.5F);
        od3.addChild(cube_r68);
        setRotationAngle(cube_r68, 0.0F, 0.0F, -0.1745F);
        cube_r68.setTextureOffset(16, 53).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        od4 = new ModelRenderer(this);
        od4.setRotationPoint(0.0F, -31.0F, 14.0F);
        outer.addChild(od4);
        setRotationAngle(od4, 0.0F, 0.0F, -3.1416F);
        od4.setTextureOffset(40, 18).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
        od4.setTextureOffset(74, 0).addBox(-1.0F, -20.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        cube_r69 = new ModelRenderer(this);
        cube_r69.setRotationPoint(5.6071F, -21.5094F, -1.5F);
        od4.addChild(cube_r69);
        setRotationAngle(cube_r69, 0.0F, 0.0F, 0.1745F);
        cube_r69.setTextureOffset(52, 36).addBox(-3.0F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        cube_r70 = new ModelRenderer(this);
        cube_r70.setRotationPoint(-5.1147F, -21.5963F, -1.5F);
        od4.addChild(cube_r70);
        setRotationAngle(cube_r70, 0.0F, 0.0F, -0.1745F);
        cube_r70.setTextureOffset(52, 42).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float div = 900.0F;
        float deg = (System.currentTimeMillis() % 36000000) / div;
        rgb.rotateAngleZ = deg;

        this.main.copyModelAngles(this.bipedBody);
        matrixStack.push();
        matrixStack.scale(0.5f, 0.5f, 0.5f);

        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        matrixStack.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}