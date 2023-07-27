package tech.lq0.providencraft.item.providencefirst.madoka;

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
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Sneakers extends ArmorItem {
    public Sneakers() {
        super(ModArmorMaterial.RED_AHOGE, EquipmentSlotType.FEET, new Properties().group(ModGroup.itemgroup).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add((new TranslationTextComponent("des.providencraft.sneakers")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.SNEAKERS.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "sneaker modifier", 0.25, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @SubscribeEvent
    public static void onFalling(LivingHurtEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SNEAKERS.get() &&
                event.getSource() == DamageSource.FALL){
            event.setAmount(event.getAmount() / 2.0f);
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SNEAKERS.get()){
            event.setDistance(Math.max(0, event.getDistance() - 6));
        }
    }

    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SNEAKERS.get()){
            livingEntity.setMotion(livingEntity.getMotion().add(0, 0.175, 0));
        }
    }
}
