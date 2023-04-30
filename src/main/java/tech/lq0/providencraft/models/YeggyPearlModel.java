package tech.lq0.providencraft.models;// Made with Blockbench 4.7.0
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class YeggyPearlModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer flower;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cloth;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer wires;
	private final ModelRenderer wire1;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer wire2;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer wire3;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer wire4;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer bow;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer pearl;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;

	public YeggyPearlModel() {
		super(1.0f);
		textureWidth = 32;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		flower = new ModelRenderer(this);
		flower.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(flower);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(8.8437F, -14.3009F, -9.073F);
		flower.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2618F, -0.6109F, 0.0F);
		cube_r1.setTextureOffset(0, 5).addBox(-2.1F, -2.7F, 0.1F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(8.1595F, -14.7244F, -8.1497F);
		flower.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.6021F, -0.2834F, 0.7473F);
		cube_r2.setTextureOffset(9, 9).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		cloth = new ModelRenderer(this);
		cloth.setRotationPoint(0.2F, 0.0F, 0.25F);
		main.addChild(cloth);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(8.0286F, -8.1359F, -7.6055F);
		cloth.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.153F, -0.9621F, -0.1165F);
		cube_r3.setTextureOffset(14, 6).addBox(-1.0925F, -1.9428F, -0.3076F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(7.8286F, -8.1359F, -7.6055F);
		cloth.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.2473F, -0.5352F, 0.0291F);
		cube_r4.setTextureOffset(6, 14).addBox(-2.2425F, -1.7869F, -0.9212F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(8.1728F, -6.5981F, -7.871F);
		cloth.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.1745F, -1.0908F, 0.0F);
		cube_r5.setTextureOffset(10, 14).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(7.6286F, -6.1359F, -7.5055F);
		cloth.addChild(cube_r6);
		setRotationAngle(cube_r6, 2.6337F, -1.5199F, -2.7175F);
		cube_r6.setTextureOffset(12, 0).addBox(0.4171F, -1.8798F, -0.6444F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(7.8286F, -8.1359F, -7.9055F);
		cloth.addChild(cube_r7);
		setRotationAngle(cube_r7, 2.5464F, -1.5199F, -2.7175F);
		cube_r7.setTextureOffset(14, 3).addBox(0.4171F, -1.8798F, -0.6444F, 2.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(6.1571F, -11.2718F, -9.011F);
		cloth.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.2243F, 0.0282F, 0.1559F);
		cube_r8.setTextureOffset(8, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(8.7F, -11.2F, -7.2F);
		cloth.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.0479F, -1.0495F, -0.042F);
		cube_r9.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(7.4652F, -11.2228F, -8.4294F);
		cloth.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.1335F, -0.3972F, -0.0721F);
		cube_r10.setTextureOffset(10, 5).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		wires = new ModelRenderer(this);
		wires.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(wires);
		

		wire1 = new ModelRenderer(this);
		wire1.setRotationPoint(7.468F, -10.1528F, -10.0524F);
		wires.addChild(wire1);
		setRotationAngle(wire1, -0.0386F, 0.0385F, 0.0674F);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-0.4585F, 0.1918F, 0.7941F);
		wire1.addChild(cube_r11);
		setRotationAngle(cube_r11, 2.7925F, -0.5236F, 0.0F);
		cube_r11.setTextureOffset(12, 3).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-0.043F, 1.2404F, 0.0745F);
		wire1.addChild(cube_r12);
		setRotationAngle(cube_r12, 1.789F, -0.5236F, 0.0F);
		cube_r12.setTextureOffset(16, 2).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(0.3068F, 0.8945F, -0.5314F);
		wire1.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.4363F, -0.5236F, 0.0F);
		cube_r13.setTextureOffset(18, 2).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.3691F, -0.0511F, -0.6392F);
		wire1.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.1745F, -0.5236F, 0.0F);
		cube_r14.setTextureOffset(18, 3).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-0.0494F, -1.8425F, 0.0855F);
		wire1.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.5236F, -0.5236F, 0.0F);
		cube_r15.setTextureOffset(12, 17).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		wire2 = new ModelRenderer(this);
		wire2.setRotationPoint(10.3822F, -10.1575F, -6.9231F);
		wires.addChild(wire2);
		setRotationAngle(wire2, 0.0F, -0.6545F, 0.0F);
		

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-0.8173F, 0.1918F, 0.6833F);
		wire2.addChild(cube_r16);
		setRotationAngle(cube_r16, 2.7925F, -0.5236F, 0.0F);
		cube_r16.setTextureOffset(0, 10).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-0.4018F, 1.2404F, -0.0363F);
		wire2.addChild(cube_r17);
		setRotationAngle(cube_r17, 1.789F, -0.5236F, 0.0F);
		cube_r17.setTextureOffset(7, 10).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-0.052F, 0.8945F, -0.6422F);
		wire2.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.4363F, -0.5236F, 0.0F);
		cube_r18.setTextureOffset(6, 12).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0103F, -0.0511F, -0.75F);
		wire2.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.1745F, -0.5236F, 0.0F);
		cube_r19.setTextureOffset(6, 13).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-0.4081F, -1.8425F, -0.0253F);
		wire2.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.5236F, -0.5236F, 0.0F);
		cube_r20.setTextureOffset(10, 17).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		wire3 = new ModelRenderer(this);
		wire3.setRotationPoint(0.0F, 0.0F, 0.0F);
		wires.addChild(wire3);
		

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(8.929F, -3.251F, -10.1034F);
		wire3.addChild(cube_r21);
		setRotationAngle(cube_r21, -0.0873F, -0.6545F, 0.0F);
		cube_r21.setTextureOffset(2, 18).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(8.6114F, -7.213F, -9.6896F);
		wire3.addChild(cube_r22);
		setRotationAngle(cube_r22, -0.1745F, -0.6545F, 0.0F);
		cube_r22.setTextureOffset(0, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(8.7601F, -11.8389F, -8.2407F);
		wire3.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.2618F, -0.6545F, 0.0F);
		cube_r23.setTextureOffset(8, 17).addBox(-1.5F, -1.25F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		wire4 = new ModelRenderer(this);
		wire4.setRotationPoint(9.3315F, -9.1638F, -8.2238F);
		wires.addChild(wire4);
		setRotationAngle(wire4, 0.0346F, -0.3135F, -0.0379F);
		

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(0.2633F, 1.9507F, -0.3431F);
		wire4.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.1745F, -0.6545F, 0.0F);
		cube_r24.setTextureOffset(14, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(0.4119F, -2.6752F, 1.1059F);
		wire4.addChild(cube_r25);
		setRotationAngle(cube_r25, -0.2618F, -0.6545F, 0.0F);
		cube_r25.setTextureOffset(6, 17).addBox(-1.5F, -1.25F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		bow = new ModelRenderer(this);
		bow.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(bow);
		

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(9.15F, -12.0F, -7.0F);
		bow.addChild(cube_r26);
		setRotationAngle(cube_r26, -0.0752F, 0.5187F, -0.4999F);
		cube_r26.setTextureOffset(0, 10).addBox(-0.5F, -2.0F, -0.9F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(7.0F, -11.5F, -9.25F);
		bow.addChild(cube_r27);
		setRotationAngle(cube_r27, 1.0908F, -0.5236F, 0.2269F);
		cube_r27.setTextureOffset(0, 0).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		pearl = new ModelRenderer(this);
		pearl.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(pearl);
		pearl.setTextureOffset(16, 16).addBox(5.5F, -14.25F, -9.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(10.0F, -13.75F, -8.0F);
		pearl.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, -0.6981F, 0.0F);
		cube_r28.setTextureOffset(16, 14).addBox(-1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(8.6618F, -11.8424F, -9.0959F);
		pearl.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0994F, -0.5754F, 0.1544F);
		cube_r29.setTextureOffset(16, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(7.5618F, -12.3424F, -9.7959F);
		pearl.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.3829F, -0.0651F, -0.0068F);
		cube_r30.setTextureOffset(4, 10).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(6.0F, -12.75F, -9.75F);
		pearl.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.2182F, 0.0F, -0.3054F);
		cube_r31.setTextureOffset(2, 16).addBox(-0.25F, -0.25F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.main.copyModelAngles(this.bipedHead);
		matrixStack.push();
		matrixStack.scale(0.5f, 0.5f, 0.5f);
//		matrixStack.translate(0.12f, -0.1f, 0.0f);
		main.render(matrixStack, buffer, packedLight, packedOverlay);
		matrixStack.pop();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}