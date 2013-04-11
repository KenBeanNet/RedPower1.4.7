package buildcraft.api.power;

import net.minecraft.nbt.NBTTagCompound;

public abstract class PowerFramework
{
    private static String baseNBTName = "com.eloraam.redpower.buildcarft.Power";
    public static PowerFramework currentFramework;

    public abstract IPowerProvider createPowerProvider();

    public void loadPowerProvider(IPowerReceptor var1, NBTTagCompound var2)
    {
        IPowerProvider var3 = this.createPowerProvider();

        if (var2.hasKey(baseNBTName))
        {
            NBTTagCompound var4 = var2.getCompoundTag(baseNBTName);

            if (var4.getString("class").equals(this.getClass().getName()))
            {
                var3.readFromNBT(var4.getCompoundTag("contents"));
            }
        }

        var1.setPowerProvider(var3);
    }

    public void savePowerProvider(IPowerReceptor var1, NBTTagCompound var2)
    {
        IPowerProvider var3 = var1.getPowerProvider();

        if (var3 != null)
        {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setString("class", this.getClass().getName());
            NBTTagCompound var5 = new NBTTagCompound();
            var3.writeToNBT(var5);
            var4.setTag("contents", var5);
            var2.setTag(baseNBTName, var4);
        }
    }
}
