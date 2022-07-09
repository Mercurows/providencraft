package tech.lq0.providencraft.models;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class ChiramIdolHelmetModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer hat;
	private final ModelRenderer cube_r1;
	private final ModelRenderer ear;
	private final ModelRenderer ear2;
	private final ModelRenderer total;

	public ChiramIdolHelmetModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		total = new ModelRenderer(this);
		total.setRotationPoint(0.0F, 24.0F, 0.0F);

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, -7.0F, 0.0F);


		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, -1.6F, 2.5F);
		main.addChild(hat);
		setRotationAngle(hat, -0.3054F, 0.0F, 0.0F);
		hat.setTextureOffset(0, 0).addBox(-3.0F, -0.9F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(8, 15).addBox(3.0F, -0.4F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(0, 14).addBox(-4.0F, -0.4F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 5.6F, 0.0F);
		hat.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.setTextureOffset(0, 7).addBox(3.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		cube_r1.setTextureOffset(8, 8).addBox(-4.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		ear = new ModelRenderer(this);
		ear.setRotationPoint(-0.5F, 0.0F, 0.5F);
		main.addChild(ear);
		ear.setTextureOffset(8, 10).addBox(-4.0F, -3.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ear.setTextureOffset(0, 10).addBox(-3.0F, -3.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ear.setTextureOffset(8, 7).addBox(-2.0F, -3.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ear.setTextureOffset(8, 17).addBox(-4.0F, -4.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ear.setTextureOffset(16, 15).addBox(-3.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ear.setTextureOffset(16, 11).addBox(-4.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ear.setTextureOffset(16, 9).addBox(-4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ear2 = new ModelRenderer(this);
		ear2.setRotationPoint(0.5F, 0.0F, 0.5F);
		main.addChild(ear2);
		ear2.setTextureOffset(0, 7).addBox(3.0F, -3.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ear2.setTextureOffset(0, 3).addBox(2.0F, -3.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ear2.setTextureOffset(0, 0).addBox(1.0F, -3.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		ear2.setTextureOffset(16, 7).addBox(3.0F, -4.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ear2.setTextureOffset(0, 16).addBox(2.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ear2.setTextureOffset(8, 15).addBox(3.0F, -5.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		ear2.setTextureOffset(0, 14).addBox(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		total.addChild(main);
	}

	@Override
	@ParametersAreNonnullByDefault
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	@ParametersAreNonnullByDefault
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.total.copyModelAngles(this.bipedHead);
		total.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}