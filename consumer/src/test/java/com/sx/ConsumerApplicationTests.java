package com.sx;

import com.sx.factory.MqFactory;
import com.sx.rxy.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ConsumerApplicationTests {

    @Autowired
    private CarService carService;
    @Test
    void contextLoads() {
        String parkinglot = carService.getParkinglot();
        System.out.println(parkinglot);
    }
    @Test
    void testDirect() {
        String parkinglot = carService.testDirect();
        System.out.println(parkinglot);
    }

    /**
     * #.parking.*
     * *.payment.#
     * rxy.#
     */
    @Test
    void testTopic() {
        String routingKey = "rxy.payment.parking.24659";
        String parkinglot = carService.testTopic(routingKey);
        System.out.println(parkinglot);
    }

    @Test
    void testTransc() {
        carService.testTranscation( new BigDecimal(4),"沪A88882");
    }
    @Test
    void testFactory() {
        MqFactory.createQueue("queue1","exc1", ExchangeTypes.DIRECT,"dir1");
    }
}
