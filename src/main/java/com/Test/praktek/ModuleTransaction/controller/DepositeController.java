package com.Test.praktek.ModuleTransaction.controller;

import com.Test.praktek.ModuleTransaction.service.DepositService;
import com.Test.praktek.component.message.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController @RequiredArgsConstructor
@RequestMapping(value = "/api")
@PreAuthorize("isAuthenticated()")
public class DepositeController {

    private final DepositService service;

    @GetMapping("/balance")
    public ResponseEntity<Result> getBalance(){
        return service.getBalance();
    }
    @PostMapping("/topup")
    public ResponseEntity<Result> topUpDeposit(@RequestParam BigDecimal topUpAmount) {
        service.topUpDeposit(topUpAmount);
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(0);
        result.setMessage("Top-up successful.");
        return ResponseEntity.ok(result);
    }
//    @PostMapping("/top-up")
//    public ResponseEntity<Result> topUpDeposit(@RequestParam BigDecimal topUpAmount) {
//        Result result = new Result();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        if (auth instanceof UsernamePasswordAuthenticationToken) {
//            UserDetails userDetails = (UserDetails) auth.getPrincipal();
//            String username = userDetails.getUsername(); // Mendapatkan username pengguna yang login
//
//            // Validasi bahwa pengguna yang login sesuai dengan yang memasukkan topupAmount
//            if (service.validateUserForTopUp(username, topUpAmount)) {
//                BigDecimal newBalance = service.calculateNewBalance(topUpAmount);
//                // Melakukan top-up dan lainnya
//                // ...
//
//                result.setSuccess(true);
//                result.setCode(0);
//                result.setMessage("Top-up successful.");
//                result.setData(newBalance);
//                return ResponseEntity.ok(result);
//            } else {
//                result.setSuccess(false);
//                result.setCode(1);
//                result.setMessage("Invalid user for top-up.");
//                return ResponseEntity.badRequest().body(result);
//            }
//        } else {
//            result.setSuccess(false);
//            result.setCode(2);
//            result.setMessage("Authentication error.");
//            return ResponseEntity.status(401).body(result);
//        }
//    }

}
