package tech.lq0.providencraft.item.providenceOI.yyky;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class LunaticBow extends ArmorItem {
    public LunaticBow(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(928).setNoRepair().group(ModGroup.itemgroup));
    }
}
