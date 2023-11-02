package com.Test.praktek.ModuleTransaction.service;

import com.Test.praktek.ModuleTransaction.Repository.DepositRepository;
import com.Test.praktek.ModuleTransaction.Repository.DepositRepositoryExt;
import com.Test.praktek.ModuleTransaction.entity.Deposit;
import com.Test.praktek.component.message.Result;
import com.Test.praktek.moduleMembership.entity.Users;
import com.Test.praktek.moduleMembership.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service @RequiredArgsConstructor
public class DepositService {
    Result result = new Result();
    private final DepositRepositoryExt repository;
    private final DepositRepository depositRepository;
    private final UsersRepository usersRepository;

    public ResponseEntity<Result> getBalance() {
        Result result = new Result();
        try {
            BigDecimal balance = repository.getBalance();
            result.setSuccess(true);
            result.setCode(0);
            result.setMessage("success");
            result.setData(balance != null ? balance : BigDecimal.ZERO);
            return ResponseEntity.ok(result);
        } catch (EmptyResultDataAccessException e) {
            result.setSuccess(false);
            result.setCode(1);
            result.setMessage("No balance found");
            result.setData(BigDecimal.ZERO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
    public void topUpDeposit(BigDecimal topUpAmount) {
        repository.updateDeposit(topUpAmount);
    }
    public void topUpDeposit(BigDecimal topUpAmount, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            String username = authentication.getName(); // Mendapatkan username pengguna yang login

            // Lakukan validasi jika diperlukan (misalnya, pastikan topUpAmount tidak negatif)
            if (topUpAmount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Top-up amount cannot be negative.");
            }

            // Dapatkan balance saat ini dari repository (jika diperlukan)
            BigDecimal currentBalance = depositRepository.getBalanceByUsername(username);

            // Hitung balance baru setelah top-up
            BigDecimal newBalance = currentBalance.add(topUpAmount);

            // Lakukan penyimpanan atau pembaruan balance sesuai dengan implementasi Anda
            // repository.updateBalance(username, newBalance);

        } else {
            throw new IllegalArgumentException("User is not authenticated.");
        }
    }


}
