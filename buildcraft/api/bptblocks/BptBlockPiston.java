package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;

public class BptBlockPiston extends BptBlockRotateMeta
{
    public BptBlockPiston(int var1)
    {
        super(var1, new int[] {2, 5, 3, 4}, true);
    }

    public void buildBlock(BptSlotInfo var1, IBptContext var2)
    {
        int var3 = var1.meta & 7;
        var2.world().setBlockAndMetadataWithNotify(var1.x, var1.y, var1.z, var1.blockId, var3);
    }
}
