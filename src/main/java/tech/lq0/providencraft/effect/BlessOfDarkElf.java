package tech.lq0.providencraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlessOfDarkElf extends Effect {
    public BlessOfDarkElf() {
        super(EffectType.BENEFICIAL, 1919810);
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Effect effect_bless = EffectRegistry.BLESS_OF_DARK_ELF.get();
        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.isPotionActive(effect_bless)) {
                int level = Objects.requireNonNull(player.getActivePotionEffect(effect_bless)).getAmplifier();
                if (source.isFireDamage() || source.getDamageType().equals("lava")) {
                    event.setAmount(0);
                } else if (source.isExplosion()) {
                    event.setAmount(event.getAmount());
                } else {
                    int num = (level + 1) * 2;
                    event.setAmount(event.getAmount() > num ? event.getAmount() - num : 0);
                }
            }
        }
    }
}
