package com.step.parking;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingLotTest {
    
    @Test
    public void shouldParkTheCarAndNotifyTheAssistant() {
        ArrayList<ParkingLotListener> listeners = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        listeners.add(assistant);
        ParkingLot parkingLot = new ParkingLot(1, 1, listeners);
        
        assertEquals(ParkingLotStatus.FULL, parkingLot.park());
        verify(assistant, times(1)).informFull(1);
    }
    
    @Test
    public void shouldParkTheCarAndNotifyTheAssistantWhenLotIsAlmostEmpty() {
        ArrayList<ParkingLotListener> listeners = new ArrayList<>();
        ParkingLotListener attendant = mock(ParkingLotListener.class);
        listeners.add(attendant);
        ParkingLot parkingLot = new ParkingLot(1, 5, listeners);
        
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
        verify(attendant, times(1)).informAlmostEmpty(1);
    }
    
    
    @Test
    public void shouldParkTheCarAndNotifyTheListenerWhenSlotsAre80PercentageFull() {
        ArrayList<ParkingLotListener> listeners = new ArrayList<>();
        ParkingLotListener assistant = mock(ParkingLotListener.class);
        ParkingLotListener manager = mock(ParkingLotListener.class);
        listeners.add(assistant);
        listeners.add(manager);
        ParkingLot parkingLot = new ParkingLot(1, 5, listeners);
        parkingLot.park();
        parkingLot.park();
        parkingLot.park();
        final ParkingLotStatus lotStatus = parkingLot.park();
        
        assertEquals(ParkingLotStatus.AVAILABLE, lotStatus);
        verify(manager, times(1)).informAlmostFull(1);
        verify(manager, times(0)).informFull(1);
        
        verify(assistant, times(1)).informAlmostFull(1);
        verify(assistant, times(0)).informFull(1);
        
        
    }
}