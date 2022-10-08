package tech.lq0.providencraft.item.providencesecond.lecia;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.WaterCardEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DuelWaterGun extends Item {
    public DuelWaterGun(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(40));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("duel_water_gun_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("duel_water_gun_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("duel_water_gun_func")).mergeStyle(TextFormatting.AQUA));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIA);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        ItemStack stack = context.getItem();
        PlayerEntity player = context.getPlayer();
        if(!world.isRemote){
            if(player != null && player.isSneaking()) {
                //这里需要修改，功能是潜行+右键水源，补充20耐久
                if (world.getBlockState(blockpos).isIn(Blocks.WATER) && world.getFluidState(blockpos).getLevel() == 8) {
                    System.out.println(123);
                    stack.setDamage(stack.getDamage() < 20 ? 0 : stack.getDamage() - 20);
                }
            }
        }
        return ActionResultType.CONSUME;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            if(stack.getDamage() < stack.getMaxDamage()) {
                WaterCardEntity waterCard = new WaterCardEntity(worldIn, playerIn);
                waterCard.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 4.0f, 0.0f);
                worldIn.addEntity(waterCard);

                if (!playerIn.abilities.isCreativeMode) {
                    stack.setDamage(stack.getDamage() + 1);
                }
                return new ActionResult<>(ActionResultType.CONSUME, stack);
            }
        }
        return new ActionResult<>(ActionResultType.FAIL, stack);
    }
}
