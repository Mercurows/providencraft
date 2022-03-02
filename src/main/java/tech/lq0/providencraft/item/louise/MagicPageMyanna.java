package tech.lq0.providencraft.item.louise;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.world.World;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectInit;

public class MagicPageMyanna extends Item {
    public MagicPageMyanna() {
        super(new Properties().group(ModGroup.itemgroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getHeldItem(hand);

        if(!world.isRemote){
            player.addPotionEffect(new EffectInstance(EffectInit.BLESS_OF_DARK_ELF.get(),600,1));
            player.addPotionEffect(new EffectInstance(Effects.REGENERATION,600,1));
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH,600,1));
            player.getCooldownTracker().setCooldown(heldItem.getItem(),2400);
            world.playSound(null,player.getPosX(),player.getPosY(),player.getPosZ(),
                    SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.NEUTRAL,0.5f,0.4f);
        }

        return new ActionResult<>(ActionResultType.SUCCESS,heldItem);
    }


}
