package com.sx.rxy.service.fanout;

import com.rxy.parking.service.ParkingService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author rongxiaoya
 */
@Service
@RabbitListener(queues = "parkingPayment.fanout.queue")
public class ParkingPaymentService {


    @RabbitHandler
    public void onMessage(String message){
        System.out.println("MQ接收到消息，parkingPayment.fanout.queue，message:"+message);
    }

}
