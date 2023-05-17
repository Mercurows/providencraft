package tech.lq0.providencraft.item.providenceOI.yesa;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TailFishingRod extends FishingRodItem {
    public static final String TAG_CAST = "tail_cast";

    public TailFishingRod(){
        super(new Properties().group(ModGroup.itemgroup).defaultMaxDamage(82).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add((new TranslationTextComponent("des.providencraft.tail_fishing_rod_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.tail_fishing_rod_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.YESA);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityIn;
            boolean flag = player.fishingBobber != null;

            ItemNBTTool.setBoolean(stack, TAG_CAST, flag && isSelected);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
