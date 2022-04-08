package tech.lq0.providencraft.item.providencemagicros.haine;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.SoundRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class HaiPlate extends ShieldItem {
    public HaiPlate() {
        super(new Properties().maxDamage(401).group(ModGroup.itemgroup));
        DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        playerIn.setActiveHand(handIn);
        if (playerIn.isSneaking() && itemstack.getDamage() < itemstack.getMaxDamage() - 80) {
            playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 10));
            itemstack.damageItem(80, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
            playerIn.getCooldownTracker().setCooldown(itemstack.getItem(), 220);
            worldIn.playSound(playerIn, playerIn.getPosition(),
                    SoundRegistry.HAIPLATE.get(), SoundCategory.AMBIENT, 0.5f, 1f);
        }

        return ActionResult.resultConsume(itemstack);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("hai_plate_func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("hai_plate_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("hai_plate_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
    }


}
