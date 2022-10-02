package tech.lq0.providencraft.register;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tech.lq0.providencraft.init.EntityRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributesRegister {
    @SubscribeEvent
    public static void setupAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(EntityRegistry.NIIT_CAR_ENTITY.get(), MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).create());
            GlobalEntityTypeAttributes.put(EntityRegistry.NIIT_CAR_ENTITY.get(), MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D).create());
        });
    }
}
