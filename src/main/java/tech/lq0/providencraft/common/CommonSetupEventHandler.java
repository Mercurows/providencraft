package tech.lq0.providencraft.common;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import tech.lq0.providencraft.capability.IChaosCapability;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetupEventHandler {
    @SubscribeEvent
    public static void onSetupEvent(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            CapabilityManager.INSTANCE.register(
                    IChaosCapability.class,
                    new Capability.IStorage<IChaosCapability>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<IChaosCapability> capability, IChaosCapability instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<IChaosCapability> capability, IChaosCapability instance, Direction side, INBT nbt) {

                        }
                    },
                    () -> null
            );
        });
    }
}
