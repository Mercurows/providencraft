package tech.lq0.providencraft.item.donate;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
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
import tech.lq0.providencraft.init.ItemRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class AtsuiShio extends Item {

    public static final Food food = (new Food.Builder()).saturation(0.5f).hunger(1).setAlwaysEdible().build();

    public AtsuiShio() {
        super(new Properties().food(food).maxStackSize(1).group(ModGroup.donategroup).isImmuneToFire());
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("atsuishio_des")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("donate_item_des")).mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (entityLiving instanceof PlayerEntity && !worldIn.isRemote) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (player.isCreative()) {
                return itemStack;
            } else {
                return ItemRegistry.EMPTY_JAR.get().getDefaultInstance();
            }
        }
        return itemStack;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
        return armorType == EquipmentSlotType.HEAD;
    }
}
