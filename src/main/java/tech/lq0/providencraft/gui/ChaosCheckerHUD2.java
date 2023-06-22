package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;

public class ChaosCheckerHUD2 extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value_bar.png");
    private MatrixStack matrixStack;
    private final int chaos;

    public ChaosCheckerHUD2(MatrixStack matrixStack, int chaos) {
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
        //TODO 根据混沌值实时修改渲染
        if(chaos > 0) {
            blit(matrixStack, width - 66, height + 23, 0.5f, 1, 60, 6, 60, 15);
        }else if(chaos < 0) {
            blit(matrixStack, width + 6, height + 23, 0.5f, 8, 60 + 60 * chaos / 100, 6, 60, 15);
        }
    }
}
