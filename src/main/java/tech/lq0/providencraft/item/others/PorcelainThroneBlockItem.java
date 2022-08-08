package tech.lq0.providencraft.item.others;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;

public class PorcelainThroneBlockItem extends BlockItem {
    public PorcelainThroneBlockItem() {
        super(BlockRegistry.PORCELAIN_THRONE.get(), new Item.Properties().group(ModGroup.itemgroup));
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }
}
