package com.step.record;

import com.step.parking.ParkingLotStatus;
import com.step.parking.Slot;

import java.util.ArrayList;

public class ParkingLotRecord {
    private final ArrayList<Slot> slots;
    private final ParkingLotStatus parkingLotStatus;
    
    public ParkingLotRecord(ArrayList<Slot> slots, ParkingLotStatus parkingLotStatus) {
        this.slots = slots;
        this.parkingLotStatus = parkingLotStatus;
    }
    
    @Override
    public int hashCode() {
        int result = slots.hashCode();
        result = 31 * result + parkingLotStatus.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLotRecord)) return false;
        
        ParkingLotRecord that = (ParkingLotRecord) o;
        
        if (!slots.equals(that.slots)) return false;
        return parkingLotStatus == that.parkingLotStatus;
    }
    
    @Override
    public String toString() {
        return String.format("ParkingLotRecord{slots=%s, " +
                                     "parkingLotStatus=%s}", slots.toString(),
                parkingLotStatus);
    }
}
