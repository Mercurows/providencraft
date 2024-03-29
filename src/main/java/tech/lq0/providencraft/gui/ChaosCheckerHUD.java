package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.tools.RenderTool;
import tech.lq0.providencraft.Utils;

public class ChaosCheckerHUD extends AbstractGui {
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value.png");
    private final ResourceLocation BAR = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value_bar.png");
    private int lastStatus = 0;
    private long lastChangeTime = 0;
    private float lastX = 0;
    private float lastY = 0;
    private float lastW = 0;
    private float lastH = 0;
    private float lastAlpha = 0;
    private boolean is0to1 = false;

    private int lastChaos = 0;
    private long lastChaosChangeTime = 0;
    private boolean chaosAnimateFinished = true;

    public ChaosCheckerHUD() {
        this.minecraft = Minecraft.getInstance();
    }

    public void render(MatrixStack matrixStack, int chaos, int status) {

        float width = minecraft.getMainWindow().getScaledWidth() / 2f;
        float height = minecraft.getMainWindow().getScaledHeight() / 2f;

        long MAX_PROGRESS = 300;   // 动画持续时间，单位：毫秒
        float progress = System.currentTimeMillis() - lastChangeTime;

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
            is0to1 = lastStatus == 0 && status == 1;
            lastStatus = status;
            lastChangeTime = System.currentTimeMillis();
        }

        float rate = (float) Math.min(1, Math.sqrt(Math.sqrt(progress / MAX_PROGRESS)));

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
            RenderTool.preciseBlit(matrixStack, ease(lastX, width - 101, rate), ease(lastY, height + 10, rate), ease(lastW, 200, rate), ease(lastH, 32, rate), -0.5f, 0, 200, 32, 200, 32);
        } else {
            RenderTool.preciseBlit(matrixStack, ease(lastX, width - 50, rate), ease(lastY, 0, rate), ease(lastW, 100, rate), ease(lastH, 16, rate), -0.5f, 0, 200, 32, 200, 32);
        }

        // 渲染条
        this.minecraft.getTextureManager().bindTexture(BAR);
        if (is0to1) {
            rate = 1;
        }

        if (chaosAnimateFinished && chaos != lastChaos) {
            lastChaosChangeTime = System.currentTimeMillis();
            chaosAnimateFinished = false;
        }
        float msPassed = System.currentTimeMillis() - lastChaosChangeTime;

        float chaosRate = (float) Math.min(1, Math.sqrt(Math.sqrt(msPassed / MAX_PROGRESS)));

        // 动画播放过程中的临时混沌值
        float tempChaos = ease(lastChaos, chaos, chaosRate);
        final float start = width - 33 + 30 - 30 * tempChaos / 100f;
        final float end = width - 66 + 60 - 60 * tempChaos / 100f;

        if (status == 2) {
            // 转换到屏幕中间显示
            if (tempChaos > 0) {
                // 混沌
                RenderTool.preciseBlit(matrixStack, ease(start, end, rate),
                        ease(6, height + 23, rate),
                        ease(30 * tempChaos / 100f, 60 * tempChaos / 100f, rate),
                        ease(4, 6, rate),
                        ease(60 - (60 * tempChaos / 100f), 0.5f + 60 - (60 * tempChaos / 100f), rate),
                        1,
                        60 * tempChaos / 100f, 6, 60, 15);
            } else if (tempChaos < 0) {
                // 清楚
                RenderTool.preciseBlit(matrixStack, width + ease(3, 6, rate),
                        ease(6, height + 23, rate),
                        ease(30 * tempChaos / -100f, 60 * tempChaos / -100f, rate),
                        ease(4, 6, rate),
                        0.5f,
                        8,
                        60 * tempChaos / -100f, 6, 60, 15);
            }
            FontRenderer font = Minecraft.getInstance().fontRenderer;
            String text = String.format("%.1f", Math.abs(tempChaos));
            float tempRate = (tempChaos + 100) / 200f;
            font.drawStringWithShadow(matrixStack, text, width - font.getStringWidth(text) / 2f, height + 36, 0xFF << 16 | ease(0xF9, 0xD0, tempRate) << 8 | ease(0xE1, 0xE5, tempRate));
        } else {
            // 转换到屏幕顶端显示/消失
            if (tempChaos > 0) {
                // 混沌
                RenderTool.preciseBlit(matrixStack, ease(end, start + 0.5f, rate),
                        ease(height + 23, 6.5f, rate),
                        ease(60 * tempChaos / 100f, 30 * tempChaos / 100f, rate),
                        ease(6, 3, rate),
                        ease(0.5f + 60 - (60 * tempChaos / 100f), 60 - (60 * tempChaos / 100f), rate),
                        1,
                        60 * tempChaos / 100f, 6, 60, 15);
            } else if (tempChaos < 0) {
                // 清楚
                RenderTool.preciseBlit(matrixStack, width + ease(6, 4, rate),
                        ease(height + 23, 6.5f, rate),
                        ease(60 * tempChaos / -100f, 30 * tempChaos / -100f, rate),
                        ease(6, 3, rate),
                        1,
                        8,
                        60 * tempChaos / -100f, 6, 60, 15);
            }
        }

        if (msPassed >= MAX_PROGRESS) {
            if (!chaosAnimateFinished) {
                lastChaos = chaos;
            }
            chaosAnimateFinished = true;
        }


        // 还原透明度
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.enableAlphaTest();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }

    private static int ease(int start, int end, float rate) {
        return (int) (start + (end - start) * rate);
    }
}
