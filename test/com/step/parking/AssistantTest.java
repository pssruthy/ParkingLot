package com.step.parking;

import com.step.record.ParkingLotRecord;
import com.step.record.SlotRecord;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AssistantTest {
    @Test
    public void shouldMonitorTheParkingLotsAndUpdateDisplay() {
        final ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        final Assistant assistant = new Assistant(parkingLots);
        final ArrayList<SlotRecord> slots = new ArrayList<>();
        slots.add(new SlotRecord(SlotStatus.EMPTY));
        
        final ArrayList<ParkingLotRecord> expected = new ArrayList<>();
        expected.add(new ParkingLotRecord(slots, ParkingLotStatus.AVAILABLE));
        final ArrayList<ParkingLotRecord> parkingLotRecords = assistant.monitor();
        
        assertEquals(expected, parkingLotRecords);
    }
}