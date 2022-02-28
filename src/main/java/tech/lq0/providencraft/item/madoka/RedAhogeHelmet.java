package tech.lq0.providencraft.item.madoka;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.ModArmorMaterial;
import tech.lq0.providencraft.ModGroup;
import tech.lq0.providencraft.init.ItemInit;

public class RedAhogeHelmet extends ArmorItem{
    public RedAhogeHelmet(){
        super(ModArmorMaterial.RED_AHOGE, EquipmentSlotType.HEAD,new Properties().group(ModGroup.itemgroup));
    }



}
