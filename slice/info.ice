#pragma once

module SmartHome {

    sequence<string> DeviceIds;

    interface DeviceInfo {
        void setDevices();
        DeviceIds getDevices();
    }

}