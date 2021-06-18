package com.sx.rxy.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author rongxiaoya
 */
@Service
@RabbitListener(queues = "loginRecord.fanout.queue")
public class LoginRecordService {


    @RabbitHandler
    public void onMessage(String message){
        System.out.println("MQ接收到消息，loginRecord.fanout.queue，message:"+message);
    }

}
