package tech.lq0.providencraft.render.special;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import tech.lq0.providencraft.item.providenceOI.shirako.MomoPhone;
import tech.lq0.providencraft.tools.ItemNBTTool;

import java.awt.*;

public class MomoPhoneRenderer {
    public static final double MAX_DISTANCE = 500;

    public static void render(RenderWorldLastEvent evt) {
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
                    SpecialRender.renderLandmark(evt.getMatrixStack(), new BlockPos(posX, posY, posZ), Color.gray);
                } else {
                    SpecialRender.renderLandmark(evt.getMatrixStack(), new BlockPos(posX, posY, posZ), Color.green);
                }
            }
        }
    }
}
