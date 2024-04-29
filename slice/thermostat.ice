#pragma once

module SmartHome {

    exception InvalidTemperatureRangeException {
        short badValue;
        short minValue; //  10
        short maxValue; //  35
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

    dictionary<string, float> Presets;

    interface Thermostat {
        idempotent float getTemperature();
        idempotent void setTemperature(ThermostatRequest request);
        idempotent Presets getPresets();
        void addPreset(string name, float temperature);
        idempotent editPreset(string name, float temperature);
        idempotent void removePreset(string name);
    }

}