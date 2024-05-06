package com.smarthome;

import com.smarthome.appliances.*;
import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ObjectAdapter adapter;
    private final List<Identity> identityList = new ArrayList<>();

    public static void main(String[] args) {
        Server smartHomeServer = new Server();
        smartHomeServer.start(args);
    }

    public void start(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            adapter = communicator.createObjectAdapter("SmartHome");

            Blind bedroomBlinds = new Blind();
            Gate entranceGate = new Gate();
            Gate garageGate = new Gate();
            LightImpl bedroomLight = new LightImpl();
            RgbLightImpl deskRgbLight = new RgbLightImpl();
            ThermostatImpl thermostat = new ThermostatImpl();
            DeviceInfoImpl deviceInfo = new DeviceInfoImpl(identityList);

            addServantMapping(bedroomBlinds, new Identity("blinds", "bedroom"));
            addServantMapping(entranceGate, new Identity("gate", "entrance"));
            addServantMapping(garageGate, new Identity("gate", "garage"));
            addServantMapping(bedroomLight, new Identity("light", "bedroom"));
            addServantMapping(deskRgbLight, new Identity("rgb", "desk"));
            addServantMapping(thermostat, new Identity("thermostat", "household"));
            adapter.add(deviceInfo, new Identity("devices", "util"));

            adapter.activate();

            System.out.println("Entering listen loop...");
            communicator.waitForShutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private void addServantMapping(
        Object servant,
        Identity id
    ) {
        identityList.add(id);
        adapter.add(servant, id);
    }

}
