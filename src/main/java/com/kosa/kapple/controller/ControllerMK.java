package com.kosa.kapple.controller;

import com.kosa.kapple.domain.OrdersVO;
import com.kosa.kapple.domain.SaleVO;
import com.kosa.kapple.service.ServiceMKImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ControllerMK {

    @Autowired
    private ServiceMKImpl service;

    @GetMapping("/sales")
    public List<SaleVO> getSaleList() {
        return service.getSaleList();
    }

    @GetMapping("/allData")
    public ResponseEntity<Object> fetchInitialData(){
        Map<String, Object> result = new HashMap<>();

        //result.put("avgScore", avg);
        //result.put("reviews", reviews);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    // 요약 조회 ============================================
    @PostMapping("/comparison/{tableName}")
    public Map<String, Object> comparison(@PathVariable String tableName){

        Map<String, Object> result = new HashMap<>();

        Date startDate=null;
        Date endDate=null;

        List<OrdersVO> objList = service.getComparisonByPeriod(tableName, startDate, endDate);
        result.put(tableName, objList);

        return result;
    }

    // 비교 조회 ============================================
    // 부품 주문량
    // 제품 생산량
    // 제품 판매량
    // 제품 반품량


    // 분석 조회 ============================================
    // 제품별 판매량 조회
    // 판매 예측 정확도 조회
    // 부품 공급 의존도 조회
    // 부품 회전율 조회




}
