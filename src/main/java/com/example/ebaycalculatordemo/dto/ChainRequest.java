package com.example.ebaycalculatordemo.dto;

import lombok.Data;
//import org.jetbrains.annotations.NotNull;


import java.math.BigDecimal;
import java.util.List;

/**
 * @Create 03/2025
 * @Author xiao
 * @Description
 */

@Data
public class ChainRequest {
//    @NotNull
    Object initialValue;
    List<ChainRequestItems> items;


}
