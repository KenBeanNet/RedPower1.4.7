package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BptBlockBed extends BptBlock
{
    public BptBlockBed(int var1)
    {
        super(var1);
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        if ((var1.meta & 8) == 0)
        {
            var3.add(new ItemStack(Item.bed));
        }
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        int var3 = var1.meta & 7;
        int var4 = var1.meta - var3;

        switch (var3)
        {
            case 0:
                var1.meta = 1 + var4;
                break;

            case 1:
                var1.meta = 2 + var4;
                break;

            case 2:
                var1.meta = 3 + var4;
                break;

            case 3:
                var1.meta = 0 + var4;
        }
    }

    public void buildBlock(BptSlotInfo var1, IBptContext var2)
    {
        if ((var1.meta & 8) == 0)
        {
            var2.world().setBlockAndMetadataWithNotify(var1.x, var1.y, var1.z, var1.blockId, var1.meta);
            int var3 = var1.x;
            int var4 = var1.z;

            switch (var1.meta)
            {
                case 0:
                    ++var4;
                    break;

                case 1:
                    --var3;
                    break;

                case 2:
                    --var4;
                    break;

                case 3:
                    ++var3;
            }

            var2.world().setBlockAndMetadataWithNotify(var3, var1.y, var4, var1.blockId, var1.meta + 8);
        }
    }

    public boolean ignoreBuilding(BptSlotInfo var1)
    {
        return (var1.meta & 8) != 0;
    }
}
