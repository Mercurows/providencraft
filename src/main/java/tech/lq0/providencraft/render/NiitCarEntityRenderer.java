package tech.lq0.providencraft.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.entity.NiitCarEntity;
import tech.lq0.providencraft.models.NiitCarModel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class NiitCarEntityRenderer extends MobRenderer<NiitCarEntity, NiitCarModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/niit_car_texture.png");

    public NiitCarEntityRenderer(EntityRendererManager manager) {
        super(manager, new NiitCarModel(), 1.0f);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ResourceLocation getEntityTexture(NiitCarEntity entity) {
        return TEXTURE;
    }
}

