package com.sx.factory;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

/**
 * @author rongxiaoya
 */
public class MqFactory {

    public static RxyQueue createQueue(String queName,String excName,String exchangeType,String key){

        RxyQueue queue = new RxyQueue();

        try {
            switch (exchangeType){
                case ExchangeTypes.FANOUT:queue = new FanoutQueue(queName,excName,key);break;
                case ExchangeTypes.DIRECT:queue = new DirectQueue(queName,excName,key);break;
            }
            return queue;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




}
