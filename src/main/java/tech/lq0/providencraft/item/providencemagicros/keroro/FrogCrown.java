package tech.lq0.providencraft.item.providencemagicros.keroro;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class FrogCrown extends ArmorItem {
    public FrogCrown(){
        super(ArmorMaterial.GOLD, EquipmentSlotType.HEAD, new Properties().setNoRepair().defaultMaxDamage(302).group(ModGroup.itemgroup));
    }
}
