import java.util.Arrays;

public class ParkingLot {
    private final SlotStatus[] slots;

    public ParkingLot(int noOfSlots) {
        this.slots = new SlotStatus[noOfSlots];
        Arrays.fill(this.slots, SlotStatus.EMPTY);
    }

    public ParkingLotStatus park() {
        for (int slotNo = 0; slotNo < this.slots.length; slotNo++) {
            if (isSlotEmpty(this.slots[slotNo])) {
                this.slots[slotNo] = SlotStatus.FILLED;
                return ParkingLotStatus.AVAILABLE;
            }
        }
        return ParkingLotStatus.FULL;
    }

    public boolean isFull() {
        return Arrays.stream(this.slots).noneMatch(this::isSlotEmpty);
    }

    private boolean isSlotEmpty(SlotStatus slot) {
        return slot == SlotStatus.EMPTY;
    }
}
