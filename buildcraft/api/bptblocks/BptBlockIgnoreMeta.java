package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockIgnoreMeta extends BptBlock
{
    public BptBlockIgnoreMeta(int var1)
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
}
