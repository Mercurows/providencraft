package tech.lq0.providencraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import tech.lq0.providencraft.render.animation.AnimationMeta;
import tech.lq0.providencraft.render.animation.AnimationSoundManager;
import tech.lq0.providencraft.render.animation.AnimationSoundMeta;

import java.util.UUID;

//Forked from TaC
public class ClientPlayerHandler {
    public static void handleMessageAnimationSound(UUID fromWho, ResourceLocation animationResource, ResourceLocation soundResource, boolean play){
        World world = Minecraft.getInstance().world;
        if(world == null){
            return;
        }
        PlayerEntity player = world.getPlayerByUuid(fromWho);
        if (player == null){
            return;
        }
        if (animationResource == null || soundResource == null){
            return;
        }
        AnimationMeta animationMeta = new AnimationMeta(animationResource);
        AnimationSoundMeta soundMeta = new AnimationSoundMeta(soundResource);
        if (play){
            AnimationSoundManager.INSTANCE.playerSound(player, animationMeta, soundMeta);
        }
        else{
            AnimationSoundManager.INSTANCE.interruptSound(player, animationMeta);
        }
    }
}
