package tech.lq0.providencraft.integration.vrc.ameki;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class RainyButterfly extends SwordItem {
    public static final String TAG_RAINY_BUTTERFLY_COUNT = "rainy_butterfly_count";
    public static final String TAG_RAINY_BUTTERFLY_TIME = "rainy_butterfly_time";
    public static final String TAG_RAINY_BUTTERFLY_OPEN = "rainy_butterfly_open";

    public RainyButterfly(){
        super(ItemTier.IRON, 5, -2.1f, new Properties().group(ModGroup.integrationgroup).maxDamage(1206));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_3")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addHideText(tooltip, new StringTextComponent(""));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.coop.ameki").mergeStyle(Style.EMPTY.setColor(Color.fromHex("#D7F0FE"))));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {


        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_TIME, 0);
        ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote && isSelected){
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entityIn;

                boolean open = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
                if (open) {
                    if(player.ticksExisted % 20 == 0 && getRainyButterflyTime(stack) < 20
                        && getRainyButterflyCount(stack) < (worldIn.isRaining() ? 9 : 3)){
                        setRainyButterflyTime(stack, Math.min(20, getRainyButterflyTime(stack) + 1));
                    }

                    if (worldIn.isRaining()) {
                        if(getRainyButterflyTime(stack) >= 5 && getRainyButterflyCount(stack) < 9 && getRainyButterflyTime(stack) > 0){
                            setRainyButterflyCount(stack, Math.min(9, getRainyButterflyCount(stack) + 1));
                            setRainyButterflyTime(stack, getRainyButterflyTime(stack) - 5);
                        }
                    }else {
                        if(getRainyButterflyTime(stack) % 20 == 0 && getRainyButterflyCount(stack) < 3 && getRainyButterflyTime(stack) > 0){
                            setRainyButterflyCount(stack, Math.min(3, getRainyButterflyCount(stack) + 1));
                            setRainyButterflyTime(stack, getRainyButterflyTime(stack) - 20);
                        }
                    }
                }
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            boolean open = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
            if(open){
                ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
            }else {
                int level = getRainyButterflyCount(stack);
                if(level > 0){
                    if(playerIn.isSneaking()){
                        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 800, level - 1, false, false));
                        setRainyButterflyCount(stack, 0);

                        //TODO 发射冲击波，击退面前的生物

                    }else {
                        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 1200, 0, false, false));
                        setRainyButterflyCount(stack, level - 1);
                    }
                }

                ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, true);
            }
        }
        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    private static int getRainyButterflyCount(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
    }

    private static int getRainyButterflyTime(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_TIME, 0);
    }

    private static void setRainyButterflyCount(ItemStack stack, int count){
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, count);
    }

    private static void setRainyButterflyTime(ItemStack stack, int time){
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_TIME, time);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
