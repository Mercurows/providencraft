package tech.lq0.providencraft.integration.vrc.item.sui;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class SuimashedCookie extends Item {
    private static final Food food = new Food.Builder().fastToEat().setAlwaysEdible().hunger(2).saturation(0.25f).build();

    public SuimashedCookie() {
        super(new Properties().group(ModGroup.integrationgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.suimashed_cookie")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addHideText(tooltip, new StringTextComponent(""));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.coop.sui").mergeStyle(Style.EMPTY.setColor(Color.fromHex("#87EAFF"))));
    }
}
