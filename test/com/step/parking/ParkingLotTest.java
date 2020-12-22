package com.step.parking;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        ArrayList<ParkingLotListener> listeners = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        listeners.add(assistant);
        ParkingLot parkingLot = new ParkingLot(1, 2, listeners);

        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
        verify(assistant, times(0)).listen(1);
    }
}