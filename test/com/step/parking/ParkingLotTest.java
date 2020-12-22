package com.step.parking;

import com.sun.tools.javac.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Test
    public void shouldParkTheCarAndNotifyTheAssistant() {
        ArrayList<Pair<ParkingLotListener, Integer>> listeners = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        listeners.add(new Pair<>(assistant, 100));
        ParkingLot parkingLot = new ParkingLot(1, 1, listeners);

        assertEquals(ParkingLotStatus.FULL, parkingLot.park());
        verify(assistant, times(1)).listen(1);
    }

    @Test
    public void shouldParkTheCarAndNotifyTheListenerWhenSlotsAre80PercentageFull() {
        ArrayList<Pair<ParkingLotListener, Integer>> listeners = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        listeners.add(new Pair<>(assistant, 80));
        ParkingLot parkingLot = new ParkingLot(1, 5, listeners);

        parkingLot.park();
        parkingLot.park();
        parkingLot.park();

        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
        verify(assistant, times(1)).listen(1);
    }
}