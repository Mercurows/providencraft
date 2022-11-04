package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class PeachBeach extends Item {
    private static final Food food = (new Food.Builder()).saturation(8).hunger(6).setAlwaysEdible().
            effect(new EffectInstance(Effects.NAUSEA, 300, 0), 0.3f).
            effect(new EffectInstance(Effects.STRENGTH, 300, 0), 1.0f).build();

    public PeachBeach() {
        super(new Properties().group(ModGroup.itemgroup).food(food).maxStackSize(1));
    }

    @Override
    @Nonnull
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("peach_beach_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("peach_beach_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }
}
