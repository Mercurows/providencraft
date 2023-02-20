package tech.lq0.providencraft.item.others;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MMAStew extends Item {
    //MMA means Madoka Mumu Asui

    private static final Food food = (new Food.Builder()).saturation(0.4f).hunger(12).
            effect(() -> new EffectInstance(Effects.STRENGTH, 3600, 1), 1.0f).build();

    public MMAStew() {
        super(new Properties().food(food).maxStackSize(1).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("mma_stew_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("mma_stew_des2")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if(entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (player.isCreative()) {
                return itemStack;
            } else {
                return Items.BOWL.getDefaultInstance();
            }
        }
        return itemStack;
    }
}
