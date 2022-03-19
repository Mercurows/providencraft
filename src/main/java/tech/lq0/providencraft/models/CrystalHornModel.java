package tech.lq0.providencraft.models;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class CrystalHornModel<T extends LivingEntity> extends BipedModel<T> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public CrystalHornModel(float modelSize, EquipmentSlotType slot, LivingEntity entity) {
		super(modelSize, 0.0f, 64, 64);
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.0F, -4.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(12, 2).addBox(2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(28, 31).addBox(5.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(20, 15).addBox(6.0F, -7.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(10, 19).addBox(7.0F, -8.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(10, 29).addBox(8.0F, -7.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(0, 6).addBox(3.0F, -9.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(32, 6).addBox(5.0F, -7.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(22, 5).addBox(2.0F, -10.0F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(30, 15).addBox(2.0F, -11.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(0, 29).addBox(2.0F, -14.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(26, 15).addBox(3.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(18, 34).addBox(2.0F, -17.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.0F, -4.0F, 0.0F);
		bone.addChild(bone3);
		bone3.setTextureOffset(0, 12).addBox(-5.0F, -3.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(22, 28).addBox(-6.0F, -4.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(0, 19).addBox(-7.0F, -7.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(14, 9).addBox(-8.0F, -8.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(26, 21).addBox(-9.0F, -7.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(-7.0F, -9.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(32, 1).addBox(-6.0F, -7.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(22, 0).addBox(-5.0F, -10.0F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(24, 10).addBox(-4.0F, -11.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(16, 25).addBox(-3.0F, -14.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(6, 19).addBox(-4.0F, -13.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone3.setTextureOffset(32, 20).addBox(-3.0F, -17.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.copyModelAngles(this.bipedHead);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}