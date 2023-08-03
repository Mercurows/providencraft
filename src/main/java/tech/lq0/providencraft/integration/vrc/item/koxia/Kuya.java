package tech.lq0.providencraft.integration.vrc.item.koxia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Kuya extends Item {
    public Kuya(){
        super(new Properties().group(ModGroup.integrationgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.kuya")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addHideText(tooltip, new StringTextComponent(""));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.coop.koxia").mergeStyle(Style.EMPTY.setColor(Color.fromHex("#EE548E"))));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(stack);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if(!worldIn.isRemote) {
            if (entityLiving instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entityLiving;

                KuyaEntity kuyaEntity = new KuyaEntity(worldIn, player);
                int usingTime = this.getUseDuration(stack) - timeLeft;

                float power = Math.min(usingTime / 30.0f, 3.5f);

                kuyaEntity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, power, 0.0f);
                worldIn.addEntity(kuyaEntity);

                if(!player.isCreative()) {
                    stack.shrink(1);
                }

                player.getCooldownTracker().setCooldown(stack.getItem(), 100);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 1000;
    }
}
