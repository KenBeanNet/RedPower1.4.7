package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BptBlockRedstoneRepeater extends BptBlock
{
    public BptBlockRedstoneRepeater(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(Item.redstoneRepeater));
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        int var3 = var1.meta - (var1.meta & 3);

        switch (var1.meta - var3)
        {
            case 0:
                var1.meta = 1 + var3;
                break;

            case 1:
                var1.meta = 2 + var3;
                break;

            case 2:
                var1.meta = 3 + var3;
                break;

            case 3:
                var1.meta = 0 + var3;
        }
    }
}
