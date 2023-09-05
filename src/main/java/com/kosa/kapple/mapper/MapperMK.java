package com.kosa.kapple.mapper;

import com.kosa.kapple.domain.OrdersVO;
import com.kosa.kapple.domain.SaleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface MapperMK {

    public List<SaleVO> getSaleList();

    public List<OrdersVO> getComparisonByPeriod(String tableName);


}
