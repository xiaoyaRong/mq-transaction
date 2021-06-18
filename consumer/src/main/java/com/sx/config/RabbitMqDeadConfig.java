package com.sx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rongxiaoya
 */
@Configuration
public class RabbitMqDeadConfig {

    @Bean
    public DirectExchange genDeadExchange(){
        return  new DirectExchange("dead-direct-exchange",true,false);
    }

    @Bean
    public Queue deadQueue(){
        return new Queue("dead.direct.queue",true);
    }

    @Bean
    public Binding deadBinding(){
        return BindingBuilder.bind(deadQueue()).to(genDeadExchange()).with("dead");
    }




}
