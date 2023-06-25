package tech.lq0.providencraft.item.providenceOI.rino;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
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
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class ClarityAmulet extends Item {
    public ClarityAmulet() {
        super(new Properties().group(ModGroup.itemgroup).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.clarity_amulet")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.RINO);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote){
            if(entityIn instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) entityIn;
                int chaos = ChaosHelper.getChaos(player);

                if(chaos <= -70){
                    player.addPotionEffect(new EffectInstance(Effects.LUCK, 100, 0, false, false));
                    player.addPotionEffect(new EffectInstance(EffectRegistry.HOLINESS.get(), 100, 2, false, false));
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 0, false, false));
                }else if(chaos <= -30){
                    player.addPotionEffect(new EffectInstance(Effects.LUCK, 100, 0, false, false));
                    player.addPotionEffect(new EffectInstance(EffectRegistry.HOLINESS.get(), 100, 1, false, false));
                }else if(chaos < 0){
                    player.addPotionEffect(new EffectInstance(EffectRegistry.HOLINESS.get(), 100, 0, false, false));
                }else if(chaos >= 80){
                    player.addPotionEffect(new EffectInstance(Effects.HASTE, 100, 0, false, false));
                    player.addPotionEffect(new EffectInstance(Effects.UNLUCK, 100, 0, false, false));
                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 300, 0, false, false));
                }
            }
        }
    }
}
