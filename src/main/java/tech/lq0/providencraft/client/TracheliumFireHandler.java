package tech.lq0.providencraft.client;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import tech.lq0.providencraft.entity.TracheliumBulletEntity;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;
import tech.lq0.providencraft.network.TracheliumPack;


public class TracheliumFireHandler {

    public static void fireHandler(TracheliumPack pack, ServerPlayerEntity player) {
        if(!player.isSpectator()) {
            World world = player.world;
            ItemStack itemStack = player.getHeldItem(Hand.MAIN_HAND);
            if(itemStack.getItem() == ItemRegistry.TRACHELIUM.get()) {
                if(Trachelium.getAmmo(itemStack) != 0) {

                    player.rotationYaw = pack.getYaw();
                    player.rotationPitch = pack.getPitch();

                    Trachelium.shoot(itemStack, player);

                    TracheliumBulletEntity entity = new TracheliumBulletEntity(EntityRegistry.TRACHELIUM_BULLET_ENTITY.get(), world, player, 0);
                    world.addEntity(entity);
                    entity.tick();

                }else {
                    world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3F, 0.8F);
                }
            }

        }
    }
}
