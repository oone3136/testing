package com.Test.praktek.ModuleInformation.controller;

import com.Test.praktek.ModuleInformation.Entity.Banner;
import com.Test.praktek.ModuleInformation.repository.BannerRepository;
import com.Test.praktek.ModuleInformation.service.BannerService;
import com.Test.praktek.component.message.Result;
import com.Test.praktek.component.message.ResultgetAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BannerController {

    private final BannerService service;
    @GetMapping("/banner")
    public ResponseEntity<ResultgetAll<List<Banner>>> getAllBanner() {
        return service.getAllBanner();
    }

}
