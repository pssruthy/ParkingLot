package com.step.parking;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    
    @Test
    public void shouldParkTheCarAndNotifyTheAssistant() {
        ArrayList<ListenerDispatch> listeners = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        listeners.add(new ListenerDispatch(assistant, 100));
        ParkingLot parkingLot = new ParkingLot(1, 1, listeners);
        
        assertEquals(ParkingLotStatus.FULL, parkingLot.park());
        verify(assistant, times(1)).listen(1);
    }
    
    @Test
    public void shouldParkTheCarAndNotifyTheListenerWhenSlotsAre80PercentageFull() {
        ArrayList<ListenerDispatch> dispatchFilter = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        ParkingLotListener manager = mock(ParkingLotListener.class);
        
        dispatchFilter.add(new ListenerDispatch(manager, 80));
        dispatchFilter.add(new ListenerDispatch(assistant, 100));
        ParkingLot parkingLot = new ParkingLot(1, 5, dispatchFilter);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        final ParkingLotStatus lotStatus = parkingLot.park();
        
        assertEquals(ParkingLotStatus.AVAILABLE, lotStatus);
        verify(manager, times(1)).listen(1);
        verify(assistant, times(0)).listen(1);
        
    }
}