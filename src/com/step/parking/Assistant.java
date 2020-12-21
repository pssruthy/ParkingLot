package com.step.parking;

import com.step.record.ParkingLotRecord;

import java.util.HashMap;

public class Assistant {

    public HashMap<Integer, ParkingLotRecord> records;

    public Assistant(HashMap<Integer, ParkingLotRecord> records) {
        this.records = records;
    }

    public void updateDisplay(int parkingLotId, ParkingLotRecord parkingLotRecord) {
        this.records.put(parkingLotId, parkingLotRecord);
    }
}
