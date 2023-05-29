package tech.lq0.providencraft.item.blockitem;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;

public class EliboardBlockItem extends BlockItem {
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public EliboardBlockItem(){
        super(BlockRegistry.ELIBOARD.get(), new Properties().group(ModGroup.blockgroup));
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 4, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }
}
