package tech.lq0.providencraft.render.special;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import tech.lq0.providencraft.item.providencefirst.myanna.MountainDestroyer;
import tech.lq0.providencraft.tools.ItemNBTTool;

import java.awt.*;
import java.util.ArrayList;

public class MountainDestroyerRenderer {
    public static void render(RenderWorldLastEvent evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getHeldItemMainhand();

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

                    posList.forEach(b -> {
                        BlockState s = world.getBlockState(b);
                        if (s.getBlockHardness(world, b) != -1.0F && item.canHarvestBlock(player.getEntityWorld().getBlockState(b))) {
                            SpecialRender.renderBlock(evt.getMatrixStack(), b, Color.yellow);
                        }
                    });
                }
            }
        }

    }
}
