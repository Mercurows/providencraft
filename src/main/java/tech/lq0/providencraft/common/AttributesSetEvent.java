package tech.lq0.providencraft.common;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tech.lq0.providencraft.init.AttributeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributesSetEvent {
    @SubscribeEvent
    public static void setupAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
                GlobalEntityTypeAttributes.put(EntityType.PLAYER, PlayerEntity.func_234570_el_().createMutableAttribute(AttributeRegistry.CHAOS.get(), 0.0D).create());
            }
        );
    }
}