package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.item.providenceOI.shirako.MomoPhone;
import tech.lq0.providencraft.tools.ItemNBTTool;

import java.awt.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpecialRender {

    public static final double MAX_DISTANCE = 500;

    @SubscribeEvent
    public static void renderWorldLastEvent(RenderWorldLastEvent evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getHeldItemMainhand();
        if (item.getItem() instanceof MomoPhone) {
            float posX = ItemNBTTool.getFloat(item, MomoPhone.NBT_POS_X, Float.NaN) - .5F;
            float posY = ItemNBTTool.getFloat(item, MomoPhone.NBT_POS_Y, Float.NaN) - .5F;
            float posZ = ItemNBTTool.getFloat(item, MomoPhone.NBT_POS_Z, Float.NaN) - .5F;
            if (!(Float.isNaN(posX) || Float.isNaN(posY) || Float.isNaN(posZ))) {
                double distance = Math.sqrt(Math.pow(posX - player.getPosX(), 2) + Math.pow(posZ - player.getPosZ(), 2));

                if (distance > MAX_DISTANCE) {
                    posX = (float) (player.getPosX() - (player.getPosX() - posX) * (MAX_DISTANCE / distance));
                    posZ = (float) (player.getPosZ() - (player.getPosZ() - posZ) * (MAX_DISTANCE / distance));
                }

                if (player.getCooldownTracker().getCooldown(item.getItem(), evt.getPartialTicks()) > 0) {
                    renderLandmark(evt.getMatrixStack(), new BlockPos(posX, posY, posZ), Color.gray);
                } else {
                    renderLandmark(evt.getMatrixStack(), new BlockPos(posX, posY, posZ), Color.green);
                }
            }
        }
    }

    private static void renderLandmark(MatrixStack matrix, BlockPos pos, Color color) {
        net.minecraft.client.renderer.IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();

        Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();

        int posX = pos.getX(), posY = pos.getY(), posZ = pos.getZ();
        matrix.push();
        matrix.translate(-view.x, 0, -view.z);

        IVertexBuilder builder;
        builder = buffer.getBuffer(CustomRenderType.Landmark);

        {
            matrix.push();
            matrix.translate(posX, posY, posZ);
            matrix.translate(-0.005f, -0.005f, -0.005f);
            matrix.scale(1.01f, 1.01f, 1.01f);
            matrix.rotate(Vector3f.YP.rotationDegrees(-90.0F));
            matrix.translate(0, -posY, 0);

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

    private static void renderBlock(MatrixStack matrix, BlockPos pos, Color color) {
        net.minecraft.client.renderer.IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();

        Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();

        int posX = pos.getX(), posY = pos.getY(), posZ = pos.getZ();
        matrix.push();
        matrix.translate(-view.x, -view.y + 1.5F, -view.z);

        IVertexBuilder builder;
        builder = buffer.getBuffer(CustomRenderType.BlockOverlay);

        {
            matrix.push();
            matrix.translate(posX, posY, posZ);
            matrix.translate(-0.005f, -0.005f, -0.005f);
            matrix.scale(1.01f, 1.01f, 1.01f);
            matrix.rotate(Vector3f.YP.rotationDegrees(-90.0F));
            matrix.translate(0, -posY, 0);

            Matrix4f matrix4f = matrix.getLast().getMatrix();
            float red = color.getRed() / 255f, green = color.getGreen() / 255f, blue = color.getBlue() / 255f;

            float alpha = .2f;
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
