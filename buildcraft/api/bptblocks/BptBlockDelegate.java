package buildcraft.api.bptblocks;

import buildcraft.api.blueprints.BlueprintManager;
import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;
import java.util.LinkedList;

public class BptBlockDelegate extends BptBlock
{
    final int delegateTo;

    public BptBlockDelegate(int var1, int var2)
    {
        super(var1);
        this.delegateTo = var2;
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        BptSlotInfo var4 = var1.clone();
        var1.blockId = this.delegateTo;

        if (BlueprintManager.blockBptProps[this.delegateTo] != null)
        {
            BlueprintManager.blockBptProps[this.delegateTo].addRequirements(var4, var2, var3);
        }
        else
        {
            super.addRequirements(var4, var2, var3);
        }
    }

    public boolean isValid(BptSlotInfo var1, IBptContext var2)
    {
        BptSlotInfo var3 = var1.clone();
        var1.blockId = this.delegateTo;
        return BlueprintManager.blockBptProps[this.delegateTo] != null ? BlueprintManager.blockBptProps[this.delegateTo].isValid(var3, var2) : super.isValid(var3, var2);
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2)
    {
        BptSlotInfo var3 = var1.clone();
        var1.blockId = this.delegateTo;

        if (BlueprintManager.blockBptProps[this.delegateTo] != null)
        {
            BlueprintManager.blockBptProps[this.delegateTo].rotateLeft(var3, var2);
        }
        else
        {
            super.rotateLeft(var3, var2);
        }
    }
}
