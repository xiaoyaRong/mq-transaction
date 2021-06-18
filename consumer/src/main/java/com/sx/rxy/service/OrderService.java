package com.sx.rxy.service;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;

import com.alibaba.fastjson.JSON;
import com.sx.entity.ParkingRecordEntity;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private MqConfirmCallback mqConfirmCallback;


    public void sendMessage(ParkingRecordEntity parkingRecordEntity){

        String exchange = "order-direct-exchanger";
        String routingKey = "order";

        CorrelationData correlationData = new CorrelationData();

        correlationData.setId(parkingRecordEntity.getId());
        correlationData.setReturned(new ReturnedMessage(null,8888,JSON.toJSONString(parkingRecordEntity),exchange,routingKey));

        rabbitTemplate.convertAndSend(exchange,routingKey, JSON.toJSONString(parkingRecordEntity),correlationData);

        rabbitTemplate.setConfirmCallback(mqConfirmCallback);


    }






}
