package tech.lq0.providencraft.models;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class KurumiHaloModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;

	public KurumiHaloModel() {
		super(1.0F);
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 8.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(34, 31).addBox(-1.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(41, 18).addBox(-2.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(41, 12).addBox(-4.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(34, 26).addBox(-5.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(11, 34).addBox(-8.0F, -23.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(27, 20).addBox(-9.0F, -23.0F, 6.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(23, 21).addBox(-10.0F, -22.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(12, 15).addBox(-11.0F, -21.0F, 6.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 9).addBox(-12.0F, -20.0F, 6.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(8, 23).addBox(-13.0F, -18.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(21, 33).addBox(-14.0F, -16.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(23, 5).addBox(-7.0F, -24.0F, 6.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(13, 8).addBox(-15.0F, -12.0F, 6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(24, 18).addBox(-18.0F, -11.5F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(32, 16).addBox(-2.0F, -19.5F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(15, 32).addBox(-8.5F, -13.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(7, 41).addBox(-8.0F, -15.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(3, 39).addBox(-7.0F, -16.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(38, 29).addBox(-6.0F, -17.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(38, 25).addBox(-5.0F, -18.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(40, 38).addBox(-3.0F, -19.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(22, 38).addBox(-4.0F, -19.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 8.0F, 0.0F);
		bone.addChild(bone3);
		bone3.setTextureOffset(32, 8).addBox(0.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(18, 38).addBox(-0.5F, -28.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(40, 33).addBox(1.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(40, 15).addBox(3.0F, -24.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(4, 32).addBox(4.0F, -25.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(32, 0).addBox(7.0F, -23.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(4, 26).addBox(8.0F, -23.0F, 6.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(19, 22).addBox(9.0F, -22.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(8, 15).addBox(10.0F, -21.0F, 6.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(8, 0).addBox(11.0F, -20.0F, 6.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(15, 22).addBox(12.0F, -18.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(31, 22).addBox(13.0F, -16.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(22, 0).addBox(5.0F, -24.0F, 6.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(8, 13).addBox(11.0F, -12.0F, 6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(24, 16).addBox(15.0F, -11.5F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(31, 19).addBox(0.0F, -19.5F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(31, 13).addBox(6.5F, -13.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(40, 9).addBox(7.0F, -15.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(37, 35).addBox(6.0F, -16.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(37, 18).addBox(5.0F, -17.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(37, 12).addBox(4.0F, -18.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(40, 0).addBox(2.0F, -19.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(33, 36).addBox(3.0F, -19.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -14.0F, 0.0F);
		bone.addChild(bone4);
		bone4.setTextureOffset(0, 31).addBox(0.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(36, 39).addBox(1.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(30, 39).addBox(3.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(30, 30).addBox(4.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(26, 30).addBox(7.0F, 19.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(0, 25).addBox(8.0F, 18.0F, 6.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(20, 15).addBox(9.0F, 16.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(12, 0).addBox(10.0F, 14.0F, 6.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(4, 0).addBox(11.0F, 12.0F, 6.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(4, 19).addBox(12.0F, 12.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(8, 30).addBox(13.0F, 12.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(18, 10).addBox(5.0F, 20.0F, 6.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(8, 11).addBox(11.0F, 11.0F, 6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(33, 41).addBox(10.0F, 10.5F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(16, 29).addBox(0.0F, 17.5F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(29, 5).addBox(6.5F, 11.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(26, 39).addBox(7.0F, 13.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(36, 8).addBox(6.0F, 13.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(7, 36).addBox(5.0F, 14.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(36, 0).addBox(4.0F, 15.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(39, 22).addBox(2.0F, 17.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(0, 36).addBox(3.0F, 16.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -14.0F, 0.0F);
		bone.addChild(bone5);
		bone5.setTextureOffset(22, 28).addBox(-1.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(29, 35).addBox(-0.5F, 25.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(14, 39).addBox(-2.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(10, 39).addBox(-4.0F, 22.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(12, 28).addBox(-5.0F, 21.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(28, 9).addBox(-8.0F, 19.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(24, 10).addBox(-9.0F, 18.0F, 6.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(0, 18).addBox(-10.0F, 16.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(4, 11).addBox(-11.0F, 14.0F, 6.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(0, 0).addBox(-12.0F, 12.0F, 6.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(16, 15).addBox(-13.0F, 12.0F, 6.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(28, 0).addBox(-14.0F, 12.0F, 6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(16, 0).addBox(-7.0F, 20.0F, 6.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(4, 9).addBox(-15.0F, 11.0F, 6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(41, 28).addBox(-11.0F, 10.5F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(26, 27).addBox(-2.0F, 17.5F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(16, 5).addBox(-8.5F, 11.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(39, 6).addBox(-8.0F, 13.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(25, 35).addBox(-7.0F, 13.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(35, 22).addBox(-6.0F, 14.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(15, 35).addBox(-5.0F, 15.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(39, 3).addBox(-3.0F, 17.0F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(35, 4).addBox(-4.0F, 16.0F, 6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.bone.copyModelAngles(this.bipedBody);
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}