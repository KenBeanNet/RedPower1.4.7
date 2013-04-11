package buildcraft.api.fuels;

import java.util.Iterator;
import java.util.LinkedList;
import net.minecraftforge.liquids.LiquidStack;

public class IronEngineFuel
{
    public static LinkedList fuels = new LinkedList();
    public final LiquidStack liquid;
    public final float powerPerCycle;
    public final int totalBurningTime;

    public static IronEngineFuel getFuelForLiquid(LiquidStack var0)
    {
        if (var0 == null)
        {
            return null;
        }
        else if (var0.itemID <= 0)
        {
            return null;
        }
        else
        {
            Iterator var1 = fuels.iterator();
            IronEngineFuel var2;

            do
            {
                if (!var1.hasNext())
                {
                    return null;
                }

                var2 = (IronEngineFuel)var1.next();
            }
            while (!var2.liquid.isLiquidEqual(var0));

            return var2;
        }
    }

    public IronEngineFuel(int var1, float var2, int var3)
    {
        this(new LiquidStack(var1, 1000, 0), var2, var3);
    }

    public IronEngineFuel(LiquidStack var1, float var2, int var3)
    {
        this.liquid = var1;
        this.powerPerCycle = var2;
        this.totalBurningTime = var3;
    }
}
