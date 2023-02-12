package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.CursedCatDollEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CursedMarshaimallow extends Item {
    public CursedMarshaimallow(){
        super(new Properties().group(ModGroup.itemgroup).rarity(Rarity.UNCOMMON));
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

                CursedCatDollEntity cursedCatDoll = new CursedCatDollEntity(worldIn, player);
                int usingTime = this.getUseDuration(stack) - timeLeft;

                float power = Math.min(usingTime / 30.0f, 3.5f);

                cursedCatDoll.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, power, 0.0f);
                worldIn.addEntity(cursedCatDoll);

                if(!player.isCreative()) {
                    stack.shrink(1);
                }

                player.getCooldownTracker().setCooldown(stack.getItem(), 100);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("cursed_marshaimallow_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("cursed_marshaimallow_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.HAINE);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 1000;
    }
}
