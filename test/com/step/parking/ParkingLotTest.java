package com.step.parking;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        HashMap<Integer, ParkingLotStatus> records = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(1, new Assistant(records), 2);
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }
}