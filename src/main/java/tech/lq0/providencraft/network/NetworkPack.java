package tech.lq0.providencraft.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public interface NetworkPack {
    void encode(PacketBuffer buffer);

    void decode(PacketBuffer buffer);

    void handler(Supplier<NetworkEvent.Context> context);
}
