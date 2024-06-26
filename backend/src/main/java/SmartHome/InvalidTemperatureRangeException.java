//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `thermostat.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public class InvalidTemperatureRangeException extends com.zeroc.Ice.UserException
{
    public InvalidTemperatureRangeException()
    {
        this.message = "Value out of bounds";
    }

    public InvalidTemperatureRangeException(Throwable cause)
    {
        super(cause);
        this.message = "Value out of bounds";
    }

    public InvalidTemperatureRangeException(float badValue, float minValue, float maxValue, String message)
    {
        this.badValue = badValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.message = message;
    }

    public InvalidTemperatureRangeException(float badValue, float minValue, float maxValue, String message, Throwable cause)
    {
        super(cause);
        this.badValue = badValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.message = message;
    }

    public String ice_id()
    {
        return "::SmartHome::InvalidTemperatureRangeException";
    }

    public float badValue;

    public float minValue;

    public float maxValue;

    public String message;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::SmartHome::InvalidTemperatureRangeException", -1, true);
        ostr_.writeFloat(badValue);
        ostr_.writeFloat(minValue);
        ostr_.writeFloat(maxValue);
        ostr_.writeString(message);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        badValue = istr_.readFloat();
        minValue = istr_.readFloat();
        maxValue = istr_.readFloat();
        message = istr_.readString();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = -1806940431L;
}
