package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class BlackEarphonesModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public BlackEarphonesModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 1.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(4, 11).addBox(-5.0F, -8.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(13, 5).addBox(-5.0F, -7.5F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 13).addBox(-5.0F, -7.5F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(5, 3).addBox(-6.0F, -7.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(14, 11).addBox(-5.0F, -10.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(6, 9).addBox(-4.0F, -10.25F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 1.0F, 0.0F);
		bone.addChild(bone3);
		bone3.setTextureOffset(0, 7).addBox(4.0F, -8.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		bone3.setTextureOffset(10, 11).addBox(4.0F, -7.5F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(10, 2).addBox(4.0F, -7.5F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(5.0F, -7.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bone3.setTextureOffset(14, 1).addBox(4.0F, -10.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(5, 0).addBox(0.0F, -10.25F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.bone.copyModelAngles(this.bipedHead);
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}