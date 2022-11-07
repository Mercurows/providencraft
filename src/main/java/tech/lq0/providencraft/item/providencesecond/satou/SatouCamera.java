package tech.lq0.providencraft.item.providencesecond.satou;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.SoundRegistry;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
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

            List<LivingEntity> target = new ArrayList<>();
            Vector3d start = playerIn.getPositionVec().add(0, playerIn.getEyeHeight(), 0);

            EntityRayTraceResult result;

            //最远距离5m
            float distance = 5;

            float yaw = playerIn.rotationYaw;
            float pitch = playerIn.rotationPitch < -30 ? -30 : playerIn.rotationPitch > 30 ? 30 : playerIn.rotationPitch;

            //生成闪光粒子效果
            ServerWorld world = (ServerWorld) worldIn;
            world.spawnParticle(ParticleTypes.FLASH, playerIn.getPosX() + playerIn.getLookVec().x, playerIn.getPosY() + playerIn.getEyeHeight() + playerIn.getLookVec().y, playerIn.getPosZ() + playerIn.getLookVec().z, 1, 0, 0, 0, 0);

            //水平±60°
            for (int i = 0; i < 24; i++) {
                //垂直±30°
                for (int j = 0; j < 12; j++) {

                    float finalYaw = (yaw + 5 * (i - 11.5F)) / 180F * 3.14159F;
                    float finalPitch = (pitch + 5 * (j - 5.5F)) / 180F * 3.14159F;

                    Vector3d end = start.add(-distance * MathHelper.sin(finalYaw) * MathHelper.cos(finalPitch), -distance * MathHelper.sin(finalPitch), distance * MathHelper.cos(finalYaw) * MathHelper.cos(finalPitch));

                    do {
                        result = ProjectileHelper.rayTraceEntities(worldIn, playerIn, start, end, playerIn.getBoundingBox().grow(distance, distance, distance), (e) -> (!target.contains(e)) && e != playerIn && !playerIn.isOnSameTeam(e) && e instanceof LivingEntity && !(e instanceof ArmorStandEntity));
                        if (result != null) {
                            target.add((LivingEntity) result.getEntity());
                        }
                    } while (result != null);
                }
            }
            for (LivingEntity livingentity : target) {
                livingentity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200, 0));
                livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 4));

                livingentity.hurtResistantTime = 0;
                livingentity.attackEntityFrom(DamageSource.causePlayerDamage(playerIn), 0);
            }

            playerIn.playSound(SoundRegistry.SHUTTER.get(), SoundCategory.AMBIENT, 0.7f, 1f);
            stack.damageItem(1, playerIn, (player1 -> player1.sendBreakAnimation(handIn)));

            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 100);
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }
        return new ActionResult<>(ActionResultType.FAIL, stack);
    }
}
