package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tiers.ModItemTier;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CrimsonImpact extends SwordItem {
    public CrimsonImpact() {
        super(ModItemTier.RED_AHOGE, 2, -1.2f, new Properties().maxDamage(429).group(ModGroup.itemgroup).rarity(Rarity.UNCOMMON));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.crimson_impact_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.crimson_impact_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double random = Math.random();
        if(random > .7f){
            target.addPotionEffect(new EffectInstance(EffectRegistry.BLEEDING.get(), 200, 1));
        }

        if(attacker instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) attacker;

            if(player.isSneaking()){
                Vector3d targetVec = target.getMotion().mul(1,0,1);
                Vector3d playerVec = player.getMotion().mul(1,0,1);
                Vector3d vec = targetVec.subtract(playerVec).normalize().scale(1.5).add(0,1.0,0);

                target.setMotion(vec);
            }
        }

        return super.hitEntity(stack, target, attacker);
    }
}
