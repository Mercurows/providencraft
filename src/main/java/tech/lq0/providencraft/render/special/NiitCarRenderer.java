package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import tech.lq0.providencraft.entity.NiitCarEntity;

import java.awt.*;

public class NiitCarRenderer {
    public static void render(RenderGameOverlayEvent evt) {
        if (evt.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null && player.getRidingEntity() instanceof NiitCarEntity) {
            MatrixStack stack = evt.getMatrixStack();
            Minecraft mc = Minecraft.getInstance();

            NiitCarEntity car = (NiitCarEntity) player.getRidingEntity();

            double spd = Math.min(car.getSpeed(), 80.0);

            FontRenderer f = Minecraft.getInstance().fontRenderer;
            String spdStr = String.format("%.2f km/h", spd);
            float left = mc.getMainWindow().getScaledWidth() / 2F - f.getStringWidth(spdStr) / 2F;
            float top = mc.getMainWindow().getScaledHeight() / 2F + 20;

            Matrix4f matrixBar = stack.getLast().getMatrix();
            int left2 = mc.getMainWindow().getScaledWidth() / 2 - 50;

            GuiUtils.drawGradientRect(matrixBar, 1, left2 + 100, (int) top + 14, (int) (left2 + (spd / 80 * 100)), (int) (top + 13), 0xaa888888, 0xaa888888);

            int color;
            if (spd <= 40) {
                Color temp = Color.GREEN;
                int r = (int) (temp.getRed() + (Color.YELLOW.getRed() - temp.getRed()) * spd / 40);
                int g = (int) (temp.getGreen() + (Color.YELLOW.getGreen() - temp.getGreen()) * spd / 40);
                int b = (int) (temp.getBlue() + (Color.YELLOW.getBlue() - temp.getBlue()) * spd / 40);
                color = new Color(r, g, b).getRGB();
            } else {
                Color temp = Color.YELLOW;
                int r = (int) (temp.getRed() + (Color.RED.getRed() - temp.getRed()) * (spd - 40) / 40);
                int g = (int) (temp.getGreen() + (Color.RED.getGreen() - temp.getGreen()) * (spd - 40) / 40);
                int b = (int) (temp.getBlue() + (Color.RED.getBlue() - temp.getBlue()) * (spd - 40) / 40);
                color = new Color(r, g, b).getRGB();
            }

            GuiUtils.drawGradientRect(matrixBar, 1, (int) (left2 + (spd / 80 * 100)), (int) top + 14, left2, (int) (top + 13), color, color);
            f.drawStringWithShadow(evt.getMatrixStack(), spdStr, left, top, color);
        }
    }
}
