package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providenceOI.shirako.WorldPeaceStaff;

import java.awt.*;

public class WorldPeaceStaffRenderer {
    public static void render(RenderGameOverlayEvent evt) {
        if (evt.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null && player.getHeldItemMainhand().getItem() == ItemRegistry.WORLD_PEACE_STAFF.get()) {

            if (player.isSpectator()) {
                return;
            }

            ItemStack item = player.getHeldItemMainhand();

            MatrixStack stack = evt.getMatrixStack();
            Minecraft mc = Minecraft.getInstance();

            float blood = WorldPeaceStaff.getAllDamage(item);

            float top = mc.getMainWindow().getScaledHeight() / 2F;

            Matrix4f matrixBar = stack.getLast().getMatrix();
            int left = mc.getMainWindow().getScaledWidth() / 2;

            //边框
            int color_border1 = new Color(11609897).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left - 100, (int) top - 43, left - 98, (int) top + 44, color_border1, color_border1);
            int color_border2 = new Color(11013905).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left - 98, (int) top - 43, left - 95, (int) top - 41, color_border2, color_border2);
            GuiUtils.drawGradientRect(matrixBar, 0, left - 98, (int) top + 42, left - 95, (int) top + 44, color_border2, color_border2);
            int color_border3 = new Color(9899279).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left - 95, (int) top - 43, left - 90, (int) top - 41, color_border3, color_border3);
            GuiUtils.drawGradientRect(matrixBar, 0, left - 95, (int) top + 42, left - 90, (int) top + 44, color_border3, color_border3);
            int color_border4 = new Color(8915981).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left - 90, (int) top - 43, left - 87, (int) top - 41, color_border4, color_border4);
            GuiUtils.drawGradientRect(matrixBar, 0, left - 90, (int) top + 42, left - 87, (int) top + 44, color_border4, color_border4);
            int color_border5 = new Color(7998220).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left - 87, (int) top - 43, left - 85, (int) top + 44, color_border5, color_border5);

            //血条
            int color_blood = new Color(15803756).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 1, left - 98, (int) (top + 41 - blood / 500 * 81), left - 87, (int) top + 42, color_blood, color_blood);

            //刻度
            int color_scale = new Color(15834818).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 40, left - 90, (int) top - 39, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 35, left - 96, (int) top - 34, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 30, left - 96, (int) top - 29, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 25, left - 96, (int) top - 24, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 20, left - 94, (int) top - 19, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 15, left - 96, (int) top - 14, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 10, left - 96, (int) top - 9, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top - 5, left - 96, (int) top - 4, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top, left - 91, (int) top + 1, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 5, left - 96, (int) top + 6, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 10, left - 96, (int) top + 11, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 15, left - 96, (int) top + 16, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 20, left - 94, (int) top + 21, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 25, left - 96, (int) top + 26, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 30, left - 96, (int) top + 31, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 35, left - 96, (int) top + 36, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 40, left - 90, (int) top + 41, color_scale, color_scale);

            //高光
            int color_highlight = new Color(255, 255, 255, 150).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top - 38, left - 95, (int) top - 31, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top - 31, left - 96, (int) top - 26, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top - 23, left - 96, (int) top - 22, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top + 35, left - 96, (int) top + 39, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top + 33, left - 96, (int) top + 34, color_highlight, color_highlight);

            //刀边
            int color_knife1 = new Color(201, 201, 201).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left - 100, (int) top - 31, left - 99, (int) top + 32, color_knife1, color_knife1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 86, (int) top - 31, left - 85, (int) top + 32, color_knife1, color_knife1);
            int color_knife2 = new Color(0, 0, 0).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left - 100, (int) top - 27, left - 99, (int) top + 3, color_knife2, color_knife2);
            int color_knife3 = new Color(49, 49, 49).getRGB();
            for (int i = 0; i < 7; i++) {
                GuiUtils.drawGradientRect(matrixBar, 2, left - 101, (int) top - 26 + i * 3, left - 100, (int) top - 25 + i * 3, color_knife3, color_knife3);
                GuiUtils.drawGradientRect(matrixBar, 2, left - 102, (int) top - 25 + i * 3, left - 101, (int) top - 24 + i * 3, color_knife3, color_knife3);
                GuiUtils.drawGradientRect(matrixBar, 2, left - 102, (int) top - 24 + i * 3, left - 101, (int) top - 23 + i * 3, color_knife2, color_knife2);
                GuiUtils.drawGradientRect(matrixBar, 2, left - 101, (int) top - 25 + i * 3, left - 100, (int) top - 23 + i * 3, color_knife2, color_knife2);
            }
            GuiUtils.drawGradientRect(matrixBar, 2, left - 101, (int) top - 5, left - 100, (int) top - 3, color_knife3, color_knife3);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 102, (int) top - 3, left - 101, (int) top - 2, color_knife3, color_knife3);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 101, (int) top - 3, left - 100, (int) top + 2, color_knife2, color_knife2);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 102, (int) top - 2, left - 101, (int) top + 1, color_knife2, color_knife2);

            //十字架
            int color_cross1 = new Color(12487482).getRGB(); //be8b3a
            int color_cross2 = new Color(12025380).getRGB(); //b77e24
            int color_cross3 = new Color(10776864).getRGB(); //a47120
            int color_cross4 = new Color(9659677).getRGB(); //93651d
            int color_cross5 = new Color(10251038).getRGB();
            int color_cross6 = new Color(12883790).getRGB();
            int color_cross7 = new Color(12289327).getRGB(); //bb852f
            int color_cross8 = new Color(12685636).getRGB();
            int color_cross9 = new Color(11434018).getRGB(); //ae7822
            int color_cross10 = new Color(10251038).getRGB(); //9c6b1e

            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 36, left - 85, (int) top - 35, color_cross1, color_cross1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 36, left - 84, (int) top - 35, color_cross2, color_cross2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 87, (int) top - 35, left - 85, (int) top - 34, color_cross1, color_cross1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 35, left - 83, (int) top - 34, color_cross2, color_cross2);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 87, (int) top - 34, left - 85, (int) top - 33, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 34, left - 83, (int) top - 33, color_cross4, color_cross4);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 33, left - 85, (int) top - 30, color_cross2, color_cross2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 33, left - 84, (int) top - 32, color_cross5, color_cross5);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 32, left - 84, (int) top - 29, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 30, left - 85, (int) top - 29, color_cross7, color_cross7);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 91, (int) top - 30, left - 90, (int) top - 29, color_cross6, color_cross6);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 90, (int) top - 31, left - 89, (int) top - 29, color_cross8, color_cross8);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 89, (int) top - 30, left - 86, (int) top - 29, color_cross1, color_cross1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 91, (int) top - 29, left - 85, (int) top - 28, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 29, left - 79, (int) top - 28, color_cross4, color_cross4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 84, (int) top - 30, left - 80, (int) top - 29, color_cross2, color_cross2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 81, (int) top - 31, left - 80, (int) top - 30, color_cross2, color_cross2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 80, (int) top - 30, left - 79, (int) top - 29, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 81, (int) top - 28, left - 80, (int) top - 27, color_cross4, color_cross4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 90, (int) top - 28, left - 89, (int) top - 27, color_cross4, color_cross4);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 28, left - 85, (int) top - 25, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 28, left - 84, (int) top - 25, color_cross4, color_cross4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 25, left - 85, (int) top - 22, color_cross9, color_cross9);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 25, left - 84, (int) top - 22, color_cross10, color_cross10);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 22, left - 85, (int) top - 18, color_cross2, color_cross2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 85, (int) top - 22, left - 84, (int) top - 16, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 84, (int) top - 18, left - 83, (int) top - 17, color_cross3, color_cross3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 87, (int) top - 17, left - 85, (int) top - 16, color_cross2, color_cross2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 88, (int) top - 18, left - 86, (int) top - 17, color_cross1, color_cross1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 18, left - 85, (int) top - 17, color_cross7, color_cross7);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 86, (int) top - 16, left - 84, (int) top - 15, color_cross4, color_cross4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 84, (int) top - 17, left - 83, (int) top - 16, color_cross4, color_cross4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 83, (int) top - 18, left - 82, (int) top - 17, color_cross4, color_cross4);

            //数字
            int color_max = new Color(16735067).getRGB();
            int color_dot = new Color(16764365).getRGB();

            GuiUtils.drawGradientRect(matrixBar, 4, left - 107, (int) top - 38, left - 106, (int) top - 37, color_dot, color_dot);
            SpecialRender.drawNumber(matrixBar, 4, left - 105, (int) top - 42, 0, color_max);
            SpecialRender.drawNumber(matrixBar, 4, left - 111, (int) top - 42, 0, color_max);
            SpecialRender.drawNumber(matrixBar, 4, left - 115, (int) top - 42, 0, color_max);
            SpecialRender.drawNumber(matrixBar, 4, left - 119, (int) top - 42, 5, color_max);

            GuiUtils.drawGradientRect(matrixBar, 4, left - 107, (int) top + 42, left - 106, (int) top + 43, color_dot, color_dot);

            int num_1 = (int) blood / 100;
            int num_2 = (int) blood / 10 % 10;
            int num_3 = (int) blood % 10;
            int num_4 = (int) (blood * 10 % 10);

            SpecialRender.drawNumber(matrixBar, 4, left - 119, (int) top + 38, num_1, color_blood);
            SpecialRender.drawNumber(matrixBar, 4, left - 115, (int) top + 38, num_2, color_blood);
            SpecialRender.drawNumber(matrixBar, 4, left - 111, (int) top + 38, num_3, color_blood);
            SpecialRender.drawNumber(matrixBar, 4, left - 105, (int) top + 38, num_4, color_blood);

            /* 兔子 */
            int color_usagi1 = new Color(255, 255, 255).getRGB(); //ffffff
            int color_usagi2 = new Color(241, 241, 241).getRGB(); //f1f1f1
            int color_usagi3 = new Color(247, 247, 247).getRGB(); //f7f7f7
            int color_usagi4 = new Color(226, 226, 226).getRGB(); //e2e2e2

            int color_usagi_border1 = new Color(161, 161, 161).getRGB(); //a1a1a1
            int color_usagi_border2 = new Color(168, 168, 168).getRGB(); //a8a8a8
            int color_usagi_border3 = new Color(157, 157, 157).getRGB(); //9d9d9d
            int color_usagi_border4 = new Color(137, 137, 137).getRGB(); //898989

            //脸部
            GuiUtils.drawGradientRect(matrixBar, 2, left - 112, (int) top - 5, left - 110, (int) top + 4, color_usagi1, color_usagi1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 108, (int) top - 5, left - 106, (int) top + 4, color_usagi1, color_usagi1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 110, (int) top - 2, left - 108, (int) top + 4, color_usagi1, color_usagi1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 113, (int) top - 2, left - 112, (int) top + 3, color_usagi1, color_usagi1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 114, (int) top - 1, left - 113, (int) top + 2, color_usagi1, color_usagi1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 106, (int) top - 2, left - 105, (int) top + 3, color_usagi1, color_usagi1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 105, (int) top - 1, left - 104, (int) top + 2, color_usagi1, color_usagi1);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 113, (int) top - 2, left - 112, (int) top - 1, color_usagi2, color_usagi2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 109, (int) top - 2, left - 108, (int) top - 1, color_usagi2, color_usagi2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 105, (int) top - 1, left - 104, (int) top, color_usagi2, color_usagi2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 105, (int) top + 1, left - 104, (int) top + 2, color_usagi2, color_usagi2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 107, (int) top + 3, left - 106, (int) top + 4, color_usagi2, color_usagi2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 112, (int) top + 3, left - 111, (int) top + 4, color_usagi2, color_usagi2);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 111, (int) top + 2, left - 110, (int) top + 3, color_usagi2, color_usagi2);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 113, (int) top + 2, left - 112, (int) top + 3, color_usagi3, color_usagi3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 110, (int) top + 3, left - 109, (int) top + 4, color_usagi3, color_usagi3);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 114, (int) top + 1, left - 113, (int) top + 2, color_usagi4, color_usagi4);

            //边框
            GuiUtils.drawGradientRect(matrixBar, 3, left - 113, (int) top - 5, left - 112, (int) top - 2, color_usagi_border1, color_usagi_border1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 112, (int) top - 6, left - 110, (int) top - 5, color_usagi_border1, color_usagi_border1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 114, (int) top - 2, left - 113, (int) top - 1, color_usagi_border1, color_usagi_border1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 115, (int) top - 1, left - 114, (int) top + 2, color_usagi_border1, color_usagi_border1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 114, (int) top + 2, left - 113, (int) top + 3, color_usagi_border1, color_usagi_border1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 113, (int) top + 3, left - 112, (int) top + 4, color_usagi_border1, color_usagi_border1);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 112, (int) top + 4, left - 110, (int) top + 5, color_usagi_border1, color_usagi_border1);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 110, (int) top - 5, left - 109, (int) top - 2, color_usagi_border2, color_usagi_border2);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 110, (int) top + 4, left - 108, (int) top + 5, color_usagi_border3, color_usagi_border3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 109, (int) top - 5, left - 108, (int) top - 2, color_usagi_border3, color_usagi_border3);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 108, (int) top - 6, left - 106, (int) top - 5, color_usagi_border3, color_usagi_border3);

            GuiUtils.drawGradientRect(matrixBar, 3, left - 106, (int) top - 5, left - 105, (int) top - 2, color_usagi_border4, color_usagi_border4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 105, (int) top - 2, left - 104, (int) top - 1, color_usagi_border4, color_usagi_border4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 104, (int) top - 1, left - 103, (int) top + 2, color_usagi_border4, color_usagi_border4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 105, (int) top + 2, left - 104, (int) top + 3, color_usagi_border4, color_usagi_border4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 106, (int) top + 3, left - 105, (int) top + 4, color_usagi_border4, color_usagi_border4);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 108, (int) top + 4, left - 106, (int) top + 5, color_usagi_border4, color_usagi_border4);

            //可变色眼睛
            Color color_eye1 = new Color(13777775);
            Color color_eye2 = new Color(16711722);

            int eye_r = (int) Math.min(255, color_eye1.getRed() + (color_eye2.getRed() - color_eye1.getRed()) * blood / 500);
            int eye_g = (int) Math.min(255, color_eye1.getGreen() + (color_eye2.getGreen() - color_eye1.getGreen()) * blood / 500);
            int eye_b = (int) Math.min(255, color_eye1.getBlue() + (color_eye2.getBlue() - color_eye1.getBlue()) * blood / 500);
            int color_eye = new Color(eye_r, eye_g, eye_b).getRGB();

            GuiUtils.drawGradientRect(matrixBar, 3, left - 108, (int) top - 1, left - 107, (int) top + 1, color_eye, color_eye);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 111, (int) top - 1, left - 110, (int) top + 1, color_eye, color_eye);

            //如果玩家在使用，兔子冒红光
            int color_usagi_awaken1 = new Color(15542894).getRGB();
            int color_usagi_awaken2 = new Color(14752865).getRGB();

            if (player.isHandActive() && blood >= 5.0f) {
                GuiUtils.drawGradientRect(matrixBar, 4, left - 113, (int) top - 5, left - 112, (int) top - 2, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 112, (int) top - 6, left - 110, (int) top - 5, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 114, (int) top - 2, left - 113, (int) top - 1, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 115, (int) top - 1, left - 114, (int) top + 2, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 114, (int) top + 2, left - 113, (int) top + 3, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 113, (int) top + 3, left - 112, (int) top + 4, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 112, (int) top + 4, left - 110, (int) top + 5, color_usagi_awaken1, color_usagi_awaken1);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 110, (int) top - 5, left - 109, (int) top - 2, color_usagi_awaken1, color_usagi_awaken1);

                GuiUtils.drawGradientRect(matrixBar, 4, left - 110, (int) top + 4, left - 108, (int) top + 5, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 109, (int) top - 5, left - 108, (int) top - 2, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 108, (int) top - 6, left - 106, (int) top - 5, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 106, (int) top - 5, left - 105, (int) top - 2, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 105, (int) top - 2, left - 104, (int) top - 1, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 104, (int) top - 1, left - 103, (int) top + 2, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 105, (int) top + 2, left - 104, (int) top + 3, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 106, (int) top + 3, left - 105, (int) top + 4, color_usagi_awaken2, color_usagi_awaken2);
                GuiUtils.drawGradientRect(matrixBar, 4, left - 108, (int) top + 4, left - 106, (int) top + 5, color_usagi_awaken2, color_usagi_awaken2);
            }
        }
    }
}
