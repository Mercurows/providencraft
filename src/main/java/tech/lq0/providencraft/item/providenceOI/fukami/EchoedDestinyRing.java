package tech.lq0.providencraft.item.providenceOI.fukami;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.models.bakedModel.EchoedDestinyRingBakedModel;
import tech.lq0.providencraft.render.tile.EchoedDestinyRingTileEntityRenderer;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EchoedDestinyRing extends Item {
    public static final String TAG_ECHO = "underwater";

    public EchoedDestinyRing() {
        super(new Properties().maxStackSize(1).maxDamage(404).group(ModGroup.itemgroup)
                .rarity(Rarity.create("LEGENDARY", TextFormatting.GOLD)).setISTER(() -> EchoedDestinyRingTileEntityRenderer::new));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("echoed_destiny_ring_des1").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("echoed_destiny_ring_des2").mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.FUKAMI);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isRemote) {
            if (player.isInWater() || world.isRaining()) {
                ItemNBTTool.setBoolean(stack, TAG_ECHO, true);
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 2, true, false));
                player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 300, 0, true, false));
                player.addPotionEffect(new EffectInstance(Effects.HASTE, 300, 1, true, false));
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 2, true, false));

                if (player.isSwimming()) {
                    player.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 300, 0, true, false));
                }
                for (LivingEntity livingentity : player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, player.getBoundingBox().grow(30.0D, 30.0D, 30.0D))) {
                    if (livingentity instanceof PlayerEntity && livingentity != player && livingentity.isOnSameTeam(player)) {
                        PlayerEntity playerEntity = (PlayerEntity) livingentity;
                        playerEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 1, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 1, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 300, 0, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 300, 0, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 300, 1, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 0, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.HASTE, 300, 1, true, false));
                    }
                }
            } else {
                ItemNBTTool.setBoolean(stack, TAG_ECHO, false);
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 1, true, false));
                player.addPotionEffect(new EffectInstance(Effects.HASTE, 300, 1, true, false));

                for (LivingEntity livingentity : player.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, player.getBoundingBox().grow(10.0D, 10.0D, 10.0D))) {
                    if (livingentity instanceof PlayerEntity && livingentity != player) {
                        PlayerEntity playerEntity = (PlayerEntity) livingentity;
                        playerEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 0, true, false));
                        playerEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 300, 0, true, false));
                    }
                }
            }

            //heal player
            if(player.ticksExisted % 100 == 0){
                player.heal(1.0f);
            }

            //give saturation effect when player is dying
            if(player.getHealth() <= 5.0f && !player.getCooldownTracker().hasCooldown(stack.getItem())){
                player.addPotionEffect(new EffectInstance(Effects.SATURATION, 100, 0, true, false));
                player.getCooldownTracker().setCooldown(stack.getItem(), 2400);
            }
        }
        super.onArmorTick(stack, world, player);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(ItemRegistry.ECHOED_DESTINY_RING.hashCode() + slot.toString().hashCode(), 0);
        if (slot == EquipmentSlotType.HEAD) {
            map = HashMultimap.create(map);
            boolean underwater = ItemNBTTool.getBoolean(stack, TAG_ECHO, false);
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, "echoed destiny ring modifier", underwater ? 9.0f : 3.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "echoed destiny ring modifier", underwater ? 6.0f : 0.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "echoed destiny ring modifier", underwater ? 20.0f : 6.0f, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

    @SubscribeEvent
    public static void onModelBaked(ModelBakeEvent event) {
        Map<ResourceLocation, IBakedModel> modelRegistry = event.getModelRegistry();
        ModelResourceLocation location = new ModelResourceLocation(Objects.requireNonNull(ItemRegistry.ECHOED_DESTINY_RING.get().getRegistryName()), "inventory");
        IBakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException();
        } else if (existingModel instanceof EchoedDestinyRingBakedModel) {
            throw new RuntimeException();
        } else {
            EchoedDestinyRingBakedModel echoedDestinyRingBakedModel = new EchoedDestinyRingBakedModel(existingModel);
            event.getModelRegistry().put(location, echoedDestinyRingBakedModel);
        }
    }
}
