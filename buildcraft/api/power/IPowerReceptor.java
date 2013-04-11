package buildcraft.api.power;

public interface IPowerReceptor
{
    void setPowerProvider(IPowerProvider var1);

    IPowerProvider getPowerProvider();

    void doWork();

    int powerRequest();
}
