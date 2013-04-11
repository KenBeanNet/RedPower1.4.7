package buildcraft.api.filler;

import buildcraft.api.core.IBox;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public interface IFillerPattern
{
    int getId();

    void setId(int var1);

    boolean iteratePattern(TileEntity var1, IBox var2, ItemStack var3);

    String getTextureFile();

    int getTextureIndex();

    String getName();
}
