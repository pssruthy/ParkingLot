package com.step.parking;

import com.step.record.ParkingLotRecord;
import com.step.record.SlotRecord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        HashMap<Integer, ParkingLotRecord> records = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(2, new Assistant(records) );
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }
    
    @Test
    public void shouldGenerateParkingLotRecord() {
        HashMap<Integer, ParkingLotRecord> records = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(1, new Assistant(records));
        ArrayList<SlotRecord> slots = new ArrayList<>();
        slots.add(new SlotRecord(SlotStatus.EMPTY));
        final ParkingLotRecord parkingLotRecord = new ParkingLotRecord(slots, ParkingLotStatus.AVAILABLE);
    
        assertEquals(parkingLotRecord, parkingLot.generateRecord());
    
    }
}