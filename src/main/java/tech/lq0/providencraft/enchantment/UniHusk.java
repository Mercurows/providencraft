package tech.lq0.providencraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class UniHusk extends Enchantment {
    private static final EquipmentSlotType[] CHEST = new EquipmentSlotType[]{EquipmentSlotType.CHEST};

    public UniHusk() {
        super(Rarity.RARE, EnchantmentType.ARMOR_CHEST, CHEST);
    }

    public int getMinEnchantability(int level){
        return 8+6*level;
    }

    public int getMaxEnchantability(int level){
        return super.getMinEnchantability(level)+20;
    }

    public int getMaxLevel(){
        return 3;
    }
}
