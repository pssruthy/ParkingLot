package com.step.parking;

public enum SlotStatus {
    EMPTY, FILLED;
    
    public boolean isEmpty() {
        return this == EMPTY;
    }
}
