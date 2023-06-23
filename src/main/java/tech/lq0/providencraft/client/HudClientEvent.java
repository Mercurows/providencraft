package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.gui.ChaosCheckerHUD;
import tech.lq0.providencraft.gui.EclipseNightHUD;
import tech.lq0.providencraft.gui.EclipseNightHUD2;
import tech.lq0.providencraft.gui.RainyButterflyHUD;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.integration.CompatHandler;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;
import tech.lq0.providencraft.item.others.ChaosChecker;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class HudClientEvent {
    public static final ChaosCheckerHUD CheckerHUD = new ChaosCheckerHUD();
    private static int lastTick = 0;

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onOverlayRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.HELMET) {
            return;
        }
        if (Minecraft.getInstance().player == null) {
            return;
        }
        PlayerEntity player = Minecraft.getInstance().player;
        if (Minecraft.getInstance().player.isPotionActive(EffectRegistry.ECLIPSE_NIGHT.get())) {
            int level = Math.min(5, player.getActivePotionEffect(EffectRegistry.ECLIPSE_NIGHT.get()).getAmplifier() + 1);

            EclipseNightHUD2 eclipseNightHUD2 = new EclipseNightHUD2(event.getMatrixStack(), level);
            eclipseNightHUD2.render();

            EclipseNightHUD eclipseNightHUD = new EclipseNightHUD(event.getMatrixStack(), level);
            eclipseNightHUD.render();
        }
    }

    @SubscribeEvent
    public static void onRainyButterflyHudRender(RenderGameOverlayEvent.Post event) {
        if (CompatHandler.virtuarealcraft) {
            if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
                return;
            }
            if (Minecraft.getInstance().player == null) {
                return;
            }

            PlayerEntity player = Minecraft.getInstance().player;

            if (player.isSpectator() || player.isCreative()) {
                return;
            }

            ItemStack stack = null;
            ItemStack mainhandStack = player.getHeldItemMainhand();
            ItemStack offhandStack = player.getHeldItemOffhand();

            if (mainhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get()) {
                stack = mainhandStack;
            } else if (offhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get()) {
                stack = offhandStack;
            }
            if (mainhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get() &&
                    offhandStack.getItem() == VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get()) {
                stack = mainhandStack;
            }

            if (stack != null) {
                RainyButterflyHUD butterflyHUD = new RainyButterflyHUD(event.getMatrixStack(), stack, player.world.isRaining());
                butterflyHUD.render();
            }
        }
    }

    @SubscribeEvent
    public static void onChaosRender(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        if (player.isSpectator()) {
            return;
        }

        ItemStack mainStack = player.getHeldItemMainhand();
        ItemStack offStack = player.getHeldItemOffhand();
        if (!(mainStack.getItem() instanceof ChaosChecker) && offStack.getItem() instanceof ChaosChecker) {
            mainStack = offStack;
        }
        // TODO 获取混沌值
        int chaos = ChaosChecker.getChaos(mainStack);
//        System.out.println(chaos);

        int status;
        if (mainStack.getItem() instanceof ChaosChecker) {
            // 主/副手持有检测器
            status = 2;
        } else if (player.inventory.hasItemStack(ItemRegistry.CHAOS_CHECKER.get().getDefaultInstance())) {
            // 背包里有检测器
            status = 1;
        } else {
            // 无检测器
            status = 0;
        }
        int tick = Minecraft.getInstance().player.ticksExisted;
        CheckerHUD.render(event.getMatrixStack(), tick % 200 - 100, status, event.getPartialTicks(), tick == lastTick);
        lastTick = tick;

    }
}
