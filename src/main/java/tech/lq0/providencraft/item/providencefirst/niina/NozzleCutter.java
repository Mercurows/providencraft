package tech.lq0.providencraft.item.providencefirst.niina;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IForgeShearable;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Random;

public class NozzleCutter extends ShearsItem {
    public NozzleCutter(){
        super(new Properties().group(ModGroup.itemgroup).defaultMaxDamage(170));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("des.providencraft.nozzle_cutter_1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("des.providencraft.nozzle_cutter_2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.ITALIC));
        TooltipTool.addLiverInfo(tooltip, Livers.NIINA);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity entity, Hand hand) {
        if (entity.world.isRemote) {
            return ActionResultType.PASS;
        }

        if (entity instanceof IForgeShearable) {
            IForgeShearable target = (IForgeShearable)entity;
            BlockPos pos = new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ());
            if (target.isShearable(stack, entity.world, pos)) {
                double random = Math.random();

                List<ItemStack> drops = target.onSheared(playerIn, stack, entity.world, pos,
                        EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack));

                if(random <= 0.35){
                    entity.attackEntityFrom(DamageSource.causePlayerDamage(playerIn), 4.0f);
                    Random rand = new Random();

                    ItemEntity ent = entity.entityDropItem(Items.MUTTON.getDefaultInstance(), 1.0F);
                    if(ent != null) {
                        ent.setMotion(ent.getMotion().add((rand.nextFloat() - rand.nextFloat()) * 0.1F, rand.nextFloat() * 0.05F, (rand.nextFloat() - rand.nextFloat()) * 0.1F));
                    }

                }else {
                    Random rand = new Random();
                    drops.forEach(d -> {
                        ItemEntity ent = entity.entityDropItem(d, 1.0F);
                        ItemEntity ent2 = entity.entityDropItem(d, 1.0F);
                        if(ent != null) {
                            ent.setMotion(ent.getMotion().add((rand.nextFloat() - rand.nextFloat()) * 0.1F, rand.nextFloat() * 0.05F, (rand.nextFloat() - rand.nextFloat()) * 0.1F));
                        }
                        if(ent2 != null) {
                            ent2.setMotion(ent2.getMotion().add((rand.nextFloat() - rand.nextFloat()) * 0.1F, rand.nextFloat() * 0.05F, (rand.nextFloat() - rand.nextFloat()) * 0.1F));
                        }
                    });
                }
                stack.damageItem(1, entity, e -> e.sendBreakAnimation(hand));
            }
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
