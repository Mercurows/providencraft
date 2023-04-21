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

            if(player.isSpectator()){
                return;
            }

            ItemStack item = player.getHeldItemMainhand();

            MatrixStack stack = event.getMatrixStack();
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
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top , left - 91, (int) top + 1, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 5, left - 96, (int) top + 6, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 10, left - 96, (int) top + 11, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 15, left - 96, (int) top + 16, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 20, left - 94, (int) top + 21, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 25, left - 96, (int) top + 26, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 30, left - 96, (int) top + 31, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 35, left - 96, (int) top + 36, color_scale, color_scale);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 98, (int) top + 40, left - 90, (int) top + 41, color_scale, color_scale);

            //高光
            int color_highlight = new Color(255,255,255, 150).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top - 38, left - 95, (int) top - 31, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top - 31, left - 96, (int) top - 26, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top - 23, left - 96, (int) top - 22, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top + 35, left - 96, (int) top + 39, color_highlight, color_highlight);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 97, (int) top + 33, left - 96, (int) top + 34, color_highlight, color_highlight);

            //刀边
            int color_knife1 = new Color(201,201,201).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left - 100, (int) top - 31, left - 99, (int) top + 32, color_knife1, color_knife1);
            GuiUtils.drawGradientRect(matrixBar, 2, left - 86, (int) top - 31, left - 85, (int) top + 32, color_knife1, color_knife1);
            int color_knife2 = new Color(0,0,0).getRGB();
            GuiUtils.drawGradientRect(matrixBar, 2, left - 100, (int) top - 27, left - 99, (int) top + 3, color_knife2, color_knife2);
            int color_knife3 = new Color(49,49,49).getRGB();
            for(int i = 0;i < 7;i++){
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
            drawNumber(matrixBar, 4, left - 105, (int) top - 42, 0, color_max);
            drawNumber(matrixBar, 4, left - 111, (int) top - 42, 0, color_max);
            drawNumber(matrixBar, 4, left - 115, (int) top - 42, 0, color_max);
            drawNumber(matrixBar, 4, left - 119, (int) top - 42, 5, color_max);

            GuiUtils.drawGradientRect(matrixBar, 4, left - 107, (int) top + 42, left - 106, (int) top + 43, color_dot, color_dot);

            int num_1 = (int) blood / 100;
            int num_2 = (int) blood / 10 % 10;
            int num_3 = (int) blood % 10;
            int num_4 = (int) (blood * 10 % 10);

            drawNumber(matrixBar, 4, left - 119, (int) top + 38, num_1, color_blood);
            drawNumber(matrixBar, 4, left - 115, (int) top + 38, num_2, color_blood);
            drawNumber(matrixBar, 4, left - 111, (int) top + 38, num_3, color_blood);
            drawNumber(matrixBar, 4, left - 105, (int) top + 38, num_4, color_blood);

            /* 兔子 */
            int color_usagi1 = new Color(255,255,255).getRGB(); //ffffff
            int color_usagi2 = new Color(241,241,241).getRGB(); //f1f1f1
            int color_usagi3 = new Color(247,247,247).getRGB(); //f7f7f7
            int color_usagi4 = new Color(226,226,226).getRGB(); //e2e2e2

            int color_usagi_border1 = new Color(161,161,161).getRGB(); //a1a1a1
            int color_usagi_border2 = new Color(168,168,168).getRGB(); //a8a8a8
            int color_usagi_border3 = new Color(157,157,157).getRGB(); //9d9d9d
            int color_usagi_border4 = new Color(137,137,137).getRGB(); //898989

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
            int color_eye = new Color(eye_r,eye_g,eye_b).getRGB();

            GuiUtils.drawGradientRect(matrixBar, 3, left - 108, (int) top - 1, left - 107, (int) top + 1, color_eye, color_eye);
            GuiUtils.drawGradientRect(matrixBar, 3, left - 111, (int) top - 1, left - 110, (int) top + 1, color_eye, color_eye);

            //如果玩家在使用，兔子冒红光
            int color_usagi_awaken1 = new Color(15542894).getRGB();
            int color_usagi_awaken2 = new Color(14752865).getRGB();

            if(player.isHandActive() && blood >= 5.0f){
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

    private static void drawNumber(Matrix4f matrix, int level, int left, int top, int num, int color){
        switch (num){
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
                GuiUtils.drawGradientRect(matrix, level,left + 1, top + 2, left + 2, top + 3, color, color);
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
