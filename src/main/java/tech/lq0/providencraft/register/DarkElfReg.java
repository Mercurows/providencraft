package tech.lq0.providencraft.register;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectInit;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DarkElfReg {
    @SubscribeEvent
    public static void onLivineHurt(LivingHurtEvent event){
        DamageSource source = event.getSource();
        Effect effect = EffectInit.blessOfDarkElf.get();
        LivingEntity entity = event.getEntityLiving();

        if(source.getDamageType().equals("inFire")||source.getDamageType().equals("onFire")){
            if(entity.isPotionActive(effect)){
                EffectInstance effectInstance = entity.getActivePotionEffect(effect);
                int level = effectInstance.getAmplifier();
                if(level>=0){
                    event.setCanceled(true);
                }
            }
        }

    }

   // entity.setGlowing(true);
}
