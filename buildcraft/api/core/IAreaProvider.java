package buildcraft.api.core;

public interface IAreaProvider
{
    int xMin();

    int yMin();

    int zMin();

    int xMax();

    int yMax();

    int zMax();

    void removeFromWorld();
}
