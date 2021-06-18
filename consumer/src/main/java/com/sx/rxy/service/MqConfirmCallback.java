package com.sx.rxy.service;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author rongxiaoya
 */
@Component
@Slf4j
public class MqConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private ParkingRecordMqSendService parkingRecordMqSendService;

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            String parkingRecordId = correlationData.getId();
            if(!StringUtils.isEmpty(parkingRecordId)){
                parkingRecordMqSendService.updateByParkingRecordId(parkingRecordId);
            }
            log.info("停车记录parkingRecordId" + "消费成功");

        }else{
            log.info("停车记录：" + (StringUtils.isEmpty(correlationData.getId()) ? null : correlationData.getId()) + "消费失败");
        }
    }
}
