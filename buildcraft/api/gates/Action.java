package buildcraft.api.gates;

public abstract class Action implements IAction
{
    protected int id;

    public Action(int var1)
    {
        this.id = var1;
        ActionManager.actions[var1] = this;
    }

    public int getId()
    {
        return this.id;
    }

    public abstract String getTexture();

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
}
