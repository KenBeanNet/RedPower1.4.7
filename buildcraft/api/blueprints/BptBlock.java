package buildcraft.api.blueprints;

import java.util.ArrayList;
import java.util.LinkedList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BptBlock
{
    public final int blockId;

    public BptBlock(int var1)
    {
        this.blockId = var1;
        BlueprintManager.blockBptProps[var1] = this;
    }

    public void addRequirements(BptSlotInfo var1, IBptContext var2, LinkedList var3)
    {
        if (var1.blockId != 0)
        {
            if (var1.storedRequirements.size() != 0)
            {
                var3.addAll(var1.storedRequirements);
            }
            else
            {
                var3.add(new ItemStack(var1.blockId, 1, var1.meta));
            }
        }
    }

    public ItemStack useItem(BptSlotInfo var1, IBptContext var2, ItemStack var3, ItemStack var4)
    {
        ItemStack var5 = var4.copy();

        if (var4.isItemStackDamageable())
        {
            if (var3.getItemDamage() + var4.getItemDamage() <= var4.getMaxDamage())
            {
                var4.setItemDamage(var3.getItemDamage() + var4.getItemDamage());
                var5.setItemDamage(var3.getItemDamage());
                var3.stackSize = 0;
            }

            if (var4.getItemDamage() >= var4.getMaxDamage())
            {
                var4.stackSize = 0;
            }
        }
        else if (var4.stackSize >= var3.stackSize)
        {
            var5.stackSize = var3.stackSize;
            var4.stackSize -= var3.stackSize;
            var3.stackSize = 0;
        }
        else
        {
            var3.stackSize -= var4.stackSize;
            var4.stackSize = 0;
        }

        if (var4.stackSize == 0 && var4.getItem().getContainerItem() != null)
        {
            Item var6 = var4.getItem().getContainerItem();
            var4.itemID = var6.itemID;
            var4.stackSize = 1;
            var4.setItemDamage(0);
        }

        return var5;
    }

    public boolean isValid(BptSlotInfo var1, IBptContext var2)
    {
        return var1.blockId == var2.world().getBlockId(var1.x, var1.y, var1.z) && var1.meta == var2.world().getBlockMetadata(var1.x, var1.y, var1.z);
    }

    public void rotateLeft(BptSlotInfo var1, IBptContext var2) {}

    public void buildBlock(BptSlotInfo var1, IBptContext var2)
    {
        var2.world().setBlockAndMetadataWithNotify(var1.x, var1.y, var1.z, var1.blockId, var1.meta);
        var2.world().setBlockMetadataWithNotify(var1.x, var1.y, var1.z, var1.meta);

        if (Block.blocksList[var1.blockId] instanceof BlockContainer)
        {
            TileEntity var3 = var2.world().getBlockTileEntity(var1.x, var1.y, var1.z);
            var1.cpt.setInteger("x", var1.x);
            var1.cpt.setInteger("y", var1.y);
            var1.cpt.setInteger("z", var1.z);

            if (var3 != null)
            {
                var3.readFromNBT(var1.cpt);
            }
        }
    }

    public boolean ignoreBuilding(BptSlotInfo var1)
    {
        return false;
    }

    public void initializeFromWorld(BptSlotInfo var1, IBptContext var2, int var3, int var4, int var5)
    {
        if (Block.blocksList[var1.blockId] instanceof BlockContainer)
        {
            TileEntity var6 = var2.world().getBlockTileEntity(var3, var4, var5);

            if (var6 != null)
            {
                var6.writeToNBT(var1.cpt);
            }
        }

        if (Block.blocksList[var1.blockId] != null)
        {
            ArrayList var7 = Block.blocksList[var1.blockId].getBlockDropped(var2.world(), var3, var4, var5, var2.world().getBlockMetadata(var3, var4, var5), 0);

            if (var7 != null)
            {
                var1.storedRequirements.addAll(var7);
            }
        }
    }

    public void postProcessing(BptSlotInfo var1, IBptContext var2) {}

    public BlockSignature getSignature(Block var1)
    {
        BlockSignature var2 = new BlockSignature();

        if (var1.blockID > 122)
        {
            var2.blockClassName = var1.getClass().getSimpleName();

            if (var1 instanceof BlockContainer)
            {
                TileEntity var3 = ((BlockContainer)var1).createNewTileEntity((World)null);

                if (var3 != null)
                {
                    var2.tileClassName = var3.getClass().getSimpleName();
                }
            }
        }

        var2.blockName = var1.getBlockName();
        var2.replaceNullWithStar();
        return var2;
    }

    public boolean match(Block var1, BlockSignature var2)
    {
        if (var1 == null)
        {
            return false;
        }
        else
        {
            BlockSignature var3 = BlueprintManager.getBlockSignature(var1);
            return this.starMatch(var2.blockName, var3.blockName) && this.starMatch(var2.blockClassName, var3.blockClassName) && this.starMatch(var2.tileClassName, var3.tileClassName) && this.starMatch(var2.customField, var3.customField) && this.starMatch(var2.mod, var3.mod);
        }
    }

    private boolean starMatch(String var1, String var2)
    {
        return var1.equals("*") || var2.equals("*") || var1.equals(var2);
    }
}
