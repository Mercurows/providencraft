package tech.lq0.providencraft.item.providencefirst.unia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TaroIceCream extends Item {
    private static final Food food = (new Food.Builder()).saturation(3.0f).hunger(5).
            effect(new EffectInstance(Effects.SLOWNESS, 80, 2), 1.0F).build();

    public TaroIceCream() {
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("taro_ice_cream_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("taro_ice_cream_des2")).mergeStyle(TextFormatting.GRAY));
    }
}
