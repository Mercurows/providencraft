package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class ElectricTail extends ArmorItem {
    public ElectricTail(){
        super(ArmorMaterial.IRON, EquipmentSlotType.LEGS, new Properties().group(ModGroup.itemgroup));
    }
}
