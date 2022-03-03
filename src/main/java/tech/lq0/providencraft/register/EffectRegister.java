package tech.lq0.providencraft.register;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EffectRegister {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Effect effect_bless = EffectRegistry.BLESS_OF_DARK_ELF.get();
        Effect effect_curse = EffectRegistry.CURSE_OF_SERPENT.get();
        LivingEntity entity = event.getEntityLiving();

        if (source.getDamageType().equals("inFire") || source.getDamageType().equals("onFire") || source.getDamageType().equals("lava")) {
            if (entity.isPotionActive(effect_bless)) {
                EffectInstance effectInstance = entity.getActivePotionEffect(effect_bless);
                int level = effectInstance.getAmplifier();
                if (level >= 0) {
                    event.setCanceled(true);
                }
            }
        } else if(!source.isExplosion()){
            if (entity.isPotionActive(effect_bless)) {
                EffectInstance effectInstance = entity.getActivePotionEffect(effect_bless);
                int level = effectInstance.getAmplifier();
                if (level >= 10) {
                    event.setAmount(0);
                } else {
                    event.setAmount(event.getAmount() * (10 - level) / 10.0f);
                }
            }
        }

        if(source.isExplosion()){
            if(entity.isPotionActive(effect_curse)){
                EffectInstance effectInstance = entity.getActivePotionEffect(effect_curse);
                int level = effectInstance.getAmplifier();
                event.setAmount(event.getAmount()*(1+level));
            }
        }
    }


}
