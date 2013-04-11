package buildcraft.api.gates;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public interface ITriggerDirectional extends ITrigger
{
    boolean isTriggerActive(ForgeDirection var1, TileEntity var2, ITriggerParameter var3);
}
