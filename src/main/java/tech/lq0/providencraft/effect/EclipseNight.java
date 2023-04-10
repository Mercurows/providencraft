package tech.lq0.providencraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.tools.Livers;

import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EclipseNight extends Effect {
    public EclipseNight(){
        super(EffectType.BENEFICIAL, 0xFC96A1);
        addAttributesModifier(Attributes.ATTACK_SPEED, new UUID(Livers.SORAYO.hashCode(), 0).toString(), 0.08F, AttributeModifier.Operation.MULTIPLY_TOTAL);
        addAttributesModifier(Attributes.ATTACK_DAMAGE, new UUID(Livers.SORAYO.hashCode() + 0xFC96A1, 0).toString(), 1.0f, AttributeModifier.Operation.ADDITION);
    }

    @SubscribeEvent
    public static void entityHurt(LivingHurtEvent event){
        DamageSource source = event.getSource();
        Effect effect = EffectRegistry.ECLIPSE_NIGHT.get();
        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
            PlayerEntity player = (PlayerEntity) entity;
            if (player.isPotionActive(effect)) {
                if (source.getDamageType().equals("sorayo")) {
                    event.setAmount(event.getAmount() / 2.0f);
                }
            }
        }
    }
}
