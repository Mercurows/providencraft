package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.network.PdcNetwork;
import tech.lq0.providencraft.network.packet.LeviyLaunchPacket;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Leviy extends Item {
    public Leviy() {
        super(new Properties().group(ModGroup.itemgroup).rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add((new TranslationTextComponent("des.providencraft.leviy_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.leviy_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            ItemStack stack = playerIn.getHeldItem(handIn);
            Vector3d look = playerIn.getLookVec();
            int distance = 512;
            Vector3d start = playerIn.getPositionVec().add(0, playerIn.getEyeHeight(), 0);
            Vector3d end = playerIn.getPositionVec().add(look.x * distance, look.y * distance + playerIn.getEyeHeight(), look.z * distance);

            RayTraceContext context = new RayTraceContext(start, end, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, playerIn);
            BlockRayTraceResult result = playerIn.getEntityWorld().rayTraceBlocks(context);

            // 命中方块再发请求
            if (!result.getType().equals(RayTraceResult.Type.MISS)) {
                BlockPos pos = result.getPos();
                PdcNetwork.CHANNEL.sendToServer(new LeviyLaunchPacket(pos.getX(), pos.getY(), pos.getZ()));

                // TODO 修改为正确的冷却时间
                playerIn.getCooldownTracker().setCooldown(this, 100);
                return ActionResult.resultSuccess(stack);
            } else {
                playerIn.sendStatusMessage(new TranslationTextComponent("des.providencraft.leviy.invalid_select"), true);
                return ActionResult.resultFail(stack);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
