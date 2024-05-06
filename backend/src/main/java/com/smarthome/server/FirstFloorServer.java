package com.smarthome.server;

import com.smarthome.appliances.*;
import com.zeroc.Ice.*;

import java.lang.Exception;

public class FirstFloorServer extends AbstractServer {

    public static void main(String[] args) {
        FirstFloorServer smartHomeServer = new FirstFloorServer();
        smartHomeServer.start(args);
    }

    public void start(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            adapter = communicator.createObjectAdapter("FirstFloor");

            Gate entranceGate = new Gate();
            Gate garageGate = new Gate();
            ThermostatImpl thermostat = new ThermostatImpl();
            DeviceInfoImpl deviceInfo = new DeviceInfoImpl(identityList);

            addServantMapping(entranceGate, new Identity("gate", "entrance"));
            addServantMapping(garageGate, new Identity("gate", "garage"));
            addServantMapping(thermostat, new Identity("thermostat", "household"));
            adapter.add(deviceInfo, new Identity("devices", null));

            adapter.activate();

            System.out.println("Entering listen loop...");
            communicator.waitForShutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

}
