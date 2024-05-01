import sys, Ice
import generated.SmartHome as SmartHome

if __name__ == '__main__':
    with Ice.initialize(sys.argv) as communicator:
        bedroomBlindsBase = communicator.propertyToProxy("BedroomBlinds.Proxy")
        entranceGateBase = communicator.propertyToProxy("EntranceGate.Proxy")
        garageGateBase = communicator.propertyToProxy("GarageGate.Proxy")
        bedroomLightBase = communicator.propertyToProxy("BedroomLight.Proxy")
        deskRgbLightBase = communicator.propertyToProxy("DeskRgbLight.Proxy")
        thermostatBase = communicator.propertyToProxy("Thermostat.Proxy")
        deviceInfoBase = communicator.propertyToProxy("DeviceInfo.Proxy")

        bedroomBlinds = SmartHome.CloseablePrx.checkedCast(bedroomBlindsBase)
        entranceGate = SmartHome.CloseablePrx.checkedCast(entranceGateBase)
        garageGate = SmartHome.CloseablePrx.checkedCast(garageGateBase)
        bedroomLight = SmartHome.LightPrx.checkedCast(bedroomLightBase)
        deskRgbLight = SmartHome.RgbLightPrx.checkedCast(deskRgbLightBase)
        thermostat = SmartHome.ThermostatPrx.checkedCast(thermostatBase)
        deviceInfo = SmartHome.DeviceInfoPrx.checkedCast(deviceInfoBase)

        if (       not bedroomBlinds
                or not entranceGate
                or not garageGate
                or not bedroomLight
                or not deskRgbLight
                or not thermostat):
            raise RuntimeError("Invalid proxy")

        command = True
        while command is not None:
            try:
                print("> ", end='')
                command = input()

                commandParts = command.split(' ')
                result = None

                match commandParts[0]:
                    case "bedroom/blinds":
                        match commandParts[1]:
                            case "open":
                                result = bedroomBlinds.open()
                            case "close":
                                result = bedroomBlinds.close()
                            case "state":
                                result = bedroomBlinds.getState()
                            case _:
                                print("Error: Unknown command")

                    case "entrance/gate":
                        match commandParts[1]:
                            case "open":
                                result = entranceGate.open()
                            case "close":
                                result = entranceGate.close()
                            case "state":
                                result = bedroomBlinds.getState()
                            case _:
                                print("Error: Unknown command")

                    case "garage/gate":
                        match commandParts[1]:
                            case "open":
                                result = garageGate.open()
                            case "close":
                                result = garageGate.close()
                            case "state":
                                result = bedroomBlinds.getState()
                            case _:
                                print("Error: Unknown command")

                    case "bedroom/light":
                        match commandParts[1]:
                            case "on":
                                result = bedroomLight.turnOn()
                            case "off":
                                result = bedroomLight.turnOff()
                            case "state":
                                result = bedroomBlinds.getState()
                            case _:
                                print("Error: Unknown command")

                    case "desk/rgb":
                        match commandParts[1]:
                            case "on":
                                result = deskRgbLight.turnOn()
                            case "off":
                                result = deskRgbLight.turnOff()
                            case "state":
                                result = deskRgbLight.getState()
                            case "getColor":
                                result = deskRgbLight.getColor()
                            case "setColor":
                                red, green, blue = [int(x) for x in commandParts[2].split('/')]
                                request = SmartHome.RgbLightRequest(
                                    SmartHome.RgbLightOperation.CLASSIC,
                                    color=SmartHome.Color(red, green, blue))
                                result = deskRgbLight.changeColor(request)
                            case "setPresetColor":
                                presetName = commandParts[2]
                                request = SmartHome.RgbLightRequest(
                                    SmartHome.RgbLightOperation.PRESET,
                                    presetName=presetName)
                                result = deskRgbLight.changeColor(request)
                            case "getPresets":
                                result = deskRgbLight.getPresets()
                            case "addPreset":
                                presetName = commandParts[2]
                                red, green, blue = [int(x) for x in commandParts[3].split('/')]
                                deskRgbLight.addPreset(presetName, SmartHome.Color(red, green, blue))
                            case "editPreset":
                                presetName = commandParts[2]
                                red, green, blue = [int(x) for x in commandParts[3].split('/')]
                                deskRgbLight.addPreset(presetName, SmartHome.Color(red, green, blue))
                            case "removePreset":
                                presetName = commandParts[2]
                                deskRgbLight.removePreset(presetName)
                            case _:
                                print("Error: Unknown command")

                    case "household/thermostat":
                        match commandParts[1]:
                            case "getTemp":
                                result = thermostat.getTemperature()
                            case "setTemp":
                                temperature = float(commandParts[2])
                                request = SmartHome.ThermostatRequest(
                                    SmartHome.ThermostatOperation.CLASSIC,
                                    temperature=temperature)
                                result = thermostat.setTemperature(request)
                            case "setPresetTemp":
                                presetName = commandParts[2]

                                request = SmartHome.ThermostatRequest(
                                    SmartHome.ThermostatOperation.PRESET,
                                    presetName=presetName)
                                result = thermostat.setTemperature(request)
                            case "getPresets":
                                result = thermostat.getPresets()
                            case "addPreset":
                                presetName = commandParts[2]
                                temperature = float(commandParts[3])
                                thermostat.addPreset(presetName, temperature)
                            case "editPreset":
                                presetName = commandParts[2]
                                temperature = float(commandParts[3])
                                thermostat.editPreset(presetName, temperature)
                            case "removePreset":
                                presetName = commandParts[2]
                                thermostat.removePreset(presetName)
                            case _:
                                print("Error: Unknown command")

                    case "devices":
                        result = deviceInfo.getDevices()

                    case _:
                        print("Error: Unknown command")

                print(f"Command: {command}; Result: {result}")

            except Exception as ex:
                print(ex)
