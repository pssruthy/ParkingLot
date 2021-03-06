package com.step.parking;

import com.step.record.SlotRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlotTest {
    @Test
    public void shouldConfirmIfSlotIsAvailable() {
        Slot slot = new Slot(SlotStatus.EMPTY);
        
        assertTrue(slot.isAvailable());
    }
    
    @Test
    public void shouldNotConfirmIfSlotIsAvailable() {
        Slot slot = new Slot(SlotStatus.FILLED);
        
        assertFalse(slot.isAvailable());
    }
    
    @Test
    public void shouldGenerateSlotRecord() {
        Slot slot = new Slot(SlotStatus.EMPTY);
        SlotRecord expected = slot.generateSlotRecord();
        
        assertEquals(expected, new SlotRecord(SlotStatus.EMPTY));
    }
}