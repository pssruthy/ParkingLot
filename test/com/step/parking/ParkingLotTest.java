package com.step.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        ArrayList<ParkingLotListener> listeners = mockito;
        listeners.add(parkingLotId -> { });
        ParkingLot parkingLot = new ParkingLot(1, 2, listeners);
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }
}