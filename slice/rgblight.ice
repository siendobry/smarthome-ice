#pragma once
#include "light.ice"
#include "preset.ice"

module SmartHome {

    exception InvalidColorRangeException {
        short badValue;
        short minValue;
        short maxValue;
        string message = "Value out of bounds";
    }

    struct Color {
        short red;
        short green;
        short blue;
    }

    enum RgbLightOperation {
        CLASSIC, PRESET
    }

    struct RgbLightRequest {
        RgbLightOperation operation;
        Color color;
        string presetName;
    }

    dictionary<string, Color> ColorPresets;

    interface RgbLight extends Light {
        idempotent Color getColor();
        idempotent Color changeColor(RgbLightRequest request)
            throws InvalidColorRangeException, NonExistentPreset;
        idempotent ColorPresets getPresets();
        void addPreset(string name, Color color)
            throws InvalidColorRangeException;
        idempotent void editPreset(string name, Color color)
            throws InvalidColorRangeException;
        idempotent void removePreset(string name);
    }

}