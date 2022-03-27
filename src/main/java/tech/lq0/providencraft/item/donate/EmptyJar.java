package tech.lq0.providencraft.item.donate;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class EmptyJar extends Item {
    public EmptyJar(){
        super(new Properties().maxStackSize(1).group(ModGroup.donategroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("empty_jar_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if(!world.isRemote){
            player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,40,0));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot,stack);
        UUID uuid = new UUID(ItemRegistry.EMPTY_JAR.hashCode() + slot.toString().hashCode(), 0);
        if (slot == EquipmentSlotType.HEAD) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, "empty jar modifier", 1.0D, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }
}
