package tech.lq0.providencraft.init;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tech.lq0.providencraft.advancements.criterion.FillLavaTrigger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class CriteriaRegistry {
    public static FillLavaTrigger FILL_LAVA;

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FILL_LAVA = register(new FillLavaTrigger());
        });
    }

    public static <T extends ICriterionTrigger<?>> T register(T criterion) {
        CriteriaTriggers.register(criterion);
        return criterion;
    }
}
