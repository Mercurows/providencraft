package tech.lq0.providencraft.item.providencesecond.lucia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BigFierceOneCoffee extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.5f).hunger(2).
            effect(() -> new EffectInstance(Effects.NIGHT_VISION, 1200, 0), 1.0f).
            effect(() -> new EffectInstance(Effects.HASTE, 1200, 1), 1.0f).
            effect(() -> new EffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 1200, 3), 1.0f).
            setAlwaysEdible().build();

    public BigFierceOneCoffee(){
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @Override
    @Nonnull
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.big_fierce_one_coffee_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.big_fierce_one_coffee_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.LUCIA);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
