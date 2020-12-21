package com.step.parking;

import com.step.record.ParkingLotRecord;
import com.step.record.SlotRecord;

import java.util.ArrayList;
import java.util.Arrays;

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
        slots.stream().filter(Slot::isAvailable).findFirst().ifPresent(Slot::occupy);
        assistant.updateDisplay(this.hashCode() ,generateRecord());
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
    
    public ParkingLotRecord generateRecord() {
        final ArrayList<SlotRecord> slotRecords = new ArrayList<>();
        for (Slot slot : slots) {
            slotRecords.add(slot.generateSlotRecord());
        }
        return new ParkingLotRecord(slotRecords, determineStatus());
    }
    
}
