package com.Test.praktek.modelTransaction.repository;

import com.Test.praktek.modelTransaction.entity.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Long> {
    Optional<Saldo> findByBalance(String balance);
}
