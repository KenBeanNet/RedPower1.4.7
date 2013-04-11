package buildcraft.api.power;

import buildcraft.api.core.SafeTimeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class PowerProvider implements IPowerProvider
{
    protected int latency;
    protected int minEnergyReceived;
    protected int maxEnergyReceived;
    protected int maxEnergyStored;
    protected int minActivationEnergy;
    protected float energyStored = 0.0F;
    protected int powerLoss = 1;
    protected int powerLossRegularity = 100;
    public SafeTimeTracker timeTracker = new SafeTimeTracker();
    public SafeTimeTracker energyLossTracker = new SafeTimeTracker();
    public int[] powerSources = new int[] {0, 0, 0, 0, 0, 0};

    public SafeTimeTracker getTimeTracker()
    {
        return this.timeTracker;
    }

    public int getLatency()
    {
        return this.latency;
    }

    public int getMinEnergyReceived()
    {
        return this.minEnergyReceived;
    }

    public int getMaxEnergyReceived()
    {
        return this.maxEnergyReceived;
    }

    public int getMaxEnergyStored()
    {
        return this.maxEnergyStored;
    }

    public int getActivationEnergy()
    {
        return this.minActivationEnergy;
    }

    public float getEnergyStored()
    {
        return this.energyStored;
    }

    public void configure(int var1, int var2, int var3, int var4, int var5)
    {
        this.latency = var1;
        this.minEnergyReceived = var2;
        this.maxEnergyReceived = var3;
        this.maxEnergyStored = var5;
        this.minActivationEnergy = var4;
    }

    public void configurePowerPerdition(int var1, int var2)
    {
        this.powerLoss = var1;
        this.powerLossRegularity = var2;
    }

    public boolean update(IPowerReceptor var1)
    {
        if (!this.preConditions(var1))
        {
            return false;
        }
        else
        {
            TileEntity var2 = (TileEntity)var1;
            boolean var3 = false;

            if (this.energyStored >= (float)this.minActivationEnergy)
            {
                if (this.latency == 0)
                {
                    var1.doWork();
                    var3 = true;
                }
                else if (this.timeTracker.markTimeIfDelay(var2.worldObj, (long)this.latency))
                {
                    var1.doWork();
                    var3 = true;
                }
            }

            if (this.powerLoss > 0 && this.energyLossTracker.markTimeIfDelay(var2.worldObj, (long)this.powerLossRegularity))
            {
                this.energyStored -= (float)this.powerLoss;

                if (this.energyStored < 0.0F)
                {
                    this.energyStored = 0.0F;
                }
            }

            for (int var4 = 0; var4 < 6; ++var4)
            {
                if (this.powerSources[var4] > 0)
                {
                    --this.powerSources[var4];
                }
            }

            return var3;
        }
    }

    public boolean preConditions(IPowerReceptor var1)
    {
        return true;
    }

    public float useEnergy(float var1, float var2, boolean var3)
    {
        float var4 = 0.0F;

        if (this.energyStored >= var1)
        {
            if (this.energyStored <= var2)
            {
                var4 = this.energyStored;

                if (var3)
                {
                    this.energyStored = 0.0F;
                }
            }
            else
            {
                var4 = var2;

                if (var3)
                {
                    this.energyStored -= var2;
                }
            }
        }

        return var4;
    }

    public void readFromNBT(NBTTagCompound var1)
    {
        this.latency = var1.getInteger("latency");
        this.minEnergyReceived = var1.getInteger("minEnergyReceived");
        this.maxEnergyReceived = var1.getInteger("maxEnergyReceived");
        this.maxEnergyStored = var1.getInteger("maxStoreEnergy");
        this.minActivationEnergy = var1.getInteger("minActivationEnergy");

        try
        {
            this.energyStored = var1.getFloat("storedEnergy");
        }
        catch (Throwable var3)
        {
            this.energyStored = 0.0F;
        }
    }

    public void writeToNBT(NBTTagCompound var1)
    {
        var1.setInteger("latency", this.latency);
        var1.setInteger("minEnergyReceived", this.minEnergyReceived);
        var1.setInteger("maxEnergyReceived", this.maxEnergyReceived);
        var1.setInteger("maxStoreEnergy", this.maxEnergyStored);
        var1.setInteger("minActivationEnergy", this.minActivationEnergy);
        var1.setFloat("storedEnergy", this.energyStored);
    }

    public void receiveEnergy(float var1, ForgeDirection var2)
    {
        this.powerSources[var2.ordinal()] = 2;
        this.energyStored += var1;

        if (this.energyStored > (float)this.maxEnergyStored)
        {
            this.energyStored = (float)this.maxEnergyStored;
        }
    }

    public boolean isPowerSource(ForgeDirection var1)
    {
        return this.powerSources[var1.ordinal()] != 0;
    }
}
