package com.sx.rxy.service.direct;//package com.sx.rxy.service.direct;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
///**
// * @author rongxiaoya
// */
//@Service
//@RabbitListener(queues = "parkingPayment.direct.queue")
//public class ParkingPaymentDirectService {
//
//
//    @RabbitHandler
//    public void onMessage(String message){
//        System.out.println("MQ接收到消息，parkingPayment.direct.queue，message:"+message);
//    }
//
//}
