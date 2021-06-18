package com.sx.rxy.service.topic;//package com.sx.rxy.service.topic;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
///**
// * @author rongxiaoya
// */
//
////@RabbitListener(bindings = @QueueBinding(
////        value = @Queue(value = "parkingRecord.topic.queue",durable = "true",autoDelete = "false"),
////        exchange = @Exchange(value = "topic-exchange",type = ExchangeTypes.TOPIC),
////        key = "*.parkingRecord.*"
////))
//
//@Service
//@RabbitListener(queues = "parkingPayment.topic.queue")
//public class PaymentTopicService {
//
//    @RabbitHandler
//    public void getPaymentTopicMessage(String message){
//            System.out.println("MQ接收到消息，payment.topic.queue，message:"+message);
//    }
//}
