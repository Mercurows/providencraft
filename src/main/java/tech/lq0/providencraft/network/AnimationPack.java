package tech.lq0.providencraft.network;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.UUID;
import java.util.function.Supplier;

//Forked from TaC
public class AnimationPack implements NetworkPack{
    private ResourceLocation animationResource;
    private ResourceLocation soundResource;
    private boolean play;
    private UUID fromWho;

    public AnimationPack(){}

    public AnimationPack(ResourceLocation animationResource, ResourceLocation soundResource, boolean play, UUID fromWho) {
        this.animationResource = animationResource;
        this.soundResource = soundResource;
        this.play = play;
        this.fromWho = fromWho;
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeResourceLocation(animationResource);
        buffer.writeResourceLocation(soundResource);
        buffer.writeBoolean(play);
        buffer.writeUniqueId(fromWho);
    }

    @Override
    public void decode(PacketBuffer buffer) {
        animationResource = buffer.readResourceLocation();
        soundResource = buffer.readResourceLocation();
        play = buffer.readBoolean();
        fromWho = buffer.readUniqueId();
    }

    @Override
    public void handler(Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> {
            AnimationPack message = new AnimationPack(animationResource,soundResource,play,fromWho);
            NetworkHandler.getInstance().send(PacketDistributor.ALL.noArg(), message);
        });
        supplier.get().setPacketHandled(true);
    }
}
