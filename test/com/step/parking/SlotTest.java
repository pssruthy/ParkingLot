package com.step.parking;

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

}