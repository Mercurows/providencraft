package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IsekaiLollipop extends Item {
    private static final Food food = new Food.Builder().saturation(0.5f).hunger(14)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 2400, 2), 1.0F)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 300, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.RESISTANCE, 6000, 0), 1.0F)
            .effect(() -> new EffectInstance(Effects.WATER_BREATHING, 6000, 0), 1.0F)
            .setAlwaysEdible().build();

    public IsekaiLollipop(){
        super(new Properties().isImmuneToFire().group(ModGroup.itemgroup).maxStackSize(1).food(food));
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        int level = checkEnchantments(stack);
        if(level <= 10){
            return Rarity.UNCOMMON;
        }else if (level < 30){
            return Rarity.RARE;
        }else {
            return Rarity.EPIC;
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.isekai_lollipop_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.isekai_lollipop_2")).mergeStyle(TextFormatting.GRAY));
        if(checkEnchantments(stack) >= 30){
            tooltip.add((new TranslationTextComponent("des.providencraft.isekai_lollipop_4")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.ITALIC));
        }else if(checkEnchantments(stack) > 10){
            tooltip.add((new TranslationTextComponent("des.providencraft.isekai_lollipop_3")).mergeStyle(TextFormatting.LIGHT_PURPLE).mergeStyle(TextFormatting.ITALIC));
        }
        TooltipTool.addChaosInfo(tooltip, -50);
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote && entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;

            int level = checkEnchantments(stack);
            if(level > 10){
                int random = (int)(Math.random() * 100) + 1;
                if(random <= (level - 10) * 5){
                    player.attackEntityFrom(DamageSource.MAGIC, 5.0f);
                    player.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 200, 0));

                    return player.abilities.isCreativeMode ? stack : new ItemStack(ItemRegistry.PAST_SUGAR.get());
                }
            }

            ChaosHelper.addChaos(player, -50);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    public int checkEnchantments(ItemStack stack){
        AtomicInteger sum = new AtomicInteger();
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack);
        map.forEach(((enchantment, integer) -> sum.addAndGet(integer)));

        return sum.get();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return true;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return 20;
    }
}
