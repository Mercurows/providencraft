package tech.lq0.providencraft.item.providencemagicros.chiram;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
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
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class BreezeCrown extends ArmorItem {
    public BreezeCrown(){
        super(ModArmorMaterial.MAGICROS, EquipmentSlotType.HEAD, new Properties().group(ModGroup.itemgroup).isImmuneToFire().setNoRepair()
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(new TranslationTextComponent("des.providencraft.breeze_crown_1").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("des.providencraft.breeze_crown_2").mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.CHIRAM);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.BREEZE_CROWN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "pdc armor modifier", 3.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(uuid, "pdc armor modifier", 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
}
