package tech.lq0.providencraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.lq0.providencraft.init.EnchantRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

public class AhogeParasitic extends Enchantment {
    private static final EquipmentSlotType[] MAINHAND = new EquipmentSlotType[]{EquipmentSlotType.MAINHAND};

    public AhogeParasitic() {
        super(Rarity.RARE, EnchantmentType.WEAPON, MAINHAND);
    }

    public int getMinEnchantability(int level){
        return 1+8*(level - 1);
    }

    public int getMaxEnchantability(int level){
        return super.getMinEnchantability(level)+20;
    }

    public int getMaxLevel(){
        return 3;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        if((stack.getItem()== ItemRegistry.RED_AHOGE_BOOMERANG.get())||stack.getItem()== ItemRegistry.RED_AHOGE_SWORD.get()){
            return true;
        }else{
            return super.canApply(stack);
        }
    }
}
