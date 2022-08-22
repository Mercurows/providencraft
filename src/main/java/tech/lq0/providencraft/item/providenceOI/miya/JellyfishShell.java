package tech.lq0.providencraft.item.providenceOI.miya;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class JellyfishShell extends ArmorItem {
    public JellyfishShell(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup).maxDamage(207).setNoRepair());
    }
}
