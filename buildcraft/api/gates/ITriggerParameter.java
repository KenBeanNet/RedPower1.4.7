package buildcraft.api.gates;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface ITriggerParameter
{
    ItemStack getItemStack();

    void set(ItemStack var1);

    void writeToNBT(NBTTagCompound var1);

    void readFromNBT(NBTTagCompound var1);

    ItemStack getItem();
}
