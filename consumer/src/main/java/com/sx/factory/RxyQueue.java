package com.sx.factory;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author rongxiaoya
 */
@Component
public  class RxyQueue {

    protected String queName = "";
    private Boolean durable = true;
    private String excName = "rxy-exchang";
    private String key = "";
    private String type = ExchangeTypes.DIRECT;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RxyQueue() {
    }

    public RxyQueue(String queName,String excName,String type,String key,Boolean durable) {
        if(!StringUtils.isEmpty(queName)){
            this.queName = queName;
        }
        if(!StringUtils.isEmpty(excName)){
            this.excName = excName;
        }
        if(!StringUtils.isEmpty(key)){
            this.key = key;
        }
        if(!StringUtils.isEmpty(type)){
            this.type = type;
        }
        if(Objects.nonNull(durable)){
            this.durable = durable;
        }
       this.createQueue();
    }

    @Bean
    protected Queue newQueue(){
        return new Queue(queName,durable,false,false);
    }


    @Bean
    protected DirectExchange createDirExchange(){
        return new DirectExchange(excName,durable,false);
    }
    @Bean
    protected FanoutExchange createFanExchange(){
        return new FanoutExchange(excName,durable,false);
    }


    @Bean
    protected Binding createQueue(){
        if(queName == ""){
            return null;
        }
        Binding binding ;
        switch (type){
            case ExchangeTypes.FANOUT: binding = BindingBuilder.bind(newQueue()).to(createFanExchange());break;
            case ExchangeTypes.DIRECT:binding = BindingBuilder.bind(newQueue()).to(createDirExchange()).with(key); break;
            default:throw new RuntimeException("目前只支持 FANOUT  DIRECT 类型的交换机");
        }
      return  binding;
    }

}
