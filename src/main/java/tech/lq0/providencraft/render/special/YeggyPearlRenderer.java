package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import tech.lq0.providencraft.gui.YeggyPearlHUD;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providenceOI.yesa.YeggyPearl;
import tech.lq0.providencraft.tools.RenderTool;

import java.awt.*;

public class YeggyPearlRenderer {
    public static void render(RenderGameOverlayEvent evt) {
        if (evt.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null && player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemRegistry.YEGGY_PEARL.get()) {

            if (player.isSpectator()) {
                return;
            }

            ItemStack itemStack = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            MatrixStack stack = evt.getMatrixStack();
            Minecraft mc = Minecraft.getInstance();

            int energy = YeggyPearl.getEnergy(itemStack);
            float times = YeggyPearl.getDamageTimes(energy);

            float left = mc.getMainWindow().getScaledWidth() / 2F;
            float top = mc.getMainWindow().getScaledHeight() / 2F - 20;

            Matrix4f matrixBar = stack.getLast().getMatrix();
            YeggyPearlHUD yeggyPearlHUD = new YeggyPearlHUD(stack);
            yeggyPearlHUD.render();

            int color1 = new Color(0xa1c4fc).getRGB();
            int color2 = new Color(0x6e99dd).getRGB();
            int color3 = new Color(0xc0addb).getRGB();

            RenderTool.drawGradientRect(matrixBar, 1, left - 42.5f + 67 * energy / 80, (int) top + 74, (int) left - 43f, (int) top + 72, color1, color1);
            RenderTool.drawGradientRect(matrixBar, 1, left - 42.5f + 67 * energy / 80, (int) top + 75, (int) left - 43f, (int) top + 74, color2, color2);

            int num1 = (int) times;
            int num2 = (int) (times * 10) % 10;
            int num3 = (int) (times * 100) % 10;

            SpecialRender.drawNumber(matrixBar, 1, (int) left - 43, (int) top + 64, num1, color1);
            GuiUtils.drawGradientRect(matrixBar, 1, (int) left - 39, (int) top + 68, (int) left - 38, (int) top + 69, color3, color3);
            SpecialRender.drawNumber(matrixBar, 1, (int) left - 37, (int) top + 64, num2, color1);
            SpecialRender.drawNumber(matrixBar, 1, (int) left - 33, (int) top + 64, num3, color1);

            GuiUtils.drawGradientRect(matrixBar, 1, (int) left - 29, (int) top + 68, (int) left - 28, (int) top + 69, color3, color3);
            GuiUtils.drawGradientRect(matrixBar, 1, (int) left - 27, (int) top + 68, (int) left - 26, (int) top + 69, color3, color3);
            GuiUtils.drawGradientRect(matrixBar, 1, (int) left - 28, (int) top + 67, (int) left - 27, (int) top + 68, color3, color3);
            GuiUtils.drawGradientRect(matrixBar, 1, (int) left - 29, (int) top + 66, (int) left - 28, (int) top + 67, color3, color3);
            GuiUtils.drawGradientRect(matrixBar, 1, (int) left - 27, (int) top + 66, (int) left - 26, (int) top + 67, color3, color3);
        }
    }
}
