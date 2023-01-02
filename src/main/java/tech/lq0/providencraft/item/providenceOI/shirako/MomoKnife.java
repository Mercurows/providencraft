package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.text.NumberFormat;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MomoKnife extends SwordItem {
    public static final String TAG_DAMAGE = "damage";

    public MomoKnife(){
        super(ItemTier.IRON, 1, -1.0f, new Properties().group(ModGroup.itemgroup).maxDamage(1231).setNoRepair().rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("momo_knife_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("momo_knife_func")).mergeStyle(TextFormatting.AQUA));
        showDamage(stack, tooltip);
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.heal(getAllDamage(stack) * 0.5f);
        setAllDamage(stack, 0.0f);
        return ActionResult.resultSuccess(stack);
    }

    private void showDamage(ItemStack stack, List<ITextComponent> tooltip){
        float allDamage = getAllDamage(stack);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(1);
        String damage = numberFormat.format(allDamage);

        tooltip.add((new StringTextComponent("")));
        tooltip.add((new TranslationTextComponent("momo_knife_damage")).mergeStyle(TextFormatting.WHITE));
        tooltip.add((new StringTextComponent(damage)).mergeStyle(TextFormatting.GREEN).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int sharpLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);
        float maxDamage = 4.0f;
        if(sharpLevel != 0){
            maxDamage = 4.0f + (0.5f * sharpLevel + 0.5f);
        }

        int random = (int)(Math.random() * (maxDamage * 10)) + 20;
        float allDamage = getAllDamage(stack);
        setAllDamage(stack, allDamage + random / 10.0f);

        int lvl = -1;
        if (target.isPotionActive(EffectRegistry.BLEEDING.get())) {
            lvl = target.getActivePotionEffect(EffectRegistry.BLEEDING.get()).getAmplifier();
        }

        target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 120, lvl > 2 ? 3 : lvl + 1));
        return super.hitEntity(stack, target, attacker);
    }

    private static float getAllDamage(ItemStack stack) {
        return ItemNBTTool.getFloat(stack, TAG_DAMAGE, 0.0f);
    }

    private static void setAllDamage(ItemStack stack, float num) {
        ItemNBTTool.setFloat(stack, TAG_DAMAGE, Math.min(num, 100.0f));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        setAllDamage(stack, getAllDamage(stack) > 0.1f ? getAllDamage(stack) - 0.1f : 0.0f);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }
}
