package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BlockSignature;
import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BptBlockSign extends BptBlock
{
    boolean isWall;

    public BptBlockSign(int var1, boolean var2)
    {
        super(var1);
        this.isWall = var2;
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        var3.add(new ItemStack(Item.sign));
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        if (!this.isWall)
        {
            double var3 = (double)var1.meta * 360.0D / 16.0D;
            var3 += 90.0D;

            if (var3 >= 360.0D)
            {
                var3 -= 360.0D;
            }

            var1.meta = (int)(var3 / 360.0D * 16.0D);
        }
    }

    public BlockSignature getSignature(Block var1)
    {
        BlockSignature var2 = super.getSignature(var1);

        if (this.isWall)
        {
            var2.customField = "wall";
        }
        else
        {
            var2.customField = "floor";
        }

        return var2;
    }
}
