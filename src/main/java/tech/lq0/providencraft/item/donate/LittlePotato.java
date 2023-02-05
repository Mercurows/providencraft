package tech.lq0.providencraft.item.donate;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class LittlePotato extends Item {
    public static final Food food = (new Food.Builder()).saturation(1.0f).hunger(20).build();

    public LittlePotato() {
        super(new Properties().food(food).group(ModGroup.donategroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("little_potato_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote && entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            player.sendStatusMessage(new TranslationTextComponent("little_potato_eaten").mergeStyle(TextFormatting.WHITE), true);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 120;
    }
}
