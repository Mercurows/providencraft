package tech.lq0.providencraft.item.donate;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
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
import tech.lq0.providencraft.models.OrangeTrackerModel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OrangeTracker extends ArmorItem {
    public OrangeTracker() {
        super(ArmorMaterial.CHAIN, EquipmentSlotType.LEGS, new Properties().group(ModGroup.donategroup).defaultMaxDamage(2022));
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return (A) new OrangeTrackerModel<>();
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return Utils.MOD_ID + ":textures/models/armor/orange_tracker_texture.png";
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.orange_tracker_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.orange_tracker_2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.orange_tracker_3")).mergeStyle(TextFormatting.RED));
        tooltip.add((new TranslationTextComponent("des.providencraft.donate_item")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        int r = 5;
        AxisAlignedBB area = new AxisAlignedBB(player.getPosition().add(-r, -r, -r), player.getPosition().add(r, r, r));

        List<ItemEntity> items = player.world.getEntitiesWithinAABB(EntityType.ITEM, area,
                item -> item.isAlive() && (player.world.isRemote || item.ticksExisted > 1) &&
                        (item.getThrowerId() == null || !item.getThrowerId().equals(player.getUniqueID()) || !item.cannotPickup()) &&
                        !item.getItem().isEmpty()
        );
        items.forEach(item -> item.setPosition(player.getPosX(), player.getPosY(), player.getPosZ()));

        player.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 1, true, false));
        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 1, true, false));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.ORANGE_TRACKER.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(uuid, "orange tracker modifier", 0.1, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @SubscribeEvent
    public static void Effect(LivingHurtEvent event) {
        Entity entity = event.getEntityLiving();
        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
            PlayerEntity player = (PlayerEntity) entity;
            ItemStack tracker = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            if (!tracker.isEmpty() && tracker.getItem().equals(ItemRegistry.ORANGE_TRACKER.get())) {
                int random = (int) (Math.random() * 10 + 1);
                if (random == 1) {
                    player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, 0));
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 0));
                }
            }
        }
    }
}
