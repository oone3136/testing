package com.Test.praktek.modelTransaction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Setter @Getter @Data @AllArgsConstructor
@Table(name = "saldo")
public class Saldo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "balance")
    private BigDecimal balance;

    public Saldo() {

    }
}
