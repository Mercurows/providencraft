package tech.lq0.providencraft.entity.boundingbox;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

//Forked from MrCrayfish and TaC
public interface IHeadBox<T extends Entity> {
    @Nullable
    AxisAlignedBB getHeadshotBox(T entity);
}
