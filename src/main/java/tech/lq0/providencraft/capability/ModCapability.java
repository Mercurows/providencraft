package tech.lq0.providencraft.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapability {
    @CapabilityInject(IChaosCapability.class)
    public static Capability<IChaosCapability> CHAOS_CAPABILITY;
}
