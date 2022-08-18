package tech.lq0.providencraft.item.providencethird.leciel;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class LecielEarCoverts extends ArmorItem {
    public LecielEarCoverts(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().maxDamage(285).group(ModGroup.itemgroup));
    }
}
