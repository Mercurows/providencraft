package tech.lq0.providencraft.item.providencefirst.ayelet;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.CrystalHornModel;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.ItemNBTTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CrystalHorn extends ArmorItem {
    public static final String TAG_NIGHT = "isnight";

    public CrystalHorn() {
        super(ModArmorMaterial.CRYSTAL, EquipmentSlotType.HEAD, new Properties().group(ModGroup.itemgroup));
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new CrystalHornModel<>(1.0F, slot, entityLiving);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/crystal_horn_texture.png";
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.CRYSTAL_HORN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            boolean night = ItemNBTTool.getBoolean(stack, TAG_NIGHT, false);
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "crystal horn modifier", night ? 6.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "crystal horn modifier", night ? 4.0 : 0, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "crystal horn modifier", night ? 0.2 : 0, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if (!world.isDaytime()) {
            ItemNBTTool.setBoolean(stack, TAG_NIGHT, true);
            player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0));
        } else {
            ItemNBTTool.setBoolean(stack, TAG_NIGHT, false);
        }

        if (player.isSleeping()) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 12000, 2));
            player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 12000, 2));
            player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 12000, 2));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("crystal_horn_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("crystal_horn_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("crystal_horn_des3")).mergeStyle(TextFormatting.RED));
    }

    //对牛特攻
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();

        Entity entityP = event.getSource().getImmediateSource();
        if (entityP instanceof PlayerEntity && !entityP.world.isRemote()) {
            PlayerEntity player = (PlayerEntity) entityP;
            ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (item.getItem().equals(ItemRegistry.CRYSTAL_HORN.get())) {
                if (entity instanceof CowEntity || entity.getUniqueID().toString().equals("1e10b6810052495bb7a93c0c5fc35552")) {
                    event.setAmount(event.getAmount() + 200);
                }
            }
        }
    }

}
