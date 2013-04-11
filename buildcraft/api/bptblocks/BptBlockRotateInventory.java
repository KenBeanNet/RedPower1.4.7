package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class BptBlockRotateInventory extends BptBlockRotateMeta
{
    public BptBlockRotateInventory(int var1, int[] var2, boolean var3)
    {
        super(var1, var2, var3);
    }

    public void buildBlock(BptSlotInfo var1, IBptContext var2)
    {
        super.buildBlock(var1, var2);
        IInventory var3 = (IInventory)var2.world().getBlockTileEntity(var1.x, var1.y, var1.z);

        for (int var4 = 0; var4 < var3.getSizeInventory(); ++var4)
        {
            var3.setInventorySlotContents(var4, (ItemStack)null);
        }
    }
}
