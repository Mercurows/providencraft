package tech.lq0.providencraft.item.providencesecond.lucia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        super(new Properties().food(food).maxStackSize(1).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            int random = (int) (Math.random() * 99 + 1);
            if (random > 10) {
                player.addPotionEffect(new EffectInstance(EffectRegistry.BIG_FIERCE_ONE.get(), 3600, 2));
                player.sendStatusMessage(new TranslationTextComponent("big_moe_one_potion_fierce").mergeStyle(TextFormatting.GOLD), true);
            } else {
                player.addPotionEffect(new EffectInstance(EffectRegistry.BIG_MOE_ONE.get(), 3600, 0));
                player.sendStatusMessage(new TranslationTextComponent("big_moe_one_potion_moe").mergeStyle(TextFormatting.LIGHT_PURPLE), true);
            }

            if (player.isCreative()) {
                return itemStack;
            } else {
                return Items.GLASS_BOTTLE.getDefaultInstance();
            }
        }
        return itemStack;
    }

    @Override
    @Nonnull
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("big_moe_one_potion_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("big_moe_one_potion_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("big_moe_one_potion_warn")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        TooltipTool.addLiverInfo(tooltip, Livers.LUCIA);
    }
}
