package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class ElectricHorn extends ArmorItem {
    public ElectricHorn() {
        super(ArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(1145).group(ModGroup.itemgroup));
    }
}
