package com.step.parking;

public class ParkingLotNotificationDispatcher implements NotificationDispatcher {
    private final ParkingLotListener parkingLotListener;
    private final int threshold;
    
    public ParkingLotNotificationDispatcher(ParkingLotListener listener, int threshold) {
        this.parkingLotListener = listener;
        this.threshold = threshold;
    }
    
    @Override
    public void update(int parkingLotId, float eventData) {
        if(eventData >= threshold){
            parkingLotListener.update(parkingLotId);
        }
    }
}
