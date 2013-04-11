package buildcraft.api.blueprints;

import java.util.LinkedList;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class BptBlockUtils
{
    public static void requestInventoryContents(BptSlotInfo var0, IBptContext var1, LinkedList var2)
    {
        ItemStack[] var3 = getItemStacks(var0, var1);
        ItemStack[] var4 = var3;
        int var5 = var3.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            ItemStack var7 = var4[var6];

            if (var7 != null)
            {
                var2.add(var7);
            }
        }
    }

    public static void initializeInventoryContents(BptSlotInfo var0, IBptContext var1, IInventory var2)
    {
        ItemStack[] var3 = new ItemStack[var2.getSizeInventory()];

        for (int var4 = 0; var4 < var2.getSizeInventory(); ++var4)
        {
            var3[var4] = var2.getStackInSlot(var4);
        }

        setItemStacks(var0, var1, var3);
    }

    public static void buildInventoryContents(BptSlotInfo var0, IBptContext var1, IInventory var2)
    {
        ItemStack[] var3 = getItemStacks(var0, var1);

        for (int var4 = 0; var4 < var3.length; ++var4)
        {
            var2.setInventorySlotContents(var4, var3[var4]);
        }
    }

    public static ItemStack[] getItemStacks(BptSlotInfo var0, IBptContext var1)
    {
        NBTTagList var2 = (NBTTagList)var0.cpt.getTag("inv");

        if (var2 == null)
        {
            return new ItemStack[0];
        }
        else
        {
            ItemStack[] var3 = new ItemStack[var2.tagCount()];

            for (int var4 = 0; var4 < var2.tagCount(); ++var4)
            {
                ItemStack var5 = ItemStack.loadItemStackFromNBT((NBTTagCompound)var2.tagAt(var4));

                if (var5 != null && var5.itemID != 0 && var5.stackSize > 0)
                {
                    var3[var4] = var1.mapItemStack(var5);
                }
            }

            return var3;
        }
    }

    public static void setItemStacks(BptSlotInfo var0, IBptContext var1, ItemStack[] var2)
    {
        NBTTagList var3 = new NBTTagList();

        for (int var4 = 0; var4 < var2.length; ++var4)
        {
            NBTTagCompound var5 = new NBTTagCompound();
            var3.appendTag(var5);
            ItemStack var6 = var2[var4];

            if (var6 != null && var6.stackSize != 0)
            {
                var6.writeToNBT(var5);
                var1.storeId(var6.itemID);
            }
        }

        var0.cpt.setTag("inv", var3);
    }
}
