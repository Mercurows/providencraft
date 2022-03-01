package tech.lq0.providencraft.register;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EnchantInit;
import tech.lq0.providencraft.init.ItemInit;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EnchantRegister {
    //呆毛寄生附魔
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        Entity entity = event.getSource().getImmediateSource();
        if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack heldItem = player.getHeldItemMainhand();
            int level = EnchantmentHelper.getEnchantmentLevel(EnchantInit.AHOGE_PARASITIC.get(), heldItem);

            if (player.getHealth() < player.getMaxHealth()) {
                ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
                if (!helmet.equals(null)) {
                    if (!helmet.isEmpty()&&helmet.getItem().equals(ItemInit.RED_AHOGE_HELMET.get())) {
                        player.setHealth(player.getHealth() + level * 3.0f > player.getMaxHealth()?
                                player.getMaxHealth():player.getHealth() + level * 3.0f );
                    } else {
                        player.setHealth(player.getHealth() + level * 2.0f > player.getMaxHealth()?
                                player.getMaxHealth():player.getHealth() + level * 2.0f );
                    }
                }
            }
        }
    }
}
