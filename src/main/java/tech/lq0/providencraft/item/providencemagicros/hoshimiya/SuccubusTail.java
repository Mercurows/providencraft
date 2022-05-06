package tech.lq0.providencraft.item.providencemagicros.hoshimiya;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Rarity;
import tech.lq0.providencraft.group.ModGroup;

public class SuccubusTail extends ArmorItem {
    public SuccubusTail(){
        super(ArmorMaterial.CHAIN, EquipmentSlotType.LEGS, new Properties().defaultMaxDamage(530).setNoRepair().rarity(Rarity.RARE).group(ModGroup.itemgroup));
    }
}
