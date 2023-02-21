package tech.lq0.providencraft.render.animation;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//Forked from TaC
@OnlyIn(Dist.CLIENT)
public class AnimationSoundMeta {
    private final ResourceLocation resourceLocation;

    public AnimationSoundMeta(ResourceLocation resourceLocation){
        this.resourceLocation = resourceLocation;
    }
    public ResourceLocation getResourceLocation(){
        return resourceLocation;
    }

    public boolean equals(AnimationSoundMeta meta){
        return meta.resourceLocation.equals(resourceLocation);
    }
}
