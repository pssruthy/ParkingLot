import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(1, parkingLot.park());
    }
}