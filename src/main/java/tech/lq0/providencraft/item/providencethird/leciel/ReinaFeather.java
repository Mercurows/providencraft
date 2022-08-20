package tech.lq0.providencraft.item.providencethird.leciel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class ReinaFeather extends Item {
    public ReinaFeather(){
        super(new Properties().group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("reina_feather_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("description_third")).mergeStyle(TextFormatting.DARK_AQUA).mergeStyle(TextFormatting.BOLD));
    }
}