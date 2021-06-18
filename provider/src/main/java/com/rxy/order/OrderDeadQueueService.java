package com.rxy.order;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rxy.dao.ParkingRecordDao;
import com.rxy.entity.ParkingRecordEntity;
import com.rxy.parking.service.SendService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author rongxiaoya
 */
@Service
@RabbitListener(queues = "dead.direct.queue")
public class OrderDeadQueueService {

    @Autowired
    private ParkingRecordDao parkingRecordDao;
    @Autowired
    private SendService sendService;

    @RabbitHandler
    private void carIn(String message, Channel channel, CorrelationData correlationData, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        //死信队列消费者如果再异常 设置不再排队，然后从公司邮箱发邮件让程序员处理
        try {
            ParkingRecordEntity parkingRecordEntity = JSON.parseObject(message, ParkingRecordEntity.class);
            parkingRecordDao.insertOne(parkingRecordEntity);
            channel.basicAck(tag,true);
        }catch (Exception e){
            e.printStackTrace();
            channel.basicNack(tag,false,false);
            sendService.sendEmailMessage(message);
        }
    }
}
