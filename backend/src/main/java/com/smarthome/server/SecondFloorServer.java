package com.smarthome.server;

import com.smarthome.appliances.*;
import com.zeroc.Ice.*;

import java.lang.Exception;

public class SecondFloorServer extends AbstractServer {

    public static void main(String[] args) {
        SecondFloorServer smartHomeServer = new SecondFloorServer();
        smartHomeServer.start(args);
    }

    public void start(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            adapter = communicator.createObjectAdapter("SecondFloor");

            Blind bedroomBlinds = new Blind();
            LightImpl bedroomLight = new LightImpl();
            RgbLightImpl deskRgbLight = new RgbLightImpl();
            DeviceInfoImpl deviceInfo = new DeviceInfoImpl(identityList);

            addServantMapping(bedroomBlinds, new Identity("blinds", "bedroom"));
            addServantMapping(bedroomLight, new Identity("lights", "bedroom"));
            addServantMapping(deskRgbLight, new Identity("desk-rgb", "office"));
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
