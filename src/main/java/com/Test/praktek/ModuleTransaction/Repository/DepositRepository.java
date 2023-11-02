package com.Test.praktek.ModuleTransaction.Repository;

import com.Test.praktek.ModuleTransaction.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    @Query("SELECT d.balance FROM Deposit d WHERE d.username = :username")
    BigDecimal getBalanceByUsername(String username);

    // Misalnya, Anda ingin mengupdate saldo berdasarkan username pengguna
//    @Query("UPDATE Deposit d SET d.balance = :newBalance WHERE d.username = :username")
//    void updateBalanceByUsername(String username, BigDecimal newBalance);
}
