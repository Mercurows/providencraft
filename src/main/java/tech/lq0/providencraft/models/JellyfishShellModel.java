package tech.lq0.providencraft.models;// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class JellyfishShellModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer head;
    private final ModelRenderer nekomimi;
    private final ModelRenderer nekomimi2;
    private final ModelRenderer body;
    private final ModelRenderer tentacles;
    private final ModelRenderer ttc1;
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
    private final ModelRenderer ttc3;
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
    private final ModelRenderer ttc4;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer cube_r34;
    private final ModelRenderer cube_r35;
    private final ModelRenderer ttc2;
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
    private final ModelRenderer lt1;
    private final ModelRenderer cube_r47;
    private final ModelRenderer cube_r48;
    private final ModelRenderer cube_r49;
    private final ModelRenderer lt3;
    private final ModelRenderer cube_r50;
    private final ModelRenderer cube_r51;
    private final ModelRenderer cube_r52;
    private final ModelRenderer lt4;
    private final ModelRenderer cube_r53;
    private final ModelRenderer cube_r54;
    private final ModelRenderer cube_r55;
    private final ModelRenderer lt2;
    private final ModelRenderer cube_r56;
    private final ModelRenderer cube_r57;
    private final ModelRenderer cube_r58;
    private final ModelRenderer lt5;
    private final ModelRenderer cube_r59;
    private final ModelRenderer cube_r60;
    private final ModelRenderer cube_r61;
    private final ModelRenderer lt6;
    private final ModelRenderer cube_r62;
    private final ModelRenderer cube_r63;
    private final ModelRenderer cube_r64;

    public JellyfishShellModel() {
        super(1.0f);
        textureWidth = 128;
        textureHeight = 128;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 1.0F, 0.0F);


        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 12.0F, 0.0F);
        main.addChild(head);
        head.setTextureOffset(54, 26).addBox(-3.0F, -23.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(64, 60).addBox(-4.0F, -22.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(51, 58).addBox(-5.0F, -21.0F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(26, 56).addBox(-6.0F, -20.0F, -6.0F, 12.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(54, 33).addBox(-6.0F, -20.0F, 5.0F, 12.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(56, 40).addBox(-6.0F, -18.0F, 6.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(55, 38).addBox(-6.0F, -12.0F, 6.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(54, 13).addBox(-6.0F, -11.0F, 5.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(26, 39).addBox(-7.0F, -17.0F, 6.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(14, 22).addBox(-6.0F, -18.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(66, 6).addBox(-3.0F, -19.0F, -7.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(66, 4).addBox(-3.0F, -19.0F, 6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 17).addBox(-6.0F, -12.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(28, 30).addBox(-6.0F, -11.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(64, 62).addBox(-4.0F, -11.0F, -7.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 19).addBox(-7.0F, -17.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(14, 31).addBox(-7.0F, -16.0F, -7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 31).addBox(-7.0F, -13.0F, -7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(14, 24).addBox(-8.0F, -15.0F, -7.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 21).addBox(2.0F, -18.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(52, 56).addBox(-5.0F, -21.0F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(64, 36).addBox(-4.0F, -22.0F, 3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(8, 61).addBox(3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(34, 45).addBox(4.0F, -21.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(54, 15).addBox(5.0F, -20.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        head.setTextureOffset(14, 22).addBox(-7.0F, -19.0F, -6.0F, 1.0F, 2.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(0, 31).addBox(-7.0F, -12.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(14, 5).addBox(-8.0F, -17.0F, -6.0F, 1.0F, 5.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(0, 17).addBox(6.0F, -19.0F, -6.0F, 1.0F, 2.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(54, 2).addBox(-6.0F, -20.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        head.setTextureOffset(44, 45).addBox(-6.0F, -11.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        head.setTextureOffset(14, 8).addBox(3.0F, -17.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(28, 22).addBox(4.0F, -16.0F, -7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 23).addBox(5.0F, -15.0F, -7.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(28, 26).addBox(4.0F, -13.0F, -7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(14, 10).addBox(2.0F, -12.0F, -7.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(28, 28).addBox(3.0F, -11.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(22, 45).addBox(5.0F, -11.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        head.setTextureOffset(28, 26).addBox(6.0F, -12.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(7.0F, -17.0F, -6.0F, 1.0F, 5.0F, 12.0F, 0.0F, false);
        head.setTextureOffset(12, 44).addBox(-5.0F, -21.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(56, 60).addBox(-4.0F, -22.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        nekomimi = new ModelRenderer(this);
        nekomimi.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(nekomimi);
        nekomimi.setTextureOffset(26, 45).addBox(3.0F, -24.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(54, 19).addBox(5.0F, -25.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(54, 17).addBox(5.0F, -24.0F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(28, 15).addBox(4.0F, -23.0F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(28, 13).addBox(4.0F, -22.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(54, 15).addBox(5.0F, -21.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(54, 21).addBox(6.0F, -20.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(8, 6).addBox(6.0F, -24.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(54, 6).addBox(6.0F, -22.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(12, 49).addBox(5.0F, -24.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(28, 8).addBox(4.0F, -23.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(28, 10).addBox(4.0F, -22.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(22, 53).addBox(5.0F, -21.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(54, 2).addBox(6.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        nekomimi.setTextureOffset(28, 53).addBox(6.0F, -20.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        nekomimi2 = new ModelRenderer(this);
        nekomimi2.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(nekomimi2);
        nekomimi2.setTextureOffset(19, 4).addBox(-5.0F, -24.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(46, 34).addBox(-7.0F, -25.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(46, 21).addBox(-7.0F, -24.0F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(28, 6).addBox(-7.0F, -23.0F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(28, 4).addBox(-7.0F, -22.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(46, 8).addBox(-7.0F, -21.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(8, 41).addBox(-7.0F, -20.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(8, 0).addBox(-7.0F, -24.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(48, 49).addBox(-7.0F, -22.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(34, 32).addBox(-7.0F, -24.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(14, 27).addBox(-7.0F, -23.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(0, 26).addBox(-7.0F, -22.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(28, 32).addBox(-7.0F, -21.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(44, 49).addBox(-7.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        nekomimi2.setTextureOffset(5, 5).addBox(-7.0F, -20.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 12.0F, 0.0F);
        main.addChild(body);
        body.setTextureOffset(56, 51).addBox(-5.0F, -10.0F, -6.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 44).addBox(5.0F, -10.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
        body.setTextureOffset(42, 26).addBox(6.0F, -8.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
        body.setTextureOffset(28, 13).addBox(6.0F, -6.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
        body.setTextureOffset(42, 60).addBox(7.0F, -5.0F, -6.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(14, 4).addBox(7.0F, -4.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(56, 48).addBox(-5.0F, -8.0F, -7.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(70, 8).addBox(5.0F, -8.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(38, 49).addBox(6.0F, -5.0F, -7.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(54, 0).addBox(-6.0F, -6.0F, -7.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 56).addBox(-6.0F, -5.0F, -8.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(66, 2).addBox(-3.0F, -2.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(64, 64).addBox(-3.0F, -2.0F, 7.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 60).addBox(7.0F, -5.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(0, 8).addBox(7.0F, -4.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(34, 49).addBox(6.0F, -5.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(14, 0).addBox(-6.0F, -5.0F, 7.0F, 12.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(56, 42).addBox(-5.0F, -10.0F, 5.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(56, 45).addBox(-5.0F, -8.0F, 6.0F, 10.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(4, 70).addBox(5.0F, -8.0F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(42, 0).addBox(-6.0F, -10.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
        body.setTextureOffset(42, 13).addBox(-7.0F, -8.0F, -5.0F, 1.0F, 2.0F, 10.0F, 0.0F, false);
        body.setTextureOffset(69, 69).addBox(-6.0F, -8.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 70).addBox(-6.0F, -8.0F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(28, 0).addBox(-7.0F, -6.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
        body.setTextureOffset(0, 49).addBox(-7.0F, -5.0F, -7.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(20, 59).addBox(-8.0F, -5.0F, -6.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(34, 59).addBox(-8.0F, -5.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(0, 4).addBox(-8.0F, -4.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(4, 49).addBox(-7.0F, -5.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(14, 36).addBox(-6.0F, -6.0F, 6.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);

        tentacles = new ModelRenderer(this);
        tentacles.setRotationPoint(0.0F, 12.0F, 0.0F);
        main.addChild(tentacles);


        ttc1 = new ModelRenderer(this);
        ttc1.setRotationPoint(-1.0F, 0.0F, 0.0F);
        tentacles.addChild(ttc1);
        ttc1.setTextureOffset(22, 44).addBox(-5.0F, -2.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        ttc1.setTextureOffset(16, 44).addBox(-5.0F, 2.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-5.1574F, 8.3877F, -7.5F);
        ttc1.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2618F);
        cube_r1.setTextureOffset(12, 44).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-5.1574F, 8.3877F, -7.5F);
        ttc1.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3491F);
        cube_r2.setTextureOffset(66, 67).addBox(0.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r2.setTextureOffset(54, 67).addBox(-0.8164F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-5.1574F, 8.3877F, -7.5F);
        ttc1.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.8727F);
        cube_r3.setTextureOffset(62, 67).addBox(-1.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r3.setTextureOffset(58, 67).addBox(-0.7571F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-3.836F, 4.1059F, -7.5F);
        ttc1.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.6109F);
        cube_r4.setTextureOffset(20, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-5.164F, 3.1059F, -7.5F);
        ttc1.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, 0.6109F);
        cube_r5.setTextureOffset(16, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-5.164F, 5.1059F, -7.5F);
        ttc1.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 0.6109F);
        cube_r6.setTextureOffset(12, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-3.836F, 6.1059F, -7.5F);
        ttc1.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, -0.6109F);
        cube_r7.setTextureOffset(8, 68).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-5.164F, 1.1059F, -7.5F);
        ttc1.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6109F);
        cube_r8.setTextureOffset(32, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-3.836F, 2.1059F, -7.5F);
        ttc1.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, -0.6109F);
        cube_r9.setTextureOffset(24, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-3.836F, 0.1059F, -7.5F);
        ttc1.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, -0.6109F);
        cube_r10.setTextureOffset(28, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-5.164F, -0.8941F, -7.5F);
        ttc1.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, 0.6109F);
        cube_r11.setTextureOffset(36, 69).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        ttc3 = new ModelRenderer(this);
        ttc3.setRotationPoint(3.0F, -3.0F, 1.0F);
        tentacles.addChild(ttc3);
        ttc3.setTextureOffset(42, 26).addBox(-5.0F, -2.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        ttc3.setTextureOffset(42, 18).addBox(-5.0F, 2.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-6.3337F, 11.465F, -7.5F);
        ttc3.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, 0.4363F);
        cube_r12.setTextureOffset(58, 60).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-5.1574F, 8.3877F, -7.5F);
        ttc3.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0F, 0.0F, 0.2618F);
        cube_r13.setTextureOffset(42, 13).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(-5.1574F, 8.3877F, -7.5F);
        ttc3.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0F, 0.0F, -0.3491F);
        cube_r14.setTextureOffset(28, 62).addBox(0.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r14.setTextureOffset(42, 62).addBox(-0.8164F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-5.1574F, 8.3877F, -7.5F);
        ttc3.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, 0.8727F);
        cube_r15.setTextureOffset(32, 62).addBox(-1.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r15.setTextureOffset(36, 62).addBox(-0.7571F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(-3.836F, 4.1059F, -7.5F);
        ttc3.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.0F, -0.6109F);
        cube_r16.setTextureOffset(0, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(-5.164F, 3.1059F, -7.5F);
        ttc3.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 0.0F, 0.6109F);
        cube_r17.setTextureOffset(8, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(-5.164F, 5.1059F, -7.5F);
        ttc3.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.0F, 0.6109F);
        cube_r18.setTextureOffset(16, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(-3.836F, 6.1059F, -7.5F);
        ttc3.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.0F, 0.0F, -0.6109F);
        cube_r19.setTextureOffset(50, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(-5.164F, 1.1059F, -7.5F);
        ttc3.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.0F, 0.0F, 0.6109F);
        cube_r20.setTextureOffset(54, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(-3.836F, 2.1059F, -7.5F);
        ttc3.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.0F, 0.0F, -0.6109F);
        cube_r21.setTextureOffset(58, 63).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-3.836F, 0.1059F, -7.5F);
        ttc3.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.0F, 0.0F, -0.6109F);
        cube_r22.setTextureOffset(66, 8).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(-5.164F, -0.8941F, -7.5F);
        ttc3.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.0F, 0.0F, 0.6109F);
        cube_r23.setTextureOffset(66, 15).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        ttc4 = new ModelRenderer(this);
        ttc4.setRotationPoint(6.7838F, 1.7975F, -5.5F);
        tentacles.addChild(ttc4);
        setRotationAngle(ttc4, 0.0F, 0.0F, -0.2618F);
        ttc4.setTextureOffset(42, 5).addBox(1.4505F, -4.5781F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        ttc4.setTextureOffset(42, 0).addBox(1.4505F, -0.5781F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(3.7841F, 8.887F, 0.0F);
        ttc4.addChild(cube_r24);
        setRotationAngle(cube_r24, 0.0F, 0.0F, -0.4363F);
        cube_r24.setTextureOffset(58, 5).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(2.6079F, 5.8097F, 0.0F);
        ttc4.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0F, 0.0F, -0.2618F);
        cube_r25.setTextureOffset(22, 38).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setRotationPoint(2.6079F, 5.8097F, 0.0F);
        ttc4.addChild(cube_r26);
        setRotationAngle(cube_r26, 0.0F, 0.0F, 0.3491F);
        cube_r26.setTextureOffset(59, 20).addBox(-1.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r26.setTextureOffset(36, 59).addBox(-0.1836F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r27 = new ModelRenderer(this);
        cube_r27.setRotationPoint(2.6079F, 5.8097F, 0.0F);
        ttc4.addChild(cube_r27);
        setRotationAngle(cube_r27, 0.0F, 0.0F, -0.8727F);
        cube_r27.setTextureOffset(28, 59).addBox(0.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r27.setTextureOffset(32, 59).addBox(-0.2429F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setRotationPoint(1.2865F, 1.5279F, 0.0F);
        ttc4.addChild(cube_r28);
        setRotationAngle(cube_r28, 0.0F, 0.0F, 0.6109F);
        cube_r28.setTextureOffset(42, 59).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r29 = new ModelRenderer(this);
        cube_r29.setRotationPoint(2.6145F, 0.5279F, 0.0F);
        ttc4.addChild(cube_r29);
        setRotationAngle(cube_r29, 0.0F, 0.0F, -0.6109F);
        cube_r29.setTextureOffset(0, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r30 = new ModelRenderer(this);
        cube_r30.setRotationPoint(2.6145F, 2.5279F, 0.0F);
        ttc4.addChild(cube_r30);
        setRotationAngle(cube_r30, 0.0F, 0.0F, -0.6109F);
        cube_r30.setTextureOffset(8, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r31 = new ModelRenderer(this);
        cube_r31.setRotationPoint(1.2865F, 3.5279F, 0.0F);
        ttc4.addChild(cube_r31);
        setRotationAngle(cube_r31, 0.0F, 0.0F, 0.6109F);
        cube_r31.setTextureOffset(60, 15).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r32 = new ModelRenderer(this);
        cube_r32.setRotationPoint(2.6145F, -1.4721F, 0.0F);
        ttc4.addChild(cube_r32);
        setRotationAngle(cube_r32, 0.0F, 0.0F, -0.6109F);
        cube_r32.setTextureOffset(16, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r33 = new ModelRenderer(this);
        cube_r33.setRotationPoint(1.2865F, -0.4721F, 0.0F);
        ttc4.addChild(cube_r33);
        setRotationAngle(cube_r33, 0.0F, 0.0F, 0.6109F);
        cube_r33.setTextureOffset(20, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r34 = new ModelRenderer(this);
        cube_r34.setRotationPoint(1.2865F, -2.4721F, 0.0F);
        ttc4.addChild(cube_r34);
        setRotationAngle(cube_r34, 0.0F, 0.0F, 0.6109F);
        cube_r34.setTextureOffset(50, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r35 = new ModelRenderer(this);
        cube_r35.setRotationPoint(2.6145F, -3.4721F, 0.0F);
        ttc4.addChild(cube_r35);
        setRotationAngle(cube_r35, 0.0F, 0.0F, -0.6109F);
        cube_r35.setTextureOffset(54, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        ttc2 = new ModelRenderer(this);
        ttc2.setRotationPoint(0.0F, 0.0F, 0.0F);
        tentacles.addChild(ttc2);
        ttc2.setTextureOffset(4, 44).addBox(4.0F, -2.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        ttc2.setTextureOffset(0, 44).addBox(4.0F, 2.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r36 = new ModelRenderer(this);
        cube_r36.setRotationPoint(5.1574F, 8.3877F, -7.5F);
        ttc2.addChild(cube_r36);
        setRotationAngle(cube_r36, 0.0F, 0.0F, -0.2618F);
        cube_r36.setTextureOffset(42, 31).addBox(-0.5F, -2.6059F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r37 = new ModelRenderer(this);
        cube_r37.setRotationPoint(5.1574F, 8.3877F, -7.5F);
        ttc2.addChild(cube_r37);
        setRotationAngle(cube_r37, 0.0F, 0.0F, 0.3491F);
        cube_r37.setTextureOffset(66, 18).addBox(-1.3307F, -1.0287F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r37.setTextureOffset(26, 66).addBox(-0.1836F, 0.6096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r38 = new ModelRenderer(this);
        cube_r38.setRotationPoint(5.1574F, 8.3877F, -7.5F);
        ttc2.addChild(cube_r38);
        setRotationAngle(cube_r38, 0.0F, 0.0F, -0.8727F);
        cube_r38.setTextureOffset(66, 21).addBox(0.9043F, -1.8479F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        cube_r38.setTextureOffset(22, 66).addBox(-0.2429F, -0.2096F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r39 = new ModelRenderer(this);
        cube_r39.setRotationPoint(3.836F, 4.1059F, -7.5F);
        ttc2.addChild(cube_r39);
        setRotationAngle(cube_r39, 0.0F, 0.0F, 0.6109F);
        cube_r39.setTextureOffset(30, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r40 = new ModelRenderer(this);
        cube_r40.setRotationPoint(5.164F, 3.1059F, -7.5F);
        ttc2.addChild(cube_r40);
        setRotationAngle(cube_r40, 0.0F, 0.0F, -0.6109F);
        cube_r40.setTextureOffset(34, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r41 = new ModelRenderer(this);
        cube_r41.setRotationPoint(5.164F, 5.1059F, -7.5F);
        ttc2.addChild(cube_r41);
        setRotationAngle(cube_r41, 0.0F, 0.0F, -0.6109F);
        cube_r41.setTextureOffset(38, 66).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r42 = new ModelRenderer(this);
        cube_r42.setRotationPoint(3.836F, 6.1059F, -7.5F);
        ttc2.addChild(cube_r42);
        setRotationAngle(cube_r42, 0.0F, 0.0F, 0.6109F);
        cube_r42.setTextureOffset(0, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r43 = new ModelRenderer(this);
        cube_r43.setRotationPoint(5.164F, 1.1059F, -7.5F);
        ttc2.addChild(cube_r43);
        setRotationAngle(cube_r43, 0.0F, 0.0F, -0.6109F);
        cube_r43.setTextureOffset(4, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r44 = new ModelRenderer(this);
        cube_r44.setRotationPoint(3.836F, 2.1059F, -7.5F);
        ttc2.addChild(cube_r44);
        setRotationAngle(cube_r44, 0.0F, 0.0F, 0.6109F);
        cube_r44.setTextureOffset(42, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r45 = new ModelRenderer(this);
        cube_r45.setRotationPoint(3.836F, 0.1059F, -7.5F);
        ttc2.addChild(cube_r45);
        setRotationAngle(cube_r45, 0.0F, 0.0F, 0.6109F);
        cube_r45.setTextureOffset(46, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r46 = new ModelRenderer(this);
        cube_r46.setRotationPoint(5.164F, -0.8941F, -7.5F);
        ttc2.addChild(cube_r46);
        setRotationAngle(cube_r46, 0.0F, 0.0F, -0.6109F);
        cube_r46.setTextureOffset(50, 67).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        lt1 = new ModelRenderer(this);
        lt1.setRotationPoint(2.0F, 0.0F, -3.0F);
        tentacles.addChild(lt1);
        lt1.setTextureOffset(18, 38).addBox(-10.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lt1.setTextureOffset(25, 48).addBox(-10.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r47 = new ModelRenderer(this);
        cube_r47.setRotationPoint(-9.9602F, 9.5876F, 0.5F);
        lt1.addChild(cube_r47);
        setRotationAngle(cube_r47, 0.0F, 0.0F, -0.1745F);
        cube_r47.setTextureOffset(14, 38).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r48 = new ModelRenderer(this);
        cube_r48.setRotationPoint(-10.2147F, 3.7522F, 0.5F);
        lt1.addChild(cube_r48);
        setRotationAngle(cube_r48, 0.0F, 0.0F, 0.0873F);
        cube_r48.setTextureOffset(58, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r49 = new ModelRenderer(this);
        cube_r49.setRotationPoint(-9.921F, 1.8444F, 0.5F);
        lt1.addChild(cube_r49);
        setRotationAngle(cube_r49, 0.0F, 0.0F, 0.2182F);
        cube_r49.setTextureOffset(48, 45).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lt3 = new ModelRenderer(this);
        lt3.setRotationPoint(-8.7075F, 3.7802F, 2.5F);
        tentacles.addChild(lt3);
        setRotationAngle(lt3, 0.0F, 0.0F, 0.0873F);
        lt3.setTextureOffset(36, 26).addBox(-0.0425F, -7.7802F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lt3.setTextureOffset(46, 13).addBox(-0.8424F, 0.9247F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r50 = new ModelRenderer(this);
        cube_r50.setRotationPoint(-0.0027F, 5.8074F, 0.0F);
        lt3.addChild(cube_r50);
        setRotationAngle(cube_r50, 0.0F, 0.0F, -0.1745F);
        cube_r50.setTextureOffset(8, 36).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r51 = new ModelRenderer(this);
        cube_r51.setRotationPoint(-0.2571F, -0.028F, 0.0F);
        lt3.addChild(cube_r51);
        setRotationAngle(cube_r51, 0.0F, 0.0F, 0.0873F);
        cube_r51.setTextureOffset(54, 26).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r52 = new ModelRenderer(this);
        cube_r52.setRotationPoint(0.0365F, -1.9358F, 0.0F);
        lt3.addChild(cube_r52);
        setRotationAngle(cube_r52, 0.0F, 0.0F, 0.2182F);
        cube_r52.setTextureOffset(46, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lt4 = new ModelRenderer(this);
        lt4.setRotationPoint(8.7075F, 3.7802F, 2.5F);
        tentacles.addChild(lt4);
        setRotationAngle(lt4, 0.0F, 0.0F, -0.0873F);
        lt4.setTextureOffset(36, 4).addBox(-0.9575F, -7.7802F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lt4.setTextureOffset(46, 0).addBox(-0.1576F, 0.9247F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r53 = new ModelRenderer(this);
        cube_r53.setRotationPoint(0.0027F, 5.8074F, 0.0F);
        lt4.addChild(cube_r53);
        setRotationAngle(cube_r53, 0.0F, 0.0F, 0.1745F);
        cube_r53.setTextureOffset(4, 33).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r54 = new ModelRenderer(this);
        cube_r54.setRotationPoint(0.2571F, -0.028F, 0.0F);
        lt4.addChild(cube_r54);
        setRotationAngle(cube_r54, 0.0F, 0.0F, -0.0873F);
        cube_r54.setTextureOffset(36, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r55 = new ModelRenderer(this);
        cube_r55.setRotationPoint(-0.0365F, -1.9358F, 0.0F);
        lt4.addChild(cube_r55);
        setRotationAngle(cube_r55, 0.0F, 0.0F, -0.2182F);
        cube_r55.setTextureOffset(46, 4).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lt2 = new ModelRenderer(this);
        lt2.setRotationPoint(-2.0F, 0.0F, -3.0F);
        tentacles.addChild(lt2);
        lt2.setTextureOffset(4, 38).addBox(9.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lt2.setTextureOffset(46, 26).addBox(9.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r56 = new ModelRenderer(this);
        cube_r56.setRotationPoint(9.9602F, 9.5876F, 0.5F);
        lt2.addChild(cube_r56);
        setRotationAngle(cube_r56, 0.0F, 0.0F, 0.1745F);
        cube_r56.setTextureOffset(0, 38).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r57 = new ModelRenderer(this);
        cube_r57.setRotationPoint(10.2147F, 3.7522F, 0.5F);
        lt2.addChild(cube_r57);
        setRotationAngle(cube_r57, 0.0F, 0.0F, -0.0873F);
        cube_r57.setTextureOffset(54, 29).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r58 = new ModelRenderer(this);
        cube_r58.setRotationPoint(9.921F, 1.8444F, 0.5F);
        lt2.addChild(cube_r58);
        setRotationAngle(cube_r58, 0.0F, 0.0F, -0.2182F);
        cube_r58.setTextureOffset(46, 30).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lt5 = new ModelRenderer(this);
        lt5.setRotationPoint(-6.0F, 2.0F, 7.0F);
        tentacles.addChild(lt5);
        lt5.setTextureOffset(0, 33).addBox(9.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lt5.setTextureOffset(38, 45).addBox(9.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r59 = new ModelRenderer(this);
        cube_r59.setRotationPoint(9.9602F, 9.5876F, 0.5F);
        lt5.addChild(cube_r59);
        setRotationAngle(cube_r59, 0.0F, 0.0F, 0.1745F);
        cube_r59.setTextureOffset(8, 31).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r60 = new ModelRenderer(this);
        cube_r60.setRotationPoint(10.2147F, 3.7522F, 0.5F);
        lt5.addChild(cube_r60);
        setRotationAngle(cube_r60, 0.0F, 0.0F, -0.0873F);
        cube_r60.setTextureOffset(36, 9).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r61 = new ModelRenderer(this);
        cube_r61.setRotationPoint(9.921F, 1.8444F, 0.5F);
        lt5.addChild(cube_r61);
        setRotationAngle(cube_r61, 0.0F, 0.0F, -0.2182F);
        cube_r61.setTextureOffset(44, 45).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        lt6 = new ModelRenderer(this);
        lt6.setRotationPoint(6.0F, 2.0F, 7.0F);
        tentacles.addChild(lt6);
        lt6.setTextureOffset(22, 24).addBox(-10.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
        lt6.setTextureOffset(36, 13).addBox(-10.7999F, 4.7048F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r62 = new ModelRenderer(this);
        cube_r62.setRotationPoint(-9.9602F, 9.5876F, 0.5F);
        lt6.addChild(cube_r62);
        setRotationAngle(cube_r62, 0.0F, 0.0F, -0.1745F);
        cube_r62.setTextureOffset(8, 23).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r63 = new ModelRenderer(this);
        cube_r63.setRotationPoint(-10.2147F, 3.7522F, 0.5F);
        lt6.addChild(cube_r63);
        setRotationAngle(cube_r63, 0.0F, 0.0F, 0.0873F);
        cube_r63.setTextureOffset(22, 31).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        cube_r64 = new ModelRenderer(this);
        cube_r64.setRotationPoint(-9.921F, 1.8444F, 0.5F);
        lt6.addChild(cube_r64);
        setRotationAngle(cube_r64, 0.0F, 0.0F, 0.2182F);
        cube_r64.setTextureOffset(34, 45).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.main.copyModelAngles(this.bipedHead);
        matrixStack.push();
        matrixStack.scale(1.35f, 1.35f, 1.35f);
        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

        matrixStack.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}