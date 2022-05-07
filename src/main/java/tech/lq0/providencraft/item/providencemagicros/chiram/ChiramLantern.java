package tech.lq0.providencraft.item.providencemagicros.chiram;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class ChiramLantern extends Item {
    public ChiramLantern(){
        super(new Properties().maxStackSize(1).group(ModGroup.itemgroup).isImmuneToFire());
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("chiram_lantern_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("chiram_lantern_des2")).mergeStyle(TextFormatting.GRAY));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setFire(5);
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity && isSelected){
            PlayerEntity player = (PlayerEntity) entityIn;
            if(worldIn.getLight(player.getPosition()) <= 5){
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 300, 0));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 1));
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 0));
                player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0));
            }
        }
    }
}
