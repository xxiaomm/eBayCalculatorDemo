package com.example.ebaycalculatordemo.controller;

import com.example.ebaycalculatordemo.dto.CalculateRequest;
import com.example.ebaycalculatordemo.dto.ChainRequest;
import com.example.ebaycalculatordemo.dto.ChainRequestItems;
import com.example.ebaycalculatordemo.enums.Operation;
import com.example.ebaycalculatordemo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */


@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;


    @PostMapping("/basic")
    public ResponseEntity<BigDecimal> calculateBasic(
//        @Valid
        @RequestBody CalculateRequest calculateRequest) {


        return ResponseEntity.ok(calculatorService.calculate(calculateRequest));
    }

    @PostMapping("/chain")
    public ResponseEntity<BigDecimal> calculateChain(@RequestBody ChainRequest chainRequest) {


        return ResponseEntity.ok(calculatorService.calculateChained(chainRequest));
    }
}