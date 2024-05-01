package com.smarthome.appliances;

import com.zeroc.Ice.Current;

public abstract class CloseableImpl implements SmartHome.Closeable {

    private boolean isOpen = false;

    @Override
    public boolean open(Current current) {
        isOpen = true;
        return true;
    }

    @Override
    public boolean close(Current current) {
        isOpen = false;
        return true;
    }

    @Override
    public boolean getState(Current current) {
        return isOpen;
    }
}
