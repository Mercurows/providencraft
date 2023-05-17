package tech.lq0.providencraft.models;// Made with Blockbench 4.6.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tech.lq0.providencraft.entity.projectile.CursedCatDollEntity;

public class CursedCatDollModel extends EntityModel<CursedCatDollEntity> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer ears;
	private final ModelRenderer eyes;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer neck;
	private final ModelRenderer flower_r1;
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer legs;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;

	public CursedCatDollModel() {
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -3.0F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(14, 15).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 1.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(18, 10).addBox(-3.5F, -10.5F, -2.0F, 7.0F, 1.0F, 4.0F, 0.0F, false);

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(ears);
		ears.setTextureOffset(26, 26).addBox(5.5F, -7.75F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		ears.setTextureOffset(26, 2).addBox(5.0F, -8.75F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		ears.setTextureOffset(20, 22).addBox(4.0F, -9.75F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		ears.setTextureOffset(16, 30).addBox(-6.5F, -7.75F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		ears.setTextureOffset(10, 26).addBox(-6.0F, -8.75F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		ears.setTextureOffset(0, 25).addBox(-5.0F, -9.75F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(eyes);
		eyes.setTextureOffset(0, 38).addBox(1.25F, -8.25F, -2.75F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		eyes.setTextureOffset(15, 10).addBox(-3.25F, -8.25F, -2.75F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		eyes.setTextureOffset(3, 0).addBox(-2.75F, -6.05F, -2.55F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(0.0F, -0.5F, 0.75F);
		head.addChild(bow);
		bow.setTextureOffset(36, 29).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-5.4858F, -9.9217F, -2.7446F);
		bow.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.1719F, -0.4971F, -0.3492F);
		cube_r1.setTextureOffset(36, 10).addBox(0.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(5.4858F, -9.9217F, -2.7446F);
		bow.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1719F, 0.4971F, 0.3492F);
		cube_r2.setTextureOffset(14, 36).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.799F, -10.5F, -0.616F);
		bow.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.5236F, 0.0F);
		cube_r3.setTextureOffset(32, 15).addBox(-1.5F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.9821F, -11.0F, -0.366F);
		bow.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.0692F, 0.2527F, -0.2706F);
		cube_r4.setTextureOffset(26, 23).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(4.6177F, -11.3744F, -1.0722F);
		bow.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.035F, 0.2595F, 0.1355F);
		cube_r5.setTextureOffset(21, 2).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-4.6177F, -11.3744F, -1.0722F);
		bow.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.035F, -0.2595F, -0.1355F);
		cube_r6.setTextureOffset(32, 26).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-1.9821F, -11.0F, -0.366F);
		bow.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.0692F, -0.2527F, 0.2706F);
		cube_r7.setTextureOffset(32, 2).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-1.799F, -10.5F, -0.616F);
		bow.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -0.5236F, 0.0F);
		cube_r8.setTextureOffset(26, 32).addBox(-2.5F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(neck);
		neck.setTextureOffset(21, 0).addBox(-3.5F, -4.75F, -2.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		neck.setTextureOffset(20, 20).addBox(-3.5F, -4.75F, 1.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		neck.setTextureOffset(32, 18).addBox(3.0F, -4.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		neck.setTextureOffset(32, 5).addBox(-4.0F, -4.75F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		flower_r1 = new ModelRenderer(this);
		flower_r1.setRotationPoint(-3.75F, -4.25F, -2.25F);
		neck.addChild(flower_r1);
		setRotationAngle(flower_r1, 0.0F, 0.7854F, 0.0F);
		flower_r1.setTextureOffset(22, 30).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -3.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 10).addBox(-3.0F, -4.0F, -1.5F, 6.0F, 6.0F, 3.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, -2.5454F, -2.6181F);
		body.addChild(arms);
		setRotationAngle(arms, 0.1745F, 0.0F, 0.0F);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(3.5F, 0.2462F, 0.2066F);
		arms.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.1745F, 0.0F);
		cube_r9.setTextureOffset(8, 19).addBox(-1.0F, -0.7954F, -2.3681F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(3.5F, 0.2462F, 0.2066F);
		arms.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.2182F, -0.1745F, 0.0F);
		cube_r10.setTextureOffset(0, 19).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-3.5F, 0.2462F, 0.2066F);
		arms.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.1745F, 0.0F);
		cube_r11.setTextureOffset(6, 25).addBox(-1.0F, -0.7954F, -2.3681F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-3.5F, 0.2462F, 0.2066F);
		arms.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.2182F, 0.1745F, 0.0F);
		cube_r12.setTextureOffset(12, 20).addBox(-1.0F, -0.9036F, -0.6201F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 1.0F, 0.0F);
		body.addChild(legs);
		

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(1.75F, 4.8453F, -0.9791F);
		legs.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.4363F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(8, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(24, 35).addBox(-4.5F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(1.75F, 2.75F, -0.25F);
		legs.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.1745F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(0, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		cube_r14.setTextureOffset(32, 35).addBox(-4.5F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-1.25F, 2.5584F, 2.0627F);
		main.addChild(tail);
		setRotationAngle(tail, 0.0F, 0.0F, 0.2182F);
		tail.setTextureOffset(20, 22).addBox(-0.5F, -0.3153F, -0.1092F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.0F, 4.47F, -0.3709F);
		tail.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.2618F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.0F, 1.6108F, 0.2645F);
		tail.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.1309F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(16, 26).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(0.0F, -1.2415F, 0.2645F);
		tail.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.1309F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(0, 19).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.0F, -4.0584F, -0.3127F);
		tail.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.3491F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(0, 25).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(CursedCatDollEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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