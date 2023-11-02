package com.Test.praktek.ModuleTransaction.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class DepositRepositoryExt {
    private final JdbcTemplate jdbcTemplate;

    public DepositRepositoryExt(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BigDecimal getBalance() {
        String sql = "SELECT balance FROM deposit ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class);
    }
    public void insertDeposit(BigDecimal balance, BigDecimal topUpAmount) {
        String sql = "INSERT INTO deposit (balance, top_up_amount) VALUES (?, ?)";
        jdbcTemplate.update(sql, balance, topUpAmount);
    }
    public void updateDeposit(BigDecimal topUpAmount) {
        if (topUpAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Top-up amount cannot be negative.");
        }
        BigDecimal currentBalance = getBalance();

        BigDecimal newBalance = currentBalance.add(topUpAmount);

        String insertSql = "INSERT INTO deposit (balance, top_up_amount) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, newBalance, topUpAmount);

        String updateIdSql = "UPDATE deposit SET id = (SELECT max(id) FROM deposit) WHERE id = (SELECT max(id) - 1 FROM deposit)";
        jdbcTemplate.update(updateIdSql);
    }


}
