package com.rxy.parking.service;

import com.rxy.dao.ParkingRecordDao;
import com.rxy.entity.ParkingRecordEntity;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class ParkingServiceImpl implements ParkingService {

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
    public Boolean carIn(String plate, Date entranceTime,String parkingId) {
        ParkingRecordEntity parkingRecordEntity = new ParkingRecordEntity();
        String id = parkingId;
        if(plate.equals("沪A88888")){
            try {
                Thread.sleep(10 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            //throw new RuntimeException("沪A88888抛异常");
        }
        parkingRecordEntity.setId(id);
        parkingRecordEntity.setPlateNumber(plate);
        parkingRecordEntity.setEntranceTime(entranceTime);
        parkingRecordDao.insertOne(parkingRecordEntity);
        return true;
    }

}
