//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `rgblight.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public enum RgbLightOperation implements java.io.Serializable
{
    CLASSIC(0),
    PRESET(1);

    public int value()
    {
        return _value;
    }

    public static RgbLightOperation valueOf(int v)
    {
        switch(v)
        {
        case 0:
            return CLASSIC;
        case 1:
            return PRESET;
        }
        return null;
    }

    private RgbLightOperation(int v)
    {
        _value = v;
    }

    public void ice_write(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeEnum(_value, 1);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, RgbLightOperation v)
    {
        if(v == null)
        {
            ostr.writeEnum(SmartHome.RgbLightOperation.CLASSIC.value(), 1);
        }
        else
        {
            ostr.writeEnum(v.value(), 1);
        }
    }

    public static RgbLightOperation ice_read(com.zeroc.Ice.InputStream istr)
    {
        int v = istr.readEnum(1);
        return validate(v);
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<RgbLightOperation> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    public static void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, RgbLightOperation v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            ice_write(ostr, v);
        }
    }

    public static java.util.Optional<RgbLightOperation> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.Size))
        {
            return java.util.Optional.of(ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static RgbLightOperation validate(int v)
    {
        final RgbLightOperation e = valueOf(v);
        if(e == null)
        {
            throw new com.zeroc.Ice.MarshalException("enumerator value " + v + " is out of range");
        }
        return e;
    }

    private final int _value;
}
