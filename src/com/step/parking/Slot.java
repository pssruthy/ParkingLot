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
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slot)) return false;
        Slot slot = (Slot) o;
        return slotStatus == slot.slotStatus;
    }
    
//    @Override
//    public int hashCode() {
//        return slotStatus.hashCode();
//    }
}
