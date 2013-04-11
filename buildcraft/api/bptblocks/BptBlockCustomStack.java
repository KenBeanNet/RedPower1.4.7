package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockCustomStack extends BptBlock
{
    final ItemStack customStack;

    public BptBlockCustomStack(int var1, ItemStack var2)
    {
        super(var1);
        this.customStack = var2;
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(this.customStack.copy());
    }
}
