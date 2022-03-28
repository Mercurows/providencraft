package tech.lq0.providencraft.item.providencemagicros.chiram;

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

public class LotusPotato extends Item {
    private static final Food food = (new Food.Builder()).saturation(8.0f).hunger(6).build();

    public LotusPotato() {
        super(new Properties().food(food).group(ModGroup.itemgroup));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (player.getHealth() <= player.getMaxHealth() - 6) {
                player.heal(4.0f);
            } else {
                float finalHealth = 6.0f - (player.getHealth() + 4.0f) % player.getMaxHealth();
                player.setHealth(finalHealth < 2 ? 2 : finalHealth);
            }
            if (!player.isAlive()) {
                player.sendStatusMessage(new TranslationTextComponent("death.lotus_potato", entityLiving.getDisplayName()), false);
            }
        }
        return itemStack;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("lotus_potato_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("lotus_potato_warn")).mergeStyle(TextFormatting.RED));
    }

}
