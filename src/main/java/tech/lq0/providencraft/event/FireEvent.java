package tech.lq0.providencraft.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

//Forked from TaC
public class FireEvent extends PlayerEvent {
    private final ItemStack stack;

    public FireEvent(PlayerEntity player, ItemStack stack) {
        super(player);
        this.stack = stack;
    }

    public ItemStack getStack() {
        return stack;
    }

    public boolean isClient() {
        return this.getPlayer().getEntityWorld().isRemote();
    }

    @Cancelable
    public static class Pre extends FireEvent {
        public Pre(PlayerEntity player, ItemStack stack) {
            super(player, stack);
        }
    }

    public static class Post extends FireEvent {
        public Post(PlayerEntity player, ItemStack stack) {
            super(player, stack);
        }
    }
}
