package tech.lq0.providencraft.item.madoka;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tiers.ModItemTier;

public class RedAhogeBoomerang extends SwordItem {
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote()){
            if(item.getDamage()<item.getMaxDamage() - 5) {
                SnowballEntity snowball = new SnowballEntity(worldIn, playerIn);
                snowball.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 1.5f, 1.0f);
                worldIn.addEntity(snowball);
                item.setDamage(item.getDamage() + 5);
                playerIn.getCooldownTracker().setCooldown(item.getItem(), 40);
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS,item);
    }

    public RedAhogeBoomerang() {
        super(ModItemTier.RED_AHOGE, 3, -2, new Item.Properties().group(ModGroup.itemgroup));


    }
}
