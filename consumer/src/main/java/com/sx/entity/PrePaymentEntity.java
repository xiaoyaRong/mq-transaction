package com.sx.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author rongxiaoya
 */
@Data
public class PrePaymentEntity {

    private Integer id;
    private BigDecimal amount;
    private Integer payStatus;
    private String parkingId;
}
