package tech.lq0.providencraft.common;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.AttributeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributesSetEvent {
    @SubscribeEvent
    public static void createAttributes(EntityAttributeModificationEvent event){
        if (!event.has(EntityType.PLAYER, AttributeRegistry.CHAOS.get())) {
            event.add(EntityType.PLAYER, AttributeRegistry.CHAOS.get());
        }
    }
}