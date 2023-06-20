package tech.lq0.providencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import tech.lq0.providencraft.block.tile.MagicMirrorTileEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class MagicMirrorBlock extends Block {
    public MagicMirrorBlock() {
        super(Properties.create(Material.GLASS).hardnessAndResistance(3.0f).sound(SoundType.GLASS).notSolid());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MagicMirrorTileEntity();
    }

    //TODO 修改底座的碰撞体积
    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.or(Block.makeCuboidShape(0, 0, 0, 16, 8, 16));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote && handIn == Hand.MAIN_HAND){
            if(player.getHeldItemMainhand() == ItemStack.EMPTY){
                MagicMirrorTileEntity tileEntity = (MagicMirrorTileEntity) worldIn.getTileEntity(pos);
                if(tileEntity != null) {
                    BlockPos tpPos = tileEntity.getTeleportPos();
                    if (tpPos != null) {
                        player.sendStatusMessage(new StringTextComponent(tpPos.toString()), true);
                    } else {
                        player.sendStatusMessage(new StringTextComponent("目前还没有绑定！"), true);
                    }
                }
            }

        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
