package tech.lq0.providencraft.item.costume.magicros.hoshimiya;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

public class EkiraIdolBoots extends ArmorItem {
    public EkiraIdolBoots(){
        super(ModArmorMaterial.IDOL_COSTUME, EquipmentSlotType.FEET, new Properties().group(ModGroup.costumegroup));
    }
}
