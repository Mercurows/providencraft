package tech.lq0.providencraft.item.others;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import tech.lq0.providencraft.capability.IChaosCapability;
import tech.lq0.providencraft.capability.ModCapability;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.AttributeRegistry;

public class ChaosChecker extends Item {
    public ChaosChecker(){
        super(new Properties().group(ModGroup.itemgroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            LazyOptional<IChaosCapability> chaosCap = playerIn.getCapability(ModCapability.CHAOS_CAPABILITY);
            chaosCap.ifPresent((l) -> {
                        int chaos = (int) (l.getChaos() + (int) playerIn.getAttributeValue(AttributeRegistry.CHAOS.get()));
                        playerIn.sendStatusMessage(new StringTextComponent("混沌值为" + chaos), true);
                    }
            );
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
