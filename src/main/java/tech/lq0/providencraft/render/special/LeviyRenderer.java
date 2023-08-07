package tech.lq0.providencraft.render.special;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.BeaconTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.item.providencesecond.lecia.Leviy;

import java.awt.*;

public class LeviyRenderer {
    private static float lastX, lastY, lastZ;
    private static long lastChangeTime;

    public static void render(RenderWorldLastEvent evt) {
        ClientPlayerEntity player = Minecraft.getInstance().player;
        assert player != null;
        ItemStack item = player.getHeldItemMainhand();

        if (item.getItem() instanceof Leviy && !player.getCooldownTracker().hasCooldown(ItemRegistry.LEVIY.get())) {
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

                int animationTime = 300;
                long timePassed = animationTime;
                if (pos.getX() != lastX || pos.getY() != lastY || pos.getZ() != lastZ) {
                    timePassed = System.currentTimeMillis() - lastChangeTime;
                }

                if (timePassed >= animationTime) {
                    lastX = pos.getX();
                    lastY = pos.getY();
                    lastZ = pos.getZ();
                    lastChangeTime = System.currentTimeMillis();
                }

                float progress = (float) Math.sqrt(Math.sqrt(Math.min(timePassed, animationTime) / (float) animationTime));
                float x = ease(lastX, pos.getX(), progress);
                float y = ease(lastY, pos.getY(), progress);
                float z = ease(lastZ, pos.getZ(), progress);

                stack.push();
                // 渲染光柱
                Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
                stack.translate(x - view.getX(), y - view.getY() + 1, z - view.getZ());
                renderBeamSegment(stack,
                        Minecraft.getInstance().getRenderTypeBuffers().getBufferSource(),
                        BeaconTileEntityRenderer.TEXTURE_BEACON_BEAM,
                        evt.getPartialTicks(),
                        1, world.getGameTime(),
                        0, 1000, new float[]{1, 0, 0},
                        0.35f, .4f, 0.5f);

                stack.pop();

                // 十字形方块标识渲染
                SpecialRender.renderBlock(stack, x, y, z, Color.cyan, 0.6f);
                SpecialRender.renderBlock(evt.getMatrixStack(), x + 1, y, z, Color.cyan, .5f);
                SpecialRender.renderBlock(evt.getMatrixStack(), x - 1, y, z, Color.cyan, .5f);
                SpecialRender.renderBlock(evt.getMatrixStack(), x, y, z + 1, Color.cyan, .5f);
                SpecialRender.renderBlock(evt.getMatrixStack(), x, y, z - 1, Color.cyan, .5f);
            }
        }
    }

    private static float ease(float start, float end, float rate) {
        return start + (end - start) * rate;
    }

    public static void renderBeamSegment(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, ResourceLocation textureLocation, float partialTicks, float textureScale, long totalWorldTime, int yOffset, int height, float[] colors, float beamRadius, float glowRadius, float alpha) {
        int i = yOffset + height;
        matrixStackIn.push();
        matrixStackIn.translate(0.5D, 0.0D, 0.5D);
        float f = (float) Math.floorMod(totalWorldTime, 40L) + partialTicks;
        float f1 = height < 0 ? -f : f;
        float f2 = MathHelper.frac(f1 * 0.2F - (float) MathHelper.floor(f1 * 0.1F));
        float r = colors[0];
        float g = colors[1];
        float b = colors[2];
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f * 2.25F - 45.0F));
        float f6 = 0.0F;
        float f8 = 0.0F;
        float f9 = -beamRadius;
        float f10 = 0.0F;
        float f11 = 0.0F;
        float f12 = -beamRadius;
        float f13 = 0.0F;
        float f14 = 1.0F;
        float f15 = -1.0F + f2;
        float f16 = (float) height * textureScale * (0.5F / beamRadius) + f15;
        renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.getBeaconBeam(textureLocation, true)), r, g, b, alpha, yOffset, i, 0.0F, beamRadius, beamRadius, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        matrixStackIn.pop();
        f6 = -glowRadius;
        float f7 = -glowRadius;
        f8 = -glowRadius;
        f9 = -glowRadius;
        f13 = 0.0F;
        f15 = -1.0F + f2;
        f16 = (float) height * textureScale + f15;
        renderPart(matrixStackIn, bufferIn.getBuffer(RenderType.getBeaconBeam(textureLocation, true)), r, g, b, 0.125F * alpha, yOffset, i, f6, f7, glowRadius, f8, f9, glowRadius, glowRadius, glowRadius, 0.0F, 1.0F, f16, f15);
        matrixStackIn.pop();
    }

    private static void renderPart(MatrixStack matrixStackIn, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float x3, float z3, float x4, float z4, float u1, float u2, float v1, float v2) {
        MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x1, z1, x2, z2, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x4, z4, x3, z3, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x2, z2, x4, z4, u1, u2, v1, v2);
        addQuad(matrix4f, matrix3f, bufferIn, red, green, blue, alpha, yMin, yMax, x3, z3, x1, z1, u1, u2, v1, v2);
    }

    private static void addQuad(Matrix4f matrixPos, Matrix3f matrixNormal, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int yMin, int yMax, float x1, float z1, float x2, float z2, float u1, float u2, float v1, float v2) {
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x1, z1, u2, v1);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x1, z1, u2, v2);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMin, x2, z2, u1, v2);
        addVertex(matrixPos, matrixNormal, bufferIn, red, green, blue, alpha, yMax, x2, z2, u1, v1);
    }

    private static void addVertex(Matrix4f matrixPos, Matrix3f matrixNormal, IVertexBuilder bufferIn, float red, float green, float blue, float alpha, int y, float x, float z, float texU, float texV) {
        bufferIn.pos(matrixPos, x, (float) y, z).color(red, green, blue, alpha).tex(texU, texV).overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
    }
}
