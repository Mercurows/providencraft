package tech.lq0.providencraft.item.providencefirst.myanna;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModItemTier;

import javax.annotation.ParametersAreNonnullByDefault;

public class MountainDestroyer extends PickaxeItem {
    public MountainDestroyer() {
        super(ModItemTier.DARK_ELF, 6, -3f, (new Properties()).defaultMaxDamage(39).rarity(Rarity.EPIC).group(ModGroup.itemgroup));
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
}
