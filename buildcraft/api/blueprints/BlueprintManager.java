package buildcraft.api.blueprints;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlueprintManager
{
    public static BptBlock[] blockBptProps = new BptBlock[Block.blocksList.length];

    public static ItemSignature getItemSignature(Item var0)
    {
        ItemSignature var1 = new ItemSignature();

        if (var0.itemID >= Block.blocksList.length + 126)
        {
            var1.itemClassName = var0.getClass().getSimpleName();
        }

        var1.itemName = var0.getItemNameIS(new ItemStack(var0));
        return var1;
    }

    public static BlockSignature getBlockSignature(Block var0)
    {
        return blockBptProps[0].getSignature(var0);
    }

    static
    {
        for (int var0 = 0; var0 < blockBptProps.length; ++var0)
        {
            new BptBlock(var0);
        }
    }
}
