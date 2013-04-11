package buildcraft.api.gates;

import net.minecraft.tileentity.TileEntity;

public abstract class Trigger implements ITrigger
{
    protected int id;

    public Trigger(int var1)
    {
        this.id = var1;
        ActionManager.triggers[var1] = this;
    }

    public int getId()
    {
        return this.id;
    }

    public abstract String getTextureFile();

    public int getIndexInTexture()
    {
        return 0;
    }

    public boolean hasParameter()
    {
        return false;
    }

    public String getDescription()
    {
        return "";
    }

    public boolean isTriggerActive(TileEntity var1, ITriggerParameter var2)
    {
        return false;
    }

    public final ITriggerParameter createParameter()
    {
        return new TriggerParameter();
    }
}
