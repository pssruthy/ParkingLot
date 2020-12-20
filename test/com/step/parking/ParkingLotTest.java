package com.step.parking;

import com.step.record.ParkingLotRecord;
import com.step.record.SlotRecord;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }
    
    @Test
    public void shouldGenerateParkingLotRecord() {
        ParkingLot parkingLot = new ParkingLot(1);
        ArrayList<SlotRecord> slots = new ArrayList<>();
        slots.add(new SlotRecord(SlotStatus.EMPTY));
        final ParkingLotRecord parkingLotRecord = new ParkingLotRecord(slots, ParkingLotStatus.AVAILABLE);
    
        assertEquals(parkingLotRecord, parkingLot.generateRecord());
    
    }
}