#pragma once

module SmartHome {

    exception NonExistentPreset {
        string badName;
        string message = "Preset with a given name does not exist";
    }

}