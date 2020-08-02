package com.planti.eventHandler;

import java.util.Date;

public interface eventListener {

    void WaterDateReached(Date iNeedWater, String plantName);
}
