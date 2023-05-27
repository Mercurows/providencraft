package tech.lq0.providencraft.item.providenceOI.sorayo;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;

public class LunarEclipse extends SwordItem {
    public LunarEclipse(){
        super(ItemTier.NETHERITE, 2, -2.3f, new Properties().group(ModGroup.itemgroup).rarity(Rarity.EPIC).maxDamage(928));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.lunar_eclipse")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SORAYO);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!(target instanceof ArmorStandEntity) && attacker instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) attacker;

            if(player.isPotionActive(EffectRegistry.ECLIPSE_NIGHT.get())){
                int level = Objects.requireNonNull(player.getActivePotionEffect(EffectRegistry.ECLIPSE_NIGHT.get())).getAmplifier();
                target.hurtResistantTime = 0;

                float damage = target.getHealth() * 0.05f * (level + 1) + 2.0f;
                target.attackEntityFrom(DamageSourceRegistry.LUNAR_ECLIPSE, damage);
            }

            if(!target.isAlive()){
                if(!player.isPotionActive(EffectRegistry.ECLIPSE_NIGHT.get())){
                    player.addPotionEffect(new EffectInstance(EffectRegistry.ECLIPSE_NIGHT.get(), 200, 0));
                }else {
                    int level = Objects.requireNonNull(player.getActivePotionEffect(EffectRegistry.ECLIPSE_NIGHT.get())).getAmplifier();
                    player.addPotionEffect(new EffectInstance(EffectRegistry.ECLIPSE_NIGHT.get(), 200, Math.min(level + 1, 4)));
                }
            }

        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && stack.getDamage() < stack.getMaxDamage() && entityIn instanceof PlayerEntity) {
            if(worldIn.isNightTime()) {
                PlayerEntity player = (PlayerEntity) entityIn;
                if (player.ticksExisted % 20 == 0) {
                    stack.damageItem(-1, player, (playerEntity) -> playerEntity.sendBreakAnimation(player.getActiveHand()));
                }
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
