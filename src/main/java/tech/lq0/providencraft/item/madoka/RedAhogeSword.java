package tech.lq0.providencraft.item.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModItemTier;

import javax.annotation.Nullable;
import java.util.List;

public class RedAhogeSword extends SwordItem{
    public RedAhogeSword() {
        super(ModItemTier.RED_AHOGE, 4, -2.4f, new Item.Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("red_ahoge_sword_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_sword_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_sword_des3")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_sword_des4")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
    }
}
