package com.smarthome.appliances;

import SmartHome.InvalidTemperatureRangeException;
import SmartHome.NonExistentPreset;
import SmartHome.ThermostatRequest;
import com.zeroc.Ice.Current;

import java.util.HashMap;
import java.util.Map;

public class ThermostatImpl implements SmartHome.Thermostat {

    private float temperature = 20f;
    private final Map<String, Float> presets = new HashMap<>();

    @Override
    public float getTemperature(Current current) {
        return temperature;
    }

    @Override
    public float setTemperature(ThermostatRequest request, Current current) throws InvalidTemperatureRangeException, NonExistentPreset {
        temperature = switch (request.operation) {
            case CLASSIC -> {
                if (request.temperature < 10f || request.temperature > 35f) {
                    throw new InvalidTemperatureRangeException(
                        request.temperature,
                        10f,
                        35f,
                        "Temperature value out of permitted range 10-35"
                    );
                }
                yield request.temperature;
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
        return temperature;
    }

    @Override
    public Map<String, Float> getPresets(Current current) {
        return presets;
    }

    @Override
    public void addPreset(String name, float temperature, Current current) throws InvalidTemperatureRangeException {
        if (temperature < 10f || temperature > 35f) {
            throw new InvalidTemperatureRangeException(
                temperature,
                10f,
                35f,
                "Temperature value out of permitted range 10-35"
            );
        }
        presets.put(name, temperature);
    }

    @Override
    public void editPreset(String name, float temperature, Current current) throws InvalidTemperatureRangeException {
        if (temperature < 10f || temperature > 35f) {
            throw new InvalidTemperatureRangeException(
                temperature,
                10f,
                35f,
                "Temperature value out of permitted range 10-35"
            );
        }
        presets.replace(name, temperature);
    }

    @Override
    public void removePreset(String name, Current current) {
        presets.remove(name);
    }
}
