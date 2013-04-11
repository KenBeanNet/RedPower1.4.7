package buildcraft.api.transport;

import buildcraft.api.transport.IPipe$WireColor;
import net.minecraft.tileentity.TileEntity;

public interface IPipe
{
    boolean isWired(IPipe$WireColor var1);

    boolean hasInterface();

    TileEntity getContainer();

    boolean isWireConnectedTo(TileEntity var1, IPipe$WireColor var2);
}
