package tech.lq0.providencraft.item.providencesecond.louise;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MagicBookRevelation extends Item {
    public MagicBookRevelation(){
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(165).rarity(Rarity.RARE));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_revelation.func")).mergeStyle(TextFormatting.AQUA));
        tooltip.add((new TranslationTextComponent("des.providencraft.magic_book_revelation")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.LOUISE);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote){
            for (LivingEntity livingentity : playerIn.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, playerIn.getBoundingBox().grow(10.0D, 10.0D, 10.0D))) {
                if (livingentity != playerIn && !playerIn.isOnSameTeam(livingentity) && !(livingentity instanceof ArmorStandEntity) && playerIn.getDistanceSq(livingentity) <= 100.0D) {
                    if(livingentity.isPotionActive(EffectRegistry.CURSE_OF_SERPENT.get())){
                        int level = livingentity.getActivePotionEffect(EffectRegistry.CURSE_OF_SERPENT.get()).getAmplifier();
                        livingentity.addPotionEffect(new EffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 200, Math.min(level + 1, 4)));
                    }else {
                        livingentity.addPotionEffect(new EffectInstance(EffectRegistry.CURSE_OF_SERPENT.get(), 200, 0));
                    }
                }
            }
            playerIn.attackEntityFrom(DamageSource.MAGIC, 4.0f);
            stack.damageItem(1, playerIn, playerEntity -> playerEntity.sendBreakAnimation(handIn));
            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 60);
        }

        return ActionResult.resultSuccess(stack);
    }
}
