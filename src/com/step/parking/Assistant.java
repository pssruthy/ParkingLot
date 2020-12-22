package com.step.parking;

import java.util.HashMap;

public class Assistant implements ParkingLotListener {

    public HashMap<Integer, ParkingLotStatus> records;

    public Assistant(HashMap<Integer, ParkingLotStatus> records) {
        this.records = records;
    }

    @Override
    public void listen(int parkingLotId) {
        this.records.put(parkingLotId, ParkingLotStatus.FULL);
    }
}
