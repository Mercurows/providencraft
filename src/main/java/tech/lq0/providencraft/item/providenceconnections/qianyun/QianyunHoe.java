package tech.lq0.providencraft.item.providenceconnections.qianyun;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QianyunHoe extends HoeItem {
    protected static final Map<Block, BlockState> QIANYUN_HOE_LOOKUP = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>()
                    .put(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.DIRT, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.COARSE_DIRT, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.PODZOL, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.SAND, Blocks.DIRT.getDefaultState())
                    .put(Blocks.RED_SAND, Blocks.DIRT.getDefaultState())
                    .put(BlockRegistry.BLUE_SAND.get(), Blocks.DIRT.getDefaultState())
                    .build()
    );

    public QianyunHoe(){
        super(ItemTier.IRON, 1, -1.0f, new Properties().group(ModGroup.itemgroup).defaultMaxDamage(861));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.qianyun_hoe")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.QIANYUN);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity playerentity = context.getPlayer();

        boolean shouldCauseDamage = false;

        ArrayList<BlockPos> posList = new ArrayList<>();
        posList.add(pos);
        posList.add(pos.add(1, 0, 0));
        posList.add(pos.add(-1, 0, 0));
        posList.add(pos.add(0, 0, 1));
        posList.add(pos.add(0, 0, -1));
        posList.add(pos.add(1, 0, 1));
        posList.add(pos.add(1, 0, -1));
        posList.add(pos.add(-1, 0, 1));
        posList.add(pos.add(-1, 0, -1));

        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;

        for(BlockPos blockPos : posList) {
            if (context.getFace() != Direction.DOWN && world.isAirBlock(blockPos.up())) {
                BlockState blockstate = getQianyunHoeTillingState(world.getBlockState(blockPos));
                if (blockstate != null) {

                    world.playSound(playerentity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (!world.isRemote) {
                        world.setBlockState(blockPos, blockstate, 11);
                        shouldCauseDamage = true;
                    }
                }
            }
        }

        if(shouldCauseDamage){
            if (playerentity != null) {
                context.getItem().damageItem(1, playerentity, (player) -> {
                    player.sendBreakAnimation(context.getHand());
                });
            }
        }

        return ActionResultType.func_233537_a_(world.isRemote);
    }

    @Nullable
    public BlockState getQianyunHoeTillingState(BlockState originalState) {
        return QIANYUN_HOE_LOOKUP.get(originalState.getBlock());
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.NETHERITE_SCRAP;
    }
}
