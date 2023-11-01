package com.Test.praktek.ModuleInformation.controller;

import com.Test.praktek.ModuleInformation.Entity.Banner;
import com.Test.praktek.ModuleInformation.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BannerController {

    private final BannerRepository repository;
    @GetMapping("/banner")
    public List<Banner> getAllBanner(){
        return repository.findAll();
    }
}
