package com.Test.praktek.ModuleInformation.controller;

import com.Test.praktek.ModuleInformation.Entity.Service;
import com.Test.praktek.ModuleInformation.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceRepository repository;

    @GetMapping("/service")
    public List<Service> GetAllServices(){
        return repository.findAll();
    }
}
