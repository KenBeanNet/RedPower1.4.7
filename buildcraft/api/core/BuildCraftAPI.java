package buildcraft.api.core;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BuildCraftAPI
{
    @Deprecated
    public static final int BUCKET_VOLUME = 1000;
    public static final int LAST_ORIGINAL_BLOCK = 122;
    public static final int LAST_ORIGINAL_ITEM = 126;
    public static final boolean[] softBlocks = new boolean[Block.blocksList.length];

    @Deprecated
    public static boolean softBlock(int var0)
    {
        return var0 == 0 || softBlocks[var0] || Block.blocksList[var0] == null;
    }

    @Deprecated
    public static boolean unbreakableBlock(int var0)
    {
        return var0 == Block.bedrock.blockID || var0 == Block.lavaStill.blockID || var0 == Block.lavaMoving.blockID;
    }

    @Deprecated
    public static void breakBlock(World var0, int var1, int var2, int var3)
    {
        int var4 = var0.getBlockId(var1, var2, var3);

        if (var4 != 0)
        {
            Block.blocksList[var4].dropBlockAsItem(var0, var1, var2, var3, var0.getBlockMetadata(var1, var2, var3), 0);
        }

        var0.setBlockWithNotify(var1, var2, var3, 0);
    }
}
