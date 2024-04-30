#pragma once

module SmartHome {

    interface Closeable {
        idempotent bool open();
        idempotent bool close();
        idempotent bool getState();
    }

}