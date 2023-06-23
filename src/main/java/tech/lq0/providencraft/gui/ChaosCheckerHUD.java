package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;

public class ChaosCheckerHUD extends AbstractGui {
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value.png");
    private final ResourceLocation BAR = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value_bar.png");
    private int lastStatus = 0;
    private float progress = 0;
    private int lastX = 0;
    private int lastY = 0;
    private int lastW = 0;
    private int lastH = 0;
    private float lastAlpha = 0;
    private boolean is0to1 = false;

    public ChaosCheckerHUD() {
        this.minecraft = Minecraft.getInstance();
    }

    public void render(MatrixStack matrixStack, int chaos, int status, float partialTick, boolean addTick) {

        int width = minecraft.getMainWindow().getScaledWidth() / 2;
        int height = minecraft.getMainWindow().getScaledHeight() / 2;

        float maxProgress = 40;
        if (addTick){
            progress = Math.min(maxProgress, progress + 1);
        }

        float alpha;
        if (status == 1) {
            alpha = 0.5f;
        } else if (status == 2) {
            alpha = 1;
        } else {
            alpha = 0;
        }
        if (status != lastStatus) {
            progress = 0;
            if (lastStatus != 2) {
                lastW = 100;
                lastH = 16;
                lastX = width - 50;
                lastY = 0;
                lastAlpha = lastStatus == 1 ? 0.5f : 0;
            } else {
                lastW = 200;
                lastH = 32;
                lastX = width - 101;
                lastY = height + 10;
                lastAlpha = 1;
            }
            if (lastStatus == 0 && status == 1) is0to1 = true;
            lastStatus = status;
        }

        float rate;
        if (progress == maxProgress) {
            rate = 1;
            is0to1 = false;
        } else {
            progress = (int) progress + partialTick;
            rate = (float) Math.sqrt(Math.sqrt(progress / maxProgress));
        }

        // 设置透明度
        // TODO 修复透明度无效的Bug
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, ease(lastAlpha, alpha, rate));
        RenderSystem.disableAlphaTest();

        // 渲染外框
        this.minecraft.getTextureManager().bindTexture(HUD);
        if (status == 2) {
            blit(matrixStack, ease(lastX, width - 101, rate), ease(lastY, height + 10, rate), ease(lastW, 200, rate), ease(lastH, 32, rate), -0.5f, 0, 200, 32, 200, 32);
        } else {
            blit(matrixStack, ease(lastX, width - 50, rate), ease(lastY, 0, rate), ease(lastW, 100, rate), ease(lastH, 16, rate), -0.5f, 0, 200, 32, 200, 32);
        }

        // 渲染条
        this.minecraft.getTextureManager().bindTexture(BAR);
        if (is0to1) {
            rate = 1;
        }

        final int start = width - 33 + 30 - 30 * chaos / 100;
        final int end = width - 66 + 60 - 60 * chaos / 100;
        if (status == 2) {
            if (chaos > 0) {
                blit(matrixStack, ease(start, end, rate),
                        ease(6, height + 23, rate),
                        ease(30 * chaos / 100, 60 * chaos / 100, rate),
                        ease(4, 6, rate),
                        ease(60 - (int) (60 * chaos / 100f), 0.5f + 60 - (int) (60 * chaos / 100f), rate),
                        1,
                        60 * chaos / 100, 6, 60, 15);
            } else if (chaos < 0) {
                blit(matrixStack, width + ease(3, 6, rate),
                        ease(6, height + 23, rate),
                        ease(30 * chaos / -100, 60 * chaos / -100, rate),
                        ease(4, 6, rate),
                        0.5f,
                        8,
                        60 + 60 * chaos / 100, 6, 60, 15);
            }
        } else {
            if (chaos > 0) {
                blit(matrixStack, ease(end, start, rate),
                        ease(height + 23, 6, rate),
                        ease(60 * chaos / 100, 30 * chaos / 100, rate),
                        ease(6, 4, rate),
                        ease(0.5f + 60 - (int) (60 * chaos / 100f), 60 - (int) (60 * chaos / 100f), rate),
                        0.5f,
                        60 * chaos / 100, 7, 60, 15);
            } else if (chaos < 0) {
                blit(matrixStack, width + ease(6, 3, rate),
                        ease(height + 23, 6, rate),
                        ease(60 * chaos / -100, 30 * chaos / -100, rate),
                        ease(6, 4, rate),
                        0.5f,
                        ease(7.5f, 8, rate),
                        60 + 60 * chaos / 100, 7, 60, 15);
            }
        }


        // 还原透明度
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.enableAlphaTest();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);


    }

    private static int ease(int start, int end, float rate) {
        return (int) (start + (end - start) * rate);
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }
}
