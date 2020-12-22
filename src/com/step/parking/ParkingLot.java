package com.step.parking;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingLot {
    private final ArrayList<Slot> slots = new ArrayList<>();
    private final int id;
    private final ArrayList<Pair<ParkingLotListener, Integer>> listeners;

    public ParkingLot(int id, int noOfSlots, ArrayList<Pair<ParkingLotListener, Integer>> listeners) {

        this.id = id;
        this.listeners = listeners;
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
        this.listeners.forEach(parkingLotListener -> {
            if (isThresholdMatched(parkingLotListener)) {
                parkingLotListener.fst.listen(id);
            }
        });
    }

    private boolean isThresholdMatched(Pair<ParkingLotListener, Integer> parkingLotListener) {
        float slotPercentage = (this.occupiedSlotCount() / (float)this.slots.size()) * 100;
        return slotPercentage == parkingLotListener.snd;
    }

    private long occupiedSlotCount() {
        return this.slots.stream().filter(slot -> !slot.isAvailable()).count();
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
