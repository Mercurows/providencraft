package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;

@OnlyIn(Dist.CLIENT)
public class SecondaryCataclysmHUD extends AbstractGui {
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/hirenade_hud.png");
    private final MatrixStack matrixStack;
    private final ItemStack stack;

    public SecondaryCataclysmHUD(MatrixStack matrixStack, ItemStack stack){
        this.matrixStack = matrixStack;
        this.stack = stack;
    }

    public void render() {
        Minecraft minecraft = Minecraft.getInstance();

        int count = ItemNBTTool.getInt(stack, "Ammo", 0);

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.enableBlend();

        int top = minecraft.getMainWindow().getScaledHeight() / 2 + 15;
        int left = minecraft.getMainWindow().getScaledWidth() / 2 + 14;
        minecraft.getTextureManager().bindTexture(HUD);

        for(int i = 0; i < 6; i++){
            blit(matrixStack, left - i * 8, top, 10, 0, 9, 9, 20, 9);
        }

        for(int i = 0; i < count; i++){
            blit(matrixStack, left - 40 + i * 8, top, 0, 0, 9, 9, 20, 9);
        }

    }
}
