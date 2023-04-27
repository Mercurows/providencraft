package tech.lq0.providencraft.item.providencethird.leciel;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;

public class GiantDiamondRing extends SwordItem {
    private static final String TAG_SILK_TOUCH = "providencraft:silk_touch";

    public GiantDiamondRing(){
        super(ItemTier.DIAMOND, 1, -1.0f, new Properties().maxDamage(794).rarity(Rarity.UNCOMMON).group(ModGroup.itemgroup));
    }

    @Override
    public boolean canHarvestBlock(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material == Material.GLASS;
    }

    //From Botania
    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {
        BlockState state = player.world.getBlockState(pos);
        boolean hasSilk = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, itemstack) > 0;
        if (hasSilk || !(state.getMaterial() == Material.GLASS || Tags.Blocks.GLASS.contains(state.getBlock()))) {
            return super.onBlockStartBreak(itemstack, pos, player);
        }

        itemstack.addEnchantment(Enchantments.SILK_TOUCH, 1);
        CompoundNBT nbt = itemstack.getTag();
        if(nbt != null) {
            nbt.putBoolean(TAG_SILK_TOUCH, true);
        }

        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (stack.getOrCreateTag().getBoolean(TAG_SILK_TOUCH)) {
            CompoundNBT nbt = stack.getTag();
            if(nbt != null) {
                nbt.remove(TAG_SILK_TOUCH);
            }

            Map<Enchantment, Integer> enchantments = EnchantmentHelper.deserializeEnchantments(stack.getEnchantmentTagList());
            enchantments.remove(Enchantments.SILK_TOUCH);
            EnchantmentHelper.setEnchantments(enchantments, stack);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.giant_diamond_ring_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.giant_diamond_ring_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.LECIEL);
    }
}
