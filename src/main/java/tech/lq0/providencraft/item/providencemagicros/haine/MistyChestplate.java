package tech.lq0.providencraft.item.providencemagicros.haine;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.TextFormatting;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModArmorMaterial;

import java.util.UUID;

public class MistyChestplate extends ArmorItem {
    public MistyChestplate(){
        super(ModArmorMaterial.MAGICROS, EquipmentSlotType.CHEST, new Properties().group(ModGroup.itemgroup).isImmuneToFire().setNoRepair()
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.MISTY_CHESTPLATE.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "misty chestplate modifier", 7.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "misty chestplate modifier", 8.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
}
