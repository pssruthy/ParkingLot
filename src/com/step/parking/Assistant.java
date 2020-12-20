package com.step.parking;

import com.step.record.ParkingLotRecord;

import java.util.ArrayList;

public class Assistant {
    private final ArrayList<ParkingLot> parkingLots;
    
    public Assistant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    
    public ArrayList<ParkingLotRecord> monitor() {
        final ArrayList<ParkingLotRecord> parkingLotRecords = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
             parkingLotRecords.add(parkingLot.generateRecord());
        }
        return parkingLotRecords;
    }
}
