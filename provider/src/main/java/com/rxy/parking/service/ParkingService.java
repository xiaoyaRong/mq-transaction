package com.rxy.parking.service;

import com.rxy.entity.ParkingRecordEntity;

import java.util.Date;

public interface ParkingService {

    String getParinglot();

    String testDirectQue();

    String testTopic(String routingKey);

    Boolean carIn(String plate, Date entranceTime, String parkingId);
}
