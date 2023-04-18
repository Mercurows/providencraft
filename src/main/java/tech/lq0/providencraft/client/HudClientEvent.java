package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.gui.EclipseNightHUD;
import tech.lq0.providencraft.init.EffectRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HudClientEvent {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onOverlayRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.HELMET) {
            return;
        }
        if (Minecraft.getInstance().player == null) {
            return;
        }
        PlayerEntity player = Minecraft.getInstance().player;
        if(Minecraft.getInstance().player.isPotionActive(EffectRegistry.ECLIPSE_NIGHT.get())) {
            int level = Math.min(5, player.getActivePotionEffect(EffectRegistry.ECLIPSE_NIGHT.get()).getAmplifier() + 1);

            EclipseNightHUD eclipseNightHUD = new EclipseNightHUD(event.getMatrixStack(), level);
            eclipseNightHUD.render();
        }
    }
}
