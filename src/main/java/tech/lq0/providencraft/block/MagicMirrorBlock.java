package tech.lq0.providencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import tech.lq0.providencraft.block.tile.MagicMirrorTileEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class MagicMirrorBlock extends Block {
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE_NS = Block.makeCuboidShape(5, 0, 0, 11, 10, 16);
    protected static final VoxelShape SHAPE_EW = Block.makeCuboidShape(0, 0, 5, 16, 10, 11);

    public MagicMirrorBlock() {
        super(Properties.create(Material.GLASS).hardnessAndResistance(3.0f).sound(SoundType.GLASS).notSolid());
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
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

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH ? SHAPE_NS : SHAPE_EW;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote && handIn == Hand.MAIN_HAND){
            if(player.getHeldItemMainhand() == ItemStack.EMPTY){
                MagicMirrorTileEntity tileEntity = (MagicMirrorTileEntity) worldIn.getTileEntity(pos);
                if(tileEntity != null) {
                    BlockPos tpPos = tileEntity.getTeleportPos();
                    if (tpPos != null) {
                        player.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.bind", tpPos.getX(), tpPos.getY(), tpPos.getZ()), true);
                    } else {
                        player.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.bind.false"), true);
                    }
                }
            }

        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
