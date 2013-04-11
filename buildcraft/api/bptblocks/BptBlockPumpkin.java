package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockPumpkin extends BptBlock
{
    public BptBlockPumpkin(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(var1.blockId, 1, 0));
    }

    public boolean isValid(BptSlotInfo var1, IBptContext var2)
    {
        return var1.blockId == var2.world().getBlockId(var1.x, var1.y, var1.z);
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        switch (var1.meta)
        {
            case 0:
                var1.meta = 1;
                break;

            case 1:
                var1.meta = 2;
                break;

            case 2:
                var1.meta = 3;
                break;

            case 3:
                var1.meta = 0;
        }
    }
}
