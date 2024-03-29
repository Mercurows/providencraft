package tech.lq0.providencraft.item.providenceOI.ccelia;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
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
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CraftBeer0322 extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.5f).hunger(5).setAlwaysEdible().
            effect(() -> new EffectInstance(Effects.NAUSEA, 300, 0), 0.1f).
            effect(() -> new EffectInstance(Effects.HASTE, 200, 1), 1.0f).
            effect(() -> new EffectInstance(Effects.REGENERATION, 100, 1), 1.0f).build();

    public CraftBeer0322(){
        super(new Properties().group(ModGroup.itemgroup).food(food).isImmuneToFire().maxStackSize(1));
    }

    @Override
    @Nonnull
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.craft_beer_0322_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.craft_beer_0322_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addChaosInfo(tooltip, 10);
        TooltipTool.addLiverInfo(tooltip, Livers.CCELIA);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote && entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;
            ChaosHelper.addChaos(player, 10);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
