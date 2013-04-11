package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockLever extends BptBlockWallSide
{
    public BptBlockLever(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(var1.blockId, 1, 0));
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        int var3 = var1.meta - (var1.meta & 7);
        var1.meta -= var3;
        super.rotateLeft(var1, var2);
        var1.meta += var3;
    }
}
