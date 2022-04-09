package tech.lq0.providencraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CommunicationTable extends Block {
    public CommunicationTable() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(2));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            int random = (int) (Math.random() * 6 + 1);
            switch (random) {
                case 1:
                    player.sendStatusMessage(new TranslationTextComponent("ct_message_1"), false);
                    break;
                case 2:
                    player.sendStatusMessage(new TranslationTextComponent("ct_message_2"), false);
                    break;
                case 3:
                    player.sendStatusMessage(new TranslationTextComponent("ct_message_3"), false);
                    break;
                case 4:
                    player.sendStatusMessage(new TranslationTextComponent("ct_message_4"), false);
                    break;
                case 5:
                    player.sendStatusMessage(new TranslationTextComponent("ct_message_5"), false);
                    break;
                default:
                    player.sendStatusMessage(new TranslationTextComponent("ct_message_default"), false);
                    break;
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("communication_table_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("communication_table_des2")).mergeStyle(TextFormatting.GRAY));
    }
}
