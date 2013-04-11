package buildcraft.api.gates;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TriggerParameter implements ITriggerParameter
{
    protected ItemStack stack;

    public ItemStack getItemStack()
    {
        return this.stack;
    }

    public void set(ItemStack var1)
    {
        if (var1 != null)
        {
            this.stack = var1.copy();
            this.stack.stackSize = 1;
        }
    }

    public void writeToNBT(NBTTagCompound var1)
    {
        if (this.stack != null)
        {
            var1.setInteger("itemID", this.stack.itemID);
            var1.setInteger("itemDMG", this.stack.getItemDamage());
        }
    }

    public void readFromNBT(NBTTagCompound var1)
    {
        int var2 = var1.getInteger("itemID");

        if (var2 != 0)
        {
            this.stack = new ItemStack(var2, 1, var1.getInteger("itemDMG"));
        }
    }

    public ItemStack getItem()
    {
        return this.stack;
    }
}
