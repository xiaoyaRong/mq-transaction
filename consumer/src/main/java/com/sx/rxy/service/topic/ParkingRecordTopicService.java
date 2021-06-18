package com.sx.rxy.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author rongxiaoya
 */

//@RabbitListener(bindings = @QueueBinding(
//        value = @Queue(value = "parkingRecord.topic.queue",durable = "true",autoDelete = "false"),
//        exchange = @Exchange(value = "topic-exchange",type = ExchangeTypes.TOPIC),
//        key = "*.parkingRecord.*"
//))

@Service
@RabbitListener(queues = "parkingRecord.topic.queue")
public class ParkingRecordTopicService {

    @RabbitHandler
    public void getParkingRecordTopicMessage(String message){
            System.out.println("MQ接收到消息，parkingRecord.topic.queue，message:"+message);
    }
}
