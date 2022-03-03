package tech.lq0.providencraft.item.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nullable;
import java.util.List;

public class RedAhogeHelmet extends ArmorItem{
    public RedAhogeHelmet(){
        super(ModArmorMaterial.RED_AHOGE, EquipmentSlotType.HEAD,new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("red_ahoge_helmet_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_helmet_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_helmet_des3")).mergeStyle(TextFormatting.GRAY));
    }

}
