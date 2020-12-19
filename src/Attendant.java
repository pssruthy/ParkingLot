import java.util.ArrayList;

public class Attendant {
    private final ArrayList<ParkingLot> parkingLots;
    
    public Attendant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    
    public boolean park() {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull()){
                parkingLot.park();
                return true;
            }
        }
        return false;
    }
}
