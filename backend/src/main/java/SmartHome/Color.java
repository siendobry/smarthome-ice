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

public class Color implements java.lang.Cloneable,
                              java.io.Serializable
{
    public short red;

    public short green;

    public short blue;

    public Color()
    {
    }

    public Color(short red, short green, short blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Color r = null;
        if(rhs instanceof Color)
        {
            r = (Color)rhs;
        }

        if(r != null)
        {
            if(this.red != r.red)
            {
                return false;
            }
            if(this.green != r.green)
            {
                return false;
            }
            if(this.blue != r.blue)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::Color");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, red);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, green);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, blue);
        return h_;
    }

    public Color clone()
    {
        Color c = null;
        try
        {
            c = (Color)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeShort(this.red);
        ostr.writeShort(this.green);
        ostr.writeShort(this.blue);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.red = istr.readShort();
        this.green = istr.readShort();
        this.blue = istr.readShort();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Color v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public Color ice_read(com.zeroc.Ice.InputStream istr)
    {
        Color v = new Color();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Color> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Color v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            ostr.writeSize(6);
            ice_write(ostr, v);
        }
    }

    static public java.util.Optional<Color> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            istr.skipSize();
            return java.util.Optional.of(Color.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Color _nullMarshalValue = new Color();

    /** @hidden */
    public static final long serialVersionUID = -449802799L;
}
