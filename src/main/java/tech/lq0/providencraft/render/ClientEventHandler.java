package tech.lq0.providencraft.render;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.init.EntityRegistry;
import tech.lq0.providencraft.init.TileEntityRegistry;

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
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.WATER_CARD_ENTITY.get(), WaterCardEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BLOOD_CRYSTAL_ENTITY.get(), BloodCrystalEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.CURSED_CAT_DOLL_ENTITY.get(), CursedCatDollEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.SHU_RINO_KEN_ENTITY.get(), ShuRinoKenEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.TAIL_BOBBER_ENTITY.get(), TailBobberRenderer::new);

        event.enqueueWork(() -> ClientRegistry.bindTileEntityRenderer(TileEntityRegistry.POINTS_STORE.get(), PointsStoreTileEntityRenderer::new));
        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(BlockRegistry.HARANO_SAPLING.get(), RenderType.getCutout()));
        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(BlockRegistry.HARANO_DOOR.get(), RenderType.getCutout()));
        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(BlockRegistry.HARANO_TRAPDOOR.get(), RenderType.getCutout()));
    }
}
