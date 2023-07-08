package tech.lq0.providencraft.item.others;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class MusicDisc extends MusicDiscItem {
    private final Livers liver;

    public MusicDisc(Livers liver, Supplier<SoundEvent> soundSupplier, Item.Properties builder, int value) {
        super(value, soundSupplier, builder);
        this.liver = liver;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.getDescription().mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, this.liver);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getDescription() {
        return new TranslationTextComponent(this.getTranslationKey() + ".desc");
    }
}
