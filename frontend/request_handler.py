import generated.SmartHome as SmartHome


class RequestHandler:

    def __init__(self, communicator):
        self.communicator = communicator
        self.devices = {}

    def handle_closeable(self, deviceId, operation):
        if self.devices.get(deviceId) is None:
            base = self.communicator.stringToProxy(deviceId)
            self.devices[deviceId] = SmartHome.CloseablePrx.checkedCast(base)
        device = self.devices[deviceId]

        result = None

        match operation:
            case "open":
                if device.open():
                    result = f"{deviceId} opened successfully"
                else:
                    result = f"could not open {deviceId}"
            case "close":
                if device.close():
                    result = f"{deviceId} closed successfully"
                else:
                    result = f"could not close {deviceId}"
            case "state":
                if device.getState():
                    result = f"{deviceId} is opened"
                else:
                    result = f"{deviceId} is closed"
            case _:
                raise Exception(f"UnsupportedOperationException: '{deviceId}' does not support '{operation}' operation")

        return result

    def handle_light(self, deviceId, operation):
        if self.devices.get(deviceId) is None:
            base = self.communicator.stringToProxy(deviceId)
            self.devices[deviceId] = SmartHome.LightPrx.checkedCast(base)
        device = self.devices[deviceId]

        result = None

        match operation:
            case "on":
                if device.turnOn():
                    result = f"{deviceId} turned on successfully"
                else:
                    result = f"could turn on {deviceId}"
            case "off":
                if device.turnOff():
                    result = f"{deviceId} turned off successfully"
                else:
                    result = f"could not turn off {deviceId}"
            case "state":
                if device.getState():
                    result = f"{deviceId} is turned on"
                else:
                    result = f"{deviceId} is turned off"
            case _:
                raise Exception(f"UnsupportedOperationException: '{deviceId}' does not support '{operation}' operation")

        return result

    def handle_rgb(self, deviceId, operation, params):
        if self.devices.get(deviceId) is None:
            base = self.communicator.stringToProxy(deviceId)
            self.devices[deviceId] = SmartHome.RgbLightPrx.checkedCast(base)
        device = self.devices[deviceId]

        result = None

        match operation:
            case "on":
                if device.turnOn():
                    result = f"{deviceId} turned on successfully"
                else:
                    result = f"could turn on {deviceId}"
            case "off":
                if device.turnOff():
                    result = f"{deviceId} turned off successfully"
                else:
                    result = f"could not turn off {deviceId}"
            case "state":
                if device.getState():
                    result = f"{deviceId} is turned on"
                else:
                    result = f"{deviceId} is turned off"
            case "getColor":
                color = device.getColor()
                result = f"Currently set color: rgb({color.red}, {color.green}, {color.blue})"
            case "setColor":
                red, green, blue = [int(x) for x in params[0].split('/')]
                request = SmartHome.RgbLightRequest(
                    SmartHome.RgbLightOperation.CLASSIC,
                    color=SmartHome.Color(red, green, blue))
                color = device.setColor(request)
                result = f"Color set to: rgb({color.red}, {color.green}, {color.blue})"
            case "setPresetColor":
                presetName = params[0]
                request = SmartHome.RgbLightRequest(
                    SmartHome.RgbLightOperation.PRESET,
                    presetName=presetName)
                color = device.setColor(request)
                result = f"Color set to: rgb({color.red}, {color.green}, {color.blue})"
            case "getPresets":
                presets = device.getPresets()
                presetList = []
                for preset in presets:
                    color = presets[preset]
                    presetList.append(f"{preset}: rgb({color.red}, {color.green}, {color.blue})")
                result = f"Presets: {", ".join(presetList)}"
            case "addPreset":
                presetName = params[0]
                red, green, blue = [int(x) for x in params[1].split('/')]
                device.addPreset(presetName, SmartHome.Color(red, green, blue))
                result = "Ok"
            case "editPreset":
                presetName = params[0]
                red, green, blue = [int(x) for x in params[1].split('/')]
                device.editPreset(presetName, SmartHome.Color(red, green, blue))
                result = "Ok"
            case "removePreset":
                presetName = params[0]
                device.removePreset(presetName)
                result = "Ok"
            case _:
                raise Exception(f"UnsupportedOperationException: '{deviceId}' does not support '{operation}' operation")

        return result

    def handle_thermostat(self, deviceId, operation, params):
        if self.devices.get(deviceId) is None:
            base = self.communicator.stringToProxy(deviceId)
            self.devices[deviceId] = SmartHome.ThermostatPrx.checkedCast(base)
        device = self.devices[deviceId]

        result = None

        match operation:
            case "getTemp":
                temperature = device.getTemperature()
                result = f"Currently set temperature: {temperature}"
            case "setTemp":
                temperature = float(params[0])
                request = SmartHome.ThermostatRequest(
                    SmartHome.ThermostatOperation.CLASSIC,
                    temperature=temperature)
                temperature = device.setTemperature(request)
                result = f"Temperature set to: {temperature}"
            case "setPresetTemp":
                presetName = params[0]
                request = SmartHome.ThermostatRequest(
                    SmartHome.ThermostatOperation.PRESET,
                    presetName=presetName)
                temperature = device.setTemperature(request)
                result = f"Temperature set to: {temperature}"
            case "getPresets":
                result = device.getPresets()
            case "addPreset":
                presetName = params[0]
                temperature = float(params[1])
                device.addPreset(presetName, temperature)
                result = "Ok"
            case "editPreset":
                presetName = params[0]
                temperature = float(params[1])
                device.editPreset(presetName, temperature)
                result = "Ok"
            case "removePreset":
                presetName = params[0]
                device.removePreset(presetName)
                result = "Ok"
            case _:
                raise Exception(f"UnsupportedOperationException: '{deviceId}' does not support '{operation}' operation")

        return result

    def handle_info(self, deviceId):
        if self.devices.get(deviceId) is None:
            base = self.communicator.stringToProxy(deviceId)
            self.devices[deviceId] = SmartHome.DeviceInfoPrx.checkedCast(base)
        device = self.devices[deviceId]

        floorSuffix = '@' + deviceId.split('@')[1]
        availableDevices = [x + floorSuffix for x in device.getDevices()]
        result = f"Available devices: {", ".join(availableDevices)}"

        return result