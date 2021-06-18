package com.sx.rxy.service;

import com.alibaba.fastjson.JSON;
import com.rxy.parking.service.ParkingService;
import com.sx.entity.ParkingRecordEntity;
import com.sx.entity.ParkingRecordMqSendEntity;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ParkingRecordMqSendService parkingRecordMqSendService;

    @Reference
    ParkingService parkingService;

    public String getParkinglot(){
        String paringlot = parkingService.getParinglot();
        return paringlot;
    }

    public String testDirect(){
        String paringlot = parkingService.testDirectQue();
        return paringlot;
    }

    public String testTopic(String routingKey){
        String paringlot = parkingService.testTopic(routingKey);
        return paringlot;
    }

    public void testTranscation(BigDecimal amount,String plate){
        //车辆入场
        String parkingId = UUID.randomUUID().toString().replaceAll("-", "");
        //修改车位状态
        placeService.changePlaceStatus();

        //生成停车记录    --->sleep 10 秒 捕捉到超时异常
        //parkingService.carIn(plate, new Date(),parkingId);

        ParkingRecordEntity parkingRecordEntity = new ParkingRecordEntity(parkingId,plate,new Date(),null);

        /**-本地存一份，防止未上传到mq丢失数据-*/
        ParkingRecordMqSendEntity mqSendEntity = new ParkingRecordMqSendEntity();
        mqSendEntity.setParkingRecordId(parkingId);
        mqSendEntity.setPlateNumber(parkingRecordEntity.getPlateNumber());
        mqSendEntity.setBody(JSON.toJSONString(parkingRecordEntity));
        this.parkingRecordMqSendService.saveOne(mqSendEntity);

        orderService.sendMessage(parkingRecordEntity);

        //生成预付费订单
        paymentService.prePayment(amount,parkingId);
    }
}
