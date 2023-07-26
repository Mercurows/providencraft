package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SpecialRender {
    @SubscribeEvent
    public static void renderWorldLastEvent(RenderWorldLastEvent evt) {
        MomoPhoneRenderer.render(evt);
        MountainDestroyerRenderer.render(evt);
        LeviyRenderer.render(evt);
    }

    @SubscribeEvent
    public static void renderOverlay(RenderGameOverlayEvent evt) {
        NiitCarRenderer.render(evt);
        YeggyPearlRenderer.render(evt);
        WorldPeaceStaffRenderer.render(evt);
    }

    public static void drawNumber(Matrix4f matrix, int level, int left, int top, int num, int color) {
        switch (num) {
            case 0:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 1, top + 5, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top, left + 3, top + 5, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 1, top, left + 2, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 1, top + 4, left + 2, top + 5, color, color);
                break;
            case 1:
                GuiUtils.drawGradientRect(matrix, level, left + 2, top, left + 3, top + 5, color, color);
                break;
            case 2:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 1, left + 3, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 2, left + 3, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 3, left + 1, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 4, left + 3, top + 5, color, color);
                break;
            case 3:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 1, left + 3, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 2, left + 3, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 3, left + 3, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 4, left + 3, top + 5, color, color);
                break;
            case 4:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 1, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 1, top + 2, left + 2, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top, left + 3, top + 5, color, color);
                break;
            case 5:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 1, left + 1, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 2, left + 3, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 3, left + 3, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 4, left + 3, top + 5, color, color);
                break;
            case 6:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 1, left + 1, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 2, left + 3, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 3, left + 1, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 3, left + 3, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 4, left + 3, top + 5, color, color);
                break;
            case 7:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 1, left + 3, top + 5, color, color);
                break;
            case 8:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 1, left + 1, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 1, left + 3, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 2, left + 3, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 3, left + 1, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 3, left + 3, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 4, left + 3, top + 5, color, color);
                break;
            case 9:
                GuiUtils.drawGradientRect(matrix, level, left, top, left + 3, top + 1, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 1, left + 1, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 1, left + 3, top + 2, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 2, left + 3, top + 3, color, color);
                GuiUtils.drawGradientRect(matrix, level, left + 2, top + 3, left + 3, top + 4, color, color);
                GuiUtils.drawGradientRect(matrix, level, left, top + 4, left + 3, top + 5, color, color);
                break;
            default:
                break;
        }
    }

    public static void renderLandmark(MatrixStack matrix, BlockPos pos, Color color) {
        float x = pos.getX();
        float y = pos.getY();
        float z = pos.getZ();
        renderLandmark(matrix, x, y, z, color);
    }

    public static void renderLandmark(MatrixStack matrix, float x, float y, float z, Color color) {
        net.minecraft.client.renderer.IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();

        Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();

        matrix.push();
        matrix.translate(-view.x, 0, -view.z);

        IVertexBuilder builder;
        builder = buffer.getBuffer(CustomRenderType.Landmark);

        {
            matrix.push();
            matrix.translate(x, y, z);
            matrix.translate(-0.005f, -0.005f, -0.005f);
            matrix.scale(1.01f, 1.01f, 1.01f);
            matrix.rotate(Vector3f.YP.rotationDegrees(-90.0F));
            matrix.translate(0, -y, 0);

            Matrix4f matrix4f = matrix.getLast().getMatrix();
            float red = color.getRed() / 255f, green = color.getGreen() / 255f, blue = color.getBlue() / 255f, alpha = .5f;
            float startX = 0, startY = -1000, startZ = -1, endX = 1, endY = 1000, endZ = 0;

            //east
            builder.pos(matrix4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();

            //west
            builder.pos(matrix4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();

            //south
            builder.pos(matrix4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();

            //north
            builder.pos(matrix4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();

            matrix.pop();
        }

        matrix.pop();
        RenderSystem.disableDepthTest();
        buffer.finish(CustomRenderType.Landmark);
    }

    public static void renderBlock(MatrixStack matrix, BlockPos pos, Color color) {
        renderBlock(matrix, pos, color, .2f);
    }

    public static void renderBlock(MatrixStack matrix, BlockPos pos, Color color, float alpha) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        renderBlock(matrix, x, y, z, color, alpha);
    }

    public static void renderBlock(MatrixStack matrix, float x, float y, float z, Color color, float alpha) {
        net.minecraft.client.renderer.IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();

        Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();

        matrix.push();
        matrix.translate(-view.x, -view.y, -view.z);

        IVertexBuilder builder;
        builder = buffer.getBuffer(CustomRenderType.BlockOverlay);

        {
            matrix.push();
            matrix.translate(x, y, z);
            matrix.translate(-0.0001f, -0.0001f, -0.0001f);
            matrix.scale(1.0001f, 1.0001f, 1.0001f);
            matrix.rotate(Vector3f.YP.rotationDegrees(-90.0F));
            matrix.translate(0, 0, 0);

            Matrix4f matrix4f = matrix.getLast().getMatrix();
            float red = color.getRed() / 255f, green = color.getGreen() / 255f, blue = color.getBlue() / 255f;

            float startX = 0, startY = 0, startZ = -1, endX = 1, endY = 1, endZ = 0;
            //down
            builder.pos(matrix4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();

            //up
            builder.pos(matrix4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();

            //east
            builder.pos(matrix4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();

            //west
            builder.pos(matrix4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();

            //south
            builder.pos(matrix4f, endX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, endX, startY, endZ).color(red, green, blue, alpha).endVertex();

            //north
            builder.pos(matrix4f, startX, startY, startZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, startY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, endZ).color(red, green, blue, alpha).endVertex();
            builder.pos(matrix4f, startX, endY, startZ).color(red, green, blue, alpha).endVertex();

            matrix.pop();
        }

        matrix.pop();
        RenderSystem.disableDepthTest();
        buffer.finish(CustomRenderType.BlockOverlay);
    }
}
