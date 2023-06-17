package tech.lq0.providencraft.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.capability.ChaosCapabilityProvider;
import tech.lq0.providencraft.capability.IChaosCapability;
import tech.lq0.providencraft.capability.ModCapability;

@Mod.EventBusSubscriber()
public class CommonEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilityEvent(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(Utils.MOD_ID, "chaos"), new ChaosCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        LazyOptional<IChaosCapability> oldChaosCap = event.getOriginal().getCapability(ModCapability.CHAOS_CAPABILITY);
        LazyOptional<IChaosCapability> newChaosCap = event.getPlayer().getCapability(ModCapability.CHAOS_CAPABILITY);
        if (oldChaosCap.isPresent() && newChaosCap.isPresent()) {
            newChaosCap.ifPresent((newCap) -> oldChaosCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
        }
    }
}
