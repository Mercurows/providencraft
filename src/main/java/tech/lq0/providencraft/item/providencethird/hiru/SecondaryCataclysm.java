package tech.lq0.providencraft.item.providencethird.hiru;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.entity.projectile.HirenadeGGEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.ItemNBTTool;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class SecondaryCataclysm extends Item {
    public static final String TAG_AMMO = "Ammo";
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public SecondaryCataclysm(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).rarity(Rarity.EPIC).isImmuneToFire());
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 9, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3.2, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.secondary_cataclysm_1")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.secondary_cataclysm_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        tooltip.add((new TranslationTextComponent("des.providencraft.secondary_cataclysm_3")).mergeStyle(TextFormatting.GRAY));
        tooltip.add(new StringTextComponent("Ammo:" + ItemNBTTool.getInt(stack, TAG_AMMO, 0)));
        TooltipTool.addLiverInfo(tooltip, Livers.HIRU);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {
        ItemStack stack = player.getHeldItem(handIn);

        ItemStack ammo = this.findAmmo(player);

        if(ItemNBTTool.getInt(stack, TAG_AMMO, 0) < 6){
            if(player.isSneaking()) {
                if(!ammo.isEmpty() || player.abilities.isCreativeMode) {
                    player.setActiveHand(handIn);
                }
                return ActionResult.resultConsume(stack);
            }
        }

        if(!player.getCooldownTracker().hasCooldown(stack.getItem()) && !player.isSneaking()){
            if(player.abilities.isCreativeMode || ItemNBTTool.getInt(stack, TAG_AMMO, 0) > 0) {
                if(!world.isRemote) {
                    HirenadeGGEntity hirenadeGG = new HirenadeGGEntity(world, player);
                    hirenadeGG.setShooter(player);
                    hirenadeGG.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0f, 1.8f, 0.0f);
                    world.addEntity(hirenadeGG);

                    player.getCooldownTracker().setCooldown(stack.getItem(), 10);
                    if (!player.abilities.isCreativeMode) {
                        ItemNBTTool.setInt(stack, TAG_AMMO, ItemNBTTool.getInt(stack, TAG_AMMO, 0) - 1);
                    }
                }
                player.playSound(SoundRegistry.GRENADE_SHOOT.get(), 1.0f, 1.0f);

                return ActionResult.resultFail(stack);
            }
        }

        return ActionResult.resultFail(stack);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 30;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote && entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;

            boolean flag2 = ItemNBTTool.getInt(stack, TAG_AMMO, 0) < 6;
            ItemStack ammo = this.findAmmo(player);

            if(player.abilities.isCreativeMode){
                ItemNBTTool.setInt(stack, TAG_AMMO, 6);
                return stack;
            }

            if (!ammo.isEmpty() || flag2) {
                int currentCount = ItemNBTTool.getInt(stack, TAG_AMMO, 0);
                int ammoCount = 6 - currentCount;

                if (ammo.isEmpty()) {
                    return stack;
                }

                boolean flag1 = ammo.getItem() instanceof HirenadeGG;

                if (flag1 && !player.abilities.isCreativeMode) {
                    if(ammo.getCount() >= ammoCount){
                        ammo.shrink(ammoCount);
                        ItemNBTTool.setInt(stack, TAG_AMMO, 6);
                    }else {
                        int count = ammo.getCount();
                        ammo.shrink(count);
                        ItemNBTTool.setInt(stack, TAG_AMMO, Math.min(currentCount + count, 6));
                    }

                    if (ammo.isEmpty()) {
                        player.inventory.deleteStack(ammo);
                    }
                }
            }
        }

        return stack;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.abilities.isCreativeMode;
    }

    protected ItemStack findAmmo(PlayerEntity player) {
        if (this.check(player.getHeldItem(Hand.OFF_HAND))) {
            return player.getHeldItem(Hand.OFF_HAND);
        } else if (this.check(player.getHeldItem(Hand.MAIN_HAND))) {
            return player.getHeldItem(Hand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                if (this.check(itemstack)) {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
        }
    }

    protected boolean check(ItemStack stack) {
        return stack.getItem() instanceof HirenadeGG;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}
