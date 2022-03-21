package tech.lq0.providencraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.init.EffectRegistry;
import tech.lq0.providencraft.init.ItemRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BigMoeOne extends Effect {
    public BigMoeOne() {
        super(EffectType.HARMFUL, 15984600);
    }

    @SubscribeEvent
    public static void effects(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Effect effect = EffectRegistry.BIG_MOE_ONE.get();
        if (entity.isPotionActive(effect)) {
            ItemStack helmet = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (!helmet.isEmpty() && helmet.getItem().equals(ItemRegistry.RED_AHOGE_HELMET.get())) {
                event.setAmount(event.getAmount() * 0.8f);
            } else {
                event.setAmount(event.getAmount() * 1.5f);
            }
        }
    }
}
