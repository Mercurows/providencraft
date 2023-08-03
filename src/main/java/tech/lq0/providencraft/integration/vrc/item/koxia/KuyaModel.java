package tech.lq0.providencraft.integration.vrc.item.koxia;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

@SuppressWarnings("FieldCanBeLocal")
public class KuyaModel extends EntityModel<KuyaEntity> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer ears;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer legs;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer bow;
	private final ModelRenderer bow_r1;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public KuyaModel() {
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);


		head = new ModelRenderer(this);
		head.setRotationPoint(-0.5F, 0.75F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-3.0F, -12.0F, -2.5F, 7.0F, 4.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 9).addBox(-2.5F, -13.0F, -2.5F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(1, 10).addBox(-2.5F, -8.75F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(ears);


		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-3.0F, -13.0F, 0.0F);
		ears.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3927F);
		cube_r1.setTextureOffset(26, 11).addBox(-1.0F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(4.0F, -13.0F, 0.0F);
		ears.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.3927F);
		cube_r2.setTextureOffset(26, 4).addBox(-1.0F, -0.75F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 15).addBox(-3.0F, -7.0F, -1.5F, 6.0F, 6.0F, 3.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, -3.3388F, -0.8719F);
		body.addChild(arms);
		setRotationAngle(arms, 1.0472F, 0.0F, 0.0F);


		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(3.5F, 0.0F, 0.0F);
		arms.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.1745F, 0.0F);
		cube_r3.setTextureOffset(24, 23).addBox(-1.0F, -0.7954F, -1.3681F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(3.5F, 0.0F, 0.0F);
		arms.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.2182F, -0.1745F, 0.0F);
		cube_r4.setTextureOffset(18, 17).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-3.5F, 0.0F, 0.0F);
		arms.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.1745F, 0.0F);
		cube_r5.setTextureOffset(8, 24).addBox(-1.0F, -0.7954F, -1.3681F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-3.5F, 0.0F, 0.0F);
		arms.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.2182F, 0.1745F, 0.0F);
		cube_r6.setTextureOffset(18, 11).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, -2.0F, 0.0F);
		body.addChild(legs);


		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(1.75F, 4.8453F, -0.9791F);
		legs.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.4363F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(0, 24).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r7.setTextureOffset(22, 7).addBox(-4.5F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.75F, 2.75F, -0.25F);
		legs.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.1745F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(16, 23).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r8.setTextureOffset(19, 0).addBox(-4.5F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(0.2677F, -6.0984F, -1.8293F);
		body.addChild(bow);
		setRotationAngle(bow, 0.0F, -0.1309F, 0.0F);
		bow.setTextureOffset(0, 12).addBox(-0.7677F, -0.6516F, -0.1707F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bow.setTextureOffset(0, 9).addBox(-2.7328F, -0.9623F, -0.1707F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bow_r1 = new ModelRenderer(this);
		bow_r1.setRotationPoint(1.2712F, -0.0754F, -0.2752F);
		bow.addChild(bow_r1);
		setRotationAngle(bow_r1, 0.0F, 0.48F, 0.0F);
		bow_r1.setTextureOffset(0, 3).addBox(0.0663F, 0.1892F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bow_r1.setTextureOffset(0, 0).addBox(0.0663F, -0.8108F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.9634F, -0.3798F, -0.1149F);
		bow.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.1122F, 0.4677F, -0.2449F);
		cube_r9.setTextureOffset(26, 17).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.2712F, -0.0754F, -0.2752F);
		bow.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.1966F, 0.4407F, 0.4369F);
		cube_r10.setTextureOffset(25, 0).addBox(-1.1603F, -0.0606F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-1.5002F, 0.1931F, 0.3293F);
		bow.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.3927F);
		cube_r11.setTextureOffset(26, 19).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-1.2296F, 0.1571F, 0.3293F);
		bow.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.3927F);
		cube_r12.setTextureOffset(24, 26).addBox(-1.5F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(KuyaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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