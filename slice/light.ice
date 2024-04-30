#pragma once

module SmartHome {

    interface Light {
        idempotent bool turnOn();
        idempotent bool turnOff();
        idempotent bool getState();
    }

}