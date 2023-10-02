package tech.lq0.providencraft.item.providencemagicros.hoshimiya;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModArmorMaterial;
import tech.lq0.providencraft.tools.ArmorTool;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CelestialBoots extends ArmorItem {
    private static final int[] HUNGER_TIME = new int[]{320, 240, 160, 160};

    public static final String TAG_SET = "Set";

    public CelestialBoots() {
        super(ModArmorMaterial.MAGICROS, EquipmentSlotType.FEET, new Properties().group(ModGroup.itemgroup).isImmuneToFire().setNoRepair()
                .rarity(Rarity.create("PROVIDENCRAFT_LEGENDARY", TextFormatting.GOLD)));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add(new TranslationTextComponent("des.providencraft.celestial_boots_1").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add(new TranslationTextComponent("des.providencraft.celestial_boots_2").mergeStyle(TextFormatting.GRAY));
        if (hasArmorSet(stack)) {
            tooltip.add(new TranslationTextComponent("des.providencraft.magicros_set").mergeStyle(TextFormatting.ITALIC).mergeStyle(Style.EMPTY.setColor(Color.fromHex("#E2B578"))));
        }

        TooltipTool.addLiverInfo(tooltip, Livers.EKIRA);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            setArmorSet(stack, player);
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isRemote) {
            setArmorSet(stack, player);

            int times = getEnhanceTimes(player, hasArmorSet(stack));
            if (times == 4) {
                if (player.getFoodStats().getFoodLevel() >= 20) {
                    if (player.ticksExisted % 80 == 0) {
                        player.getFoodStats().addStats(2, 0.75f);
                    }
                } else {
                    if (player.ticksExisted % 160 == 0) {
                        player.getFoodStats().addStats(2, 0.5f);
                    }
                }
            } else if (player.ticksExisted % HUNGER_TIME[times - 1] == 0) {
                player.getFoodStats().addStats(1, 0.5f);
            }
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(ItemRegistry.CELESTIAL_BOOTS.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == getEquipmentSlot()) {
            map = HashMultimap.create(map);
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "pdc armor modifier", 4.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "pdc armor modifier", 0.4f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "pdc armor modifier", hasArmorSet(stack) ? 0.1f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    public static void setArmorSet(ItemStack stack, PlayerEntity player) {
        ItemNBTTool.setBoolean(stack, TAG_SET, ArmorTool.hasArmorSet(player));
    }

    public static boolean hasArmorSet(ItemStack stack) {
        return ItemNBTTool.getBoolean(stack, TAG_SET, false);
    }

    private static int getEnhanceTimes(PlayerEntity player, boolean flag) {
        //套装效果，强化变为4次
        if (flag) {
            return 4;
        }

        //普通情况，倍率为1
        int times = 1;

        World world = player.world;
        BlockPos pos = player.getPosition();

        if (!world.isRemote) {
            //可见天空，倍率为2
            if (world.canSeeSky(pos)) {
                times = 2;

                //可见星空，倍率为3
                if (!world.isRaining() && world.isNightTime()) {
                    times = 3;
                }
            }
        }

        return times;
    }

    @SubscribeEvent
    public static void celestialBootsEvent(LivingHurtEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        ItemStack itemStack = livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET);
        DamageSource source = event.getSource();
        Entity entity = source.getTrueSource();

        if (!livingEntity.world.isRemote) {
            if (livingEntity instanceof PlayerEntity && !itemStack.isEmpty() && itemStack.getItem().equals(ItemRegistry.CELESTIAL_BOOTS.get())) {
                PlayerEntity player = (PlayerEntity) livingEntity;

                if (!player.getCooldownTracker().hasCooldown(ItemRegistry.CELESTIAL_BOOTS.get())) {
                    int times = getEnhanceTimes(player, hasArmorSet(itemStack));

                    if (entity instanceof LivingEntity) {
                        LivingEntity target = (LivingEntity) entity;

                        if (target != player) {
                            target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 50, times - 1));
                            target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 50, 0));

                            if (times == 4) {
                                target.addPotionEffect(new EffectInstance(Effects.GLOWING, 50, 0));
                            }
                        }
                    }

                    player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 50 + Math.min(3, times) * 50, times == 4 ? 1 : 0));

                    player.getCooldownTracker().setCooldown(itemStack.getItem(), 120);
                }
            }
        }
    }

}
