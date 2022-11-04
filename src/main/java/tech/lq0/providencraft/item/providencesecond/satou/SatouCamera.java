package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class SatouCamera extends Item {
    public SatouCamera() {
        super(new Properties().group(ModGroup.itemgroup).maxStackSize(1).maxDamage(148));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("satou_camera_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("satou_camera_des2")).mergeStyle(TextFormatting.GRAY));
        TooltipTool.addLiverInfo(tooltip, Livers.SATOU);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {

            // TODO 修改相机判定范围
            Vector3d v_player = Vector3d.fromPitchYaw(playerIn.getPitchYaw()).
                    mul(4.0, 0.0, 4.0).add(5.0, 5.0, 5.0).mul(4.0, 2.0, 4.0);

            for (LivingEntity livingentity : playerIn.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class,
                    playerIn.getBoundingBox().grow(5.0f, 5.0f, 5.0f).expand(v_player))) {
                if (livingentity != playerIn && !playerIn.isOnSameTeam(livingentity)) {
                    if (!(livingentity instanceof ArmorStandEntity)) {
                        livingentity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200, 0));
                        livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 4));
                    }
                }
            }

            playerIn.playSound(SoundRegistry.SHUTTER.get(), SoundCategory.AMBIENT, 0.7f, 1f);
            stack.damageItem(1, playerIn, (player1 -> player1.sendBreakAnimation(handIn)));

            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 100);
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }
        return new ActionResult<>(ActionResultType.FAIL, stack);
    }
}
