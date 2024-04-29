#pragma once

module SmartHome {

    interface Openable {
        idempotent void open();
        idempotent void close();
    }

}