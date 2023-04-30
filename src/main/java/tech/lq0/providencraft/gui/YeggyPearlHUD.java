package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import tech.lq0.providencraft.Utils;

public class YeggyPearlHUD extends AbstractGui {
    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/yeggy_pearl_hud.png");
    private MatrixStack matrixStack;

    public YeggyPearlHUD(MatrixStack matrixStack){
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
        blit(matrixStack, width - 48, height + 5, -0.5f, -0.5f, 96, 96, 96, 96);
    }
}
