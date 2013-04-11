package buildcraft.api.blueprints;

public class BlockSignature
{
    public String blockClassName;
    public String tileClassName;
    public String blockName;
    public String mod;
    public String modVersion;
    public String customField;

    public BlockSignature(String var1)
    {
        String[] var2 = var1.split("/");
        int var3 = 0;

        if (var2[0].equals("#B"))
        {
            ++var3;
        }

        this.blockClassName = var2[var3];
        this.tileClassName = var2[var3 + 1];
        this.blockName = var2[var3 + 2];
        this.mod = var2[var3 + 3];
        this.modVersion = var2[var3 + 4];
        this.customField = var2[var3 + 5];
        this.replaceNullWithStar();
    }

    public BlockSignature()
    {
        this.replaceNullWithStar();
    }

    public String toString()
    {
        this.replaceNullWithStar();
        return "#B/" + this.blockClassName + "/" + this.tileClassName + "/" + this.blockName + "/" + this.mod + "/" + this.modVersion + "/" + this.customField;
    }

    public void replaceNullWithStar()
    {
        if (this.blockClassName == null)
        {
            this.blockClassName = "*";
        }

        if (this.tileClassName == null)
        {
            this.tileClassName = "*";
        }

        if (this.blockName == null)
        {
            this.blockName = "*";
        }

        if (this.mod == null)
        {
            this.mod = "*";
        }

        if (this.modVersion == null)
        {
            this.modVersion = "*";
        }

        if (this.customField == null)
        {
            this.customField = "*";
        }
    }
}
