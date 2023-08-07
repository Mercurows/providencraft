package tech.lq0.providencraft.network.packet;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;
import tech.lq0.providencraft.entity.LeviyBeamEntity;
import tech.lq0.providencraft.init.EntityRegistry;

import java.util.function.Supplier;

public class LeviyLaunchPacket {
    private int x;
    private int y;
    private int z;

    private float power;
    private float radius;
    private int duration;

    public LeviyLaunchPacket(int x, int y, int z) {
        this(x, y, z, 0.5f, 10, 100);
    }

    public LeviyLaunchPacket(int x, int y, int z, float power) {
        this(x, y, z, power, 10, 100);
    }

    public LeviyLaunchPacket(int x, int y, int z, float power, float radius) {
        this(x, y, z, power, radius, 100);
    }

    public LeviyLaunchPacket(int x, int y, int z, float power, float radius, int duration) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.power = power;
        this.radius = radius;
        this.duration = duration;
    }

    public static void encode(LeviyLaunchPacket packet, PacketBuffer buf) {
        buf.writeInt(packet.x);
        buf.writeInt(packet.y);
        buf.writeInt(packet.z);
    }

    public static LeviyLaunchPacket decode(PacketBuffer buf) {
        return new LeviyLaunchPacket(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public static void handle(LeviyLaunchPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null) {
                World world = player.world;
                LeviyBeamEntity beam = EntityRegistry.LEVIY_BEAM_ENTITY.get().create(player.world);

                assert beam != null;
                beam.setPosition(packet.x, packet.y, packet.z);

                System.out.println(packet.x + ", " + packet.y + ", " + packet.z);

                beam.setPower(packet.power);
                beam.setRadius(packet.radius);
                beam.setDuration(packet.duration);
                world.addEntity(beam);

                System.out.println("beam created");
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
