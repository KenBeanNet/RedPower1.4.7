package buildcraft.api.transport;

import buildcraft.api.transport.IPipe$WireColor;

class IPipe$1
{
    static final int[] $SwitchMap$buildcraft$api$transport$IPipe$WireColor = new int[IPipe$WireColor.values().length];

    static
    {
        try
        {
            $SwitchMap$buildcraft$api$transport$IPipe$WireColor[IPipe$WireColor.Red.ordinal()] = 1;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            $SwitchMap$buildcraft$api$transport$IPipe$WireColor[IPipe$WireColor.Blue.ordinal()] = 2;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            $SwitchMap$buildcraft$api$transport$IPipe$WireColor[IPipe$WireColor.Green.ordinal()] = 3;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
