package com.example.ebaycalculatordemo.service.Impl;

import com.example.ebaycalculatordemo.dto.CalculateRequest;
import com.example.ebaycalculatordemo.dto.ChainRequest;
import com.example.ebaycalculatordemo.dto.ChainRequestItems;
import com.example.ebaycalculatordemo.entity.Calculator;
import com.example.ebaycalculatordemo.enums.Operation;
import com.example.ebaycalculatordemo.service.CalculatorService;
import com.example.ebaycalculatordemo.stratergy.OperationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    public CalculatorServiceImpl(Map<String, OperationStrategy> strategyBeans) {
        Map<Operation, OperationStrategy> strategyMap = new EnumMap<>(Operation.class);
        for (OperationStrategy strategy : strategyBeans.values()) {
            strategyMap.put(strategy.getOperation(), strategy);
        }
        this.calculator = new Calculator(strategyMap); // ✅ 使用真实 Calculator
    }
    @Override
    public BigDecimal calculate(CalculateRequest request) {
        return calculator.calculate(request.getOp(), request.getNum1(), request.getNum2());
    }

    @Override
    public BigDecimal calculateChained(ChainRequest chainRequest) {
        BigDecimal result = chainRequest.getInitialValue() != null ? chainRequest.getInitialValue() : BigDecimal.ZERO;

        for (ChainRequestItems item : chainRequest.getItems()) {
            result = calculator.calculate(item.getOp(), result, item.getNum());
        }
        return result;
    }
}
