package tech.lq0.providencraft.item.providenceOI.shirayuki;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
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

public class FoxFairyFan extends Item {
    public FoxFairyFan(){
        super(new Properties().maxDamage(186).group(ModGroup.itemgroup));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote){
            // TODO 修改扇子判定范围和威力
            for (LivingEntity livingentity : playerIn.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, playerIn.getBoundingBox().grow(3.5f, 3.5f, 3.5f))) {
                if (livingentity != playerIn && !playerIn.isOnSameTeam(livingentity) && playerIn.getDistanceSq(livingentity) < 16.0D) {
                    if(!(livingentity instanceof ArmorStandEntity)) {
                        livingentity.applyKnockback(6.0F, playerIn.getPosX() - livingentity.getPosX(), playerIn.getPosZ() - livingentity.getPosZ());
                    }
                }
            }
            playerIn.getCooldownTracker().setCooldown(itemStack.getItem(), 20);
            itemStack.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
            return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("fox_fairy_fan_des")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.AOI);
    }
}
