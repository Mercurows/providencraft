package tech.lq0.providencraft.render.animation;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;
import tech.lq0.providencraft.network.AnimationPack;
import tech.lq0.providencraft.network.NetworkHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Forked from MrCrayfish and TaC
public abstract class AnimationController {
    public enum AnimationLabel {
        RELOAD_NORMAL,
        RELOAD_EMPTY,
        RELOAD_INTRO,
        RELOAD_LOOP,
        RELOAD_NORMAL_END,
        RELOAD_EMPTY_END,
        PUMP,
        PULL_BOLT,
        INSPECT,
        DRAW,
        STATIC,
    }

    private AnimationMeta previousAnimation;

    private AnimationSoundMeta previousSound;

    private static final Map<ResourceLocation, AnimationController> animationControllerMap = new HashMap<>();

    protected void enableStaticState() {
        AnimationMeta staticMeta = getAnimationFromLabel(AnimationLabel.STATIC);
        if (staticMeta != null) {
            try {
                for (AnimationLabel label : AnimationLabel.values()) {
                    AnimationMeta meta = getAnimationFromLabel(label);
                    if (meta != null) Animations.specifyInitialModel(meta, staticMeta);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void runAnimation(AnimationMeta animationMeta, AnimationSoundMeta soundMeta, Runnable callback) {
        if (animationMeta != null) {
            Animations.runAnimation(animationMeta, callback);
            previousAnimation = animationMeta;
        }
        if (animationMeta != null && soundMeta != null) {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if (player == null) return;
            if (animationMeta.getResourceLocation() == null || soundMeta.getResourceLocation() == null)
                return;
            AnimationPack message = new AnimationPack(animationMeta.getResourceLocation(), soundMeta.getResourceLocation(), true, player.getUniqueID());
            NetworkHandler.getInstance().sendToServer(message);
            previousSound = soundMeta;
        }
    }

    public boolean isAnimationRunning() {
        return Animations.isAnimationRunning(previousAnimation);
    }

    public AnimationMeta getPreviousAnimation() {
        return previousAnimation;
    }

    public void stopAnimation() {
        if (previousAnimation != null) {
            Animations.stopAnimation(previousAnimation);
        }
        if (previousAnimation != null && previousSound != null) {
            ClientPlayerEntity player = Minecraft.getInstance().player;
            if (player == null) return;
            AnimationPack message = new AnimationPack(previousAnimation.getResourceLocation(), previousSound.getResourceLocation(), false, player.getUniqueID());
            NetworkHandler.getInstance().sendToServer(message);
        }
    }

    public void runAnimation(AnimationLabel label) {
        runAnimation(getAnimationFromLabel(label), getSoundFromLabel(label), null);
    }

    public void runAnimation(AnimationLabel label, Runnable callback) {
        runAnimation(getAnimationFromLabel(label), getSoundFromLabel(label), callback);
    }

    public abstract AnimationMeta getAnimationFromLabel(AnimationLabel label);

    protected abstract int getAttachmentsNodeIndex();

    protected abstract int getRightHandNodeIndex();

    protected abstract int getLeftHandNodeIndex();

    public AnimationSoundMeta getSoundFromLabel(AnimationLabel label) {
        return null;
    }

    protected AnimationSoundMeta getSoundFromLabel(Item item, AnimationLabel label) {
        if (item instanceof Trachelium) {
            switch (label) {
                case RELOAD_EMPTY:
                    return new AnimationSoundMeta(new ResourceLocation(Utils.MOD_ID, "blade"));
                case RELOAD_NORMAL:
                    return new AnimationSoundMeta(new ResourceLocation(Utils.MOD_ID, "how_hold_blood"));
                case DRAW:
                    return new AnimationSoundMeta(new ResourceLocation(Utils.MOD_ID, "sorry"));
                case INSPECT:
                    return new AnimationSoundMeta(new ResourceLocation(Utils.MOD_ID, "yyky_scream_1"));
                default:
                    return null;
            }
        }
        return null;
    }

    public void applyAttachmentsTransform(ItemStack itemStack, ItemCameraTransforms.TransformType transformType, LivingEntity entity, MatrixStack matrixStack) {
        boolean isFirstPerson = transformType.isFirstPerson();
        if (isFirstPerson) Animations.pushNode(previousAnimation, getAttachmentsNodeIndex());
        Animations.applyAnimationTransform(itemStack, ItemCameraTransforms.TransformType.NONE, entity, matrixStack);
        if (isFirstPerson) Animations.popNode();
    }

    public void applySpecialModelTransform(IBakedModel model, int index, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack) {
        boolean isFirstPerson = transformType.isFirstPerson();
        if (isFirstPerson) Animations.pushNode(previousAnimation, index);
        Animations.applyAnimationTransform(model, ItemCameraTransforms.TransformType.NONE, matrixStack);
        if (isFirstPerson) Animations.popNode();
    }

    public void applyTransform(ItemStack itemStack, int index, ItemCameraTransforms.TransformType transformType, LivingEntity entity, MatrixStack matrixStack) {
        boolean isFirstPerson = transformType.isFirstPerson();
        if (isFirstPerson) Animations.pushNode(previousAnimation, index);
        Animations.applyAnimationTransform(itemStack, ItemCameraTransforms.TransformType.NONE, entity, matrixStack);
        if (isFirstPerson) Animations.popNode();
    }

    public void applyRightHandTransform(MatrixStack matrixStack) {
        if (previousAnimation != null) {
            Animations.pushNode(previousAnimation, getRightHandNodeIndex());
            matrixStack.translate(-0.5, -0.5, -0.5);
            Matrix4f animationTransition = new Matrix4f(Animations.peekNodeModel().computeGlobalTransform(null));
            animationTransition.transpose();
            matrixStack.getLast().getMatrix().mul(animationTransition);
            Animations.popNode();
        }
    }

    public void applyLeftHandTransform(MatrixStack matrixStack) {
        if (previousAnimation != null) {
            Animations.pushNode(previousAnimation, getLeftHandNodeIndex());
            matrixStack.translate(-0.5, -0.5, -0.5);
            Matrix4f animationTransition = new Matrix4f(Animations.peekNodeModel().computeGlobalTransform(null));
            animationTransition.transpose();
            matrixStack.getLast().getMatrix().mul(animationTransition);
            Animations.popNode();
        }
    }

    public boolean isAnimationRunning(AnimationLabel label) {
        if (!isAnimationRunning()) return false;
        if (previousAnimation == null) return false;
        AnimationMeta meta = getAnimationFromLabel(label);
        if (meta == null) return false;
        return meta.equals(previousAnimation);
    }

    public static void setAnimationControllerMap(ResourceLocation itemRegistryName, AnimationController animationController) {
        animationControllerMap.put(itemRegistryName, animationController);
    }

    public static AnimationController fromItem(Item item) {
        return animationControllerMap.get(item.getRegistryName());
    }

    public static AnimationController fromRegistryName(ResourceLocation registryName) {
        return animationControllerMap.get(registryName);
    }
}