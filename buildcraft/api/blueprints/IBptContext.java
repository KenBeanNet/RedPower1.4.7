package buildcraft.api.blueprints;

import buildcraft.api.core.IBox;
import buildcraft.api.core.Position;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IBptContext
{
    ItemStack mapItemStack(ItemStack var1);

    int mapWorldId(int var1);

    void storeId(int var1);

    Position rotatePositionLeft(Position var1);

    IBox surroundingBox();

    World world();
}
