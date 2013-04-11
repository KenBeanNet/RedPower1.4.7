package buildcraft.api.transport;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import net.minecraft.world.World;

public abstract class PipeManager
{
    @Deprecated
    private static TreeMap allServerEntities = new TreeMap();
    @Deprecated
    private static TreeMap allClientEntities = new TreeMap();
    public static List extractionHandlers = new ArrayList();

    public static void registerExtractionHandler(IExtractionHandler var0)
    {
        extractionHandlers.add(var0);
    }

    public static boolean canExtractItems(IPipe var0, World var1, int var2, int var3, int var4)
    {
        Iterator var5 = extractionHandlers.iterator();
        IExtractionHandler var6;

        do
        {
            if (!var5.hasNext())
            {
                return true;
            }

            var6 = (IExtractionHandler)var5.next();
        }
        while (var6.canExtractItems(var0, var1, var2, var3, var4));

        return false;
    }

    public static boolean canExtractLiquids(IPipe var0, World var1, int var2, int var3, int var4)
    {
        Iterator var5 = extractionHandlers.iterator();
        IExtractionHandler var6;

        do
        {
            if (!var5.hasNext())
            {
                return true;
            }

            var6 = (IExtractionHandler)var5.next();
        }
        while (var6.canExtractLiquids(var0, var1, var2, var3, var4));

        return false;
    }

    @Deprecated
    public static TreeMap getAllEntities()
    {
        return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? allClientEntities : allServerEntities;
    }
}
