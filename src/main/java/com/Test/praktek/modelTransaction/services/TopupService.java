package com.Test.praktek.modelTransaction.services;

import com.Test.praktek.component.message.Result;
import com.Test.praktek.modelTransaction.entity.Saldo;
import com.Test.praktek.modelTransaction.entity.TopUp;
import com.Test.praktek.modelTransaction.entity.TopUpRequest;
import com.Test.praktek.modelTransaction.repository.SaldoRepository;
import com.Test.praktek.modelTransaction.repository.TopupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service @RequiredArgsConstructor @Slf4j
public class TopupService {

    private Result result;
    private final TopupRepository repository;
    private final SaldoRepository saldoRepository;

    public ResponseEntity<Result> topUpSaldo(TopUpRequest request){
        result = new Result();

        try
        {
            Optional<Saldo> cekSaldo = Optional.of(saldoRepository.findByBalance(String.valueOf(request.getBalance())).orElse(new Saldo()));
            if (cekSaldo.isPresent())
            {
                Saldo saldo = new Saldo();
                TopUp topUp = new TopUp();
                topUp.setTop_up(request.getTopUp());
                saldo.setBalance(request.getBalance().add(request.getBalance()));
                result.setSuccess(true);
                result.setMessage("berhasil menambahkan saldo");
            }
            if (request.getTopUp().longValue()<1000)
            {
                result.setSuccess(false);
                result.setMessage("minimum top up Rp. 1000,00");
                result.setCode(HttpStatus.BAD_REQUEST.value());
            }
            else
            {
                TopUp topUp = new TopUp(request.getTopUp(), request.getBalance());
                repository.save(topUp);
                result.setSuccess(true);
                result.setMessage("transaction sucses");
                result.setCode(HttpStatus.OK.value());
            }
        }catch (Exception e)
        {
        }
        return ResponseEntity.ok(result);
    }
}
