package com.step.parking;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingLot {
    private final ArrayList<Slot> slots = new ArrayList<>();
    private final int id;
    private final ArrayList<ParkingLotListener> listeners;

    public ParkingLot(int id, int noOfSlots, ArrayList<ParkingLotListener> listeners) {
        this.id = id;
        this.listeners = listeners;
        for (int i = 0; i < noOfSlots; i++) {
            this.slots.add(new Slot(SlotStatus.EMPTY));
        }
    }

    public ParkingLotStatus park() {
        if (isFull()) {
            this.informListeners();
            return ParkingLotStatus.FULL;
        }
        Optional<Slot> slot = slots.stream().filter(Slot::isAvailable).findFirst();
        slot.ifPresent(Slot::occupy);
        return determineStatus();
    }

    private void informListeners() {
        this.listeners.forEach(parkingLotListener -> parkingLotListener.listen(id));
    }

    public boolean isFull() {
        return this.slots.stream().noneMatch(Slot::isAvailable);
    }

    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            this.informListeners();
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
}
