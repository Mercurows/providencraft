package tech.lq0.providencraft.item.providencethird.beni;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class ShuraChin extends SwordItem {
    public static final String TAG_INVOKE = "invoke";

    public ShuraChin() {
        super(ItemTier.IRON, -2, -1.5f, new Properties().rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup).
                setNoRepair().maxDamage(1442));
        ItemModelsProperties.registerProperty(this, new ResourceLocation(Utils.MOD_ID, "shurachin_invoke"),
                (stack, world, entity) -> ItemNBTTool.getBoolean(stack, TAG_INVOKE, false) ? 1.0F : 0.0F);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (handIn == Hand.MAIN_HAND) {
            if (!ItemNBTTool.getBoolean(stack, TAG_INVOKE, false)) {
                for (LivingEntity livingentity : playerIn.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, playerIn.getBoundingBox().grow(2.0D, 0.5D, 2.0D))) {
                    if (livingentity != playerIn && !playerIn.isOnSameTeam(livingentity) && (!(livingentity instanceof ArmorStandEntity) || !((ArmorStandEntity) livingentity).hasMarker()) && playerIn.getDistanceSq(livingentity) < 9.0D) {
                        livingentity.applyKnockback(0.6F, MathHelper.sin(playerIn.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(playerIn.rotationYaw * ((float) Math.PI / 180F)));
                        livingentity.attackEntityFrom(DamageSource.causePlayerDamage(playerIn), 13);
                    }
                }
                playerIn.spawnSweepParticles();
                playerIn.getCooldownTracker().setCooldown(stack.getItem(), 40);

                worldIn.playSound(playerIn, playerIn.getPosition(),
                        SoundRegistry.BLADE.get(), SoundCategory.AMBIENT, 0.5f, 1f);
            }
            if (!worldIn.isRemote) {
                boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
                ItemNBTTool.setBoolean(stack, TAG_INVOKE, !flag);
            }
        }
        return ActionResult.resultFail(stack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.SHURA_CHIN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            boolean flag = ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
            map.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(uuid, "shurachin modifier", flag ? 12.0f : 0.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(uuid, "shurachin modifier", flag ? 0.3f : 0.0f, AttributeModifier.Operation.MULTIPLY_BASE));
            map.put(Attributes.ARMOR,
                    new AttributeModifier(uuid, "shurachin modifier", flag ? 0.0f : 8.0f, AttributeModifier.Operation.ADDITION));
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "shurachin modifier", flag ? 0.0f : 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.getHeldItemOffhand().getItem().equals(ItemRegistry.UME.get()) &&
                    player.getHeldItemMainhand().getItem().equals(ItemRegistry.SHURA_CHIN.get())) {
                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 300, 1));
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 1));
            }
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof SalmonEntity || target instanceof SquidEntity || target instanceof GuardianEntity ||
                target instanceof CodEntity || target instanceof PufferfishEntity || target instanceof TropicalFishEntity ||
                target instanceof ChickenEntity) {
            attacker.addPotionEffect(new EffectInstance(Effects.SATURATION, 100, 1));
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("ume_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("shurachin_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("shurachin_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return !ItemNBTTool.getBoolean(stack, TAG_INVOKE, false);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
}
