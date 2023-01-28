package tech.lq0.providencraft.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TracheliumPack implements NetworkPack{
    private float yaw;
    private float pitch;

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public TracheliumPack(){
    }

    public TracheliumPack(PlayerEntity player){
        this.yaw = player.rotationYaw;
        this.pitch = player.rotationPitch;
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeFloat(yaw);
        buffer.writeFloat(pitch);
    }

    @Override
    public void decode(PacketBuffer buffer){
        this.yaw = buffer.readFloat();
        this.pitch = buffer.readFloat();
    }

    @Override
    public void handler(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayerEntity player = context.get().getSender();
            if(player != null){
                System.out.println("test111");
            }
        });
        context.get().setPacketHandled(true);
    }
}
