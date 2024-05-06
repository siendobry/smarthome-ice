package com.smarthome.appliances;

import com.zeroc.Ice.Current;

public class LightImpl implements SmartHome.Light {

    private boolean isTurnedOn = false;

    @Override
    synchronized public boolean turnOn(Current current) {
        isTurnedOn = true;
        return true;
    }

    @Override
    synchronized public boolean turnOff(Current current) {
        isTurnedOn = false;
        return true;
    }

    @Override
    public boolean getState(Current current) {
        return isTurnedOn;
    }
}
