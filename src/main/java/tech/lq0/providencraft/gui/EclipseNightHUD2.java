package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;

public class EclipseNightHUD2 extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation("textures/misc/nausea.png");
    private MatrixStack matrixStack;
    private final float level;

    public EclipseNightHUD2(MatrixStack matrixStack, float level) {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
        this.level = level;
    }

    public void setMatrixStack(MatrixStack stack) {
        this.matrixStack = stack;
    }

    public void render() {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        RenderSystem.color4f(0.1F * level, 0.0F, 0.02F * level, 1.0F);
        RenderSystem.disableAlphaTest();
        this.minecraft.getTextureManager().bindTexture(HUD);
        blit(matrixStack, 0, 0, 0, 0, width, height, width, height);
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.enableAlphaTest();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
