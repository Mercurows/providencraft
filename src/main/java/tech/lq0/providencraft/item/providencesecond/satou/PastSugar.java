package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class PastSugar extends Item {
    private static final Food food = new Food.Builder().setAlwaysEdible().hunger(2).saturation(0.5f).build();

    public PastSugar(){
        super(new Properties().rarity(Rarity.EPIC).group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.past_sugar")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (!worldIn.isRemote) {
            double d0 = entityLiving.getPosX();
            double d1 = entityLiving.getPosY();
            double d2 = entityLiving.getPosZ();

            for(int i = 0; i < 16; ++i) {
                double d3 = entityLiving.getPosX() + (entityLiving.getRNG().nextDouble() - 0.5D) * 16.0D;
                double d4 = MathHelper.clamp(entityLiving.getPosY() + (double)(entityLiving.getRNG().nextInt(16) - 8), 0.0D, worldIn.func_234938_ad_() - 1);
                double d5 = entityLiving.getPosZ() + (entityLiving.getRNG().nextDouble() - 0.5D) * 16.0D;
                if (entityLiving.isPassenger()) {
                    entityLiving.stopRiding();
                }

                net.minecraftforge.event.entity.living.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(entityLiving, d3, d4, d5);
                if (event.isCanceled()) {
                    return itemstack;
                }
                if (entityLiving.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                    SoundEvent soundevent = entityLiving instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    worldIn.playSound(null, d0, d1, d2, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    entityLiving.playSound(soundevent, 1.0F, 1.0F);
                    break;
                }
            }

            if (entityLiving instanceof PlayerEntity) {
                ((PlayerEntity)entityLiving).getCooldownTracker().setCooldown(this, 60);
            }
        }

        return itemstack;
    }
}
