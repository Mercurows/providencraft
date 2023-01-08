package tech.lq0.providencraft.item.providencefirst.madoka;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.group.ModGroup;
import tech.lq0.providencraft.init.ItemRegistry;
import tech.lq0.providencraft.tiers.ModItemTier;
import tech.lq0.providencraft.tools.Livers;
import tech.lq0.providencraft.tools.TooltipTool;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RedAhogeMachete extends SwordItem {
    public RedAhogeMachete() {
        super(ModItemTier.RED_AHOGE, 7, -2.8f, new Properties().maxDamage(851).group(ModGroup.itemgroup));
    }

    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("red_ahoge_machete_des1")).mergeStyle(TextFormatting.GRAY));
        tooltip.add((new TranslationTextComponent("red_ahoge_machete_des2")).mergeStyle(TextFormatting.GRAY).mergeStyle(TextFormatting.STRIKETHROUGH));
        tooltip.add((new TranslationTextComponent("red_ahoge_machete_func")).mergeStyle(TextFormatting.AQUA));
        TooltipTool.addLiverInfo(tooltip, Livers.MADOKA);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.getCooldownTracker().setCooldown(stack.getItem(), 60);
        if (!playerIn.isOnGround()) {
            if (!playerIn.abilities.isFlying) {
                playerIn.addVelocity(0.0f, -8.0f, 0.0f);
            } else {
                doDamage(playerIn, 0);
            }
        } else {
            doDamage(playerIn, 0);
        }
        stack.damageItem(10, playerIn, (player1 -> player1.sendBreakAnimation(player1.getActiveHand())));
        return ActionResult.resultSuccess(stack);
    }

    @SubscribeEvent
    public static void onFlyablePlayerFall(PlayerFlyableFallEvent event) {
        doDamage(event.getPlayer(), event.getDistance());
    }

    @SubscribeEvent
    public static void onPlayerFall(LivingFallEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity playerIn = (PlayerEntity) event.getEntity();
            doDamage(playerIn, event.getDistance());
        }
    }

    private static void doDamage(PlayerEntity playerIn, float distance) {
        if (playerIn.getCooldownTracker().getCooldown(ItemRegistry.RED_AHOGE_MACHETE.get(), 0) > 0) {
            int posX = playerIn.getPosition().getX();
            int posY = playerIn.getPosition().getY();
            int posZ = playerIn.getPosition().getZ();

            Vector3d look = playerIn.getLookVec();
            Vector3d start = playerIn.getPositionVec();


            double xySquareSum = Math.sqrt(look.z * look.z + look.x * look.x);
            double ratio = 1.0 / xySquareSum;

            Vector3d end = playerIn.getPositionVec().add(look.x * 5 * ratio, 0, look.z * 5 * ratio);

            EntityRayTraceResult result;

            List<LivingEntity> target = new ArrayList<>();

            float length = .8f;
            for (int i = -2; i <= 2; i++) {
                do {
                    result = ProjectileHelper.rayTraceEntities(playerIn.getEntityWorld(), playerIn, start, end.add(look.z * length * i, 0, look.x * length * (-i)),
                            new AxisAlignedBB(posX, posY, posZ, posX, posY + 1.0, posZ).grow(5, 2, 5), (e) -> (!target.contains(e)) && e != playerIn && !playerIn.isOnSameTeam(e) && e instanceof LivingEntity && !(e instanceof ArmorStandEntity))
                    ;
                    if (result != null) {
                        target.add((LivingEntity) result.getEntity());
                    }
                } while (result != null);
            }

            target.forEach(e -> {
                e.applyKnockback(1.0F, MathHelper.sin(playerIn.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(playerIn.rotationYaw * ((float) Math.PI / 180F)));
                e.attackEntityFrom(DamageSource.causePlayerDamage(playerIn), distance * 0.5f + 10);
            });
        }
    }
}
