package tech.lq0.providencraft.item.lucia;

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

import javax.annotation.Nullable;
import java.util.List;

public class LuciaRiceCake extends Item {
    private static final Food food = (new Food.Builder()).saturation(6.4f).hunger(4).build();
    public LuciaRiceCake(){
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("lucia_rice_cake_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lucia_rice_cake_des2")).mergeStyle(TextFormatting.GRAY));
    }
}
