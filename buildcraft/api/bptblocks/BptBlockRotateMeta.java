package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;

public class BptBlockRotateMeta extends BptBlock
{
    int[] rot;
    boolean rotateForward;
    int infoMask = 0;

    public BptBlockRotateMeta(int var1, int[] var2, boolean var3)
    {
        super(var1);
        this.rot = var2;

        for (int var4 = 0; var4 < this.rot.length; ++var4)
        {
            if (this.rot[var4] < 4)
            {
                this.infoMask = this.infoMask < 3 ? 3 : this.infoMask;
            }
            else if (this.rot[var4] < 8)
            {
                this.infoMask = this.infoMask < 7 ? 7 : this.infoMask;
            }
            else if (this.rot[var4] < 16)
            {
                this.infoMask = this.infoMask < 15 ? 15 : this.infoMask;
            }
        }

        this.rotateForward = var3;
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
        int var3 = var1.meta & this.infoMask;
        int var4 = var1.meta - var3;

        if (this.rotateForward)
        {
            if (var3 == this.rot[0])
            {
                var3 = this.rot[1];
            }
            else if (var3 == this.rot[1])
            {
                var3 = this.rot[2];
            }
            else if (var3 == this.rot[2])
            {
                var3 = this.rot[3];
            }
            else if (var3 == this.rot[3])
            {
                var3 = this.rot[0];
            }
        }
        else if (var3 == this.rot[0])
        {
            var3 = this.rot[3];
        }
        else if (var3 == this.rot[1])
        {
            var3 = this.rot[2];
        }
        else if (var3 == this.rot[2])
        {
            var3 = this.rot[0];
        }
        else if (var3 == this.rot[3])
        {
            var3 = this.rot[1];
        }

        var1.meta = var3 + var4;
    }
}
