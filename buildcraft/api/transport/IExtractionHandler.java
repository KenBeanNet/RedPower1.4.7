package buildcraft.api.transport;

import net.minecraft.world.World;

public interface IExtractionHandler
{
    boolean canExtractItems(IPipe var1, World var2, int var3, int var4, int var5);

    boolean canExtractLiquids(IPipe var1, World var2, int var3, int var4, int var5);
}
