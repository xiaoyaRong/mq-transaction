package com.sx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rongxiaoya
 */
@Configuration
public class RabbitMqConfig {


    @Bean
    public FanoutExchange genFanoutExchange(){
        return  new FanoutExchange("fanout-exchange",true,false);
    }

    @Bean
    public Queue parkingRecordQueue(){
        return new Queue("parkingRecord.fanout.queue",true);
    }
    @Bean
    public Queue parkingPaymentQueue(){
        return new Queue("parkingPayment.fanout.queue",true);
    }
    @Bean
    public Queue loginRecordQueue(){
        return new Queue("loginRecord.fanout.queue",true);
    }

    @Bean
    public Binding parkingRecordBinding(){
        return BindingBuilder.bind(parkingRecordQueue()).to(genFanoutExchange());
    }
    @Bean
    public Binding parkingPaymentBinding(){
        return BindingBuilder.bind(parkingPaymentQueue()).to(genFanoutExchange());
    }
    @Bean
    public Binding loginRecordBinding(){
        return BindingBuilder.bind(loginRecordQueue()).to(genFanoutExchange());
    }




}
