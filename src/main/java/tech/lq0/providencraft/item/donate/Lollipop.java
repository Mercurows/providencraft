package tech.lq0.providencraft.item.donate;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

public class Lollipop extends Item {
    public static final Food food = (new Food.Builder()).saturation(1.5f).hunger(4).setAlwaysEdible().build();

    public Lollipop() {
        super(new Properties().food(food).isImmuneToFire().group(ModGroup.donategroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("lollipop_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lollipop_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lollipop_des3")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote && entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            int lvl = -1;
            if (player.isPotionActive(EffectRegistry.OVERLOAD.get())) {
                lvl = player.getActivePotionEffect(EffectRegistry.OVERLOAD.get()).getAmplifier();
            }

            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 340, 9));
            player.addPotionEffect(new EffectInstance(Effects.GLOWING, 340, 0));
            player.addPotionEffect(new EffectInstance(Effects.SPEED, 340, 4));
            player.addPotionEffect(new EffectInstance(Effects.HASTE, 340, 2));
            player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 340, 2));

            player.addPotionEffect(new EffectInstance(EffectRegistry.OVERLOAD.get(), 340, lvl + 1));
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

}
