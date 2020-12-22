package com.step.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class ParkingLot {
    private final ArrayList<Slot> slots = new ArrayList<>();
    private final Assistant assistant;

    public ParkingLot(int noOfSlots, Assistant assistant) {
        this.assistant = assistant;
        final Slot[] newSlots = new Slot[noOfSlots];
        Arrays.fill(newSlots, new Slot(SlotStatus.EMPTY));
        this.slots.addAll(Arrays.asList(newSlots));
    }
    
    public ParkingLotStatus park() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        Optional<Slot> availableSlot = slots.stream().filter(Slot::isAvailable).findFirst();
        availableSlot.ifPresent(Slot::occupy);
        assistant.updateDisplay(this.hashCode() ,determineStatus());
        return determineStatus();
    }
    
    public boolean isFull() {
        return slots.size() == 0;
    }
    
    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
}
