package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
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
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;

public class MomoKnife extends SwordItem {

    public static final String TAG_DAMAGE = "damage";
    public static final String TAG_TIME = "time";

    public MomoKnife() {
        super(ItemTier.IRON, 1, -1.0f, new Properties().group(ModGroup.itemgroup).maxDamage(1231).rarity(Rarity.EPIC));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("momo_knife_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("momo_knife_func")).mergeStyle(TextFormatting.AQUA));
        showDamage(stack, tooltip, worldIn == null ? 0 : worldIn.getGameTime());
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.heal(getAllDamage(stack, playerIn.world.getGameTime()) * 0.5f);
        setAllDamage(stack, 0.0f, playerIn.world.getGameTime());
        return ActionResult.resultSuccess(stack);
    }

    private void showDamage(ItemStack stack, List<ITextComponent> tooltip, long time) {
        float allDamage = getAllDamage(stack, time);
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
        if (sharpLevel != 0) {
            maxDamage = 4.0f + (0.5f * sharpLevel + 0.5f);
        }

        int random = (int) (Math.random() * (maxDamage * 10)) + 20;
        float allDamage = getAllDamage(stack, attacker.world.getGameTime());
        setAllDamage(stack, allDamage + random / 10.0f, attacker.world.getGameTime());

        int lvl = -1;
        if (target.isPotionActive(EffectRegistry.BLEEDING.get())) {
            lvl = Objects.requireNonNull(target.getActivePotionEffect(EffectRegistry.BLEEDING.get())).getAmplifier();
        }

        target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 120, lvl > 2 ? 3 : lvl + 1));
        return super.hitEntity(stack, target, attacker);
    }

    private static float getAllDamage(ItemStack stack, long time) {
        long lastDamageTime = ItemNBTTool.getLong(stack, TAG_TIME, 9223372036854775807L);
        float damage = ItemNBTTool.getFloat(stack, TAG_DAMAGE, 0.0f) - (time - lastDamageTime) * 0.1f;
        if (damage < 0 || time <= lastDamageTime) {
            damage = 0;
        }
        return damage;
    }

    private static void setAllDamage(ItemStack stack, float num, long time) {
        ItemNBTTool.setFloat(stack, TAG_DAMAGE, Math.min(num, 100.0f));
        ItemNBTTool.setLong(stack, TAG_TIME, time);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.NETHERITE_INGOT;
    }
}
