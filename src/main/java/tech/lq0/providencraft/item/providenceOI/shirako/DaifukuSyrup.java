package tech.lq0.providencraft.item.providenceOI.shirako;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
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
import tech.lq0.providencraft.entity.DaifukuSyrupEntity;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DaifukuSyrup extends Item {
    public static final Food food = (new Food.Builder()).saturation(0.5f).hunger(1).fastToEat().setAlwaysEdible().build();

    public DaifukuSyrup() {
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 20, 0));
            int random = (int) (Math.random() * 99 + 1);
            if (random > 90) {
                player.setFire(2);
                player.sendStatusMessage(new TranslationTextComponent("momo_daifuku_fire").mergeStyle(TextFormatting.RED), true);
            }

        }
        return itemStack;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("daifuku_syrup_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("daifuku_syrup_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("daifuku_syrup_des3")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SHIRAKO);
    }

    public DaifukuSyrupEntity createArrow(World p_200887_1_, ItemStack p_200887_2_, LivingEntity p_200887_3_) {
        return new DaifukuSyrupEntity(p_200887_1_, p_200887_3_);
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
        return enchant > 0 && this.getClass() == DaifukuSyrup.class;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
}
