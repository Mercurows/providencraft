package tech.lq0.providencraft.capability;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.util.LazyOptional;
import tech.lq0.providencraft.init.AttributeRegistry;

import java.util.concurrent.atomic.AtomicInteger;

public class ChaosHelper {
    public static int getChaos(PlayerEntity player){
        AtomicInteger chaos = new AtomicInteger();
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapability.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> chaos.set((int) (l.getChaos() + (int) player.getAttributeValue(AttributeRegistry.CHAOS.get()))));

        return chaos.get();
    }

    public static void setChaos(PlayerEntity player, int chaos){
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapability.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> l.setChaos(l.getChaos() + chaos));
    }

    public static void resetChaos(PlayerEntity player){
        LazyOptional<IChaosCapability> chaosCap = player.getCapability(ModCapability.CHAOS_CAPABILITY);
        chaosCap.ifPresent((l) -> l.setChaos(0));
    }

}
