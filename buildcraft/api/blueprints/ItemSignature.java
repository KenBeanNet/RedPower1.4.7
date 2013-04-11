package buildcraft.api.blueprints;

public class ItemSignature
{
    public String itemClassName;
    public String itemName;

    public ItemSignature(String var1)
    {
        String[] var2 = var1.split("/");
        this.itemClassName = var2[1];
        this.itemName = var2[2];
        this.replaceNullWithStar();
    }

    public ItemSignature()
    {
        this.replaceNullWithStar();
    }

    public String toString()
    {
        this.replaceNullWithStar();
        return "#I/" + this.itemClassName + "/" + this.itemName;
    }

    public void replaceNullWithStar()
    {
        if (this.itemClassName == null)
        {
            this.itemClassName = "*";
        }

        if (this.itemName == null)
        {
            this.itemName = "*";
        }
    }
}
