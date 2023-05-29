package tech.lq0.providencraft.item.providencefirst.haya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
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
import java.util.ArrayList;
import java.util.List;

public class HayaSword extends SwordItem {
    public HayaSword() {
        super(ItemTier.NETHERITE, 4, -2.6f, new Properties().group(ModGroup.itemgroup).rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.haya_sword.func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("des.providencraft.haya_sword_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.haya_sword_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
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
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        super.onUsingTick(stack, player, count);
        if (getUseDuration(stack) - count == 20) {
            player.playSound(SoundEvents.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity && this.getUseDuration(stack) - timeLeft > 20) {
            PlayerEntity player = (PlayerEntity) entityLiving;

            boolean isOnGround = player.isOnGround();
            int distance = isOnGround ? 16 : 32;
            float damage = isOnGround ? 9 : 4.5F;

            Vector3d look = player.getLookVec();
            Vector3d start = player.getPositionVec().add(0, 0.8, 0);
            Vector3d end = player.getPositionVec().add(look.x * distance, 0.8, look.z * distance);

            EntityRayTraceResult result;

            List<LivingEntity> target = new ArrayList<>();

            float length = .5f;
            for (int i = -1; i <= 1; i++) {
                do {
                    result = ProjectileHelper.rayTraceEntities(worldIn, player, start.add(look.z * length * i, 0, look.x * length * (-i)), end.add(look.z * length * i, 0, look.x * length * (-i)), player.getBoundingBox().grow(distance + 10, 0, distance + 10), (e) -> (!target.contains(e)) && e != player && !player.isOnSameTeam(e) && e instanceof LivingEntity);
                    if (result != null) {
                        target.add((LivingEntity) result.getEntity());
                    }
                } while (result != null);
            }

            target.forEach(e -> {
                e.applyKnockback(1.0F, MathHelper.sin(player.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(player.rotationYaw * ((float) Math.PI / 180F)));
                e.attackEntityFrom(DamageSource.causePlayerDamage(player), damage);
            });

            Vector3d v_player = Vector3d.fromPitchYaw(player.getPitchYaw());
            Vector3d v_final = v_player.mul(4.0f, 0.0f, 4.0f).add(0.0f, 0.2f, 0.0f);

            player.setMotion(v_final);
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 40, 4, true, false));

            stack.damageItem(1, player, (player1 -> player1.sendBreakAnimation(player1.getActiveHand())));
        }
    }

}
