package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.tileentity.BeaconTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import tech.lq0.providencraft.item.providencesecond.lecia.Leviy;

import java.awt.*;

public class LeviyRenderer {
    public static void render(RenderWorldLastEvent evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getHeldItemMainhand();

        if (item.getItem() instanceof Leviy) {
            World world = player.getEntityWorld();
            Vector3d look = player.getLookVec();
            MatrixStack stack = evt.getMatrixStack();

            int distance = 300;
            Vector3d start = player.getPositionVec().add(0, player.getEyeHeight(), 0);
            Vector3d end = player.getPositionVec().add(look.x * distance, look.y * distance + player.getEyeHeight(), look.z * distance);

            RayTraceContext context = new RayTraceContext(start, end, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player);
            BlockRayTraceResult result = player.getEntityWorld().rayTraceBlocks(context);

            // 命中方块再渲染
            if (!result.getType().equals(RayTraceResult.Type.MISS)) {
                BlockPos pos = result.getPos();
                stack.push();
                // 渲染光柱
                Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
                stack.translate(pos.getX() - view.getX(), pos.getY() - view.getY() + 1, pos.getZ() - view.getZ());
                BeaconTileEntityRenderer.renderBeamSegment(stack,
                        Minecraft.getInstance().getRenderTypeBuffers().getBufferSource(),
                        BeaconTileEntityRenderer.TEXTURE_BEACON_BEAM,
                        evt.getPartialTicks(),
                        1, world.getGameTime(),
                        0, 1000, new float[]{1, 0, 0},
                        0.35f, .4f);

                stack.pop();

                // 十字形方块标识渲染
                SpecialRender.renderBlock(stack, pos, Color.cyan, 0.6f);
                SpecialRender.renderBlock(evt.getMatrixStack(), pos.add(1, 0, 0), Color.cyan, .5f);
                SpecialRender.renderBlock(evt.getMatrixStack(), pos.add(-1, 0, 0), Color.cyan, .5f);
                SpecialRender.renderBlock(evt.getMatrixStack(), pos.add(0, 0, 1), Color.cyan, .5f);
                SpecialRender.renderBlock(evt.getMatrixStack(), pos.add(0, 0, -1), Color.cyan, .5f);
            }
        }
    }
}
