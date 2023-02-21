package tech.lq0.providencraft.render.animation.models;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

//Forked from MrCrayfish and TaC
@Mod.EventBusSubscriber(modid = Utils.MOD_ID, value = Dist.CLIENT)
public class ModelOverrides {
    private static final Map<Item, IOverrideModel> MODEL_MAP = new HashMap<>();

    public static void register(Item item, IOverrideModel model) {
        if(MODEL_MAP.putIfAbsent(item, model) == null) {
            MinecraftForge.EVENT_BUS.register(model);
        }
    }

    public static boolean hasModel(ItemStack stack) {
        return MODEL_MAP.containsKey(stack.getItem());
    }

    @Nullable
    public static IOverrideModel getModel(ItemStack stack) {
        return MODEL_MAP.get(stack.getItem());
    }

    @SubscribeEvent
    public static void onClientPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.phase == TickEvent.Phase.START && event.side == LogicalSide.CLIENT) //  && event.type == TickEvent.Type.RENDER
        {
            tick(event.player);
        }
    }

    private static void tick(PlayerEntity player) {
        ItemStack heldItem = player.getHeldItemMainhand();
        if(!heldItem.isEmpty() && heldItem.getItem() instanceof Trachelium) {
            IOverrideModel model = ModelOverrides.getModel(heldItem);
            if(model != null) {
                model.tick(player);
            }
        }
    }
}
