package tech.lq0.providencraft.integration.vrc;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.integration.CompatHandler;
import tech.lq0.providencraft.integration.vrc.item.koxia.KuyaEntityRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class VirtuaRealCraftHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        if(CompatHandler.virtuarealcraft) {
            RenderingRegistry.registerEntityRenderingHandler(VirtuaRealCraftRegistry.KUYA_ENTITY.get(), KuyaEntityRenderer::new);
        }
    }
}
