package com.sx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rongxiaoya
 */
@Configuration
public class RabbitMqTopicConfig {


    @Bean
    public TopicExchange genTopicExchange(){
        return  new TopicExchange("topic-exchange",true,false);
    }

    @Bean
    public Queue parkingRecordQueue1(){
        return new Queue("parkingRecord.topic.queue",true);
    }
    @Bean
    public Queue parkingPaymentQueue1(){

        Map<String,Object> arg = new HashMap<>(8);
        arg.put("x-message-ttl",5000);
        arg.put("x-dead-letter-exchange","dead-direct-exchange");
        arg.put("x-dead-letter-routing-key","dead");
        return new Queue("parkingPayment.topic.queue",true,false,false,arg);
    }
    @Bean
    public Queue loginRecordQueue1(){
        return new Queue("loginRecord.topic.queue",true);
    }

    @Bean
    public Binding parkingRecordBinding(){
        return BindingBuilder.bind(parkingRecordQueue1()).to(genTopicExchange()).with("#.parking.*");
    }
    @Bean
    public Binding parkingPaymentBinding(){
        return BindingBuilder.bind(parkingPaymentQueue1()).to(genTopicExchange()).with("*.payment.#");
    }
    @Bean
    public Binding loginRecordBinding(){
        return BindingBuilder.bind(loginRecordQueue1()).to(genTopicExchange()).with("rxy.#");
    }




}
