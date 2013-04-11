package buildcraft.api.blueprints;

import java.util.LinkedList;
import net.minecraft.nbt.NBTTagCompound;

public class BptSlotInfo
{
    public int blockId = 0;
    public int meta = 0;
    public int x;
    public int y;
    public int z;
    public LinkedList storedRequirements = new LinkedList();
    public NBTTagCompound cpt = new NBTTagCompound();

    public BptSlotInfo clone()
    {
        BptSlotInfo var1 = new BptSlotInfo();
        var1.x = this.x;
        var1.y = this.y;
        var1.z = this.z;
        var1.blockId = this.blockId;
        var1.meta = this.meta;
        var1.cpt = (NBTTagCompound)this.cpt.copy();
        return var1;
    }
}
