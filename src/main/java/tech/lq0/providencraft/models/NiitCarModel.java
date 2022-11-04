package tech.lq0.providencraft.models;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.NiitCarEntity;

public class NiitCarModel extends EntityModel<NiitCarEntity> {
    private final ModelRenderer main;
    private final ModelRenderer head;
    private final ModelRenderer glass;
    private final ModelRenderer cube_r1;
    private final ModelRenderer wheels;
    private final ModelRenderer wheel1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer wheel2;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer wheel3;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer wheel4;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer wheel5;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer wheel6;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer cube_r34;
    private final ModelRenderer cube_r35;
    private final ModelRenderer cube_r36;
    private final ModelRenderer cube_r37;
    private final ModelRenderer chest;

    public NiitCarModel() {
        textureWidth = 128;
        textureHeight = 128;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 24.75F, 0.0F);


        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, -3.0F);
        main.addChild(head);
        head.setTextureOffset(0, 47).addBox(-6.0F, -7.0F, -14.0F, 12.0F, 3.0F, 11.0F, 0.0F, false);
        head.setTextureOffset(50, 0).addBox(-6.0F, -4.0F, -15.0F, 12.0F, 2.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 72).addBox(-6.0F, -8.0F, -15.0F, 12.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 61).addBox(-7.0F, -14.0F, -3.0F, 14.0F, 10.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(12, 36).addBox(6.0F, -8.0F, -15.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(44, 9).addBox(6.0F, -13.0F, -13.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(30, 0).addBox(6.0F, -14.0F, -8.0F, 1.0F, 9.0F, 5.0F, 0.0F, false);
        head.setTextureOffset(0, 11).addBox(6.0F, -5.0F, -7.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-7.0F, -5.0F, -7.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 28).addBox(-7.0F, -14.0F, -8.0F, 1.0F, 9.0F, 5.0F, 0.0F, false);
        head.setTextureOffset(50, 6).addBox(6.0F, -14.0F, -12.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(38, 28).addBox(-7.0F, -14.0F, -12.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(42, 0).addBox(-7.0F, -13.0F, -13.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(12, 28).addBox(-7.0F, -8.0F, -15.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

        glass = new ModelRenderer(this);
        glass.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(glass);
        glass.setTextureOffset(50, 38).addBox(6.0F, -13.0F, -14.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
        glass.setTextureOffset(6, 47).addBox(-7.0F, -13.0F, -14.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, -9.8444F, -14.079F);
        glass.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.2182F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(48, 67).addBox(-6.0F, -3.0F, -0.5F, 12.0F, 5.0F, 1.0F, 0.0F, false);

        wheels = new ModelRenderer(this);
        wheels.setRotationPoint(0.0F, 0.0F, -3.0F);
        main.addChild(wheels);
        wheels.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, -11.0F, 2.0F, 2.0F, 26.0F, 0.0F, false);
        wheels.setTextureOffset(30, 14).addBox(1.0F, -4.0F, 13.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        wheels.setTextureOffset(0, 22).addBox(-6.0F, -4.0F, 7.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        wheels.setTextureOffset(12, 4).addBox(-6.0F, -4.0F, -11.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        wheels.setTextureOffset(12, 0).addBox(1.0F, -4.0F, -11.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        wheels.setTextureOffset(12, 11).addBox(1.0F, -4.0F, 7.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
        wheels.setTextureOffset(12, 15).addBox(-6.0F, -4.0F, 13.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        wheel1 = new ModelRenderer(this);
        wheel1.setRotationPoint(6.6778F, -2.9874F, -10.0F);
        wheels.addChild(wheel1);
        wheel1.setTextureOffset(0, 53).addBox(-0.6778F, -1.0126F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        wheel1.setTextureOffset(76, 15).addBox(-0.4778F, -2.4126F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        wheel1.setTextureOffset(42, 75).addBox(-0.4778F, 1.4158F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0222F, 1.3551F, 1.3536F);
        wheel1.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(54, 75).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0222F, 1.3551F, -1.3536F);
        wheel1.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.7854F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(48, 75).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0222F, -1.352F, 1.3536F);
        wheel1.addChild(cube_r4);
        setRotationAngle(cube_r4, -0.7854F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(76, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.0222F, 0.0016F, 1.9142F);
        wheel1.addChild(cube_r5);
        setRotationAngle(cube_r5, -1.5708F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(60, 75).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.0222F, 0.0016F, -1.9142F);
        wheel1.addChild(cube_r6);
        setRotationAngle(cube_r6, 1.5708F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(76, 9).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(0.0222F, -1.352F, -1.3536F);
        wheel1.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.7854F, 0.0F, 0.0F);
        cube_r7.setTextureOffset(76, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        wheel2 = new ModelRenderer(this);
        wheel2.setRotationPoint(6.6778F, -2.9874F, 8.0F);
        wheels.addChild(wheel2);
        wheel2.setTextureOffset(6, 42).addBox(-0.6778F, -1.0126F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        wheel2.setTextureOffset(36, 75).addBox(-0.4778F, -2.4126F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        wheel2.setTextureOffset(74, 67).addBox(-0.4778F, 1.4158F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(0.0222F, 1.3551F, 1.3536F);
        wheel2.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.7854F, 0.0F, 0.0F);
        cube_r8.setTextureOffset(64, 73).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(0.0222F, 1.3551F, -1.3536F);
        wheel2.addChild(cube_r9);
        setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
        cube_r9.setTextureOffset(74, 43).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(0.0222F, -1.352F, 1.3536F);
        wheel2.addChild(cube_r10);
        setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
        cube_r10.setTextureOffset(68, 74).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(0.0222F, 0.0016F, 1.9142F);
        wheel2.addChild(cube_r11);
        setRotationAngle(cube_r11, -1.5708F, 0.0F, 0.0F);
        cube_r11.setTextureOffset(74, 74).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(0.0222F, 0.0016F, -1.9142F);
        wheel2.addChild(cube_r12);
        setRotationAngle(cube_r12, 1.5708F, 0.0F, 0.0F);
        cube_r12.setTextureOffset(24, 75).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(0.0222F, -1.352F, -1.3536F);
        wheel2.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
        cube_r13.setTextureOffset(30, 75).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        wheel3 = new ModelRenderer(this);
        wheel3.setRotationPoint(6.6778F, -2.9874F, 14.0F);
        wheels.addChild(wheel3);
        wheel3.setTextureOffset(0, 42).addBox(-0.6778F, -1.0126F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        wheel3.setTextureOffset(72, 71).addBox(-0.4778F, -2.4126F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        wheel3.setTextureOffset(68, 22).addBox(-0.4778F, 1.4158F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(0.0222F, 1.3551F, 1.3536F);
        wheel3.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
        cube_r14.setTextureOffset(68, 16).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(0.0222F, 1.3551F, -1.3536F);
        wheel3.addChild(cube_r15);
        setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
        cube_r15.setTextureOffset(68, 19).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(0.0222F, -1.352F, 1.3536F);
        wheel3.addChild(cube_r16);
        setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
        cube_r16.setTextureOffset(40, 68).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(0.0222F, 0.0016F, 1.9142F);
        wheel3.addChild(cube_r17);
        setRotationAngle(cube_r17, -1.5708F, 0.0F, 0.0F);
        cube_r17.setTextureOffset(28, 70).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(0.0222F, 0.0016F, -1.9142F);
        wheel3.addChild(cube_r18);
        setRotationAngle(cube_r18, 1.5708F, 0.0F, 0.0F);
        cube_r18.setTextureOffset(34, 70).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(0.0222F, -1.352F, -1.3536F);
        wheel3.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.7854F, 0.0F, 0.0F);
        cube_r19.setTextureOffset(70, 44).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        wheel4 = new ModelRenderer(this);
        wheel4.setRotationPoint(-6.6778F, -2.9874F, -10.0F);
        wheels.addChild(wheel4);
        wheel4.setTextureOffset(14, 22).addBox(-0.3222F, -1.0126F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        wheel4.setTextureOffset(68, 13).addBox(-0.5222F, -2.4126F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        wheel4.setTextureOffset(66, 43).addBox(-0.5222F, 1.4158F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(-0.0222F, 1.3551F, 1.3536F);
        wheel4.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.7854F, 0.0F, 0.0F);
        cube_r20.setTextureOffset(36, 64).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(-0.0222F, 1.3551F, -1.3536F);
        wheel4.addChild(cube_r21);
        setRotationAngle(cube_r21, -0.7854F, 0.0F, 0.0F);
        cube_r21.setTextureOffset(40, 65).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-0.0222F, -1.352F, 1.3536F);
        wheel4.addChild(cube_r22);
        setRotationAngle(cube_r22, -0.7854F, 0.0F, 0.0F);
        cube_r22.setTextureOffset(30, 67).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(-0.0222F, 0.0016F, 1.9142F);
        wheel4.addChild(cube_r23);
        setRotationAngle(cube_r23, -1.5708F, 0.0F, 0.0F);
        cube_r23.setTextureOffset(36, 67).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(-0.0222F, 0.0016F, -1.9142F);
        wheel4.addChild(cube_r24);
        setRotationAngle(cube_r24, 1.5708F, 0.0F, 0.0F);
        cube_r24.setTextureOffset(68, 7).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(-0.0222F, -1.352F, -1.3536F);
        wheel4.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.7854F, 0.0F, 0.0F);
        cube_r25.setTextureOffset(68, 10).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        wheel5 = new ModelRenderer(this);
        wheel5.setRotationPoint(-6.6778F, -2.9874F, 8.0F);
        wheels.addChild(wheel5);
        wheel5.setTextureOffset(0, 17).addBox(-0.3222F, -1.0126F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        wheel5.setTextureOffset(30, 64).addBox(-0.5222F, -2.4126F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        wheel5.setTextureOffset(62, 44).addBox(-0.5222F, 1.4158F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setRotationPoint(-0.0222F, 1.3551F, 1.3536F);
        wheel5.addChild(cube_r26);
        setRotationAngle(cube_r26, 0.7854F, 0.0F, 0.0F);
        cube_r26.setTextureOffset(36, 61).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r27 = new ModelRenderer(this);
        cube_r27.setRotationPoint(-0.0222F, 1.3551F, -1.3536F);
        wheel5.addChild(cube_r27);
        setRotationAngle(cube_r27, -0.7854F, 0.0F, 0.0F);
        cube_r27.setTextureOffset(40, 62).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setRotationPoint(-0.0222F, -1.352F, 1.3536F);
        wheel5.addChild(cube_r28);
        setRotationAngle(cube_r28, -0.7854F, 0.0F, 0.0F);
        cube_r28.setTextureOffset(64, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r29 = new ModelRenderer(this);
        cube_r29.setRotationPoint(-0.0222F, 0.0016F, 1.9142F);
        wheel5.addChild(cube_r29);
        setRotationAngle(cube_r29, -1.5708F, 0.0F, 0.0F);
        cube_r29.setTextureOffset(64, 9).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r30 = new ModelRenderer(this);
        cube_r30.setRotationPoint(-0.0222F, 0.0016F, -1.9142F);
        wheel5.addChild(cube_r30);
        setRotationAngle(cube_r30, 1.5708F, 0.0F, 0.0F);
        cube_r30.setTextureOffset(64, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r31 = new ModelRenderer(this);
        cube_r31.setRotationPoint(-0.0222F, -1.352F, -1.3536F);
        wheel5.addChild(cube_r31);
        setRotationAngle(cube_r31, 0.7854F, 0.0F, 0.0F);
        cube_r31.setTextureOffset(64, 15).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        wheel6 = new ModelRenderer(this);
        wheel6.setRotationPoint(-6.6778F, -2.9874F, 14.0F);
        wheels.addChild(wheel6);
        wheel6.setTextureOffset(0, 6).addBox(-0.3222F, -1.0126F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        wheel6.setTextureOffset(30, 61).addBox(-0.5222F, -2.4126F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        wheel6.setTextureOffset(56, 6).addBox(-0.5222F, 1.4158F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r32 = new ModelRenderer(this);
        cube_r32.setRotationPoint(-0.0222F, 1.3551F, 1.3536F);
        wheel6.addChild(cube_r32);
        setRotationAngle(cube_r32, 0.7854F, 0.0F, 0.0F);
        cube_r32.setTextureOffset(4, 55).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r33 = new ModelRenderer(this);
        cube_r33.setRotationPoint(-0.0222F, 1.3551F, -1.3536F);
        wheel6.addChild(cube_r33);
        setRotationAngle(cube_r33, -0.7854F, 0.0F, 0.0F);
        cube_r33.setTextureOffset(35, 55).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r34 = new ModelRenderer(this);
        cube_r34.setRotationPoint(-0.0222F, -1.352F, 1.3536F);
        wheel6.addChild(cube_r34);
        setRotationAngle(cube_r34, -0.7854F, 0.0F, 0.0F);
        cube_r34.setTextureOffset(58, 43).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r35 = new ModelRenderer(this);
        cube_r35.setRotationPoint(-0.0222F, 0.0016F, 1.9142F);
        wheel6.addChild(cube_r35);
        setRotationAngle(cube_r35, -1.5708F, 0.0F, 0.0F);
        cube_r35.setTextureOffset(60, 7).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r36 = new ModelRenderer(this);
        cube_r36.setRotationPoint(-0.0222F, 0.0016F, -1.9142F);
        wheel6.addChild(cube_r36);
        setRotationAngle(cube_r36, 1.5708F, 0.0F, 0.0F);
        cube_r36.setTextureOffset(60, 10).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r37 = new ModelRenderer(this);
        cube_r37.setRotationPoint(-0.0222F, -1.352F, -1.3536F);
        wheel6.addChild(cube_r37);
        setRotationAngle(cube_r37, 0.7854F, 0.0F, 0.0F);
        cube_r37.setTextureOffset(60, 13).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        chest = new ModelRenderer(this);
        chest.setRotationPoint(0.0F, 0.0F, -3.0F);
        main.addChild(chest);
        chest.setTextureOffset(0, 28).addBox(-5.0F, -5.0F, 1.0F, 10.0F, 1.0F, 18.0F, 0.0F, false);
        chest.setTextureOffset(38, 29).addBox(6.5F, -14.75F, 1.0F, 1.0F, 8.0F, 18.0F, 0.0F, false);
        chest.setTextureOffset(56, 8).addBox(5.0F, -6.0F, 1.0F, 1.0F, 2.0F, 18.0F, 0.0F, false);
        chest.setTextureOffset(28, 55).addBox(-6.0F, -6.0F, 1.0F, 1.0F, 2.0F, 18.0F, 0.0F, false);
        chest.setTextureOffset(30, 0).addBox(-7.5F, -14.75F, 1.0F, 1.0F, 8.0F, 18.0F, 0.0F, false);
        chest.setTextureOffset(0, 11).addBox(-7.0F, -6.75F, 6.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        chest.setTextureOffset(0, 47).addBox(-7.0F, -6.75F, 17.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        chest.setTextureOffset(44, 40).addBox(-7.0F, -6.75F, 3.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        chest.setTextureOffset(48, 33).addBox(-7.0F, -6.75F, 1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        chest.setTextureOffset(0, 11).addBox(-7.0F, -6.75F, 16.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        chest.setTextureOffset(6, 6).addBox(-7.0F, -6.75F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        chest.setTextureOffset(0, 0).addBox(6.0F, -6.75F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        chest.setTextureOffset(20, 20).addBox(6.0F, -6.75F, 3.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        chest.setTextureOffset(48, 28).addBox(6.0F, -6.75F, 1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
        chest.setTextureOffset(0, 0).addBox(6.0F, -6.75F, 6.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        chest.setTextureOffset(6, 0).addBox(6.0F, -6.75F, 16.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        chest.setTextureOffset(38, 40).addBox(6.0F, -6.75F, 17.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        chest.setTextureOffset(58, 28).addBox(-7.0F, -14.75F, 19.0F, 14.0F, 11.0F, 1.0F, 0.0F, false);
        chest.setTextureOffset(48, 55).addBox(-7.0F, -14.75F, 0.0F, 14.0F, 11.0F, 1.0F, 0.0F, false);
        chest.setTextureOffset(58, 40).addBox(-7.0F, -14.75F, -1.0F, 14.0F, 2.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(NiitCarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        matrixStack.push();
        matrixStack.scale(2.0f, 2.0f, 2.0f);

        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        matrixStack.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}