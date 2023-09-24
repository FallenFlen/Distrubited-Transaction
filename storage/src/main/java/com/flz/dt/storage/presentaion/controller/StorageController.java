package com.flz.dt.storage.presentaion.controller;

import com.flz.dt.storage.application.service.StorageService;
import com.flz.storage.api.StorageApi;
import com.flz.storage.dto.StorageChangeRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
