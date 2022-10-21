package tech.lq0.providencraft.render.special;

import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import org.lwjgl.opengl.GL11;

class CustomRenderType extends RenderType {
    public static final RenderType BlockOverlay = makeType("BlockOverlay",
            DefaultVertexFormats.POSITION_COLOR, GL11.GL_QUADS, 256,
            RenderType.State.getBuilder()
                    .layer(LayerState.POLYGON_OFFSET_LAYERING)
                    .transparency(RenderState.TRANSLUCENT_TRANSPARENCY)
                    .texture(TextureState.NO_TEXTURE)
                    .depthTest(DepthTestState.DEPTH_LEQUAL)
                    .cull(RenderState.CULL_ENABLED)
                    .lightmap(RenderState.LIGHTMAP_DISABLED)
                    .writeMask(WriteMaskState.COLOR_DEPTH_WRITE)
                    .build(false)
    );

    public static final RenderType Landmark = makeType("LandmarkOverlay",
            DefaultVertexFormats.POSITION_COLOR, GL11.GL_QUADS, 256,
            RenderType.State.getBuilder()
                    .layer(LayerState.POLYGON_OFFSET_LAYERING)
                    .transparency(RenderState.TRANSLUCENT_TRANSPARENCY)
                    .texture(TextureState.NO_TEXTURE)
                    .depthTest(DepthTestState.DEPTH_ALWAYS)
                    .cull(RenderState.CULL_ENABLED)
                    .lightmap(RenderState.LIGHTMAP_DISABLED)
                    .writeMask(WriteMaskState.COLOR_DEPTH_WRITE)
                    .build(false)
    );

    public CustomRenderType(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }
}
