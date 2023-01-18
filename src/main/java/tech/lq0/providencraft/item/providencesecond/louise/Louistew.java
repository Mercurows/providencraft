package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Louistew extends Item {
    private static final Food food = (new Food.Builder()).saturation(6.0f).hunger(14).
            effect(() -> new EffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 200, 0), 0.1f).build();

    public Louistew(){
        super(new Properties().maxStackSize(1).food(food).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("louistew_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("louistew_warn")).mergeStyle(TextFormatting.RED));
        TooltipTool.addLiverInfo(tooltip, Livers.LOUISE);
    }
}
