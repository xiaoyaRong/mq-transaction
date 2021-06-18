package com.rxy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rongxiaoya
 */
@Configuration
public class OrderMqConfig {

    @Bean
    public DirectExchange orderExchanger(){
        return new DirectExchange("order-direct-exchanger",true,false);
    }

    @Bean
    public Queue orderQueue(){
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-max-length",100);
        arguments.put("x-dead-letter-exchange","dead-direct-exchange");
        arguments.put("x-dead-letter-routing-key","dead");
        return new Queue("order-queue",true,false,false,arguments);
    }

    @Bean
    public Binding bindOrderExchange(){
        return BindingBuilder.bind(orderQueue()).to(orderExchanger()).with("order");
    }





}
