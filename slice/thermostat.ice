#pragma once
#include "preset.ice"

module SmartHome {

    exception InvalidTemperatureRangeException {
        float badValue;
        float minValue; //  10.0
        float maxValue; //  35.0
        string message = "Value out of bounds";
    }

    enum ThermostatOperation {
        CLASSIC, PRESET
    }

    struct ThermostatRequest {
        ThermostatOperation operation;
        float temperature;
        string presetName;
    }

    dictionary<string, float> TemperaturePresets;

    interface Thermostat {
        idempotent float getTemperature();
        idempotent float setTemperature(ThermostatRequest request)
            throws InvalidTemperatureRangeException, NonExistentPreset;
        idempotent TemperaturePresets getPresets();
        void addPreset(string name, float temperature)
            throws InvalidTemperatureRangeException;
        idempotent void editPreset(string name, float temperature)
            throws InvalidTemperatureRangeException;
        idempotent void removePreset(string name);
    }

}