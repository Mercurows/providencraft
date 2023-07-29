package tech.lq0.providencraft.models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("FieldCanBeLocal")
public class SneakersModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer left_total;
	private final ModelRenderer left;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer right_total;
	private final ModelRenderer right;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public SneakersModel() {
		super(1.0f);
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 1.0F, 0.0F);
		

		left_total = new ModelRenderer(this);
		left_total.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.addChild(left_total);
		

		left = new ModelRenderer(this);
		left.setRotationPoint(-2.0F, 11.8F, 0.0F);
		left_total.addChild(left);
		left.setTextureOffset(0, 5).addBox(0.0F, -0.75F, -3.75F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		left.setTextureOffset(26, 18).addBox(0.0F, -0.75F, 1.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(10, 25).addBox(0.0F, -0.75F, 1.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(26, 16).addBox(0.0F, -0.85F, 0.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left.setTextureOffset(16, 13).addBox(3.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		left.setTextureOffset(0, 30).addBox(3.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		left.setTextureOffset(28, 28).addBox(-0.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		left.setTextureOffset(12, 1).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		left.setTextureOffset(14, 20).addBox(-0.25F, -1.0F, -4.0F, 4.5F, 1.0F, 2.0F, 0.0F, false);
		left.setTextureOffset(22, 3).addBox(-0.5F, -3.0F, 2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, -1.5F, -2.5F);
		left.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.5708F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(6, 12).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(22, 14).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(2.5F, -1.4142F, -2.5858F);
		left.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.5708F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(20, 25).addBox(-2.5F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.5F, -1.0F, -3.2929F);
		left.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.7854F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 20).addBox(-1.75F, -0.5F, -0.5F, 4.5F, 1.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(4.0F, -3.0F, -2.9F);
		left.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, 0.3927F);
		cube_r4.setTextureOffset(28, 20).addBox(-1.5F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(2.1157F, -2.0751F, -3.0F);
		left.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 1.5708F, 0.0F);
		cube_r5.setTextureOffset(28, 7).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(4.0F, -2.75F, -2.75F);
		left.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 1.5708F, 0.3927F);
		cube_r6.setTextureOffset(28, 25).addBox(-0.25F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		right_total = new ModelRenderer(this);
		right_total.setRotationPoint(0.0F, 24.0F, 0.0F);
		main.addChild(right_total);
		

		right = new ModelRenderer(this);
		right.setRotationPoint(2.0F, 11.8F, 0.0F);
		right_total.addChild(right);
		right.setTextureOffset(0, 0).addBox(-4.0F, -0.75F, -3.75F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		right.setTextureOffset(0, 25).addBox(-4.0F, -0.75F, 1.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(20, 23).addBox(-4.0F, -0.75F, 1.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(10, 23).addBox(-4.0F, -0.85F, 0.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		right.setTextureOffset(10, 10).addBox(-4.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		right.setTextureOffset(24, 27).addBox(-4.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		right.setTextureOffset(0, 27).addBox(-0.5F, -1.0F, -3.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		right.setTextureOffset(0, 10).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		right.setTextureOffset(18, 0).addBox(-4.25F, -1.0F, -4.0F, 4.5F, 1.0F, 2.0F, 0.0F, false);
		right.setTextureOffset(16, 8).addBox(-4.5F, -3.0F, 2.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-2.0F, -1.5F, -2.5F);
		right.addChild(cube_r7);
		setRotationAngle(cube_r7, 1.5708F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(6, 10).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(22, 12).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-2.5F, -1.4142F, -2.5858F);
		right.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.5708F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 23).addBox(-1.5F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-1.5F, -1.0F, -3.2929F);
		right.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.7854F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 17).addBox(-2.75F, -0.5F, -0.5F, 4.5F, 1.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-4.0F, -3.0F, -2.9F);
		right.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, -1.5708F, -0.3927F);
		cube_r10.setTextureOffset(6, 27).addBox(0.5F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-2.1157F, -2.0751F, -3.0F);
		right.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -1.5708F, 0.0F);
		cube_r11.setTextureOffset(12, 27).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-4.0F, -2.75F, -2.75F);
		right.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -1.5708F, -0.3927F);
		cube_r12.setTextureOffset(18, 27).addBox(-0.75F, 0.5F, -0.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.left_total.copyModelAngles(this.bipedLeftLeg);
		this.right_total.copyModelAngles(this.bipedRightLeg);
		main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}