package tech.lq0.providencraft.teleporter;

import net.minecraft.block.PortalInfo;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.function.Function;

public class MirrorTeleporter implements ITeleporter {
    private Vector3d aimPos;
    private Vector3d aimMotion;
    public MirrorTeleporter(Vector3d aimPos,Vector3d aimMotion){
        this.aimMotion = aimMotion;
        this.aimPos = aimPos;

    }
    @Override
    public boolean isVanilla(){
        return false;
    }
    @Override
    @Nullable
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo)
    {
        return this.isVanilla() ? defaultPortalInfo.apply(destWorld) : new PortalInfo(this.aimPos, this.aimMotion, entity.rotationYaw, entity.rotationPitch);
    }
    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity)
    {
        return repositionEntity.apply(true);
    }
}
