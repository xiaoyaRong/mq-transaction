package com.sx.factory;

import org.springframework.amqp.core.ExchangeTypes;

/**
 * @author rongxiaoya
 */
public class DirectQueue extends RxyQueue {

    private static String type = ExchangeTypes.DIRECT;

    public DirectQueue(String queName, String excName, String key) {
        super(queName, excName, type, key, true);
    }


}
