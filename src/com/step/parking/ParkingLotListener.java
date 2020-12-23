package com.step.parking;

public interface ParkingLotListener {
    void informAlmostEmpty(int parkingLotId);
    
    void informAlmostFull(int parkingLotId);
    
    void informFull(int parkingLotId);
}
