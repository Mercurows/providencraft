package tech.lq0.providencraft.item.magicros.keroro;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class RedNose extends ArmorItem {
    public RedNose(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(302).setNoRepair().group(ModGroup.itemgroup));
    }
}
