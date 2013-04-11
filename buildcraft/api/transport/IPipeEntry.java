package buildcraft.api.transport;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public interface IPipeEntry
{
    void entityEntering(ItemStack var1, ForgeDirection var2);

    void entityEntering(IPipedItem var1, ForgeDirection var2);

    boolean acceptItems();
}
