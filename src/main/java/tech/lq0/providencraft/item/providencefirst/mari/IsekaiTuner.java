package tech.lq0.providencraft.item.providencefirst.mari;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.block.tile.MagicMirrorTileEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.BlockRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class IsekaiTuner extends Item {
    public static final String TAG = "isekaiBind";
    public static final String TAG_BIND_X = "x";
    public static final String TAG_BIND_Y = "y";
    public static final String TAG_BIND_Z = "z";
    public static final String TAG_BIND = "bind";
    public static final String TAG_DIMENSION = "dimension";

    public IsekaiTuner() {
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner_1").mergeStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner_2").mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        displayPosInfo(stack, tooltip);

        TooltipTool.addLiverInfo(tooltip, Livers.MARI);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        PlayerEntity playerentity = context.getPlayer();
        ItemStack stack = context.getItem();

        BlockState state = world.getBlockState(pos);

        if(!world.isRemote && state.getBlock() == BlockRegistry.MAGIC_MIRROR_BLOCK.get() && playerentity != null){
            //绑定坐标和维度
            if(playerentity.isSneaking()) {
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_X, pos.getX());
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_Y, pos.getY());
                stack.getOrCreateChildTag(TAG).putInt(TAG_BIND_Z, pos.getZ());
                stack.getOrCreateChildTag(TAG).putBoolean(TAG_BIND, true);
                stack.getOrCreateChildTag(TAG).putString(TAG_DIMENSION, world.getDimensionKey().getLocation().toString());

                return ActionResultType.SUCCESS;
            }else {
                //解析坐标和维度
                int x = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_X);
                int y = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Y);
                int z = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Z);
                String key = stack.getOrCreateChildTag(TAG).getString(TAG_DIMENSION);

                RegistryKey<World> registryKey = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(key));
                ServerWorld world1 = world.getServer().getWorld(registryKey);

                if (!stack.getOrCreateChildTag(TAG).getBoolean(TAG_BIND)) {
                    playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.fail.null")
                            .mergeStyle(TextFormatting.WHITE), true);

                    return ActionResultType.FAIL;
                }

                BlockPos prevPos = new BlockPos(x, y, z);
                if (prevPos.equals(pos)) {
                    playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.fail.same"), true);
                    return ActionResultType.FAIL;
                }

                if(world == world1) {
                    MagicMirrorTileEntity tileEntity = (MagicMirrorTileEntity) world.getTileEntity(prevPos);
                    if (tileEntity != null) {
                        tileEntity.setTeleportPos(pos, key);
                        tileEntity.setBind(true);

                        playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.success",
                                pos.getX(), pos.getY(), pos.getZ()), true);
                        stack.getOrCreateChildTag(TAG).putBoolean(TAG_BIND, false);
                    }
                }else {
                    MagicMirrorTileEntity tileEntity = (MagicMirrorTileEntity) world1.getTileEntity(prevPos);
                    if(tileEntity != null){
                        tileEntity.setTeleportPos(pos, world.getDimensionKey().getLocation().toString());
                        tileEntity.setBind(true);

                        playerentity.sendStatusMessage(new TranslationTextComponent("des.providencraft.isekai_tuner.success",
                                pos.getX(), pos.getY(), pos.getZ()), true);
                        stack.getOrCreateChildTag(TAG).putBoolean(TAG_BIND, false);
                    }

                    System.out.println(1145);
                }
            }
        }

        return super.onItemUse(context);
    }

    private static void displayPosInfo(ItemStack stack, List<ITextComponent> tooltip){
        int x = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_X);
        int y = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Y);
        int z = stack.getOrCreateChildTag(TAG).getInt(TAG_BIND_Z);
        boolean flag = stack.getOrCreateChildTag(TAG).getBoolean(TAG_BIND);
        String dimension = stack.getOrCreateChildTag(TAG).getString(TAG_DIMENSION);
        if(flag) {
            tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner.bind.true").mergeStyle(TextFormatting.GREEN));
            tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner.bind", x, y, z).mergeStyle(TextFormatting.WHITE));
            tooltip.add(new StringTextComponent("dimension:" + dimension));
        }else {
            tooltip.add(new TranslationTextComponent("des.providencraft.isekai_tuner.bind.false").mergeStyle(TextFormatting.RED));
        }

    }
}
