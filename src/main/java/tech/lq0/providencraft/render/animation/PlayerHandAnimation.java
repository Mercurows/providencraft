package tech.lq0.providencraft.render.animation;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.util.HandSide;
import tech.lq0.providencraft.render.util.RenderUtil;

public class PlayerHandAnimation {
    public static void render(AnimationController controller, ItemCameraTransforms.TransformType transformType, MatrixStack matrices, IRenderTypeBuffer renderBuffer, int light){
        if(!transformType.isFirstPerson()) return;
        matrices.push();{
            controller.applyRightHandTransform(matrices);
            RenderUtil.renderFirstPersonArm(Minecraft.getInstance().player, HandSide.RIGHT, matrices, renderBuffer, light);
        }
        matrices.pop();
        matrices.push();{
            controller.applyLeftHandTransform(matrices);
            RenderUtil.renderFirstPersonArm(Minecraft.getInstance().player, HandSide.LEFT, matrices, renderBuffer, light);
        }
        matrices.pop();
    }
}
