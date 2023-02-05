package tech.lq0.providencraft.item.providencefirst.unia;

import net.minecraft.client.util.ITooltipFlag;
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

public class EnchantedUnigiri extends Item {
    private static final Food food = (new Food.Builder()).saturation(1.0f).hunger(14).
            effect(() -> new EffectInstance(Effects.JUMP_BOOST, 140, 0), 1.0F).
            effect(() -> new EffectInstance(Effects.REGENERATION, 140, 0), 1.0F).build();

    public EnchantedUnigiri() {
        super(new Properties().food(food).rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("unigiri_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("enchanted_unigiri_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.UNIA);
    }
}
