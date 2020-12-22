package com.step.parking;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingLot {
    private final ArrayList<Slot> slots = new ArrayList<>();
    private final int id;
    private final ArrayList<ListenerDispatch> dispatchFilters;

    public ParkingLot(int id, int noOfSlots, ArrayList<ListenerDispatch> dispatchFilters) {
        this.id = id;
        this.dispatchFilters = dispatchFilters;
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
        this.dispatchFilters.forEach(dispatchFilter -> {
            final float occupiedSlotPercentages = computeOccupiedSlotPercentages();
            dispatchFilter.listen(this.id, occupiedSlotPercentages);
        });
    }
    
    private float computeOccupiedSlotPercentages() {
        final long occupiedSlots = this.slots.stream().filter(slot -> !slot.isAvailable()).count();
        return ((occupiedSlots / (float)this.slots.size()) * 100);
    }
    
    
    public boolean isFull() {
        return this.slots.stream().noneMatch(Slot::isAvailable);
    }

    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
}
