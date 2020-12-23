package com.step.parking;

public interface NotificationDispatcher {
    public void listen(int parkingLotId, float eventData);
}
