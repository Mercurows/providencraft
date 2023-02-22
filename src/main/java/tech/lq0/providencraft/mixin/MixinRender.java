package tech.lq0.providencraft.mixin;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.FirstPersonRenderer;
//import net.minecraft.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import tech.lq0.providencraft.render.animation.AnimationController;
//import tech.lq0.providencraft.render.animation.AnimationMeta;
//
//@Mixin(FirstPersonRenderer.class)
//public class MixinRender {
//    @Shadow
//    private ItemStack itemStackMainHand;
//    private ItemStack prevItemStack = ItemStack.EMPTY;
//    private int prevSlot = 0;
//
//    @Inject(method = "tick",at = @At("HEAD"))
//    public void applyDrawAndHolster(CallbackInfo ci){
//        if(Minecraft.getInstance().player == null) return;
//        ItemStack mainHandItemStack = Minecraft.getInstance().player.getHeldItemMainhand();
//        AnimationController controller = AnimationController.fromItem(mainHandItemStack.getItem());
//        AnimationController controller1 = AnimationController.fromItem(this.prevItemStack.getItem());
//        if(prevItemStack.isItemEqual(mainHandItemStack)
//                && (prevSlot == Minecraft.getInstance().player.inventory.currentItem) ) {
//            return;
//        }
//        prevItemStack = mainHandItemStack;
//        prevSlot = Minecraft.getInstance().player.inventory.currentItem;
//
//        if(controller1 != null && controller1.isAnimationRunning()) {
//            controller1.stopAnimation();
//        }
//        if(controller != null && controller == controller1){
//            AnimationMeta meta = controller.getAnimationFromLabel(AnimationController.AnimationLabel.DRAW);
//            if(!controller.getPreviousAnimation().equals(meta)) controller.stopAnimation();
//            controller.runAnimation(AnimationController.AnimationLabel.DRAW);
//        }else if(controller != null && controller.getAnimationFromLabel(AnimationController.AnimationLabel.DRAW) != null) {
//            this.itemStackMainHand = mainHandItemStack;
//            controller.runAnimation(AnimationController.AnimationLabel.DRAW);
//        }
//    }
//
//}
