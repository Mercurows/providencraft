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
    private final ResourceLocation HUD2 = new ResourceLocation(Utils.MOD_ID, "textures/gui/chaos_value_bar.png");
    private MatrixStack matrixStack;

    public ChaosCheckerHUD(MatrixStack matrixStack){
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth() / 2;
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight() / 2;
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
    }

    public void setMatrixStack(MatrixStack stack) {
        this.matrixStack = stack;
    }

    public void render() {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(HUD);
        blit(matrixStack, width - 101, height + 10, -0.5f, 0, 200, 32, 200, 32);

        this.minecraft.getTextureManager().bindTexture(HUD2);
        //TODO 根据混沌值实时修改渲染
        blit(matrixStack, width - 66, height + 23, 0.5f, 1, 60, 6, 60, 15);

        blit(matrixStack, width + 6, height + 23, 0.5f, 8, 60, 6, 60, 15);
    }
}
