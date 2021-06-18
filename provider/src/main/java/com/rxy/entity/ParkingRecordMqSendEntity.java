package com.rxy.entity;

import lombok.Data;

/**
 * @author rongxiaoya
 */
@Data
public class ParkingRecordMqSendEntity {

    private Integer id;
    private String parkingRecordId;
    private String plateNumber;
    private String body;
    private Integer sendStatus;
    private Integer sendTimes;
}
