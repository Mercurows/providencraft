package tech.lq0.providencraft.register;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.VillagerInit;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VillagerEvent {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            VillagerInit.fillTradeData();
            VillagerInit.registerElifausPOI();
            VillagerInit.registerRuozhiPOI();
        });
    }
}
