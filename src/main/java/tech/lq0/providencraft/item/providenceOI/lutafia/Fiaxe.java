package tech.lq0.providencraft.item.providenceOI.lutafia;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class Fiaxe extends AxeItem {
    public Fiaxe() {
        super(ItemTier.IRON, 8.0f, -3.0f, new Properties().maxStackSize(1).maxDamage(601).group(ModGroup.itemgroup).setNoRepair());
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("fiaxe_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.LUTAFIA);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return (material == Material.WOOD || material == Material.NETHER_WOOD || material == Material.LEAVES || material == Material.ORGANIC) ? 40.0F : super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == ToolType.AXE) {
            return i >= blockIn.getHarvestLevel();
        }
        Material material = blockIn.getMaterial();
        return (material == Material.WOOD || material == Material.NETHER_WOOD || material == Material.LEAVES || material == Material.ORGANIC);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if((state.getMaterial() == Material.LEAVES || state.getMaterial() == Material.ORGANIC) && entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;
            double random = Math.random();
            stack.damageItem(random > .2 ? 0 : -1, player, (playerEntity) -> playerEntity.sendBreakAnimation(player.getActiveHand()));
            return true;
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
