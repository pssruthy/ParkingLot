import java.util.Arrays;

public class ParkingLot {
    private final SlotStatus[] slots;

    public ParkingLot(int slots) {
        this.slots = new SlotStatus[slots];
        Arrays.fill(this.slots, SlotStatus.EMPTY);
    }

    public int park() {
        for (int slotNo = 0; slotNo < this.slots.length; slotNo++) {
            if (isSlotEmpty(this.slots[slotNo])) {
                this.slots[slotNo] = SlotStatus.FILLED;
                return slotNo + 1;
            }
        }
        return -1;
    }

    public boolean isFull() {
        return Arrays.stream(this.slots).noneMatch(this::isSlotEmpty);
    }

    private boolean isSlotEmpty(SlotStatus slot) {
        return slot == SlotStatus.EMPTY;
    }
}
