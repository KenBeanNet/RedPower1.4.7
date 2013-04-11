package buildcraft.api.transport;

import buildcraft.api.transport.IPipe$1;

public enum IPipe$WireColor
{
    Red,
    Blue,
    Green,
    Yellow;

    public IPipe$WireColor reverse()
    {
        switch (IPipe$1.$SwitchMap$buildcraft$api$transport$IPipe$WireColor[this.ordinal()])
        {
            case 1:
                return Yellow;

            case 2:
                return Green;

            case 3:
                return Blue;

            default:
                return Red;
        }
    }
}
