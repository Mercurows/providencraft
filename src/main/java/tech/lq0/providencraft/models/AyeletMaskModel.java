package tech.lq0.providencraft.models;// Made with Blockbench 4.2.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class AyeletMaskModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer bone;

	public AyeletMaskModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 23.0F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -2.0F, 0.0F);
		main.addChild(bone);
		bone.setTextureOffset(12, 0).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(0, 11).addBox(4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(12, 4).addBox(-4.0F, -2.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(12, 6).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(12, 6).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.main.copyModelAngles(this.bipedHead);
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}