import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(1, parkingLot.park());
    }

    @Test
    public void shouldConfirmWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.park();

        assertTrue(parkingLot.isFull());
    }

    @Test
    public void shouldConfirmWhenParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertFalse(parkingLot.isFull());
    }
}