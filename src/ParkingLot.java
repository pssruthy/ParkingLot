import java.util.Arrays;

public class ParkingLot {
    private final SlotStatus[] slots;
    private ParkingLotStatus status;
    
    public ParkingLot(int noOfSlots) {
        this.status = ParkingLotStatus.AVAILABLE;
        this.slots = new SlotStatus[noOfSlots];
        Arrays.fill(this.slots, SlotStatus.EMPTY);
    }
    
    public ParkingLotStatus park() {
        for (int slotNo = 0; slotNo < this.slots.length; slotNo++) {
            if (isSlotEmpty(this.slots[slotNo])) {
                this.slots[slotNo] = SlotStatus.FILLED;
            }
        }
        updateStatus();
        return this.status;
    }
    
    private boolean isSlotEmpty(SlotStatus slot) {
        return slot == SlotStatus.EMPTY;
    }
    
    private void updateStatus() {
        if (isFull()) {
            this.status = ParkingLotStatus.FULL;
        }
    }
    
    public boolean isFull() {
        return Arrays.stream(this.slots).noneMatch(this::isSlotEmpty);
    }
}
