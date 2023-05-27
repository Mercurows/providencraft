package tech.lq0.providencraft.item.providencesecond.lucia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BigMoeOnePotion extends Item {
    private static final Food food = (new Food.Builder()).saturation(0).hunger(0).setAlwaysEdible().build();

    public BigMoeOnePotion() {
        super(new Properties().food(food).maxStackSize(16).group(ModGroup.itemgroup).containerItem(Items.GLASS_BOTTLE));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            int random = (int) (Math.random() * 99 + 1);
            if (random > 10) {
                player.addPotionEffect(new EffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 3600, 2));
                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.big_moe_one_potion.fierce").mergeStyle(TextFormatting.GOLD), true);
            } else {
                player.addPotionEffect(new EffectInstance(EffectRegistry.BIG_MOE_ONE.get(), 3600, 0));
                player.sendStatusMessage(new TranslationTextComponent("des.providencraft.big_moe_one_potion.moe").mergeStyle(TextFormatting.LIGHT_PURPLE), true);
            }

            if (!player.abilities.isCreativeMode) {
                stack.shrink(1);

                if (stack.isEmpty()) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                }

                player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }
        return stack;
    }

    @Override
    @Nonnull
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.big_moe_one_potion_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.big_moe_one_potion_2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.big_moe_one_potion.warn")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.LUCIA);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
