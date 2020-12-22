package com.step.parking;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        HashMap<Integer, ParkingLotStatus> records = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(2, new Assistant(records) );
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }
}