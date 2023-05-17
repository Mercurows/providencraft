package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.projectile.DaifukuSyrupEntity;

public class DaifukuSyrupModel extends EntityModel<DaifukuSyrupEntity> {
    private final ModelRenderer bone;

    public DaifukuSyrupModel() {
        textureWidth = 16;
        textureHeight = 16;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 22.0F, 0.0F);
        bone.setTextureOffset(6, 5).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(6, 8).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 7).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 4).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(DaifukuSyrupEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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