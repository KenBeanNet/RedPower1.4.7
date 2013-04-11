package buildcraft.api.tools;

import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;

public interface IToolPipette
{
    int getCapacity(ItemStack var1);

    boolean canPipette(ItemStack var1);

    int fill(ItemStack var1, LiquidStack var2, boolean var3);

    LiquidStack drain(ItemStack var1, int var2, boolean var3);
}
