package tech.lq0.providencraft.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.tools.ItemNBTTool;

@OnlyIn(Dist.CLIENT)
public class RainyButterflyHUD extends AbstractGui {
    private final ResourceLocation HUD = new ResourceLocation(Utils.MOD_ID, "textures/gui/rainy_butterfly_hud.png");
    private final MatrixStack matrixStack;
    private final ItemStack stack;
    private final boolean rain;

    public RainyButterflyHUD(MatrixStack matrixStack, ItemStack stack, boolean rain){
        this.matrixStack = matrixStack;
        this.stack = stack;
        this.rain = rain;
    }

    public void render() {
        Minecraft minecraft = Minecraft.getInstance();

        int max_count = rain ? 9 : 3;
        int count = ItemNBTTool.getInt(stack, "rainy_butterfly_count", 0);

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.enableBlend();

        int top = minecraft.getMainWindow().getScaledHeight() - ForgeIngameGui.right_height;
        int left = minecraft.getMainWindow().getScaledWidth() / 2 + 82;
        minecraft.getTextureManager().bindTexture(HUD);

        //渲染空蝴蝶
        for(int i = 0; i < max_count; i++){
            blit(matrixStack, left - i * 8, top, 0, 0, 9, 9, 20, 9);
        }

        //渲染彩蝴蝶
        for(int i = 0; i < count; i++){
            blit(matrixStack, left - i * 8, top, 10, 0, 9, 9, 20, 9);
        }

    }
}
