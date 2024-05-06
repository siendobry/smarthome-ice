import sys, Ice
import generated.SmartHome as SmartHome
from request_handler import RequestHandler

# TODO: Implement operation not supported exception
if __name__ == '__main__':
    with Ice.initialize(sys.argv) as communicator:
        requestHandler = RequestHandler(communicator)

        print("> ", end='')
        command = input()

        while command is not None and command != '':
            try:
                device, *params = command.split(' ')
                operation = None

                if len(params) > 0:
                    operation = params[0]
                    params = params[1:]

                result = None

                if device.find("blind") != -1 or device.find("gate") != -1:
                    result = requestHandler.handle_closeable(device, operation)
                elif device.find("light") != -1:
                    result = requestHandler.handle_light(device, operation)
                elif device.find("rgb") != -1:
                    result = requestHandler.handle_rgb(device, operation, params)
                elif device.find("thermostat") != -1:
                    result = requestHandler.handle_thermostat(device, operation, params)
                elif device.find("devices") != -1:
                    result = requestHandler.handle_info(device)
                else:
                    raise Exception(f"{device} is not a proper identifier.")

                print(result)

            except Ice.ObjectNotExistException as ex:
                # print(f"ObjectNotExistException: Object '{ex.id.category}/{ex.id.name}' does not exist.")
                print(f"ObjectNotExistException: Device with identifier '{ex.id.category}/{ex.id.name}' does not exist on specified floor.")
            except Ice.NotRegisteredException as ex:
                # print(f"NotRegisteredException: Object of type '{ex.kindOfObject}' with id '{ex.id}' is not registered")
                print(f"NotRegisteredException: Specified floor is not registered")
            except SmartHome.NonExistentPreset as ex: # TODO: Change name to include Exception suffix
                print(f"NonExistentPreset: Preset ex.badName does not exist.")
            except SmartHome.InvalidColorRangeException as ex:
                print(f"InvalidColorRangeException: value '{ex.badValue}' is out of range ({ex.minValue}-{ex.maxValue})")
            except SmartHome.InvalidTemperatureRangeException as ex:
                print(f"InvalidTemperatureRangeException: value '{ex.badValue}' is out of range ({ex.minValue}-{ex.maxValue})")
            except Exception as ex:
                print(ex)

            finally:
                print("> ", end='')
                command = input()
