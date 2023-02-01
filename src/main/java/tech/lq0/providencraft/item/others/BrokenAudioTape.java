package tech.lq0.providencraft.item.others;

import net.minecraft.client.util.ITooltipFlag;
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
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BrokenAudioTape extends MusicDiscItem {

    public BrokenAudioTape(Supplier<SoundEvent> soundSupplier, Properties builder) {
        super(15, soundSupplier, builder);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.getDescription().mergeStyle(TextFormatting.GRAY));
        TooltipTool.addHideText(tooltip, this.getText().mergeStyle(TextFormatting.WHITE));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getDescription() {
        return new TranslationTextComponent("des." + this.getTranslationKey());
    }

    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getText() {
        return new TranslationTextComponent("text." + this.getTranslationKey());
    }
}
