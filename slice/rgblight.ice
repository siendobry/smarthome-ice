#pragma once

module SmartHome {

    exception InvalidColorRangeException {
        short badValue;
        short minValue;
        short maxValue;
        string message = "Value out of bounds";
    }

    enum RgbLightOperation {
        CLASSIC, PRESET
    }

    struct RgbLightRequest {
        RgbLightOperation operation;
        Color color;
        string presetName;
    }

    struct Color {
        short red;
        short green;
        short blue;
    }

    dictionary<string, Color> Presets;

    interface RgbLight {
        idempotent void turnOn();
        idempotent void turnOff();
        idempotent Color getColor();
        idempotent void changeColor() throws InvalidColorRangeException;
        idempotent Presets getPresets();
        void addPreset(string name, Color color);
        idempotent void editPreset(string name, Color color);
        idempotent void removePreset(string name);
    }

}