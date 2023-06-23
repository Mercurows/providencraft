package tech.lq0.providencraft.item.others;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.ItemNBTTool;

import javax.annotation.Nullable;
import java.util.List;

public class ChaosChecker extends Item {
    public ChaosChecker(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            int chaos = ChaosHelper.getChaos(playerIn);
            playerIn.sendStatusMessage(new StringTextComponent("混沌值为" + chaos), true);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.chaos_checker_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.chaos_checker_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity && !worldIn.isRemote){
            PlayerEntity player = (PlayerEntity) entityIn;
            int chaos = ChaosHelper.getChaos(player);

            ItemNBTTool.setInt(stack, "chaos", chaos);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }

    public static int getChaos(ItemStack stack){
        return ItemNBTTool.getInt(stack, "chaos", 0);
    }
}
