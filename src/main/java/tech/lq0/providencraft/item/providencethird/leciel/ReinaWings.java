package tech.lq0.providencraft.item.providencethird.leciel;

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
import net.minecraftforge.common.ForgeMod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.ReinaWingsModel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class ReinaWings extends ArmorItem {
    public ReinaWings(){
        super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Properties().maxDamage(627).setNoRepair().group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new ReinaWingsModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/reina_wings_model_texture.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isRemote){
            player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 300, 0, true, false));
            if(player.ticksExisted % 600 == 0){
                player.addPotionEffect(new EffectInstance(Effects.SATURATION, 20, 0));
            }
        }
        super.onArmorTick(stack, world, player);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.HIRU_HEAD.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(ForgeMod.ENTITY_GRAVITY.get(),
                    new AttributeModifier(uuid, "hiru head modifier", -0.5f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "hiru head modifier", 0.3f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("reina_wings_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("reina_wings_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("description_third")).mergeStyle(TextFormatting.DARK_AQUA).mergeStyle(TextFormatting.BOLD));
    }
}
