package tech.lq0.providencraft.register;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EnchantRegistry;
import tech.lq0.providencraft.init.ItemRegistry;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EnchantRegister {
    //呆毛寄生附魔
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        Entity entity = event.getSource().getImmediateSource();
        int times = 2;
        if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack heldItem = player.getHeldItemMainhand();
            int level = EnchantmentHelper.getEnchantmentLevel(EnchantRegistry.AHOGE_PARASITIC.get(), heldItem);

            if (player.getHealth() < player.getMaxHealth()) {
                ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
                if (!helmet.equals(null)) {
                    if (!helmet.isEmpty()&&helmet.getItem().equals(ItemRegistry.RED_AHOGE_HELMET.get())) {
                        times++;
                    }
                }
                if(heldItem.getItem().equals(ItemRegistry.RED_AHOGE_SWORD.get())||
                        heldItem.getItem().equals(ItemRegistry.RED_AHOGE_BOOMERANG.get())){
                    times++;
                }
            }
            player.heal(level * times);
        }
    }
}
