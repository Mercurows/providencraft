package tech.lq0.providencraft.item.blockitem;

import com.google.common.collect.HashMultimap;
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
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

public class EliboardBlockItem extends BlockItem {
    public EliboardBlockItem(){
        super(BlockRegistry.ELIBOARD.get(), new Properties().group(ModGroup.blockgroup));
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.ELIBOARD.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "fukamizu bread modifier", 4.0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
