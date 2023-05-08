package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
        super(new Properties().isImmuneToFire().group(ModGroup.itemgroup).maxStackSize(1).rarity(Rarity.EPIC).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add((new TranslationTextComponent("des.providencraft.isekai_lollipop_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.isekai_lollipop_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote){
            int level = checkEnchantments(stack);
            System.out.println(level);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    public int checkEnchantments(ItemStack stack){
        AtomicInteger sum = new AtomicInteger();
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack);
        map.forEach(((enchantment, integer) -> sum.addAndGet(integer)));

        return sum.get();
    }
}
