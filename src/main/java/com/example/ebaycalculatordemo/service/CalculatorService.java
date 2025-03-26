package com.example.ebaycalculatordemo.service;

import com.example.ebaycalculatordemo.dto.CalculateRequest;
import com.example.ebaycalculatordemo.dto.ChainRequest;
import com.example.ebaycalculatordemo.dto.ChainRequestItems;
import com.example.ebaycalculatordemo.enums.Operation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@Service
public interface CalculatorService {
    BigDecimal calculate(CalculateRequest calculateRequest);
    BigDecimal calculateChained(ChainRequest chainRequest);
}
