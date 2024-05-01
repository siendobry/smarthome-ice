package com.smarthome.appliances;

import SmartHome.Color;
import SmartHome.InvalidColorRangeException;
import SmartHome.NonExistentPreset;
import SmartHome.RgbLightRequest;
import com.zeroc.Ice.Current;

import java.util.HashMap;
import java.util.Map;

public class RgbLightImpl extends LightImpl implements SmartHome.RgbLight {

    private Color color = new Color((short) 0, (short) 0, (short) 0);
    private final Map<String, Color> presets = new HashMap<>();

    @Override
    public Color getColor(Current current) {
        return color;
    }

    @Override
    public Color changeColor(RgbLightRequest request, Current current) throws InvalidColorRangeException, NonExistentPreset {
        color = switch (request.operation) {
            case CLASSIC -> {
                for (short rgbValue : new short[]{request.color.red, request.color.green, request.color.blue}) {
                    if (rgbValue < 0 || rgbValue > 255) {
                        throw new InvalidColorRangeException(
                            rgbValue,
                            (short) 0,
                            (short) 255,
                            "RGB value out of range 0-255"
                        );
                    }
                }
                yield request.color;
            }
            case PRESET -> {
                if (presets.get(request.presetName) == null) {
                    throw new NonExistentPreset(
                        request.presetName,
                        "Preset with a given name does not exist"
                    );
                }
                yield presets.get(request.presetName);
            }
        };
        return color;
    }

    @Override
    public Map<String, Color> getPresets(Current current) {
        return presets;
    }

    @Override
    public void addPreset(String name, Color color, Current current) throws InvalidColorRangeException {
        for (short rgbValue : new short[]{color.red, color.green, color.blue}) {
            if (rgbValue < 0 || rgbValue > 255) {
                throw new InvalidColorRangeException(
                        rgbValue,
                        (short) 0,
                        (short) 255,
                        "RGB value out of range 0-255"
                );
            }
        }
        presets.put(name, color);
    }

    @Override
    public void editPreset(String name, Color color, Current current) throws InvalidColorRangeException {
        for (short rgbValue : new short[]{color.red, color.green, color.blue}) {
            if (rgbValue < 0 || rgbValue > 255) {
                throw new InvalidColorRangeException(
                        rgbValue,
                        (short) 0,
                        (short) 255,
                        "RGB value out of range 0-255"
                );
            }
        }
        presets.replace(name, color);
    }

    @Override
    public void removePreset(String name, Current current) {
        presets.remove(name);
    }
}
