package tech.lq0.providencraft.integration.vrc.ameki;

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
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.integration.vrc.VirtuaRealCraftRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RainyButterfly extends SwordItem {
    public static final String TAG_RAINY_BUTTERFLY_COUNT = "rainy_butterfly_count";
    public static final String TAG_RAINY_BUTTERFLY_TIME = "rainy_butterfly_time";
    public static final String TAG_RAINY_BUTTERFLY_OPEN = "rainy_butterfly_open";
    public static final String TAG_RAINY_BUTTERFLY_RAIN = "rainy_butterfly_rain";

    public RainyButterfly(){
        super(ItemTier.IRON, -2, -2.1f, new Properties().group(ModGroup.integrationgroup).maxDamage(1206));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.rainy_butterfly_3")).mergeStyle(TextFormatting.GRAY));

        TooltipTool.addHideText(tooltip, new StringTextComponent(""));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.liver").mergeStyle(TextFormatting.WHITE));
        TooltipTool.addHideText(tooltip, new TranslationTextComponent("liver.providencraft.coop.ameki").mergeStyle(Style.EMPTY.setColor(Color.fromHex("#D7F0FE"))));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getEntityWorld();
        if(!world.isRemote){
            if(!ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false)) {
                int count = ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
                if (count > 0) {
                    if (!world.isRaining()) {
                        attacker.heal(2.0f);
                    } else {
                        attacker.heal(5.0f);
                    }
                    ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, count - 1);
                }
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_TIME, 0);
        ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
        ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, false);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote){
            if(entityIn instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entityIn;

                boolean isMainhand = player.getHeldItemMainhand() == stack;
                boolean isOffHand = player.getHeldItemOffhand() == stack;

                if(isMainhand || isOffHand) {
                    boolean open = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
                    if (open) {
                        if (player.ticksExisted % 20 == 0 && getRainyButterflyTime(stack) < 20
                                && getRainyButterflyCount(stack) < (worldIn.isRaining() ? 9 : 3)) {
                            setRainyButterflyTime(stack, Math.min(20, getRainyButterflyTime(stack) + 1));
                        }

                        if (worldIn.isRaining()) {
                            if (getRainyButterflyTime(stack) >= 5 && getRainyButterflyCount(stack) < 9 && getRainyButterflyTime(stack) > 0) {
                                setRainyButterflyCount(stack, Math.min(9, getRainyButterflyCount(stack) + 1));
                                setRainyButterflyTime(stack, getRainyButterflyTime(stack) - 5);
                            }
                        } else {
                            if (getRainyButterflyTime(stack) % 20 == 0 && getRainyButterflyCount(stack) < 3 && getRainyButterflyTime(stack) > 0) {
                                setRainyButterflyCount(stack, Math.min(3, getRainyButterflyCount(stack) + 1));
                                setRainyButterflyTime(stack, getRainyButterflyTime(stack) - 20);
                            }
                        }
                    }
                }
            }
        }
        if(worldIn.isRaining()){
            if(stack.getDamage() < stack.getMaxDamage()){
                PlayerEntity player = (PlayerEntity) entityIn;
                if (player.ticksExisted % 20 == 0) {
                    stack.damageItem(-1, player, (playerEntity) -> playerEntity.sendBreakAnimation(player.getActiveHand()));
                }
            }
            ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, true);
        }else {
            ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, false);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            boolean open = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
            if(open){
                ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
            }else {
                int level = getRainyButterflyCount(stack);
                if(level > 0){
                    if(playerIn.isSneaking()){
                        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 800, level - 1, false, false));
                        setRainyButterflyCount(stack, 0);

                        //TODO 发射冲击波，击退面前的生物

                    }else {
                        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 1200, 0, false, false));
                        setRainyButterflyCount(stack, level - 1);
                    }
                }

                ItemNBTTool.setBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, true);
            }
        }
        return new ActionResult<>(ActionResultType.FAIL, stack);
    }

    @SubscribeEvent
    public static void propertyOverrideRegistry(FMLClientSetupEvent event) {
        event.enqueueWork(() ->
                ItemModelsProperties.registerProperty(VirtuaRealCraftRegistry.RAINY_BUTTERFLY.get(), new ResourceLocation("open"),
                        (stack, world, entity) -> ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false) ? 1.0F : 0.0F)
        );
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot, stack);
        UUID uuid = new UUID(VirtuaRealCraftRegistry.RAINY_BUTTERFLY.hashCode() + equipmentSlot.toString().hashCode(), 0);
        UUID uuid2 = new UUID(VirtuaRealCraftRegistry.RAINY_BUTTERFLY.hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND || equipmentSlot == EquipmentSlotType.OFFHAND) {
            map = HashMultimap.create(map);
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_OPEN, false);
            int count = ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
            boolean rain = ItemNBTTool.getBoolean(stack, TAG_RAINY_BUTTERFLY_RAIN, false);

            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "rainy butterfly modifier", flag ? 0.0f : 7.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MAX_HEALTH,
                    new AttributeModifier(uuid, "rainy butterfly modifier", flag ? count * 0.05f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid2, "rainy butterfly modifier2", rain ? count * 0.03f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(uuid, "rainy butterfly modifier", rain ? count * 0.02f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "rainy butterfly modifier", rain ? count * 0.05f : 0.0f, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return map;
    }

    private static int getRainyButterflyCount(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_COUNT, 0);
    }

    private static int getRainyButterflyTime(ItemStack stack){
        return ItemNBTTool.getInt(stack, TAG_RAINY_BUTTERFLY_TIME, 0);
    }

    private static void setRainyButterflyCount(ItemStack stack, int count){
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_COUNT, count);
    }

    private static void setRainyButterflyTime(ItemStack stack, int time){
        ItemNBTTool.setInt(stack, TAG_RAINY_BUTTERFLY_TIME, time);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
