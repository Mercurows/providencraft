package tech.lq0.providencraft.item.providencefourth.hifumi;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class NetherLight extends SwordItem {
    public NetherLight() {
        super(ItemTier.IRON, 1, -1.5f, new Properties().maxDamage(321).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.nether_light_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.nether_light_2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.HIFUMI);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.STRENGTH, 80, 1));
        target.addPotionEffect(new EffectInstance(Effects.HASTE, 80, 0));
        target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 80, 0));

        attacker.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 40, 0));
        attacker.addPotionEffect(new EffectInstance(Effects.GLOWING, 40, 0));

        double random = Math.random();
        if(random < 0.123){
            target.addPotionEffect(new EffectInstance(Effects.WITHER, 80, 0));
            attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 0));
        }

        return super.hitEntity(stack, target, attacker);
    }
}
