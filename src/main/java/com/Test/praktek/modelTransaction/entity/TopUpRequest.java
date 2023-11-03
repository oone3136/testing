package com.Test.praktek.modelTransaction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter @AllArgsConstructor
public class TopUpRequest {

    private BigDecimal topUp;
    private BigDecimal balance;
}
