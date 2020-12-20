package com.step.parking;


import com.step.record.SlotRecord;

public class Slot {
    private SlotStatus slotStatus;
    
    public Slot(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }
    
    public void occupy() {
        this.slotStatus = SlotStatus.FILLED;
    }
    
    public boolean isAvailable() {
        return this.slotStatus.isEmpty();
    }
    
    public SlotRecord generateSlotRecord() {
        return new SlotRecord(slotStatus);
    }
}
