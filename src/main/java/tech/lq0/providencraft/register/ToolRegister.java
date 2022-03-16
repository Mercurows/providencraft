package tech.lq0.providencraft.register;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.ItemRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ToolRegister {

    //铁坨子的击退效果
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event){
        LivingEntity entity = event.getEntityLiving();

        Entity entityP = event.getSource().getImmediateSource();
        if (entityP instanceof PlayerEntity && !entityP.world.isRemote()) {
            PlayerEntity player = (PlayerEntity) entityP;
            ItemStack heldItem = player.getHeldItemMainhand();
            if (heldItem.getItem().equals(ItemRegistry.FETUOZI.get())) {
                entity.applyKnockback(10.0f,player.getPosX()-entity.getPosX(),player.getPosZ()-entity.getPosZ());
            }
        }
    }
}
