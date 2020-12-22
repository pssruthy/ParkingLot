package com.step.parking;

import java.util.HashMap;

public class Assistant {

    public HashMap<Integer, ParkingLotStatus> records;

    public Assistant(HashMap<Integer, ParkingLotStatus> records) {
        this.records = records;
    }

    public void updateDisplay(int parkingLotId, ParkingLotStatus parkingLotRecord) {
        this.records.put(parkingLotId, parkingLotRecord);
    }
}
