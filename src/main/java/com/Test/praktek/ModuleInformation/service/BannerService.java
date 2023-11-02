package com.Test.praktek.ModuleInformation.service;

import com.Test.praktek.ModuleInformation.Entity.Banner;
import com.Test.praktek.ModuleInformation.repository.BannerRepository;
import com.Test.praktek.component.message.Result;
import com.Test.praktek.component.message.ResultgetAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class BannerService {

    private final BannerRepository repository;

    public ResponseEntity<ResultgetAll<List<Banner>>> getAllBanner() {
        List<Banner> banners = repository.findAll();
        ResultgetAll<List<Banner>> result = new ResultgetAll<>();

        if (banners.isEmpty()) {
            result.setMessage("Data tidak ada");
            result.setData(banners);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        } else {
            result.setMessage("Sukses");
            result.setData(banners);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

}
