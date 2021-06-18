package com.rxy.order;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rxy.dao.ParkingRecordDao;
import com.rxy.entity.ParkingRecordEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author rongxiaoya
 */
@Service
@RabbitListener(queues = "order-queue")
public class OrderService {

    @Autowired
    private ParkingRecordDao parkingRecordDao;

    @RabbitHandler
    private void carIn(String message, Channel channel, CorrelationData correlationData, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        try {
            ParkingRecordEntity parkingRecordEntity = JSON.parseObject(message, ParkingRecordEntity.class);
            parkingRecordDao.insertOne(parkingRecordEntity);
            channel.basicAck(tag,true);
        }catch (Exception e){
            e.printStackTrace();
            channel.basicNack(tag,false,false);
        }
    }
}
