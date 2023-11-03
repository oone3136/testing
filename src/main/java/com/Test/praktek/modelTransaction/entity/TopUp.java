package com.Test.praktek.modelTransaction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Setter @Getter @Data @AllArgsConstructor
@Table(name = "top-up")
public class TopUp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "top_up")
    private BigDecimal top_up;
    @ManyToOne(fetch = FetchType.EAGER)
    private Saldo saldo;

    public TopUp() {

    }

    public TopUp(BigDecimal topUp, BigDecimal balance) {
        this.top_up = topUp;
        this.saldo.setBalance(balance);
    }
}
