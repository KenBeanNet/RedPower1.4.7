package buildcraft.api.inventory;

import net.minecraftforge.common.ForgeDirection;

public interface ISecuredInventory
{
    boolean canAccess(String var1);

    void prepareTransaction(ForgeDirection var1, String var2);
}
