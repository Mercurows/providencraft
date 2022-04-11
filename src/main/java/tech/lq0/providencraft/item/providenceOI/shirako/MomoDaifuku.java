package tech.lq0.providencraft.item.providenceOI.shirako;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MomoDaifuku extends Item {
    private static final Food food = (new Food.Builder()).saturation(5).hunger(6).build();

    public MomoDaifuku() {
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("momo_daifuku_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("momo_daifuku_des2")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("momo_daifuku_warn")).mergeStyle(TextFormatting.RED));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 40, 0));
            int random = (int) (Math.random() * 99 + 1);
            if (random > 90) {
                player.setFire(10);
                player.sendStatusMessage(new TranslationTextComponent("momo_daifuku_fire").mergeStyle(TextFormatting.RED), false);
            }

        }
        return itemStack;
    }
}
