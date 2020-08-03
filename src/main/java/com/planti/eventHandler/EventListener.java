package com.planti.eventHandler;

import java.util.Date;

public interface EventListener {

    void waterDateReached(Date iNeedWater, String plantName);
}
