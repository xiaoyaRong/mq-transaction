package com.sx.dao;

import com.sx.entity.PrePaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

     void insertOne(@Param("record") PrePaymentEntity record);
}
