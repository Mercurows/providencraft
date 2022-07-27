package tech.lq0.providencraft.item.providencemagicros.keroro;

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
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.FrogCrownModel;
import tech.lq0.providencraft.tools.ItemNBTTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class FrogCrown extends ArmorItem {
    public static final String TAG_RAIN = "isRaining";
    public FrogCrown(){
        super(ArmorMaterial.GOLD, EquipmentSlotType.HEAD, new Properties().setNoRepair().defaultMaxDamage(302).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new FrogCrownModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/frog_crown_model_texture.png";
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if (world.isRaining()) {
            ItemNBTTool.setBoolean(stack, TAG_RAIN, true);
            if(player.ticksExisted % 300 == 0) {
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 0, true, false));
            }
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 300, 0, true, false));
        } else {
            ItemNBTTool.setBoolean(stack, TAG_RAIN, false);
        }
        if(player.isSwimming()){
            player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 300, 0,true,false));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.FROG_CROWN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            boolean rain = ItemNBTTool.getBoolean(stack, TAG_RAIN, false);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "frog crown modifier", rain ? 2.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, "frog crown modifier", rain ? 4.0 : 0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("frog_crown_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("frog_crown_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("description_magicros")).mergeStyle(TextFormatting.GREEN).mergeStyle(TextFormatting.BOLD));
    }
}
