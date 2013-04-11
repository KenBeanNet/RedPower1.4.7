package buildcraft.api.gates;

import net.minecraft.tileentity.TileEntity;

public interface ITrigger
{
    int getId();

    String getTextureFile();

    int getIndexInTexture();

    boolean hasParameter();

    String getDescription();

    boolean isTriggerActive(TileEntity var1, ITriggerParameter var2);

    ITriggerParameter createParameter();
}
