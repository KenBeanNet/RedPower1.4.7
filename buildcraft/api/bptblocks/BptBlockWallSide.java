package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockWallSide extends BptBlock
{
    public BptBlockWallSide(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(var1.blockId, 1, 0));
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        boolean var3 = true;
        boolean var4 = true;
        boolean var5 = true;
        boolean var6 = true;

        switch (var1.meta)
        {
            case 1:
                var1.meta = 3;
                break;

            case 2:
                var1.meta = 4;
                break;

            case 3:
                var1.meta = 2;
                break;

            case 4:
                var1.meta = 1;
        }
    }
}
