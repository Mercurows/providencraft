package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.projectile.WaterCardEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.CriteriaRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DuelWaterGun extends Item {
    public DuelWaterGun() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(40));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.duel_water_gun_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.duel_water_gun_2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.duel_water_gun.func")).mergeStyle(TextFormatting.AQUA));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;

            if (stack.getDamage() < stack.getMaxDamage()) {
                int strength = (this.getUseDuration(stack) - timeLeft) / 20;

                WaterCardEntity waterCard = new WaterCardEntity(worldIn, player, Math.min(strength, 5));
                waterCard.setShooter(player);
                waterCard.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, 4.0f, 0.0f);
                worldIn.addEntity(waterCard);

                player.playSound(SoundRegistry.LECIA_HOWL.get(), 1.0F, 1.0F);

                if (!player.abilities.isCreativeMode) {
                    stack.setDamage(stack.getDamage() + 1);
                }
            }
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (playerIn.isSneaking()) {
            BlockRayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BlockState state = worldIn.getBlockState(raytraceresult.getPos());
                if (state.isIn(Blocks.WATER)) {
                    stack.setDamage(0);
                    playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                    return new ActionResult<>(ActionResultType.SUCCESS, stack);
                } else if (state.isIn(Blocks.LAVA)) {
                    playerIn.setFire(10);
                    playerIn.playSound(SoundRegistry.LECIA_SCREAM.get(), 1.0F, 1.0F);
                    playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 1.0F, 1.0F);

                    if (playerIn instanceof ServerPlayerEntity) {
                        CriteriaRegistry.FILL_LAVA.test((ServerPlayerEntity) playerIn, stack);
                    }

                    return new ActionResult<>(ActionResultType.SUCCESS, stack);
                }
            }
        } else {
            int random = (int) (Math.random() * 2 + 1);
            if (random == 1) {
                playerIn.playSound(SoundRegistry.LECIA_CAST_1.get(), 1.0F, 1.0F);
            } else {
                playerIn.playSound(SoundRegistry.LECIA_CAST_2.get(), 1.0F, 1.0F);
            }
        }

        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.CONSUME, stack);
    }
}
