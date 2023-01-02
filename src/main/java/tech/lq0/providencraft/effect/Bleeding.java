package tech.lq0.providencraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Bleeding extends Effect {
    public Bleeding(){
        super(EffectType.HARMFUL, 11815816);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.attackEntityFrom(DamageSourceRegistry.BLEEDING, 0.5f);
        entityLivingBaseIn.hurtResistantTime = 0;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int k = 40 - amplifier * 10;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

    @SubscribeEvent
    public static void effects(LivingAttackEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Effect effect = EffectRegistry.BLEEDING.get();
        if(event.getSource() != DamageSourceRegistry.BLEEDING) {
            if (entity.isPotionActive(effect)) {
                int level = entity.getActivePotionEffect(EffectRegistry.BLEEDING.get()).getAmplifier();
                entity.attackEntityFrom(DamageSourceRegistry.BLEEDING, level + 1.0f);
                entity.hurtResistantTime = 0;
            }
        }
    }
}
