package com.smarthome.server;

import com.zeroc.Ice.Identity;
import com.zeroc.Ice.Object;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.ObjectPrx;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServer {

    protected ObjectAdapter adapter;
    protected final List<Identity> identityList = new ArrayList<>();

    protected void addServantMapping(
            Object servant,
            Identity id
    ) {
        identityList.add(id);
        adapter.add(servant, id);
    }

    abstract public void start(String[] args);

}
