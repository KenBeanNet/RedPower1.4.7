package buildcraft.api.core;

import net.minecraft.world.World;

public interface IBox
{
    void expand(int var1);

    void contract(int var1);

    boolean contains(int var1, int var2, int var3);

    Position pMin();

    Position pMax();

    void createLasers(World var1, LaserKind var2);

    void deleteLasers();
}
