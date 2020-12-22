package com.step.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class ParkingLot {
    private final ArrayList<Slot> slots = new ArrayList<>();
    private final int id;
    private final ArrayList<ParkingLotListener> listeners;

    public ParkingLot(int id, int noOfSlots, ArrayList<ParkingLotListener> listeners) {
        this.id = id;
        this.listeners = listeners;
        final Slot[] newSlots = new Slot[noOfSlots];
        Arrays.fill(newSlots, new Slot(SlotStatus.EMPTY));
        this.slots.addAll(Arrays.asList(newSlots));
    }
    
    public ParkingLotStatus park() {
        if (isFull()) {
            this.informListeners();
            return ParkingLotStatus.FULL;
        }
        Optional<Slot> availableSlot = slots.stream().filter(Slot::isAvailable).findFirst();
        availableSlot.ifPresent(Slot::occupy);

        return determineStatus();
    }

    private void informListeners() {
        this.listeners.forEach(parkingLotListener -> parkingLotListener.listen(id));
    }

    public boolean isFull() {
        return slots.size() == 0;
    }
    
    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            this.informListeners();
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
}
