import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLot {
    private final ArrayList<SlotStatus> availableSlots = new ArrayList<>();
    private final ArrayList<SlotStatus> occupiedSlots;
    
    public ParkingLot(int noOfSlots) {
        final SlotStatus[] newSlots = new SlotStatus[noOfSlots];
        Arrays.fill(newSlots, SlotStatus.EMPTY);
        this.availableSlots.addAll(Arrays.asList(newSlots));
        occupiedSlots = new ArrayList<>();
    }
    
    public ParkingLotStatus park() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        this.availableSlots.remove(0);
        this.occupiedSlots.add(SlotStatus.FILLED);
        return determineStatus();
    }
    
    public boolean isFull() {
        return availableSlots.size() == 0;
    }
    
    private ParkingLotStatus determineStatus() {
        if (isFull()) {
            return ParkingLotStatus.FULL;
        }
        return ParkingLotStatus.AVAILABLE;
    }
}
