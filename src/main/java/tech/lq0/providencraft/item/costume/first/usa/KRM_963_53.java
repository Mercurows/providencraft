package tech.lq0.providencraft.item.costume.first.usa;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Rarity;
import tech.lq0.providencraft.group.ModGroup;

public class KRM_963_53 extends ArmorItem {
    public KRM_963_53(){
        super(ArmorMaterial.NETHERITE, EquipmentSlotType.CHEST, new Properties().defaultMaxDamage(963).rarity(Rarity.EPIC).group(ModGroup.costumegroup));
    }
}
