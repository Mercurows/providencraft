package tech.lq0.providencraft.item.madoka;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

public class RedAhogeHelmet extends ArmorItem{
    public RedAhogeHelmet(){
        super(ModArmorMaterial.RED_AHOGE, EquipmentSlotType.HEAD,new Properties().group(ModGroup.itemgroup));
    }



}
