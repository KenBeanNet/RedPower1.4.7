package buildcraft.api.transport;

import buildcraft.api.core.Position;
import buildcraft.api.core.SafeTimeTracker;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public interface IPipedItem
{
    void remove();

    void setWorld(World var1);

    Position getPosition();

    void setPosition(double var1, double var3, double var5);

    float getSpeed();

    void setSpeed(float var1);

    ItemStack getItemStack();

    void setItemStack(ItemStack var1);

    TileEntity getContainer();

    void setContainer(TileEntity var1);

    @Deprecated
    SafeTimeTracker getSynchroTracker();

    @Deprecated
    void setSynchroTracker(SafeTimeTracker var1);

    @Deprecated
    int getDeterministicRandomization();

    @Deprecated
    void setDeterministicRandomization(int var1);

    int getEntityId();

    void setEntityId(int var1);

    void readFromNBT(NBTTagCompound var1);

    void writeToNBT(NBTTagCompound var1);

    EntityItem toEntityItem(ForgeDirection var1);

    float getEntityBrightness(float var1);

    boolean isCorrupted();

    void addContribution(String var1, IPassiveItemContribution var2);

    IPassiveItemContribution getContribution(String var1);

    boolean hasContributions();
}
