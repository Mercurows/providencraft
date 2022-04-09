package tech.lq0.providencraft.item.providencefirst.myanna;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModItemTier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

public class MountainDestroyer extends PickaxeItem {
    public MountainDestroyer() {
        super(ModItemTier.DARK_ELF, 6, -3f, (new Properties()).defaultMaxDamage(39).rarity(Rarity.EPIC)
                .group(ModGroup.itemgroup).isImmuneToFire().setNoRepair());
    }

    @Override
    @ParametersAreNonnullByDefault
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (state.getMaterial() == Material.ROCK && !worldIn.isRemote) {
            stack.setDamage(stack.getDamage() > 0 ? stack.getDamage() - 1 : 0);

            if (pos.getY() == entityLiving.getPosY() && stack.canHarvestBlock(worldIn.getBlockState(pos.add(0, 1, 0)))) {
                BlockPos newPos = pos.add(0, 1, 0);

                BlockState newState = worldIn.getBlockState(newPos);
                TileEntity tileentity = newState.hasTileEntity() ? worldIn.getTileEntity(newPos) : null;
                Block.spawnDrops(newState, worldIn, newPos, tileentity, entityLiving, entityLiving.getHeldItemMainhand());

                worldIn.destroyBlock(newPos, false);

                if (entityLiving instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) entityLiving;
                    player.addStat(Stats.BLOCK_MINED.get(state.getBlock()), 1);
                }
            }
            if (pos.getY() == entityLiving.getPosY() + 1 && stack.canHarvestBlock(worldIn.getBlockState(pos.add(0, -1, 0)))) {
                BlockPos newPos = pos.add(0, -1, 0);

                BlockState newState = worldIn.getBlockState(newPos);
                TileEntity tileentity = newState.hasTileEntity() ? worldIn.getTileEntity(newPos) : null;
                Block.spawnDrops(newState, worldIn, newPos, tileentity, entityLiving, entityLiving.getHeldItemMainhand());

                worldIn.destroyBlock(newPos, false);

                if (entityLiving instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) entityLiving;
                    player.addStat(Stats.BLOCK_MINED.get(state.getBlock()), 1);
                }
            }
            return true;
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> map = super.getAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID(ItemRegistry.TAIL_PEN.hashCode() + equipmentSlot.toString().hashCode(), 0);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            map = HashMultimap.create(map);
            map.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid, "mountain destroyer modifier", 0.2f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("mountain_destroyer_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("mountain_destroyer_des2")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged && !oldStack.equals(newStack);
    }
}
