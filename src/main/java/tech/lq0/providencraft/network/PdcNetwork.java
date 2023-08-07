package tech.lq0.providencraft.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import tech.lq0.providencraft.Utils;
import tech.lq0.providencraft.network.packet.LeviyLaunchPacket;

public class PdcNetwork {
    public static final String NETWORK_VERSION = "1.0";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(Utils.MOD_ID, "network")
            , () -> NETWORK_VERSION, NETWORK_VERSION::equals, NETWORK_VERSION::equals);

    public static void init() {
        CHANNEL.registerMessage(0, LeviyLaunchPacket.class, LeviyLaunchPacket::encode, LeviyLaunchPacket::decode, LeviyLaunchPacket::handle)
        ;
    }

}
