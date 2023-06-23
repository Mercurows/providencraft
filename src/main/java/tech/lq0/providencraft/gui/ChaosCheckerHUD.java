package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;

public class ChaosCheckerHUD extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value.png");
    private MatrixStack matrixStack;
    private final int chaos;

    public ChaosCheckerHUD(MatrixStack matrixStack, int chaos) {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth() / 2;
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight() / 2;
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
        this.chaos = chaos;
    }

    public void setMatrixStack(MatrixStack stack) {
        this.matrixStack = stack;
    }

    public void render() {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(HUD);
        blit(matrixStack, width - 101, height + 10, -0.5f, 0, 200, 32, 200, 32);
        this.minecraft.getTextureManager().bindTexture(new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value_bar.png"));

        if (chaos > 0) {
            blit(matrixStack, width - 66 + 60 - 60 * chaos / 100, height + 23, 60 - 60 * chaos / 100, 1, 60 * chaos / 100, 6, 60, 15);
        } else if (chaos < 0) {
            blit(matrixStack, width + 6, height + 23, 0.5f, 8, 60 * chaos / -100, 6, 60, 15);
        }
    }
}
