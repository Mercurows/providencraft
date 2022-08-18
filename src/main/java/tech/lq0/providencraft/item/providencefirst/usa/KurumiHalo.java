package tech.lq0.providencraft.item.providencefirst.usa;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class KurumiHalo extends ArmorItem {
    public KurumiHalo(){
        super(ArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(535).group(ModGroup.itemgroup));
    }
}
