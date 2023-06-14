package tech.lq0.providencraft.capability;

import net.minecraft.nbt.CompoundNBT;

import net.minecraftforge.common.util.INBTSerializable;

public interface IChaosCapability extends INBTSerializable<CompoundNBT> {
    double getChaos();
    void setChaos(double chaos);
}
