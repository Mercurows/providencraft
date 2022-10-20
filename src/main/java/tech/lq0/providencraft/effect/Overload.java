package tech.lq0.providencraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.DamageSourceRegistry;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.RandomTool;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Overload extends Effect {
    public Overload() {
        super(EffectType.HARMFUL, 9240571);
    }

    private static void triggerSideEffect(PlayerEntity player, int num, int lvl) {
        switch (num) {
            case 0:
                player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, lvl));
                break;
            case 1:
                player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, lvl));
                break;
            case 2:
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, lvl));
                break;
            case 3:
                player.addPotionEffect(new EffectInstance(Effects.WITHER, 100, lvl));
                break;
            case 4:
                player.addPotionEffect(new EffectInstance(Effects.NAUSEA, 100, lvl));
                break;
        }
    }

    @SubscribeEvent
    public static void SideEffect(PotionEvent.PotionExpiryEvent event){
        LivingEntity entity = event.getEntityLiving();
        if(EffectRegistry.OVERLOAD.get().getName().equals(Objects.requireNonNull(event.getPotionEffect()).getEffectName())){
            if(entity instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) entity;
                int random = (int) (Math.random() * 99 + 1);
                int lvl = event.getPotionEffect().getAmplifier();

                if (random > 20) {
                    int[] num = RandomTool.getRandom(1, 5, 2);
                    assert num != null;
                    triggerSideEffect(player, num[0], lvl);
                    triggerSideEffect(player, num[1], lvl);
                } else {
                    player.attackEntityFrom(DamageSourceRegistry.EMO, 30.0f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void SideEffect2(PotionEvent.PotionAddedEvent event){
        LivingEntity entity = event.getEntityLiving();
        if(EffectRegistry.OVERLOAD.get().getName().equals(Objects.requireNonNull(event.getPotionEffect()).getEffectName())){
            if(entity instanceof PlayerEntity){
                PlayerEntity player = (PlayerEntity) entity;
                int lvl = event.getPotionEffect().getAmplifier();
                if (lvl >= 10) {
                    player.attackEntityFrom(DamageSourceRegistry.OVERLOAD, 300.0f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void SideEffect3(PotionEvent.PotionRemoveEvent event){
        LivingEntity entity = event.getEntityLiving();
        EffectInstance effect = event.getPotionEffect();
        if(effect != null) {
            if (EffectRegistry.OVERLOAD.get().getName().equals(effect.getEffectName())) {
                if (entity instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) entity;
                    int lvl = event.getPotionEffect().getAmplifier();
                    player.attackEntityFrom(DamageSourceRegistry.OVERLOAD, 5.0f * (lvl + 1));
                }
            }
        }
    }
}
