package com.kosa.kapple.service;

import com.kosa.kapple.domain.OrdersVO;
import com.kosa.kapple.domain.SaleVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface ServiceMK {

    public List<SaleVO> getSaleList();

    public List<OrdersVO> getComparisonByPeriod(String tableName, Date startDate, Date endDate);
}
