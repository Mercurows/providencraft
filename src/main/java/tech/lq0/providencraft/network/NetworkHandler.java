package tech.lq0.providencraft.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import tech.lq0.providencraft.Utils;

import java.util.function.Supplier;

public class NetworkHandler {
    private static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
//        INSTANCE = NetworkRegistry.newSimpleChannel(
//                new ResourceLocation(Utils.MOD_ID, "first_networking"),
//                () -> VERSION,
//                (version) -> version.equals(VERSION),
//                (version) -> version.equals(VERSION)
//        );
        INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Utils.MOD_ID, "channel"))
                .networkProtocolVersion(() -> VERSION)
                .clientAcceptedVersions((version) -> version.equals(VERSION))
                .serverAcceptedVersions((version) -> version.equals(VERSION))
                .simpleChannel();

        register(TracheliumPack.class, TracheliumPack::new);
    }

    private static <T extends NetworkPack> void register(Class<T> packClass, Supplier<T> messageSupplier) {
        INSTANCE.registerMessage(nextID(), packClass, NetworkPack::encode, buffer -> {
            T t = messageSupplier.get();
            t.decode(buffer);
            return t;
        }, NetworkPack::handler);
    }

    public static SimpleChannel getInstance(){
        return INSTANCE;
    }
}
