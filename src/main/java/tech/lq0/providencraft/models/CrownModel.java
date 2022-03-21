package tech.lq0.providencraft.models;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class CrownModel<T extends LivingEntity> extends BipedModel<T> {
    private final ModelRenderer main;
    private final ModelRenderer cross;
    private final ModelRenderer bone;
    private final ModelRenderer crownhead;
    private final ModelRenderer ele1;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer ele2;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer ele3;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer ele4;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer ele5;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer ele6;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer ele7;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer ele8;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer cube_r32;

    public CrownModel() {
        super(1.0f);
        textureWidth = 32;
        textureHeight = 32;

        main = new ModelRenderer(this);
        main.setRotationPoint(0.0F, 0.0F, 0.0F);

        cross = new ModelRenderer(this);
        cross.setRotationPoint(0.0F, -8.0F, 0.0F);
        main.addChild(cross);
        cross.setTextureOffset(0, 6).addBox(-2.0F, -12.0F, 0.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
        cross.setTextureOffset(4, 11).addBox(-3.0F, -11.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, -8.0F, 0.0F);
        main.addChild(bone);
        bone.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, -2.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        bone.setTextureOffset(15, 2).addBox(-3.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(15, 0).addBox(-3.0F, -1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(9, 7).addBox(-5.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone.setTextureOffset(4, 6).addBox(1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        crownhead = new ModelRenderer(this);
        crownhead.setRotationPoint(0.0F, -8.0F, 0.0F);
        main.addChild(crownhead);


        ele1 = new ModelRenderer(this);
        ele1.setRotationPoint(0.0F, 0.0F, 0.0F);
        crownhead.addChild(ele1);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-1.0F, -8.0115F, -1.5944F);
        ele1.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.2182F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(24, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-1.0F, -6.5528F, -4.5514F);
        ele1.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.9163F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(15, 25).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-1.0F, -1.7842F, -3.0478F);
        ele1.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.3054F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(18, 16).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0F, -1.0F, 1.0F);
        ele1.addChild(cube_r4);
        setRotationAngle(cube_r4, 1.1345F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(4, 27).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele2 = new ModelRenderer(this);
        ele2.setRotationPoint(0.0F, 0.0F, 1.0F);
        crownhead.addChild(ele2);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-1.0F, -8.0115F, 1.5944F);
        ele2.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.2182F, 0.0F, 0.0F);
        cube_r5.setTextureOffset(0, 24).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-1.0F, -6.5528F, 4.5514F);
        ele2.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.9163F, 0.0F, 0.0F);
        cube_r6.setTextureOffset(11, 24).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-1.0F, -1.7842F, 3.0478F);
        ele2.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.3054F, 0.0F, 0.0F);
        cube_r7.setTextureOffset(18, 6).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(0.0F, -1.0F, -1.0F);
        ele2.addChild(cube_r8);
        setRotationAngle(cube_r8, -1.1345F, 0.0F, 0.0F);
        cube_r8.setTextureOffset(0, 27).addBox(-2.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele3 = new ModelRenderer(this);
        ele3.setRotationPoint(0.0F, 0.0F, 0.0F);
        crownhead.addChild(ele3);
        setRotationAngle(ele3, 0.0F, 0.7854F, 0.0F);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-1.0F, -8.0115F, 1.5944F);
        ele3.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.2182F, 0.0F, 0.0F);
        cube_r9.setTextureOffset(23, 10).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-1.0F, -6.5528F, 4.5514F);
        ele3.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.9163F, 0.0F, 0.0F);
        cube_r10.setTextureOffset(22, 23).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-1.0F, -1.7842F, 3.0478F);
        ele3.addChild(cube_r11);
        setRotationAngle(cube_r11, -0.3054F, 0.0F, 0.0F);
        cube_r11.setTextureOffset(0, 18).addBox(-1.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(0.0F, -1.0F, -1.0F);
        ele3.addChild(cube_r12);
        setRotationAngle(cube_r12, -1.1345F, 0.0F, 0.0F);
        cube_r12.setTextureOffset(26, 25).addBox(-2.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele4 = new ModelRenderer(this);
        ele4.setRotationPoint(-3.0F, 0.0F, 1.0F);
        crownhead.addChild(ele4);
        setRotationAngle(ele4, 0.0F, 0.7854F, 0.0F);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(1.0F, -8.0115F, -1.5944F);
        ele4.addChild(cube_r13);
        setRotationAngle(cube_r13, -0.2182F, 0.0F, 0.0F);
        cube_r13.setTextureOffset(16, 22).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(1.0F, -6.5528F, -4.5514F);
        ele4.addChild(cube_r14);
        setRotationAngle(cube_r14, -0.9163F, 0.0F, 0.0F);
        cube_r14.setTextureOffset(7, 23).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(1.0F, -1.7842F, -3.0478F);
        ele4.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.3054F, 0.0F, 0.0F);
        cube_r15.setTextureOffset(14, 17).addBox(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(0.0F, -1.0F, 1.0F);
        ele4.addChild(cube_r16);
        setRotationAngle(cube_r16, 1.1345F, 0.0F, 0.0F);
        cube_r16.setTextureOffset(26, 21).addBox(1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele5 = new ModelRenderer(this);
        ele5.setRotationPoint(-3.0F, 0.0F, 0.0F);
        crownhead.addChild(ele5);
        setRotationAngle(ele5, 0.0F, -0.7854F, 0.0F);


        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(1.0F, -8.0115F, 1.5944F);
        ele5.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.2182F, 0.0F, 0.0F);
        cube_r17.setTextureOffset(10, 21).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(1.0F, -6.5528F, 4.5514F);
        ele5.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.9163F, 0.0F, 0.0F);
        cube_r18.setTextureOffset(22, 15).addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(1.0F, -1.7842F, 3.0478F);
        ele5.addChild(cube_r19);
        setRotationAngle(cube_r19, -0.3054F, 0.0F, 0.0F);
        cube_r19.setTextureOffset(8, 17).addBox(0.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(0.0F, -1.0F, -1.0F);
        ele5.addChild(cube_r20);
        setRotationAngle(cube_r20, -1.1345F, 0.0F, 0.0F);
        cube_r20.setTextureOffset(26, 13).addBox(1.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele6 = new ModelRenderer(this);
        ele6.setRotationPoint(0.0F, 0.0F, 1.0F);
        crownhead.addChild(ele6);
        setRotationAngle(ele6, 0.0F, -0.7854F, 0.0F);


        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(-1.0F, -8.0115F, -1.5944F);
        ele6.addChild(cube_r21);
        setRotationAngle(cube_r21, -0.2182F, 0.0F, 0.0F);
        cube_r21.setTextureOffset(21, 2).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-1.0F, -6.5528F, -4.5514F);
        ele6.addChild(cube_r22);
        setRotationAngle(cube_r22, -0.9163F, 0.0F, 0.0F);
        cube_r22.setTextureOffset(22, 5).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(-1.0F, -1.7842F, -3.0478F);
        ele6.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.3054F, 0.0F, 0.0F);
        cube_r23.setTextureOffset(15, 11).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(0.0F, -1.0F, 1.0F);
        ele6.addChild(cube_r24);
        setRotationAngle(cube_r24, 1.1345F, 0.0F, 0.0F);
        cube_r24.setTextureOffset(26, 4).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele7 = new ModelRenderer(this);
        ele7.setRotationPoint(-1.0F, 0.0F, 2.0F);
        crownhead.addChild(ele7);
        setRotationAngle(ele7, 0.0F, -1.5708F, 0.0F);


        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(-1.0F, -8.0115F, -1.5944F);
        ele7.addChild(cube_r25);
        setRotationAngle(cube_r25, -0.2182F, 0.0F, 0.0F);
        cube_r25.setTextureOffset(20, 20).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setRotationPoint(-1.0F, -6.5528F, -4.5514F);
        ele7.addChild(cube_r26);
        setRotationAngle(cube_r26, -0.9163F, 0.0F, 0.0F);
        cube_r26.setTextureOffset(4, 19).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r27 = new ModelRenderer(this);
        cube_r27.setRotationPoint(-1.0F, -1.7842F, -3.0478F);
        ele7.addChild(cube_r27);
        setRotationAngle(cube_r27, 0.3054F, 0.0F, 0.0F);
        cube_r27.setTextureOffset(4, 13).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setRotationPoint(0.0F, -1.0F, 1.0F);
        ele7.addChild(cube_r28);
        setRotationAngle(cube_r28, 1.1345F, 0.0F, 0.0F);
        cube_r28.setTextureOffset(25, 0).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        ele8 = new ModelRenderer(this);
        ele8.setRotationPoint(-2.0F, 0.0F, 2.0F);
        crownhead.addChild(ele8);
        setRotationAngle(ele8, 0.0F, 1.5708F, 0.0F);


        cube_r29 = new ModelRenderer(this);
        cube_r29.setRotationPoint(1.0F, -8.0115F, -1.5944F);
        ele8.addChild(cube_r29);
        setRotationAngle(cube_r29, -0.2182F, 0.0F, 0.0F);
        cube_r29.setTextureOffset(19, 12).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        cube_r30 = new ModelRenderer(this);
        cube_r30.setRotationPoint(1.0F, -6.5528F, -4.5514F);
        ele8.addChild(cube_r30);
        setRotationAngle(cube_r30, -0.9163F, 0.0F, 0.0F);
        cube_r30.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r31 = new ModelRenderer(this);
        cube_r31.setRotationPoint(1.0F, -1.7842F, -3.0478F);
        ele8.addChild(cube_r31);
        setRotationAngle(cube_r31, 0.3054F, 0.0F, 0.0F);
        cube_r31.setTextureOffset(11, 12).addBox(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        cube_r32 = new ModelRenderer(this);
        cube_r32.setRotationPoint(0.0F, -1.0F, 1.0F);
        ele8.addChild(cube_r32);
        setRotationAngle(cube_r32, 1.1345F, 0.0F, 0.0F);
        cube_r32.setTextureOffset(14, 6).addBox(1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.main.copyModelAngles(this.bipedHead);
        main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}