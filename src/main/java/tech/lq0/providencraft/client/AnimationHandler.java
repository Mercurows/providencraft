package tech.lq0.providencraft.client;

import de.javagl.jgltf.model.animation.AnimationRunner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.event.FireEvent;
import tech.lq0.providencraft.event.ReloadEvent;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;
import tech.lq0.providencraft.render.animation.*;

//Forked from TaC
@Mod.EventBusSubscriber(modid = Utils.MOD_ID, value = Dist.CLIENT)
public enum AnimationHandler {
    INSTANCE;

    public static void preloadAnimations(){
        TracheliumController.getInstance();
    }

    public void onGunReload(boolean reloading, ItemStack itemStack) {
        PlayerEntity player = Minecraft.getInstance().player;
        if (player == null) return;
        if (itemStack.getItem() instanceof Trachelium) {
            if (Trachelium.getAmmo(itemStack) == 8){
                return;
            }
        }
        AnimationController controller = AnimationController.fromItem(itemStack.getItem());
        if (controller == null){
            return;
        }
        if(!reloading) {
            return;
        }
        AnimationMeta reloadEmptyMeta = controller.getAnimationFromLabel(AnimationController.AnimationLabel.RELOAD_EMPTY);
        AnimationMeta reloadNormalMeta = controller.getAnimationFromLabel(AnimationController.AnimationLabel.RELOAD_NORMAL);

        if (Trachelium.getAmmo(itemStack) > 0) {
            if (controller.getPreviousAnimation() != null && !controller.getPreviousAnimation().equals(reloadNormalMeta)) {
                controller.stopAnimation();
            }
            controller.runAnimation(AnimationController.AnimationLabel.RELOAD_NORMAL);
        } else {
            if (controller.getPreviousAnimation() != null && !controller.getPreviousAnimation().equals(reloadEmptyMeta)) {
                controller.stopAnimation();
            }

            controller.runAnimation(AnimationController.AnimationLabel.RELOAD_EMPTY);
        }
    }

    @SubscribeEvent
    public void onGunFire(FireEvent.Pre event) {
        if (!event.isClient()){
            return;
        }
        if(Minecraft.getInstance().player == null){
            return;
        }
        if(!event.getPlayer().getUniqueID().equals(Minecraft.getInstance().player.getUniqueID())){
            return;
        }
        AnimationController controller = AnimationController.fromItem(event.getStack().getItem());
        if (controller == null){
            return;
        }
        if (controller.isAnimationRunning()) {
            AnimationMeta meta = controller.getPreviousAnimation();
            if(meta == null){
                return;
            }
            if (meta.equals(controller.getAnimationFromLabel(AnimationController.AnimationLabel.INSPECT)))
                controller.stopAnimation();
            else {
                AnimationRunner runner = Animations.getAnimationRunner(meta.getResourceLocation());
                if(runner == null){
                    return;
                }
                float current = runner.getAnimationManager().getCurrentTimeS();
                float max = runner.getAnimationManager().getMaxEndTimeS();
                if(max - current <= 0.25f){
                    return;
                }
                event.setCanceled(true);
            }
        }
    }

    static {
        final Runnable callback = () -> {
            final PlayerEntity player = Minecraft.getInstance().player;
            if( player == null ) return;

            final ItemStack stack = player.inventory.getCurrentItem();
            final AnimationController controller = AnimationController.fromItem( stack.getItem() );
            if( controller != null && !controller.isAnimationRunning() ) {
                controller.stopAnimation();
                controller.runAnimation( AnimationController.AnimationLabel.INSPECT );
            }
        };
    }

    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
        AnimationSoundManager.INSTANCE.onPlayerDeath(event.getPlayer());
    }

    @SubscribeEvent
    public void onClientPlayerReload(ReloadEvent.Pre event){
        if(event.isClient()){
            AnimationController controller = AnimationController.fromItem(event.getStack().getItem());
            if(controller != null){
                if(controller.isAnimationRunning(AnimationController.AnimationLabel.DRAW) ||
                        controller.isAnimationRunning(AnimationController.AnimationLabel.PUMP)) {
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onRenderHand(RenderHandEvent event){
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if(player == null){
            return;
        }
        ItemStack itemStack = player.inventory.getCurrentItem();
        AnimationController controller = AnimationController.fromItem(itemStack.getItem());
        if(controller == null){
            return;
        }
        if(controller.isAnimationRunning()){

        }
    }

    public boolean isReloadingIntro(Item item){
        AnimationController controller = AnimationController.fromItem(item);
        if(controller == null) return false;
        return controller.isAnimationRunning(AnimationController.AnimationLabel.RELOAD_INTRO);
    }

    public void onReloadLoop(Item item){
        AnimationController controller = AnimationController.fromItem(item);
        if(controller == null) return;
        controller.stopAnimation();
        controller.runAnimation(AnimationController.AnimationLabel.RELOAD_LOOP);
    }

    public void onReloadEnd(Item item){
        AnimationController controller = AnimationController.fromItem(item);
        if(controller == null) {
        }

    }
}
