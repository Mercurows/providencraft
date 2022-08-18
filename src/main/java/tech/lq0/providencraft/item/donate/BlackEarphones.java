package tech.lq0.providencraft.item.donate;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class BlackEarphones extends ArmorItem {
    public BlackEarphones(){
        super(ArmorMaterial.IRON, EquipmentSlotType.HEAD, new Properties().defaultMaxDamage(325).group(ModGroup.donategroup));
    }
}
