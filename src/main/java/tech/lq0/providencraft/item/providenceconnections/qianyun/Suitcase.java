package tech.lq0.providencraft.item.providenceconnections.qianyun;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class Suitcase extends Item {
    public Suitcase(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.suitcase")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.QIANYUN);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        EnderChestInventory enderchestinventory = playerIn.getInventoryEnderChest();
        //此处!=null判定不能删
        if (!worldIn.isRemote && enderchestinventory != null) {
            NetworkHooks.openGui((ServerPlayerEntity) playerIn,
                    new SimpleNamedContainerProvider((p_226928_1_, p_226928_2_, p_226928_3_)
                            -> ChestContainer.createGeneric9X3(p_226928_1_, p_226928_2_, enderchestinventory), stack.getDisplayName()), playerIn.getPosition());
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
