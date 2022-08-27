package tech.lq0.providencraft.item.providenceOI.ayu;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class GravityRestraintDevice extends ArmorItem {
    public GravityRestraintDevice(){
        super(ArmorMaterial.IRON, EquipmentSlotType.LEGS, new Properties().group(ModGroup.itemgroup));
    }
}
