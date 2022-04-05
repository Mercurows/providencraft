package tech.lq0.providencraft.item.providencesecond.mumu;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.models.AyeletMaskModel;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

import javax.annotation.Nullable;

public class AyeletMask extends ArmorItem {
    public AyeletMask(){
        super(ModArmorMaterial.CRYSTAL, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(515).setNoRepair().group(ModGroup.itemgroup));
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new AyeletMaskModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/ayelet_mask_model_texture.png";
    }
}
