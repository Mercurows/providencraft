package tech.lq0.providencraft.register.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.ItemRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AtsuiShioRegister {
    public static final String TAG_BURN = "burning";

    @SubscribeEvent
    public static void SetBurning(LivingEntityUseItemEvent.Finish event){
        LivingEntity livingEntity = event.getEntityLiving();
        ItemStack itemStack = event.getItem();
        if(livingEntity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) livingEntity;
            if(!player.world.isRemote && itemStack.getItem().equals(ItemRegistry.ATSUISHIO.get())){
                event.setDuration(2);
                player.addTag(TAG_BURN);
            }
        }
    }

    @SubscribeEvent
    public static void DoBurning(TickEvent.PlayerTickEvent event){
        PlayerEntity player = event.player;
        if(!player.world.isRemote && player.getTags().contains(TAG_BURN)){
            player.setFire(1);
        }
        if(!player.isAlive()){
            player.removeTag(TAG_BURN);
        }
    }
}
