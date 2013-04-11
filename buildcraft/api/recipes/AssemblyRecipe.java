package buildcraft.api.recipes;

import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class AssemblyRecipe
{
    public static LinkedList assemblyRecipes = new LinkedList();
    public final ItemStack[] input;
    public final ItemStack output;
    public final float energy;

    public AssemblyRecipe(ItemStack[] var1, int var2, ItemStack var3)
    {
        this.input = var1;
        this.output = var3;
        this.energy = (float)var2;
    }

    public boolean canBeDone(ItemStack[] var1)
    {
        ItemStack[] var2 = this.input;
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4)
        {
            ItemStack var5 = var2[var4];

            if (var5 != null)
            {
                int var6 = 0;
                ItemStack[] var7 = var1;
                int var8 = var1.length;

                for (int var9 = 0; var9 < var8; ++var9)
                {
                    ItemStack var10 = var7[var9];

                    if (var10 != null && var10.isItemEqual(var5))
                    {
                        var6 += var10.stackSize;
                    }
                }

                if (var6 < var5.stackSize)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
