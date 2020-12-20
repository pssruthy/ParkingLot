package com.step.record;

import com.step.parking.SlotStatus;

public class SlotRecord {
    private final SlotStatus slotStatus;
    
    public SlotRecord(SlotStatus slotStatus) {
        
        this.slotStatus = slotStatus;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SlotRecord)) return false;
        
        SlotRecord that = (SlotRecord) o;
     
        return slotStatus == that.slotStatus;
    }
    
    @Override
    public int hashCode() {
        return slotStatus.hashCode();
    }
}
