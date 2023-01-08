package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModItemTier;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class RedAhogeMachete extends SwordItem {
    public RedAhogeMachete() {
        super(ModItemTier.RED_AHOGE, 7, -2.8f, new Properties().maxDamage(851).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("red_ahoge_machete_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_machete_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        tooltip.add((new TranslationTextComponent("red_ahoge_machete_func")).mergeStyle(TextFormatting.AQUA));
        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        int posX = playerIn.getPosition().getX();
        int posY = playerIn.getPosition().getY();
        int posZ = playerIn.getPosition().getZ();

        int posY2 = posY;

        //calculate ground Y
        for (int i = posY; i >= 0; i--) {
            BlockState state = worldIn.getBlockState(new BlockPos(posX, i, posZ));
            if (state.getMaterial().blocksMovement()) {
                posY2 = i + 1;
                break;
            }
        }

        int height = posY - posY2;

        Vector3d look = playerIn.getLookVec();
        Vector3d start = playerIn.getPositionVec().add(0, -height, 0);


        double xySquareSum = Math.sqrt(look.z * look.z + look.x * look.x);
        double ratio = 1.0 / xySquareSum;

        Vector3d end = playerIn.getPositionVec().add(look.x * 5 * ratio, -height, look.z * 5 * ratio);

        EntityRayTraceResult result;

        List<LivingEntity> target = new ArrayList<>();

        float length = .8f;
        for (int i = -2; i <= 2; i++) {
            do {
                result = ProjectileHelper.rayTraceEntities(worldIn, playerIn, start, end.add(look.z * length * i, 0, look.x * length * (-i)),
                        new AxisAlignedBB(posX, posY2, posZ, posX, posY2 + 1.0, posZ).grow(5, 2, 5), (e) -> (!target.contains(e)) && e != playerIn && !playerIn.isOnSameTeam(e) && e instanceof LivingEntity && !(e instanceof ArmorStandEntity))
                ;
                if (result != null) {
                    target.add((LivingEntity) result.getEntity());
                }
            } while (result != null);
        }

        target.forEach(e -> {
            e.applyKnockback(1.0F, MathHelper.sin(playerIn.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(playerIn.rotationYaw * ((float) Math.PI / 180F)));
            e.attackEntityFrom(DamageSource.causePlayerDamage(playerIn), height * 0.5f + 10);
        });

        playerIn.addVelocity(0.0f, -8.0f, 0.0f);

        playerIn.sendStatusMessage(new StringTextComponent("height is" + height), false);

        stack.damageItem(10, playerIn, (player1 -> player1.sendBreakAnimation(player1.getActiveHand())));
        //playerIn.getCooldownTracker().setCooldown(stack.getItem(), 60);

        return ActionResult.resultSuccess(stack);
    }
}
