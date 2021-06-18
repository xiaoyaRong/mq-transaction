package com.sx.rxy.service;
import java.math.BigDecimal;

import com.sx.entity.PrePaymentEntity;
import com.sx.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;


    public void prePayment(BigDecimal amount,String parkingId){
        PrePaymentEntity prePaymentEntity = new PrePaymentEntity();
        if(amount.compareTo(new BigDecimal(5)) == 0){
            throw new RuntimeException("5块钱抛异常");
        }
        prePaymentEntity.setAmount(amount);
        prePaymentEntity.setPayStatus(0);
        prePaymentEntity.setParkingId(parkingId);
        paymentDao.insertOne(prePaymentEntity);
    }






}
