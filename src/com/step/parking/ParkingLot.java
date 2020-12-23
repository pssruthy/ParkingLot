package com.step.parking;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingLot {
    private final ArrayList<Slot> slots = new ArrayList<>();
    private final int id;
    private final ArrayList<ParkingLotListener> parkingLotListeners;
    
    public ParkingLot(int id, int noOfSlots, ArrayList<ParkingLotListener> parkingLotListeners) {
        this.id = id;
        this.parkingLotListeners = parkingLotListeners;
        for (int i = 0; i < noOfSlots; i++) {
            this.slots.add(new Slot(SlotStatus.EMPTY));
        }
    }
    
    public ParkingLotStatus park() {
        Optional<Slot> slot = slots.stream().filter(Slot::isAvailable).findFirst();
        slot.ifPresent(Slot::occupy);
        this.informListeners();
        return determineStatus();
    }
    
    private void informListeners() {
        this.parkingLotListeners.forEach(parkingLotListener -> {
            final float occupiedSlotPercentages = computeOccupiedSlotPercentages();
            if (occupiedSlotPercentages <= 20) {
                parkingLotListener.informAlmostEmpty(this.id);
                return;
            }
            if (occupiedSlotPercentages == 80) {
                parkingLotListener.informAlmostFull(this.id);
                return;
            }
            if (occupiedSlotPercentages == 100) {
                parkingLotListener.informFull(this.id);
            }
        });
    }
    
    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
    
    private float computeOccupiedSlotPercentages() {
        final long occupiedSlots = this.slots.stream().filter(slot -> !slot.isAvailable()).count();
        return ((occupiedSlots / (float) this.slots.size()) * 100);
    }
    
    public boolean isFull() {
        return this.slots.stream().noneMatch(Slot::isAvailable);
    }
}
