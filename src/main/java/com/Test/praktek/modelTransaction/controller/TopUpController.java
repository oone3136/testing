package com.Test.praktek.modelTransaction.controller;

import com.Test.praktek.component.message.Result;
import com.Test.praktek.modelTransaction.entity.TopUpRequest;
import com.Test.praktek.modelTransaction.services.TopupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController @RequiredArgsConstructor
@RequestMapping(value = "/api")
public class TopUpController {

    private final TopupService service;
    @PostMapping(value = "/topup")
    public ResponseEntity<Result>topUpSaldo(@Valid @RequestBody TopUpRequest request){
        return service.topUpSaldo(request);
    }
}
