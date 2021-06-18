package com.sx.rxy.service.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
@RabbitListener(queues = "loginRecord.topic.queue")
public class LoginTopicService {

    @RabbitHandler
    public void getLoginTopicMessage(String message){
            System.out.println("MQ接收到消息，loginRecord.topic.queue，message:"+message);
    }
}
