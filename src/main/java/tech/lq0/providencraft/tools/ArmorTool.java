package tech.lq0.providencraft.tools;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import tech.lq0.providencraft.init.ItemRegistry;

public class ArmorTool {

    public static boolean hasArmorSet(PlayerEntity player){
        if(player == null){
            return false;
        }

        return player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemRegistry.BREEZE_CROWN.get()
                && player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.MISTY_CHESTPLATE.get()
                && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemRegistry.FROGGY_LEGGINGS.get()
                && player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.CELESTIAL_BOOTS.get();
    }
}
