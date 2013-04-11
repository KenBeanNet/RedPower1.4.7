package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockLiquid extends BptBlock
{
    private final ItemStack bucketStack;

    public BptBlockLiquid(int var1, ItemStack var2)
    {
        super(var1);
        this.bucketStack = var2;
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        if (var1.meta == 0)
        {
            var3.add(this.bucketStack.copy());
        }
    }

    public boolean isValid(BptSlotInfo var1, IBptContext var2)
    {
        return var1.meta != 0 ? true : var1.blockId == var2.world().getBlockId(var1.x, var1.y, var1.z) && var2.world().getBlockMetadata(var1.x, var1.y, var1.z) == 0;
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2) {}

    public boolean ignoreBuilding(BptSlotInfo var1)
    {
        return var1.meta != 0;
    }

    public void buildBlock(BptSlotInfo var1, IBptContext var2)
    {
        if (var1.meta == 0)
        {
            var2.world().setBlockAndMetadataWithNotify(var1.x, var1.y, var1.z, var1.blockId, 0);
        }
    }
}
