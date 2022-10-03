package tech.lq0.providencraft.render;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.init.EntityRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientSetUpEvent(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.AHOGE_BOOMERANG_ENTITY.get(), AhogeBoomerangEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.PLUNGER_ENTITY.get(), PlungerEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.SEAT_ENTITY.get(), SeatEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.DAIFUKU_SYRUP_ENTITY.get(), DaifukuSyrupEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.FLUFF_BALL_ENTITY.get(), FluffBallEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.KURUMI_BOOMERANG_ENTITY.get(), KurumiBoomerangEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.WHITE_AHOGE_ENTITY.get(), WhiteAhogeEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.NIIT_CAR_ENTITY.get(), NiitCarEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.GOOD_MAN_CARD_ENTITY.get(), GoodManCardEntityRenderer::new);
    }
}
