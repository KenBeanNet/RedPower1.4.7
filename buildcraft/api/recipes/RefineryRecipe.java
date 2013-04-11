package buildcraft.api.recipes;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import net.minecraftforge.liquids.LiquidStack;

public class RefineryRecipe implements Comparable
{
    private static SortedSet recipes = new TreeSet();
    public final LiquidStack ingredient1;
    public final LiquidStack ingredient2;
    public final LiquidStack result;
    public final int energy;
    public final int delay;

    public static void registerRefineryRecipe(RefineryRecipe var0)
    {
        if (!recipes.contains(var0))
        {
            recipes.add(var0);
        }
    }

    public static SortedSet getRecipes()
    {
        return Collections.unmodifiableSortedSet(recipes);
    }

    public static RefineryRecipe findRefineryRecipe(LiquidStack var0, LiquidStack var1)
    {
        Iterator var2 = recipes.iterator();
        RefineryRecipe var3;

        do
        {
            if (!var2.hasNext())
            {
                return null;
            }

            var3 = (RefineryRecipe)var2.next();
        }
        while (!var3.matches(var0, var1));

        return var3;
    }

    public RefineryRecipe(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8)
    {
        this(new LiquidStack(var1, var2, 0), new LiquidStack(var3, var4, 0), new LiquidStack(var5, var6, 0), var7, var8);
    }

    public RefineryRecipe(LiquidStack var1, LiquidStack var2, LiquidStack var3, int var4, int var5)
    {
        if (var1 != null && var2 != null)
        {
            if (var1.itemID <= var2.itemID && (var1.itemID != var2.itemID || var1.itemMeta <= var2.itemMeta))
            {
                this.ingredient1 = var1;
                this.ingredient2 = var2;
            }
            else
            {
                this.ingredient1 = var2;
                this.ingredient2 = var1;
            }
        }
        else if (var2 != null)
        {
            this.ingredient1 = var2;
            this.ingredient2 = var1;
        }
        else
        {
            this.ingredient1 = var1;
            this.ingredient2 = var2;
        }

        this.result = var3;
        this.energy = var4;
        this.delay = var5;
    }

    public boolean matches(LiquidStack var1, LiquidStack var2)
    {
        return var1 == null && var2 == null ? false : (this.ingredient1 != null && this.ingredient2 != null && (var1 == null || var2 == null) ? false : (this.ingredient1 != null ? (this.ingredient2 == null ? this.ingredient1.isLiquidEqual(var1) || this.ingredient1.isLiquidEqual(var2) : this.ingredient1.isLiquidEqual(var1) && this.ingredient2.isLiquidEqual(var2) || this.ingredient2.isLiquidEqual(var1) && this.ingredient1.isLiquidEqual(var2)) : (this.ingredient2 == null ? false : this.ingredient2.isLiquidEqual(var1) || this.ingredient2.isLiquidEqual(var2))));
    }

    public int compareTo(RefineryRecipe var1)
    {
        return var1 == null ? -1 : (this.ingredient1 == null ? (var1.ingredient1 == null ? 0 : 1) : (var1.ingredient1 == null ? -1 : (this.ingredient1.itemID != var1.ingredient1.itemID ? this.ingredient1.itemID - var1.ingredient1.itemID : (this.ingredient1.itemMeta != var1.ingredient1.itemMeta ? this.ingredient1.itemMeta - var1.ingredient1.itemMeta : (this.ingredient2 == null ? (var1.ingredient2 == null ? 0 : 1) : (var1.ingredient2 == null ? -1 : (this.ingredient2.itemID != var1.ingredient2.itemID ? this.ingredient2.itemID - var1.ingredient2.itemID : (this.ingredient2.itemMeta != var1.ingredient2.itemMeta ? this.ingredient2.itemMeta - var1.ingredient2.itemMeta : 0))))))));
    }

    public boolean equals(Object var1)
    {
        return var1 != null && var1 instanceof RefineryRecipe ? this.compareTo((RefineryRecipe)var1) == 0 : false;
    }

    public int hashCode()
    {
        return this.ingredient1 == null ? 0 : (this.ingredient2 == null ? this.ingredient1.itemID ^ this.ingredient1.itemMeta : this.ingredient1.itemID ^ this.ingredient1.itemMeta ^ this.ingredient2.itemID ^ this.ingredient2.itemMeta);
    }

    public int compareTo(Object var1)
    {
        return this.compareTo((RefineryRecipe)var1);
    }
}
