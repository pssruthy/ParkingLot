import java.util.Arrays;

public class ParkingLot {
    private final SlotStatus[] slots;

    public ParkingLot(int slots) {
        this.slots = new SlotStatus[slots];
        Arrays.fill(this.slots, SlotStatus.EMPTY);
    }

    public int park() {
        return 1;
    }
}
