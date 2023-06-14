package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.gui.EclipseNightHUD;
import tech.lq0.providencraft.gui.EclipseNightHUD2;
import tech.lq0.providencraft.gui.RainyButterflyHUD;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.integration.CompatHandler;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;

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

            EclipseNightHUD2 eclipseNightHUD2 = new EclipseNightHUD2(event.getMatrixStack(), level);
            eclipseNightHUD2.render();

            EclipseNightHUD eclipseNightHUD = new EclipseNightHUD(event.getMatrixStack(), level);
            eclipseNightHUD.render();
        }
    }

    @SubscribeEvent
    public static void onRainyButterflyHudRender(RenderGameOverlayEvent.Post event) {
        if(CompatHandler.virtuarealcraft || CompatHandler.target) {
            if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
                return;
            }
            if (Minecraft.getInstance().player == null) {
                return;
            }

            PlayerEntity player = Minecraft.getInstance().player;

            if(player.isSpectator() || player.isCreative()){
                return;
            }

            ItemStack stack = null;
            ItemStack mainhandStack = player.getHeldItemMainhand();
            ItemStack offhandStack = player.getHeldItemOffhand();

            if(mainhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get()){
                stack = mainhandStack;
            }else if(offhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get()){
                stack = offhandStack;
            }
            if(mainhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get() &&
                    offhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get()){
                stack = mainhandStack;
            }

            if(stack != null) {
                RainyButterflyHUD butterflyHUD = new RainyButterflyHUD(event.getMatrixStack(), stack, player.world.isRaining());
                butterflyHUD.render();
            }
        }
    }
}
