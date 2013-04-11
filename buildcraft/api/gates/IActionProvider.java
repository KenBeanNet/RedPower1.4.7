package buildcraft.api.gates;

import java.util.LinkedList;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public interface IActionProvider
{
    LinkedList getNeighborActions(Block var1, TileEntity var2);
}
