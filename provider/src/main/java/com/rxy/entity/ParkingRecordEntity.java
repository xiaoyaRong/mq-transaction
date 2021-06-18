package com.rxy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author rongxiaoya
 */
@Data
public class ParkingRecordEntity {

    private String id;
    private String plateNumber;
    private Date entranceTime;
    private Date LeavingTime;
}
