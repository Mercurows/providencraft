package tech.lq0.providencraft.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BigFierceOne extends Effect {
    public BigFierceOne() {
        super(EffectType.BENEFICIAL, 9871020);
    }

    @SubscribeEvent
    public static void effects(AttackEntityEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        Entity target = event.getTarget();
        if (livingEntity instanceof PlayerEntity && !livingEntity.world.isRemote && target instanceof LivingEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            if (player.isPotionActive(EffectRegistry.BIG_FIERCE_ONE.get())) {
                int level = Objects.requireNonNull(player.getActivePotionEffect(EffectRegistry.BIG_FIERCE_ONE.get())).getAmplifier();
                target.setFire(level * 5);
                if (target.isAlive()) {
                    LivingEntity entity = (LivingEntity) target;
                    entity.applyKnockback(level, player.getPosX() - entity.getPosX(), player.getPosZ() - entity.getPosZ());
                }
            }
        }
    }
}
