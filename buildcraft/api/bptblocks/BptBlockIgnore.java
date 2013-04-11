package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockIgnore extends BptBlock
{
    public BptBlockIgnore(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(var1.blockId, 0, 0));
    }

    public boolean isValid(BptSlotInfo var1, IBptContext var2)
    {
        return true;
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2) {}

    public boolean ignoreBuilding(BptSlotInfo var1)
    {
        return true;
    }
}
