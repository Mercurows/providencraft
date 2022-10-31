package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.entity.NiitCarEntity;
import tech.lq0.providencraft.item.providenceOI.shirako.MomoPhone;
import tech.lq0.providencraft.item.providencefirst.myanna.MountainDestroyer;
import tech.lq0.providencraft.tools.ItemNBTTool;

import java.awt.*;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpecialRender {

    public static final double MAX_DISTANCE = 500;

    @SubscribeEvent
    public static void renderWorldLastEvent(RenderWorldLastEvent evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getHeldItemMainhand();
        ItemStack item_off = player.getHeldItemOffhand();

        if (!(item.getItem() instanceof MomoPhone) && item_off.getItem() instanceof MomoPhone) {
            item = item_off;
        }

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

        item = player.getHeldItemMainhand();
        if (item.getItem() instanceof MountainDestroyer) {
            if (ItemNBTTool.getBoolean(item, MountainDestroyer.TAG_MULTIMINE, false)) {
                World world = player.getEntityWorld();

                Vector3d look = player.getLookVec();

                Vector3d start = player.getPositionVec().add(0, player.getEyeHeight(), 0);
                Vector3d end = player.getPositionVec().add(look.x * 5, look.y * 5 + player.getEyeHeight(), look.z * 5);

                RayTraceContext context = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player);
                BlockRayTraceResult result = player.getEntityWorld().rayTraceBlocks(context);

                BlockPos pos = result.getPos();

                BlockState state = player.getEntityWorld().getBlockState(pos);

                if (state.getBlockHardness(world, pos) != -1.0F && item.canHarvestBlock(state)) {

                    ArrayList<BlockPos> posList = new ArrayList<>();

                    if (pos.getY() - player.getPosY() <= 2 && pos.getY() - player.getPosY() >= 0) {
                        pos = pos.add(0, player.getPosY() - pos.getY(), 0);
                        float yaw = Math.abs(player.rotationYaw) % 360;
                        if ((yaw >= 45.0f && yaw <= 135.0f) || (yaw >= 225.0f && yaw <= 315.0f)) {
                            //x-facing
                            posList.add(pos.add(0, 0, -1));
                            posList.add(pos.add(0, 0, 1));
                            posList.add(pos.add(0, 1, -1));
                            posList.add(pos.add(0, 1, 0));
                            posList.add(pos.add(0, 1, 1));
                            posList.add(pos.add(0, 2, -1));
                            posList.add(pos.add(0, 2, 0));
                            posList.add(pos.add(0, 2, 1));
                        } else {
                            //z-facing
                            posList.add(pos.add(-1, 0, 0));
                            posList.add(pos.add(1, 0, 0));
                            posList.add(pos.add(-1, 1, 0));
                            posList.add(pos.add(0, 1, 0));
                            posList.add(pos.add(1, 1, 0));
                            posList.add(pos.add(-1, 2, 0));
                            posList.add(pos.add(0, 2, 0));
                            posList.add(pos.add(1, 2, 0));
                        }
                    } else {
                        //up-down-facing
                        posList.add(pos.add(1, 0, 0));
                        posList.add(pos.add(-1, 0, 0));
                        posList.add(pos.add(0, 0, 1));
                        posList.add(pos.add(0, 0, -1));
                        posList.add(pos.add(1, 0, 1));
                        posList.add(pos.add(1, 0, -1));
                        posList.add(pos.add(-1, 0, 1));
                        posList.add(pos.add(-1, 0, -1));
                    }
                    posList.add(pos);

                    ItemStack finalItem = item;
                    posList.forEach(b -> {
                        BlockState s = world.getBlockState(b);
                        if (s.getBlockHardness(world, b) != -1.0F && finalItem.canHarvestBlock(player.getEntityWorld().getBlockState(b))) {
                            renderBlock(evt.getMatrixStack(), b, Color.yellow);
                        }
                    });
                }
            }
        }
    }

    @SubscribeEvent
    public static void renderOverlay(RenderGameOverlayEvent evt) {
        if (evt.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null && player.getRidingEntity() instanceof NiitCarEntity) {
            MatrixStack stack = evt.getMatrixStack();
            Minecraft mc = Minecraft.getInstance();

            NiitCarEntity car = (NiitCarEntity) player.getRidingEntity();

            double spd = car.getSpeed();

            FontRenderer f = Minecraft.getInstance().fontRenderer;
            String spdStr = String.format("speed: %.2f km/h", spd);
            float left = mc.getMainWindow().getScaledWidth() / 2F - f.getStringWidth(spdStr) / 2F;
            float top = mc.getMainWindow().getScaledHeight() / 2F + 20;

            Matrix4f matrixBar = stack.getLast().getMatrix();
            int left2 = mc.getMainWindow().getScaledWidth() / 2 - 50;
            GuiUtils.drawGradientRect(matrixBar, 1, (int) (left2 + (spd / 80 * 100)), (int) top + 14, left2, (int) (top + 13), 0xaa00ff00, 0xaa00ff00);
            f.drawStringWithShadow(evt.getMatrixStack(), spdStr, left, top, 0xff0000);
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
        matrix.translate(-view.x, -view.y, -view.z);

        IVertexBuilder builder;
        builder = buffer.getBuffer(CustomRenderType.BlockOverlay);

        {
            matrix.push();
            matrix.translate(posX, posY, posZ);
            matrix.translate(-0.0001f, -0.0001f, -0.0001f);
            matrix.scale(1.0001f, 1.0001f, 1.0001f);
            matrix.rotate(Vector3f.YP.rotationDegrees(-90.0F));
            matrix.translate(0, 0, 0);

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
