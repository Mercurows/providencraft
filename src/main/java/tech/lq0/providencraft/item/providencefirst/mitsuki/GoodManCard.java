package tech.lq0.providencraft.item.providencefirst.mitsuki;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import tech.lq0.providencraft.entity.GoodManCardEntity;
import tech.lq0.providencraft.group.ModGroup;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class GoodManCard extends Item {
    public GoodManCard(){
        super(new Properties().group(ModGroup.itemgroup).maxDamage(85));
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote()) {
            if (item.getDamage() < item.getMaxDamage() - 1) {
                int type = (int)(Math.random() * 5);

                GoodManCardEntity goodManCard = new GoodManCardEntity(worldIn, playerIn, type);

                System.out.println(type);
                System.out.println(goodManCard.getCardType());

                goodManCard.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0f, 4.0f, 0.2f);
                worldIn.addEntity(goodManCard);

                item.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }
}
