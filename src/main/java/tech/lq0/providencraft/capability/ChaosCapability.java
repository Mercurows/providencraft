package tech.lq0.providencraft.capability;

import net.minecraft.nbt.CompoundNBT;

public class ChaosCapability implements IChaosCapability{
    private double chaos;

    public ChaosCapability(double chaos){
        this.chaos = chaos;
    }

    @Override
    public double getChaos() {
        return chaos;
    }

    @Override
    public void setChaos(double chaos) {
        this.chaos = chaos;
    }

    @Override
    public CompoundNBT serializeNBT(){
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putDouble("chaos", this.chaos);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt){
        this.chaos = nbt.getDouble("chaos");

    }
}
