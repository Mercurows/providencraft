package tech.lq0.providencraft.item.providenceOI.shirayuki;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.AttributeRegistry;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.ButterflyAnkletModel;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class ButterflyAnklet extends ArmorItem {
    public ButterflyAnklet(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.FEET, new Properties().group(ModGroup.itemgroup).maxDamage(286));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add((new TranslationTextComponent("des.providencraft.butterfly_anklet_1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.butterfly_anklet_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.AOI);
    }

    @SuppressWarnings("unchecked")
    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new ButterflyAnkletModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/butterfly_anklet_texture.png";
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.BUTTERFLY_ANKLET.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "butterfly anklet modifier", 0.4, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(AttributeRegistry.CHAOS.get(),
                    new AttributeModifier(uuid, "butterfly anklet modifier", -30, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isRemote){
            if(player.isSneaking()){
                player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 40, 0, false, false));
            }
        }

        super.onArmorTick(stack, world, player);
    }
}
