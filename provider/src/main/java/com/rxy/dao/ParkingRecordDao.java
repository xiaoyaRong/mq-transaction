package com.rxy.dao;

import com.rxy.entity.ParkingRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ParkingRecordDao {

     void insertOne(@Param("record") ParkingRecordEntity record);
}
