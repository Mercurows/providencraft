package tech.lq0.providencraft.item.chiram;

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

public class FlatVegetableChestplate extends ArmorItem {
    public FlatVegetableChestplate(){
        super(ModArmorMaterial.CHIRAM, EquipmentSlotType.CHEST,new Properties().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("vegetable_chestplate_des")).mergeStyle(TextFormatting.GRAY));
    }
}
