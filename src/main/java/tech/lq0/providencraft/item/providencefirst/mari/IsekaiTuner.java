package tech.lq0.providencraft.item.providencefirst.mari;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.block.tile.MagicMirrorTileEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class IsekaiTuner extends Item {
    private static final String TAG = "isekaiBind";
    private static final String TAG_BIND_X = "x";
    private static final String TAG_BIND_Y = "y";
    private static final String TAG_BIND_Z = "z";
    private static final String TAG_BIND = "bind";

    public IsekaiTuner() {
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner_2").mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity playerentity = context.getPlayer();
        ItemStack stack = context.getItem();

        BlockState state = world.getBlockState(pos);
        if(state.getBlock() == BlockRegistry.MAGIC_MIRROR_BLOCK.get() && playerentity != null){
            if(playerentity.isSneaking()){
                MagicMirrorTileEntity tileEntity = (MagicMirrorTileEntity) world.getTileEntity(pos);
                if(tileEntity != null){
                    if(!stack.getOrCreateChildTag(TAG).getBoolean(TAG_BIND)){
                        playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.warn")
                                .mergeStyle(TextFormatting.WHITE), true);

                        return ActionResultType.FAIL;
                    }


                    BlockPos bindPos = new BlockPos(stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_X),
                            stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Y), stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Z));

                    tileEntity.setTeleportPos(bindPos);
                }
            }else {
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_X, pos.getX());
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_Y, pos.getY());
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_Z, pos.getZ());
                stack.getOrCreateChildTag(TAG).putBoolean(TAG_BIND, true);
            }
        }

        return super.onItemUse(context);
    }
}
