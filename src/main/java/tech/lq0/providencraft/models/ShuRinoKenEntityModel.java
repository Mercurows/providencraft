package tech.lq0.providencraft.models;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.projectile.ShuRinoKenEntity;

public class ShuRinoKenEntityModel extends EntityModel<ShuRinoKenEntity> {
	private final ModelRenderer main;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;

	public ShuRinoKenEntityModel() {
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bone);
		bone.setTextureOffset(21, 22).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(10, 22).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(16, 8).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(8, 8).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(23, 0).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 10).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 1.5708F, 0.0F);
		bone2.setTextureOffset(21, 18).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(5, 21).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(16, 0).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone2.setTextureOffset(8, 1).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone2.setTextureOffset(8, 8).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(8, 3).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 3.1416F, 0.0F);
		bone3.setTextureOffset(0, 20).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone3.setTextureOffset(16, 19).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone3.setTextureOffset(7, 15).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone3.setTextureOffset(0, 7).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone3.setTextureOffset(8, 0).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone3.setTextureOffset(0, 7).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bone4);
		setRotationAngle(bone4, 0.0F, -1.5708F, 0.0F);
		bone4.setTextureOffset(19, 14).addBox(-1.0F, -1.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(14, 15).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(0, 14).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone4.setTextureOffset(0, 3).addBox(-3.0F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(ShuRinoKenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
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