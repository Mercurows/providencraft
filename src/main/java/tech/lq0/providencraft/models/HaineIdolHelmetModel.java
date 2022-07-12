package tech.lq0.providencraft.models;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class HaineIdolHelmetModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer total;
	private final ModelRenderer main;
	private final ModelRenderer hat;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public HaineIdolHelmetModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		total = new ModelRenderer(this);
		total.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, -8.0F, 0.0F);
		total.addChild(main);
		

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, -0.9286F, 1.0F);
		main.addChild(hat);
		setRotationAngle(hat, -0.0873F, 0.0F, 0.0F);
		hat.setTextureOffset(8, 9).addBox(-4.0F, -0.0714F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(0, 8).addBox(3.0F, -0.0714F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		hat.setTextureOffset(16, 10).addBox(-3.0F, -0.0714F, 3.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(16, 8).addBox(-3.0F, -0.0714F, -4.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 0).addBox(-3.0F, -1.0714F, -3.5F, 6.0F, 1.0F, 7.0F, 0.0F, false);
		hat.setTextureOffset(7, 16).addBox(-3.5F, -1.0714F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		hat.setTextureOffset(0, 15).addBox(2.5F, -1.0714F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bow);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-4.5F, -0.5F, 1.0F);
		bow.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2182F, -0.4363F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -0.25F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-4.25F, 1.1124F, -0.1464F);
		bow.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.1298F, 0.017F, 0.1298F);
		cube_r2.setTextureOffset(0, 8).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-4.25F, 0.5F, -0.5F);
		bow.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.2597F, 0.0338F, 0.1265F);
		cube_r3.setTextureOffset(0, 3).addBox(-0.5F, -1.5F, -0.75F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-4.5F, -0.5F, -1.5F);
		bow.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.0472F, 0.3923F, -0.0181F);
		cube_r4.setTextureOffset(14, 16).addBox(0.25F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);
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