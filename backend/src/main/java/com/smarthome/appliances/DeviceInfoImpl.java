package com.smarthome.appliances;

import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

import java.util.List;

public class DeviceInfoImpl implements SmartHome.DeviceInfo {

    private final List<Identity> deviceIdentities;

    public DeviceInfoImpl(List<Identity> ids) {
        this.deviceIdentities = ids;
    }

    @Override
    public String[] getDevices(Current current) {
        String[] devicesInfo = new String[deviceIdentities.size()];

        for (int i = 0; i < deviceIdentities.size(); ++i) {
            devicesInfo[i] = deviceIdentities.get(i).category + '/' + deviceIdentities.get(i).name;
        }

        return devicesInfo;
    }
}
