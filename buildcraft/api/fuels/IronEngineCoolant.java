package buildcraft.api.fuels;

import java.util.Iterator;
import java.util.LinkedList;
import net.minecraftforge.liquids.LiquidStack;

public class IronEngineCoolant
{
    public static LinkedList coolants = new LinkedList();
    public final LiquidStack liquid;
    public final float coolingPerUnit;

    public static IronEngineCoolant getCoolantForLiquid(LiquidStack var0)
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
            Iterator var1 = coolants.iterator();
            IronEngineCoolant var2;

            do
            {
                if (!var1.hasNext())
                {
                    return null;
                }

                var2 = (IronEngineCoolant)var1.next();
            }
            while (!var2.liquid.isLiquidEqual(var0));

            return var2;
        }
    }

    public IronEngineCoolant(LiquidStack var1, float var2)
    {
        this.liquid = var1;
        this.coolingPerUnit = var2;
    }
}
