package com.sx.dao;

import com.sx.entity.ParkingRecordMqSendEntity;
import com.sx.entity.PrePaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ParkingRecordMqSendDao {

     void insertOne(@Param("record") ParkingRecordMqSendEntity record);

     void updateByParkingRecordId(@Param("parkingRecordId") String id);

     ParkingRecordMqSendEntity selectByParkingRecordId(@Param("parkingRecordId") String id);
}
