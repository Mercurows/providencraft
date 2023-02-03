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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.entity.NiitCarEntity;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providenceOI.shirako.MomoPhone;
import tech.lq0.providencraft.item.providenceOI.shirako.WorldPeaceStaff;
import tech.lq0.providencraft.item.providencefirst.myanna.MountainDestroyer;
import tech.lq0.providencraft.tools.ItemNBTTool;

import java.awt.*;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
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

    @SubscribeEvent
    public static void renderWPS(RenderGameOverlayEvent event){
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        ClientPlayerEntity player = Minecraft.getInstance().player;
        if (player != null && player.getHeldItemMainhand().getItem() == ItemRegistry.WORLD_PEACE_STAFF.get()) {
            ItemStack item = player.getHeldItemMainhand();

            MatrixStack stack = event.getMatrixStack();
            Minecraft mc = Minecraft.getInstance();

            FontRenderer f = Minecraft.getInstance().fontRenderer;

            float blood = WorldPeaceStaff.getAllDamage(item);
            String bloodStr = String.format("%.1f", blood);

            float top = mc.getMainWindow().getScaledHeight() / 2F;

            Matrix4f matrixBar = stack.getLast().getMatrix();
            int left2 = mc.getMainWindow().getScaledWidth() / 2;

            GuiUtils.drawGradientRect(matrixBar, 1, left2 - 60, (int) top - 20 , left2 - 55, (int) (top + 20 - (blood / 500 * 20)),
                    0xaa888888, 0xaa888888);

            int color = new Color(237,38,109).getRGB();
            int color2 = new Color(163, 15, 15).getRGB();
            int color3 = new Color(255, 196, 82).getRGB();

            GuiUtils.drawGradientRect(matrixBar, 1, left2 - 60, (int) (top + 20 - blood / 500 * 40), left2 - 55, (int) (top + 20), color, color);

            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 61, (int) top - 21, left2 - 54, (int) top + 21, color2, color2);

            //边框
            int color_border1 = new Color(11609897).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 100, (int) top - 43, left2 - 98, (int) top + 44, color_border1, color_border1);
            int color_border2 = new Color(11013905).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 98, (int) top - 43, left2 - 95, (int) top - 41, color_border2, color_border2);
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 98, (int) top + 42, left2 - 95, (int) top + 44, color_border2, color_border2);
            int color_border3 = new Color(9899279).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 95, (int) top - 43, left2 - 90, (int) top - 41, color_border3, color_border3);
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 95, (int) top + 42, left2 - 90, (int) top + 44, color_border3, color_border3);
            int color_border4 = new Color(8915981).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 90, (int) top - 43, left2 - 87, (int) top - 41, color_border4, color_border4);
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 90, (int) top + 42, left2 - 87, (int) top + 44, color_border4, color_border4);
            int color_border5 = new Color(7998220).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 0, left2 - 87, (int) top - 43, left2 - 85, (int) top + 44, color_border5, color_border5);

            //血条


            //刻度
            int color_scale = new Color(15834818).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 40, left2 - 90, (int) top - 39, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 35, left2 - 96, (int) top - 34, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 30, left2 - 96, (int) top - 29, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 25, left2 - 96, (int) top - 24, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 20, left2 - 94, (int) top - 19, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 15, left2 - 96, (int) top - 14, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 10, left2 - 96, (int) top - 9, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top - 5, left2 - 96, (int) top - 4, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top , left2 - 91, (int) top + 1, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 5, left2 - 96, (int) top + 6, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 10, left2 - 96, (int) top + 11, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 15, left2 - 96, (int) top + 16, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 20, left2 - 94, (int) top + 21, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 25, left2 - 96, (int) top + 26, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 30, left2 - 96, (int) top + 31, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 35, left2 - 96, (int) top + 36, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 98, (int) top + 40, left2 - 90, (int) top + 41, color_scale, color_scale);

            //高光
            int color_highlight = new Color(255,255,255).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 3, left2 - 97, (int) top - 38, left2 - 95, (int) top - 31, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left2 - 97, (int) top - 31, left2 - 96, (int) top - 26, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left2 - 97, (int) top - 23, left2 - 96, (int) top - 22, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left2 - 97, (int) top - 31, left2 - 96, (int) top - 26, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left2 - 97, (int) top + 35, left2 - 96, (int) top + 39, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left2 - 97, (int) top + 33, left2 - 96, (int) top + 34, color_highlight, color_highlight);

            //刀边
            int color_knife1 = new Color(201,201,201).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 100, (int) top - 31, left2 - 99, (int) top + 32, color_knife1, color_knife1);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 86, (int) top - 31, left2 - 85, (int) top + 32, color_knife1, color_knife1);
            int color_knife2 = new Color(0,0,0).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 100, (int) top - 27, left2 - 99, (int) top + 3, color_knife2, color_knife2);
            int color_knife3 = new Color(49,49,49).getRGB();
            for(int i = 0;i < 7;i++){
                GuiUtils.drawGradientRect(matrixBar, 2, left2 - 101, (int) top - 26 + i * 3, left2 - 100, (int) top - 25 + i * 3, color_knife3, color_knife3);
                GuiUtils.drawGradientRect(matrixBar, 2, left2 - 102, (int) top - 25 + i * 3, left2 - 101, (int) top - 24 + i * 3, color_knife3, color_knife3);
                GuiUtils.drawGradientRect(matrixBar, 2, left2 - 102, (int) top - 24 + i * 3, left2 - 101, (int) top - 23 + i * 3, color_knife2, color_knife2);
                GuiUtils.drawGradientRect(matrixBar, 2, left2 - 101, (int) top - 25 + i * 3, left2 - 100, (int) top - 23 + i * 3, color_knife2, color_knife2);
            }
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 101, (int) top - 5, left2 - 100, (int) top - 3, color_knife3, color_knife3);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 102, (int) top - 3, left2 - 101, (int) top - 2, color_knife3, color_knife3);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 101, (int) top - 3, left2 - 100, (int) top + 2, color_knife2, color_knife2);
            GuiUtils.drawGradientRect(matrixBar, 2, left2 - 102, (int) top - 2, left2 - 101, (int) top + 1, color_knife2, color_knife2);
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
