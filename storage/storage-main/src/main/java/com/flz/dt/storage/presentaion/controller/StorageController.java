package com.flz.dt.storage.presentaion.controller;

import com.flz.dt.storage.application.service.StorageService;
import com.flz.storage.api.StorageApi;
import com.flz.storage.dto.StorageChangeRequestDTO;
import com.flz.storage.dto.response.StorageInfoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storage")
public class StorageController implements StorageApi {
    private final StorageService storageService;

    @PostMapping("/batch-change")
    @Override
    public void batchChangeStorage(@RequestBody @Valid StorageChangeRequestDTO requestDTO) {
        storageService.batchChangeStorage(requestDTO);
    }

    @GetMapping("/info")
    @Override
    public List<StorageInfoResponseDTO> fetchStorageInfo(@RequestParam List<String> skuIds) {
        return storageService.fetchStorageInfo(skuIds);
    }
}
