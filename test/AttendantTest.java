import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AttendantTest {
    @Test
    public void shouldParkACarInAvailableParkingLot() {
        final ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1));
        final Attendant attendant = new Attendant(parkingLots);
        
        assertTrue(attendant.park());
    }
}