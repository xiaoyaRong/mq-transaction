package com.rxy.parking.service;

import java.util.Date;

public interface ParkingServiceLocal {

    String getParinglot();

    String testDirectQue();

    String testTopic(String routingKey);

    Boolean testProviderTransaction(String plate, Date entranceTime);
}
