package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;
import tech.lq0.providencraft.network.NetworkHandler;
import tech.lq0.providencraft.network.TracheliumPack;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class TracheliumHandler {
    private static TracheliumHandler tracheliumHandler;

    public TracheliumHandler(){

    }

    public static TracheliumHandler getInstance(){
        if(tracheliumHandler == null){
            tracheliumHandler = new TracheliumHandler();
        }
        return tracheliumHandler;
    }

    private boolean outOfScreen() {
        Minecraft mc = Minecraft.getInstance();

        if(mc.loadingGui != null) {
            return true;
        }else if(mc.currentScreen != null) {
            return true;
        }else if(!mc.mouseHelper.isMouseGrabbed()) {
            return true;
        }else {
            return !mc.isGameFocused();
        }
    }

    //fire when left button is clicked
    @SubscribeEvent
    public void onKeyInput(InputEvent.RawMouseEvent event){
        if(this.outOfScreen()) {
            return;
        }

        if(event.getAction() != GLFW.GLFW_PRESS) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;
        if(player == null) {
            return;
        }

        ItemStack heldItem = player.getHeldItemMainhand();
        if(heldItem.getItem() == ItemRegistry.TRACHELIUM.get()) {
            int button = event.getButton();

            if(button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
                event.setCanceled(true);
            }

            if(button == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
                if(event.getAction() == GLFW.GLFW_PRESS) {

                    //do shoot
                    player.sendStatusMessage(new StringTextComponent("test"), true);
                    doShoot(player, heldItem);
                }
            }
        }
    }

    @SubscribeEvent
    public void onTickEvent(TickEvent.ClientTickEvent event) {
        if(this.outOfScreen()) {
            return;
        }

        if(event.phase != TickEvent.Phase.START) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;

        if(player != null) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if(heldItem.getItem() == ItemRegistry.TRACHELIUM.get()) {
                boolean clicked = GLFW.glfwGetMouseButton(mc.getMainWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS;

                if(clicked) {
                    System.out.println("clicked");
                }
            }
        }

    }

    @SubscribeEvent
    public void onPostClientTick(TickEvent.ClientTickEvent event) {
        if(outOfScreen()) {
            return;
        }

        if(event.phase != TickEvent.Phase.END) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;

        if(player != null) {
            ItemStack heldItem = player.getHeldItemMainhand();
            if(heldItem.getItem() == ItemRegistry.TRACHELIUM.get()) {
                if(GLFW.glfwGetMouseButton(mc.getMainWindow().getHandle(), GLFW.GLFW_MOUSE_BUTTON_LEFT) == GLFW.GLFW_PRESS) {
                    System.out.println("114514");
                }
            }
        }
    }

    public void doShoot(PlayerEntity player, ItemStack itemStack){
        if(player == null){
            return;
        }

        if(itemStack.getItem() != ItemRegistry.TRACHELIUM.get()){
            return;
        }

        if(player.isSpectator()){
            return;
        }

        CooldownTracker tracker = player.getCooldownTracker();
        if(!tracker.hasCooldown(itemStack.getItem())){
            Trachelium trachelium = (Trachelium) itemStack.getItem();

            tracker.setCooldown(trachelium, 20);

            NetworkHandler.getInstance().sendToServer(new TracheliumPack(player));
        }
    }
}