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
//@RabbitListener(queues = "parkingRecord.direct.queue")
//public class ParkingRecordDirectService {
//
//
//    @RabbitHandler
//    public void onMessage(String message){
//        System.out.println("MQ接收到消息，parkingRecord.direct.queue，message:"+message);
//    }
//
//}
