package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

public class Sneakers extends ArmorItem {
    public Sneakers() {
        super(ModArmorMaterial.RED_AHOGE, EquipmentSlotType.FEET, new Properties().group(ModGroup.itemgroup));
    }
}
