package buildcraft.api.transport;

import java.lang.reflect.Method;
import net.minecraft.item.ItemStack;

public class FacadeManager
{
    private static Method addFacade;

    public static void addFacade(ItemStack var0)
    {
        try
        {
            if (addFacade == null)
            {
                Class var1 = Class.forName("buildcraft.transport.ItemFacade");
                addFacade = var1.getMethod("addFacade", new Class[] {ItemStack.class});
            }

            addFacade.invoke((Object)null, new Object[] {var0});
        }
        catch (Exception var2)
        {
            ;
        }
    }
}
