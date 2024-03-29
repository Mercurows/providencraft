package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
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
import java.util.List;

public class HaineCore extends Item{
    public HaineCore(){
        super(new Item.Properties().maxStackSize(1).rarity(Rarity.EPIC).group(ModGroup.itemgroup).isImmuneToFire());
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.haine_core").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.HAINE);
    }
}
