package tech.lq0.providencraft.compat.vrc.ameki;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class RainyButterfly extends SwordItem {
    public RainyButterfly(){
        super(ItemTier.IRON, 5, -2.1f, new Properties().group(ModGroup.integrationgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_2")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addHideText(tooltip, new StringTextComponent(""));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.coop.ameki").mergeStyle(Style.EMPTY.setColor(Color.fromHex("#D7F0FE"))));
    }
}
