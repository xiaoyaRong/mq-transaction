package com.rxy.config;//package com.rxy.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author rongxiaoya
// */
//@Configuration
//public class RabbitMqDirectConfig {
//
//
//    @Bean
//    public DirectExchange genDirectExchange(){
//        return  new DirectExchange("direct-exchange",true,false);
//    }
//
//    @Bean
//    public Queue parkingRecordQueue1(){
//        return new Queue("parkingRecord.direct.queue",true);
//    }
//    @Bean
//    public Queue parkingPaymentQueue1(){
//        return new Queue("parkingPayment.direct.queue",true);
//    }
//    @Bean
//    public Queue loginRecordQueue1(){
//        return new Queue("loginRecord.direct.queue",true);
//    }
//
//    @Bean
//    public Binding parkingRecordBinding(){
//        return BindingBuilder.bind(parkingRecordQueue1()).to(genDirectExchange()).with("parkingRecord");
//    }
//    @Bean
//    public Binding parkingPaymentBinding(){
//        return BindingBuilder.bind(parkingPaymentQueue1()).to(genDirectExchange()).with("parkingPayment");
//    }
//    @Bean
//    public Binding loginRecordBinding(){
//        return BindingBuilder.bind(loginRecordQueue1()).to(genDirectExchange()).with("loginRecord");
//    }
//
//
//
//
//}
