package com.step.parking;

public class ListenerDispatch implements ParkingLotDispatchFilter {
    private final ParkingLotListener parkingLotListener;
    private final int threshold;
    
    public ListenerDispatch(ParkingLotListener listener, int threshold) {
        this.parkingLotListener = listener;
        this.threshold = threshold;
    }
    
    @Override
    public void listen(int parkingLotId, float eventData) {
        if(eventData >= threshold){
            parkingLotListener.listen(parkingLotId);
        }
    }
}
