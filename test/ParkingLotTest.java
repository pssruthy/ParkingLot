import com.step.parking.ParkingLot;
import com.step.parking.ParkingLotStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertEquals(ParkingLotStatus.AVAILABLE, parkingLot.park());
    }
    
    
}