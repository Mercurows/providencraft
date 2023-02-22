package tech.lq0.providencraft.render.animation;

import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.init.ItemRegistry;

import java.io.IOException;

public class TracheliumController extends AnimationController{
    public static int INDEX_BODY = 5;
    public static int INDEX_LEFT_HAND = 0;
    public static int INDEX_RIGHT_HAND = 6;
    public static final AnimationMeta FIRE = new AnimationMeta(new ResourceLocation(Utils.MOD_ID,"animations/trachelium_fire.gltf"));
    public static final AnimationMeta RELOAD_NORM = new AnimationMeta(new ResourceLocation(Utils.MOD_ID,"animations/trachelium_fire.gltf"));
    public static final AnimationMeta RELOAD_EMPTY = new AnimationMeta(new ResourceLocation(Utils.MOD_ID,"animations/trachelium_fire.gltf"));
    public static final AnimationMeta INSPECT = new AnimationMeta(new ResourceLocation(Utils.MOD_ID,"animations/trachelium_fire.gltf"));
    public static final AnimationMeta DRAW = new AnimationMeta(new ResourceLocation(Utils.MOD_ID,"animations/trachelium_fire.gltf"));
    public static final AnimationMeta STATIC = new AnimationMeta(new ResourceLocation(Utils.MOD_ID,"animations/trachelium_fire.gltf"));
    private static final TracheliumController instance = new TracheliumController();

    private TracheliumController() {
        try {
            Animations.load(FIRE);
            Animations.load(RELOAD_NORM);
            Animations.load(INSPECT);
            Animations.load(DRAW);
            Animations.load(RELOAD_EMPTY);
            Animations.load(STATIC);
        } catch (IOException e){
            e.printStackTrace();
        }
        this.enableStaticState();
        AnimationController.setAnimationControllerMap(ItemRegistry.TRACHELIUM.getId(),this);
    }

    public static TracheliumController getInstance(){
        return instance;
    }

    @Override
    public AnimationMeta getAnimationFromLabel(AnimationLabel label) {
        switch (label){
            case FIRE: return FIRE;
            case INSPECT: return INSPECT;
            case RELOAD_NORMAL: return RELOAD_NORM;
            case DRAW: return DRAW;
            case STATIC: return STATIC;
            case RELOAD_EMPTY: return RELOAD_EMPTY;
            default: return null;
        }
    }

    @Override
    public AnimationSoundMeta getSoundFromLabel(AnimationLabel label){
        return super.getSoundFromLabel(ItemRegistry.TRACHELIUM.get(), label);
    }

    @Override
    protected int getAttachmentsNodeIndex() {
        return INDEX_BODY;
    }

    @Override
    protected int getRightHandNodeIndex() {
        return INDEX_RIGHT_HAND;
    }

    @Override
    protected int getLeftHandNodeIndex() {
        return INDEX_LEFT_HAND;
    }


}
