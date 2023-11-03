package com.Test.praktek.modelTransaction.services;

import com.Test.praktek.component.message.Result;
import com.Test.praktek.modelTransaction.entity.Saldo;
import com.Test.praktek.modelTransaction.repository.SaldoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class SaldoService {
    private Result result;
    private final SaldoRepository repository;
    public List<Saldo> getAllSaldo(){
        return repository.findAll();
    }
}
