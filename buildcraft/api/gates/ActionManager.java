package buildcraft.api.gates;

import buildcraft.api.transport.IPipe;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class ActionManager
{
    public static Trigger[] triggers = new Trigger[1024];
    public static Action[] actions = new Action[1024];
    private static LinkedList triggerProviders = new LinkedList();
    private static LinkedList actionProviders = new LinkedList();

    public static void registerTriggerProvider(ITriggerProvider var0)
    {
        if (var0 != null && !triggerProviders.contains(var0))
        {
            triggerProviders.add(var0);
        }
    }

    public static LinkedList getNeighborTriggers(Block var0, TileEntity var1)
    {
        LinkedList var2 = new LinkedList();
        Iterator var3 = triggerProviders.iterator();

        while (var3.hasNext())
        {
            ITriggerProvider var4 = (ITriggerProvider)var3.next();
            LinkedList var5 = var4.getNeighborTriggers(var0, var1);

            if (var5 != null)
            {
                Iterator var6 = var5.iterator();

                while (var6.hasNext())
                {
                    ITrigger var7 = (ITrigger)var6.next();

                    if (!var2.contains(var7))
                    {
                        var2.add(var7);
                    }
                }
            }
        }

        return var2;
    }

    public static void registerActionProvider(IActionProvider var0)
    {
        if (var0 != null && !actionProviders.contains(var0))
        {
            actionProviders.add(var0);
        }
    }

    public static LinkedList getNeighborActions(Block var0, TileEntity var1)
    {
        LinkedList var2 = new LinkedList();
        Iterator var3 = actionProviders.iterator();

        while (var3.hasNext())
        {
            IActionProvider var4 = (IActionProvider)var3.next();
            LinkedList var5 = var4.getNeighborActions(var0, var1);

            if (var5 != null)
            {
                Iterator var6 = var5.iterator();

                while (var6.hasNext())
                {
                    IAction var7 = (IAction)var6.next();

                    if (!var2.contains(var7))
                    {
                        var2.add(var7);
                    }
                }
            }
        }

        return var2;
    }

    public static LinkedList getPipeTriggers(IPipe var0)
    {
        LinkedList var1 = new LinkedList();
        Iterator var2 = triggerProviders.iterator();

        while (var2.hasNext())
        {
            ITriggerProvider var3 = (ITriggerProvider)var2.next();
            LinkedList var4 = var3.getPipeTriggers(var0);

            if (var4 != null)
            {
                Iterator var5 = var4.iterator();

                while (var5.hasNext())
                {
                    ITrigger var6 = (ITrigger)var5.next();

                    if (!var1.contains(var6))
                    {
                        var1.add(var6);
                    }
                }
            }
        }

        return var1;
    }
}
