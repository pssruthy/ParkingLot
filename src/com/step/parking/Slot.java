package com.step.parking;


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
}
