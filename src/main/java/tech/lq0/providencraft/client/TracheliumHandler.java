package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import tech.lq0.providencraft.init.ItemRegistry;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class TracheliumHandler {
//    private static TracheliumHandler tracheliumHandler;
//
//    public static TracheliumHandler getInstance(){
//        if(tracheliumHandler == null){
//            tracheliumHandler = new TracheliumHandler();
//        }
//        return tracheliumHandler;
//    }

    public TracheliumHandler(){}

    private boolean isInGame() {
        Minecraft mc = Minecraft.getInstance();
        if(mc.loadingGui != null)
            return false;
        if(mc.currentScreen != null)
            return false;
        if(!mc.mouseHelper.isMouseGrabbed())
            return false;
        return mc.isGameFocused();
    }

    //fire when left button is clicked
    @SubscribeEvent
    public void onKeyPressed(InputEvent.RawMouseEvent event){
        if(!this.isInGame()) {
            System.out.println(111);
            return;
        }

        if(event.getAction() != GLFW.GLFW_PRESS) {
            System.out.println(222);
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;
        if(player == null) {
            System.out.println(333);
            return;
        }

        ItemStack heldItem = player.getHeldItemMainhand();
        if(heldItem.getItem() == ItemRegistry.TRACHELIUM.get()) {
            int button = event.getButton();

            if(button == GLFW.GLFW_MOUSE_BUTTON_LEFT || button == GLFW.GLFW_MOUSE_BUTTON_RIGHT) {
                System.out.println(444);
                event.setCanceled(true);
            }

            if(event.getAction() == GLFW.GLFW_PRESS && button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
                System.out.println(555);
                player.sendStatusMessage(new StringTextComponent("哼哼啊啊啊"), true);
            }
        }
    }
}
