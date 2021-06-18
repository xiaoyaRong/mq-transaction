package com.sx.rxy.service;

import com.sx.dao.ParkingRecordMqSendDao;
import com.sx.dao.PaymentDao;
import com.sx.entity.ParkingRecordMqSendEntity;
import com.sx.entity.PrePaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ParkingRecordMqSendService {

    @Autowired
    private ParkingRecordMqSendDao parkingRecordMqSendDao;


    public void saveOne(ParkingRecordMqSendEntity recordMqSendEntity){
        parkingRecordMqSendDao.insertOne(recordMqSendEntity);
    }

    public void updateByParkingRecordId(String id){
        ParkingRecordMqSendEntity mqSendEntity = parkingRecordMqSendDao.selectByParkingRecordId(id);
        if(Objects.nonNull(mqSendEntity)){
            parkingRecordMqSendDao.updateByParkingRecordId(id);
        }
    }






}
