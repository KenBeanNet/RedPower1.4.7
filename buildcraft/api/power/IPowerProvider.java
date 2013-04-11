package buildcraft.api.power;

import buildcraft.api.core.SafeTimeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;

public interface IPowerProvider
{
    int getLatency();

    int getMinEnergyReceived();

    int getMaxEnergyReceived();

    int getMaxEnergyStored();

    int getActivationEnergy();

    float getEnergyStored();

    void configure(int var1, int var2, int var3, int var4, int var5);

    void configurePowerPerdition(int var1, int var2);

    boolean update(IPowerReceptor var1);

    boolean preConditions(IPowerReceptor var1);

    float useEnergy(float var1, float var2, boolean var3);

    void readFromNBT(NBTTagCompound var1);

    void writeToNBT(NBTTagCompound var1);

    void receiveEnergy(float var1, ForgeDirection var2);

    boolean isPowerSource(ForgeDirection var1);

    SafeTimeTracker getTimeTracker();
}
