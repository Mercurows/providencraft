package tech.lq0.providencraft.item.providencefirst.mari;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.DamageSourceRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MariStew extends Item {
    private static final Food food = (new Food.Builder()).saturation(12.0f).hunger(10).build();

    public MariStew() {
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
            if (random > 95) {
                player.attackEntityFrom(DamageSourceRegistry.MARI_FOOD, 20.0f);
            } else if (random > 90) {
                player.heal(20.0f);
                player.sendStatusMessage(new TranslationTextComponent("mari_stew_heal").mergeStyle(TextFormatting.GOLD), false);
            } else if (random > 70) {
                player.addPotionEffect(new EffectInstance(Effects.POISON, 200, 1));
            } else if (random > 40) {
                player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 400, 1));
            } else {
                player.sendStatusMessage(new TranslationTextComponent("mari_stew_nothing").mergeStyle(TextFormatting.GRAY), false);
            }

            if (player.isCreative()) {
                return itemStack;
            } else {
                return Items.BOWL.getDefaultInstance();
            }
        }
        return itemStack;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("mari_stew_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("mari_stew_warn")).mergeStyle(TextFormatting.RED));
    }
}
