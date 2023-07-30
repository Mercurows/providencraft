package tech.lq0.providencraft.item.providenceOI.yesa;

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
import tech.lq0.providencraft.capability.ChaosHelper;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MintChocolate extends Item {
    private static final Food food = (new Food.Builder()).saturation(0.8f).hunger(4).setAlwaysEdible().
            effect(() -> new EffectInstance(Effects.NIGHT_VISION, 1200, 0), 1.0f).
            effect(() -> new EffectInstance(Effects.GLOWING, 100, 0), 1.0f).build();

    public MintChocolate(){
        super(new Properties().group(ModGroup.itemgroup).food(food));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.mint_chocolate_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.mint_chocolate_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addChaosInfo(tooltip, -5);
        TooltipTool.addLiverInfo(tooltip, Livers.YESA);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(!worldIn.isRemote && entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;
            ChaosHelper.addChaos(player, -5);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
