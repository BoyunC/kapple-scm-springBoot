package com.kosa.kapple.service;

import com.kosa.kapple.domain.OrdersVO;
import com.kosa.kapple.domain.SaleVO;
import com.kosa.kapple.mapper.MapperMK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceMKImpl implements ServiceMK {

    @Autowired
    private MapperMK mapper;

    @Override
    public List<SaleVO> getSaleList() {
        return mapper.getSaleList();
    }

    @Override
    public List<OrdersVO> getComparisonByPeriod(String tableName, Date startDate, Date endDate) {
        List<OrdersVO> ddd = mapper.getComparisonByPeriod(tableName);
        System.out.println(ddd.toString());
        return ddd;
    }
}
