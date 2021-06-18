package com.sx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rongxiaoya
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingRecordEntity implements Serializable {

    private String id;
    private String plateNumber;
    private Date entranceTime;
    private Date LeavingTime;
}
