package tech.lq0.providencraft.item.providencefirst.myanna;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class Schedule extends Item {
    public Schedule(){
        super(new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("schedule_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("schedule_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("description_first")).mergeStyle(TextFormatting.YELLOW).mergeStyle(TextFormatting.BOLD));
    }
}
