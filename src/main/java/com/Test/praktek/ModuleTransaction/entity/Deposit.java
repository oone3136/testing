package com.Test.praktek.ModuleTransaction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Data @Setter @Getter @AllArgsConstructor
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "top_up_amount")
    private BigDecimal top_up_amount;
    @Column(name = "balance")
    private BigDecimal balance;

}
