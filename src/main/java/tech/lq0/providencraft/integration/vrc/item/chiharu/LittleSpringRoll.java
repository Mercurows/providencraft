package tech.lq0.providencraft.integration.vrc.item.chiharu;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class LittleSpringRoll extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(6).saturation(0.35f)
            .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 200, 0), 1.0f)
            .effect(() -> new EffectInstance(Effects.HUNGER, 300, 0), 0.5f).build();

    public LittleSpringRoll(){
        super(new Properties().group(ModGroup.integrationgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.little_spring_roll")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addHideText(tooltip, new StringTextComponent(""));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.coop.chiharu").mergeStyle(Style.EMPTY.setColor(Color.fromHex("#8C6250"))));
    }
}
