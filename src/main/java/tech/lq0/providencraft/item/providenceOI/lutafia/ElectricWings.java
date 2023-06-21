package tech.lq0.providencraft.item.providenceOI.lutafia;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class ElectricWings extends ArmorItem {
    public ElectricWings(){
        super(ArmorMaterial.IRON, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup));
    }
}
