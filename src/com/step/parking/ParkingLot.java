package com.step.parking;

import com.step.record.ParkingLotRecord;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLot {
    private final ArrayList<Slot> availableSlots = new ArrayList<>();
    
    public ParkingLot(int noOfSlots) {
        final Slot[] newSlots = new Slot[noOfSlots];
        Arrays.fill(newSlots, new Slot(SlotStatus.EMPTY));
        this.availableSlots.addAll(Arrays.asList(newSlots));
    }
    
    public ParkingLotStatus park() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        availableSlots.stream().filter(Slot::isAvailable).findFirst().ifPresent(Slot::occupy);
        return determineStatus();
    }
    
    public boolean isFull() {
        return availableSlots.size() == 0;
    }
    
    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
    
    public ParkingLotRecord generateTheSummary() {
        return new ParkingLotRecord(availableSlots,determineStatus());
    }
    
}
