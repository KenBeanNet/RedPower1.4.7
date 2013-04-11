package buildcraft.api.inventory;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public interface ISelectiveInventory extends ISpecialInventory
{
    ItemStack[] extractItem(Object[] var1, boolean var2, boolean var3, ForgeDirection var4, int var5);
}
