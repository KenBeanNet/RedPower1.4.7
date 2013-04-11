package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class BptBlockDirt extends BptBlock
{
    public BptBlockDirt(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(Block.dirt));
    }

    public void buildBlock(BptSlotInfo var1, IBptContext var2)
    {
        var2.world().setBlockAndMetadataWithNotify(var1.x, var1.y, var1.z, Block.dirt.blockID, var1.meta);
    }

    public boolean isValid(BptSlotInfo var1, IBptContext var2)
    {
        int var3 = var2.world().getBlockId(var1.x, var1.y, var1.z);
        return var3 == Block.dirt.blockID || var3 == Block.grass.blockID || var3 == Block.tilledField.blockID;
    }
}
