package tech.lq0.providencraft.item.providencesecond.mojuko;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
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
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class YagiStaffCard extends Item {
    public YagiStaffCard() {
        super(new Properties().maxStackSize(1).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("yagi_staff_card_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("yagi_staff_card_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MOJUKO);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.YAGI_STAFF_CARD.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.OFFHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "yagi staff card modifier", -0.5f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "yagi staff card modifier", 6.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
