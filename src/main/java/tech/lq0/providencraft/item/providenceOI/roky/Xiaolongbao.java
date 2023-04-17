package tech.lq0.providencraft.item.providenceOI.roky;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class Xiaolongbao extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.5f).hunger(7).setAlwaysEdible().build();

    public Xiaolongbao(){
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.xiaolongbao")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.xiaolongbao.warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addLiverInfo(tooltip, Livers.ROKY);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 50;
    }
}
