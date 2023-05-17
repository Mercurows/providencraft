package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.projectile.KurumiBoomerangEntity;

public class KurumiBoomerangModel extends EntityModel<KurumiBoomerangEntity> {
    private final ModelRenderer bone;
    private final ModelRenderer nei;
    private final ModelRenderer wai;
    private final ModelRenderer wai2;
    private final ModelRenderer wai3;
    private final ModelRenderer wai4;
    private final ModelRenderer huan;
    private final ModelRenderer huan2;

    public KurumiBoomerangModel() {
        textureWidth = 64;
        textureHeight = 64;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);


        nei = new ModelRenderer(this);
        nei.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(nei);
        nei.setTextureOffset(14, 14).addBox(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        nei.setTextureOffset(0, 20).addBox(5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
        nei.setTextureOffset(18, 8).addBox(2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
        nei.setTextureOffset(8, 21).addBox(-5.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
        nei.setTextureOffset(18, 21).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        nei.setTextureOffset(22, 13).addBox(-3.0F, -1.0F, 5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        nei.setTextureOffset(0, 0).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 3.0F, 0.0F, false);
        nei.setTextureOffset(0, 4).addBox(-5.0F, -1.0F, 2.0F, 10.0F, 1.0F, 3.0F, 0.0F, false);

        wai = new ModelRenderer(this);
        wai.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(wai);
        wai.setTextureOffset(13, 38).addBox(-12.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai.setTextureOffset(38, 12).addBox(-12.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai.setTextureOffset(26, 2).addBox(-13.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai.setTextureOffset(26, 6).addBox(-13.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai.setTextureOffset(0, 17).addBox(-15.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);

        wai2 = new ModelRenderer(this);
        wai2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(wai2);
        wai2.setTextureOffset(38, 9).addBox(11.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai2.setTextureOffset(9, 38).addBox(11.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai2.setTextureOffset(21, 25).addBox(8.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai2.setTextureOffset(18, 23).addBox(8.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai2.setTextureOffset(0, 14).addBox(7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);

        wai3 = new ModelRenderer(this);
        wai3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(wai3);
        setRotationAngle(wai3, 0.0F, 1.5708F, 0.0F);
        wai3.setTextureOffset(38, 5).addBox(11.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai3.setTextureOffset(38, 3).addBox(11.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai3.setTextureOffset(23, 4).addBox(8.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai3.setTextureOffset(23, 0).addBox(8.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai3.setTextureOffset(0, 11).addBox(7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);

        wai4 = new ModelRenderer(this);
        wai4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(wai4);
        setRotationAngle(wai4, 0.0F, -1.5708F, 0.0F);
        wai4.setTextureOffset(38, 1).addBox(11.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai4.setTextureOffset(36, 37).addBox(11.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        wai4.setTextureOffset(22, 17).addBox(8.0F, -1.0F, -2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai4.setTextureOffset(22, 15).addBox(8.0F, -1.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        wai4.setTextureOffset(0, 8).addBox(7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);

        huan = new ModelRenderer(this);
        huan.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(huan);
        huan.setTextureOffset(26, 33).addBox(-10.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(18, 33).addBox(-9.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(0, 33).addBox(-8.0F, -1.0F, 6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(32, 31).addBox(-6.0F, -1.0F, 7.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(32, 28).addBox(-4.0F, -1.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(32, 37).addBox(-8.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(37, 23).addBox(-4.0F, -1.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(6, 37).addBox(-9.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(36, 34).addBox(-10.0F, -1.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(37, 7).addBox(-5.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(0, 36).addBox(-7.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(10, 35).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(12, 26).addBox(-10.0F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(0, 27).addBox(-9.0F, -1.0F, -6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(18, 27).addBox(-8.0F, -1.0F, -8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(26, 27).addBox(-6.0F, -1.0F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(6, 28).addBox(-4.0F, -1.0F, -10.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(18, 8).addBox(-8.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(8, 20).addBox(-4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(8, 22).addBox(-9.0F, -1.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(24, 27).addBox(-10.0F, -1.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(28, 19).addBox(-5.0F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan.setTextureOffset(0, 20).addBox(-7.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        huan.setTextureOffset(0, 23).addBox(-6.0F, -1.0F, -7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        huan2 = new ModelRenderer(this);
        huan2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(huan2);
        setRotationAngle(huan2, 0.0F, 3.1416F, 0.0F);
        huan2.setTextureOffset(32, 25).addBox(-10.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(32, 17).addBox(-9.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(12, 32).addBox(-8.0F, -1.0F, 6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(6, 31).addBox(-6.0F, -1.0F, 7.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(26, 30).addBox(-4.0F, -1.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(29, 36).addBox(-8.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(25, 36).addBox(-4.0F, -1.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(21, 36).addBox(-9.0F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(36, 20).addBox(-10.0F, -1.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(17, 36).addBox(-5.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(32, 34).addBox(-7.0F, -1.0F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(34, 13).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(28, 8).addBox(-10.0F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(12, 29).addBox(-9.0F, -1.0F, -6.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(0, 30).addBox(-8.0F, -1.0F, -8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(18, 30).addBox(-6.0F, -1.0F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(30, 21).addBox(-4.0F, -1.0F, -10.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(24, 30).addBox(-8.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(24, 33).addBox(-4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(35, 0).addBox(-9.0F, -1.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(35, 4).addBox(-10.0F, -1.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(14, 35).addBox(-5.0F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        huan2.setTextureOffset(6, 34).addBox(-7.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        huan2.setTextureOffset(34, 9).addBox(-6.0F, -1.0F, -7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(KurumiBoomerangEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}