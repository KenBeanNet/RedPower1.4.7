package buildcraft.api.filler;

import net.minecraft.inventory.IInventory;

public interface IFillerRegistry
{
    void addRecipe(IFillerPattern var1, Object[] var2);

    IFillerPattern findMatchingRecipe(IInventory var1);

    int getPatternNumber(IFillerPattern var1);

    IFillerPattern getPattern(int var1);
}
