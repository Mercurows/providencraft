package tech.lq0.providencraft.item.providencesecond.mumu;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

public class AyeletMask extends ArmorItem {
    public AyeletMask(){
        super(ModArmorMaterial.CRYSTAL, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(515).setNoRepair().group(ModGroup.itemgroup));
    }
}
