package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tech.lq0.providencraft.event.FireEvent;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;

//Forked from TaC
public class ClientRenderHandler {
    private static ClientRenderHandler instance;

    public static ClientRenderHandler get() {
        if (instance == null) {
            instance = new ClientRenderHandler();
        }
        return instance;
    }

    public int sprintTransition;
    private int sprintCooldown;

    private float speedUpDistanceFrom = 0f;

    private ClientRenderHandler() {
    }

    private long fireTime = System.currentTimeMillis();

    @SubscribeEvent
    public void onGunFired(FireEvent event) {
        if (event.isClient()) {
            fireTime = System.currentTimeMillis();
        }
    }

    @SubscribeEvent
    public void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.world == null)
            return;
        if (!(mc.player.getHeldItemMainhand().getItem() instanceof Trachelium) || mc.player.getHeldItemMainhand().getTag() == null) {
            return;
        }

        float cameraShakeDuration = 0.15f;
        long alphaTime = System.currentTimeMillis() - fireTime;
        float progress = (alphaTime < cameraShakeDuration * 1000 ? 1 - alphaTime / (cameraShakeDuration * 1000f) : 0);

        float alpha = (progress * (Math.random() - 0.5 < 0 ? -1 : 1) * 4.0f);
        event.setPitch(event.getPitch() - Math.abs(alpha));
        event.setRoll(event.getRoll() + alpha * 0.05f);
    }


    @SubscribeEvent
    public void onGunFire(FireEvent.Post event) {
        if (!event.isClient()) {
            return;
        }
        if (Minecraft.getInstance().player == null) return;
        Item item = event.getStack().getItem();
        if (item instanceof Trachelium) {
            LivingEntity entity = event.getEntityLiving();
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                Trachelium trachelium = (Trachelium) item;
                trachelium.playAnimation("fire", item.getDefaultInstance(), player);
            }
        }
        this.sprintTransition = 0;
        this.speedUpDistanceFrom = Minecraft.getInstance().player.distanceWalkedModified;
        this.sprintCooldown = 8;
    }

//    @SubscribeEvent
//    public void onAnimatedGunReload(ReloadEvent.Pre event) {
//        Item item = event.getStack().getItem();
//        if (item instanceof Trachelium) {
//            ITimelessAnimated animated = (ITimelessAnimated) item;
//            animated.playAnimation("reload", event.getStack(), false);
//        }
//    }

    @SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent event) {
        if (event.phase.equals(TickEvent.Phase.START))
            return;

        Minecraft mc = Minecraft.getInstance();
        if (!mc.isGameFocused())
            return;

        PlayerEntity player = mc.player;
        if (player == null)
            return;

        if (Minecraft.getInstance().gameSettings.getPointOfView() != PointOfView.FIRST_PERSON)
            return;

        ItemStack heldItem = player.getHeldItem(Hand.MAIN_HAND);
        if (heldItem.isEmpty())
            return;
    }

    //    private void renderMuzzleFlash(LivingEntity entity, MatrixStack matrixStack, IRenderTypeBuffer buffer, ItemStack weapon, ItemCameraTransforms.TransformType transformType) {
//        Gun modifiedGun = ((GunItem) weapon.getItem()).getModifiedGun(weapon);
//        if (modifiedGun.getDisplay().getFlash() == null) {
//            return;
//        }
//        //if (modifiedGun.canAttachType(IAttachment.Type.BARREL) && GunModifierHelper.isSilencedFire(weapon)) return;
//
//        if (transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND || transformType == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || transformType == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND) {
//            if (this.entityIdForMuzzleFlash.contains(entity.getEntityId())) {
//                float randomValue = this.entityIdToRandomValue.get(entity.getEntityId());
//                this.drawMuzzleFlash(weapon, modifiedGun, randomValue, randomValue >= 0.5F, matrixStack, buffer);
//            }
//        }
//    }
//
//    public double displayX = 0;
//    public double displayY = 0;
//    public double displayZ = 0;
//    public double sizeZ = 0;
//
//    public double adjustedTrailZ = 0;
//
//    private void drawMuzzleFlash(ItemStack weapon, Gun modifiedGun, float random, boolean flip, MatrixStack matrixStack, IRenderTypeBuffer buffer) {
//        matrixStack.push();
//
//        Gun.Positioned muzzleFlash = modifiedGun.getDisplay().getFlash();
//        if (muzzleFlash == null)
//            return;
//
//        displayX = muzzleFlash.getXOffset();
//        displayY = muzzleFlash.getYOffset();
//        displayZ = (muzzleFlash.getZOffset() + this.muzzleExtraOnEnch);
//
//        //GunRenderingHandler.get().adjustedTrailZ = muzzleFlash.get
//
//        double displayXv = displayX * 0.0625;
//        double displayYv = displayY * 0.0625;
//        double displayZv = displayZ * 0.0625;
//        if (ClientRenderHandler.get().muzzleExtraOnEnch != 0)
//            this.muzzleExtraOnEnch = 0;
//
//        displayX *= 0.0625;
//        displayY *= 0.0625;
//        displayZ *= 0.0625;
//
//        adjustedTrailZ = modifiedGun.getDisplay().getFlash().getTrailAdjust();
//
//        matrixStack.translate(displayXv, displayYv, displayZv);
//        matrixStack.translate(0, -0.5, 0);
//
//        ItemStack barrelStack = Gun.getAttachment(IAttachment.Type.BARREL, weapon);
//        if (!barrelStack.isEmpty() && barrelStack.getItem() instanceof IBarrel) {
//            Barrel barrel = ((IBarrel) barrelStack.getItem()).getProperties();
//            Gun.ScaledPositioned positioned = modifiedGun.getModules().getAttachments().getBarrel();
//            if (positioned != null) {
//                matrixStack.translate(0, 0, -barrel.getLength() * 0.0625 * positioned.getScale());
//            }
//        }
//
//        matrixStack.scale(0.5F, 0.5F, 0.0F);
//
//        double partialSize = modifiedGun.getDisplay().getFlash().getSize() / 5.0;
//        float size = (float) (modifiedGun.getDisplay().getFlash().getSize() - partialSize + partialSize * random);
//        size = (float) GunModifierHelper.getMuzzleFlashSize(weapon, size);
//        matrixStack.rotate(Vector3f.ZP.rotationDegrees(360F * random));
//        matrixStack.rotate(Vector3f.XP.rotationDegrees(flip ? 180F : 0F));
//        matrixStack.translate(-size / 2, -size / 2, 0);
//
//        float sizeForTrail = (float) (1 - partialSize + partialSize);
//        //sizeForTrail = (float) GunModifierHelper.getMuzzleFlashSize(weapon, sizeForTrail);
//
//        sizeZ = -sizeForTrail;
//
//        Matrix4f matrix = matrixStack.getLast().getMatrix();
//        IVertexBuilder builder = buffer.getBuffer(GunRenderType.getMuzzleFlash());
//        builder.pos(matrix, 0, 0, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(1.0F, 1.0F).lightmap(15728880).endVertex();
//        builder.pos(matrix, size, 0, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(0, 1.0F).lightmap(15728880).endVertex();
//        builder.pos(matrix, size, size, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(0, 0).lightmap(15728880).endVertex();
//        builder.pos(matrix, 0, size, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(1.0F, 0).lightmap(15728880).endVertex();
//
//        /*float smokeSize = (float) modifiedGun.getDisplay().getFlash().getSmokeSize();
//        builder = buffer.getBuffer(GunRenderType.getMuzzleSmoke());
//        matrixStack.translate(size / 2,size / 2,0);
//        matrixStack.translate(-smokeSize / 2, -smokeSize / 2, 0);
//        builder.pos(matrix, 0, 0, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(1.0F, 1.0F).lightmap(15728880).endVertex();
//        builder.pos(matrix, smokeSize, 0, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(0, 1.0F).lightmap(15728880).endVertex();
//        builder.pos(matrix, smokeSize, smokeSize, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(0, 0).lightmap(15728880).endVertex();
//        builder.pos(matrix, 0, smokeSize, 0).color(1.0F, 1.0F, 1.0F, 1.0F).tex(1.0F, 0).lightmap(15728880).endVertex();
//*/
//        matrixStack.pop();
//    }

}
