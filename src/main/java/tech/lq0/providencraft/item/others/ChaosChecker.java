package tech.lq0.providencraft.item.others;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;

public class ChaosChecker extends Item {
    public ChaosChecker(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            int chaos = ChaosHelper.getChaos(playerIn);
            playerIn.sendStatusMessage(new StringTextComponent("混沌值为" + chaos), true);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
