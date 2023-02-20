package tech.lq0.providencraft.item.providencemagicros.hoshimiya;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
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

public class BubbleTea extends Item {
    public static final Food food = (new Food.Builder()).saturation(0.4f).hunger(8).setAlwaysEdible().build();

    public BubbleTea(){
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 400, 0));

            double random = Math.random();
            if (random <= .2) {
                player.addPotionEffect(new EffectInstance(Effects.HASTE, 200, 2));
                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200, 1));
                player.sendStatusMessage(new TranslationTextComponent("bubble_tea_message").mergeStyle(TextFormatting.LIGHT_PURPLE), true);
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("bubble_tea_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.EKIRA);
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
}
