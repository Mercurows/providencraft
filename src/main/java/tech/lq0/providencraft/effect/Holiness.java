package tech.lq0.providencraft.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Holiness extends Effect {
    public Holiness(){
        super(EffectType.BENEFICIAL, 16777159);
    }

    @SubscribeEvent
    public static void effect1(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Effect effect = EffectRegistry.HOLINESS.get();
        LivingEntity entity = event.getEntityLiving();

        Entity enemy = source.getTrueSource();

        if(entity instanceof PlayerEntity && !entity.world.isRemote) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.isPotionActive(effect)) {
                int level = Objects.requireNonNull(player.getActivePotionEffect(effect)).getAmplifier();
                if (enemy instanceof LivingEntity) {
                    LivingEntity enemyL = (LivingEntity) enemy;
                    if(enemyL.isEntityUndead()) {
                        float damage = event.getAmount() - (level + 1) * 3;
                        event.setAmount(damage > 0 ? damage : 1.0f);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void effect2(AttackEntityEvent event){
        PlayerEntity player = event.getPlayer();
        Effect effect = EffectRegistry.HOLINESS.get();
        Entity entity = event.getTarget();

        if(!player.world.isRemote && player.isPotionActive(effect)){
            int level = Objects.requireNonNull(player.getActivePotionEffect(effect)).getAmplifier();
            if(entity instanceof LivingEntity) {
                LivingEntity entity1 = (LivingEntity) entity;
                if (entity1.isEntityUndead()) {
                    entity1.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 10, level));
                    entity1.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, level));
                }
            }
        }
    }
}
