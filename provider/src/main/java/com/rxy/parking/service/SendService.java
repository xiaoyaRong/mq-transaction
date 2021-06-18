package com.rxy.parking.service;

import com.alibaba.fastjson.JSON;
import com.rxy.entity.ParkingRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    @Autowired
    private MailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${system.deal-message.email}")
    private String to;

    public String sendEmailMessage(String parkingRecord){

        try {
            ParkingRecordEntity parkingRecordEntity = JSON.parseObject(parkingRecord, ParkingRecordEntity.class);

            //发给后台人员处理
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(to);
            mailMessage.setSubject("订单生产异常");
            mailMessage.setText("订单编号" + parkingRecordEntity.getId() + "入场时间：" + parkingRecordEntity.getEntranceTime() + "车牌号：" + parkingRecordEntity.getPlateNumber() + "模拟json:" + parkingRecord);
            mailSender.send(mailMessage);
            return "ok";
        }catch (Exception  e){
            e.printStackTrace();
            return "error";
        }

    }
}
