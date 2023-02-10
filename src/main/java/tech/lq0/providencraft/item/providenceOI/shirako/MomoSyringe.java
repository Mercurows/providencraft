package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
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
import java.util.List;

public class MomoSyringe extends Item {
    public MomoSyringe(){
        super(new Properties().rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("momo_syringe_des1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("momo_syringe_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        double random = Math.random();

        if (playerIn.getCooldownTracker().hasCooldown(stack.getItem())) {
            return ActionResultType.FAIL;
        } else {
            if (random <= .1) {
                target.setFire(8);
                target.addPotionEffect(new EffectInstance(Effects.SPEED, 160, 2));
            } else {
                target.addPotionEffect(new EffectInstance(Effects.SPEED, 160, 1));
                target.heal(target.getMaxHealth() * 0.25f);
            }

            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 200);

            if (!playerIn.isCreative()) {
                stack.shrink(1);
            }
        }
        return ActionResultType.CONSUME;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.CROSSBOW;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerEntity = (PlayerEntity) entityLiving;

        double random = Math.random();
        if(random <= .1){
            playerEntity.setFire(8);
            playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 160, 2));
        }else {
            playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 160, 1));
            playerEntity.heal(playerEntity.getMaxHealth() * 0.25f);
        }

        if(!playerEntity.isCreative()) {
            stack.shrink(1);
        }

        playerEntity.getCooldownTracker().setCooldown(stack.getItem(), 200);

        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
