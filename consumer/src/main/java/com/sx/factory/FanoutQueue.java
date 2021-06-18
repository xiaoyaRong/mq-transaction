package com.sx.factory;

import org.springframework.amqp.core.*;

/**
 * @author rongxiaoya
 */
public class FanoutQueue extends RxyQueue {

    private static String type = ExchangeTypes.FANOUT;

    public FanoutQueue(String queName, String excName, String key) {
        super(queName, excName, type, key, true);
    }


}
