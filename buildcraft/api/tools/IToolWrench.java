package buildcraft.api.tools;

import net.minecraft.entity.player.EntityPlayer;

public interface IToolWrench
{
    boolean canWrench(EntityPlayer var1, int var2, int var3, int var4);

    void wrenchUsed(EntityPlayer var1, int var2, int var3, int var4);
}
