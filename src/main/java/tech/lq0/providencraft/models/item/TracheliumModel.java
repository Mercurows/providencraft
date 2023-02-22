package tech.lq0.providencraft.models.item;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;

public class TracheliumModel extends AnimatedGeoModel<Trachelium> {

    @Override
    public ResourceLocation getModelLocation(Trachelium object) {
        return new ResourceLocation(Utils.MOD_ID, "geo/trachelium.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Trachelium object) {
        return new ResourceLocation(Utils.MOD_ID, "textures/item/trachelium_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Trachelium animatable) {
        return new ResourceLocation(Utils.MOD_ID, "animations/animation.trachelium.fire.json");
    }
}
