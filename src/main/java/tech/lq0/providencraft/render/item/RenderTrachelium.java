package tech.lq0.providencraft.render.item;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import tech.lq0.providencraft.item.providencefirst.madoka.Trachelium;
import tech.lq0.providencraft.models.item.TracheliumModel;

public class RenderTrachelium extends GeoItemRenderer<Trachelium> {
    public RenderTrachelium() {
        super(new TracheliumModel());
    }
}
