package com.rxy.parking.service;

import com.rxy.dao.ParkingRecordDao;
import com.rxy.entity.ParkingRecordEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParkingServiceLocalImpl implements ParkingServiceLocal {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ParkingRecordDao parkingRecordDao;


    @Override
    public String getParinglot() {

        //把停车场信息放到mq中

        rabbitTemplate.convertAndSend("fanout-exchange","","测试广播模式mq--外滩停车场");

        return "外滩停车场";



    }

    //@Override
    //public String testDirectQue() {
    //
    //    //把停车场信息放到mq中
    //    String routingKey = "parkingRecord";
    //    rabbitTemplate.convertAndSend("direct-exchange",routingKey,"测试direct模式mq--外滩停车场2");
    //    return "外滩停车场";
    //}
    @Override
    public String testDirectQue() {

        //把停车场信息放到mq中
        String routingKey = "parkingPayment";
        rabbitTemplate.convertAndSend("direct-exchange",routingKey,"测试direct模式mq--外滩停车场2");
        return "外滩停车场";
    }
    //@Override
    //public String testDirectQue() {
    //
    //    //把停车场信息放到mq中
    //    String routingKey = "parkingRecord";
    //    rabbitTemplate.convertAndSend("direct-exchange",routingKey,"测试direct模式mq--外滩停车场2");
    //    return "外滩停车场";
    //}

    @Override
    public String testTopic(String routingKey) {

        //把停车场信息放到mq中
        //String routingKey = "parkingRecord-topic";
        rabbitTemplate.convertAndSend("topic-exchange",routingKey,"测试topic模式mq--外滩停车场2");
        return "外滩停车场";
    }

    @Override
    public Boolean testProviderTransaction(String plate, Date entranceTime) {
        ParkingRecordEntity parkingRecordEntity = new ParkingRecordEntity();
        parkingRecordEntity.setPlateNumber(plate);
        parkingRecordEntity.setEntranceTime(entranceTime);
        parkingRecordDao.insertOne(parkingRecordEntity);
        return true;
    }

}
