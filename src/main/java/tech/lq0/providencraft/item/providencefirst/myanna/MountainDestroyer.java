package tech.lq0.providencraft.item.providencefirst.myanna;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModItemTier;

public class MountainDestroyer extends PickaxeItem {
    public MountainDestroyer(){
        super(ModItemTier.DARK_ELF,6,-3f,(new Properties()).defaultMaxDamage(39).rarity(Rarity.EPIC).group(ModGroup.itemgroup));
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if(state.getMaterial() == Material.ROCK && !worldIn.isRemote){
            stack.setDamage(stack.getDamage() > 0 ? stack.getDamage() - 1 : 0);
            return true;
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
