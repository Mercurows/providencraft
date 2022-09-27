package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class HayaSword extends SwordItem {
    public HayaSword(){
        super(ItemTier.NETHERITE, 4, -2.0f, new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("haya_sword_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("haya_sword_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("haya_sword_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.HAYA);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving instanceof PlayerEntity && this.getUseDuration(stack) - timeLeft > 20) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            Vector3d v_player = player.getForward();
            Vector3d v_final = v_player.mul(4.0f, 0.0f, 4.0f).add(0.0f, 0.2f, 0.0f);

            for(LivingEntity livingentity : player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class,
                    player.getBoundingBox().grow(0.5f, 0.0f, 0.5f).expand(v_final))){
                if (livingentity != player && !player.isOnSameTeam(livingentity) && (!(livingentity instanceof ArmorStandEntity) || !((ArmorStandEntity) livingentity).hasMarker())) {
                    livingentity.applyKnockback(1.0F, MathHelper.sin(player.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(player.rotationYaw * ((float) Math.PI / 180F)));
                    livingentity.attackEntityFrom(DamageSource.causePlayerDamage(player), 9);
                }
            }

            player.setMotion(v_final);
            stack.damageItem(1, player, (player1 -> player1.sendBreakAnimation(player1.getActiveHand())));
        }
    }

}
