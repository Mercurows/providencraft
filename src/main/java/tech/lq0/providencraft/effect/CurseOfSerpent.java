package tech.lq0.providencraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CurseOfSerpent extends Effect {
    public CurseOfSerpent() {
        super(EffectType.HARMFUL, 7324312);
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Effect effect_curse = EffectRegistry.CURSE_OF_SERPENT.get();
        LivingEntity entity = event.getEntityLiving();

        if (!entity.world.isRemote) {
            if (entity.isPotionActive(effect_curse)) {
                int level = Objects.requireNonNull(entity.getActivePotionEffect(effect_curse)).getAmplifier();
                if (source.isExplosion()) {
                    event.setAmount(event.getAmount() * (1 + level));
                }
            }
        }
    }
}
