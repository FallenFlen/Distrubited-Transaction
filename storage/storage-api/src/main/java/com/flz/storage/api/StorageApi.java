package com.flz.storage.api;

import com.flz.storage.dto.StorageChangeRequestDTO;
import com.flz.storage.dto.response.StorageInfoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StorageApi {

    @PostMapping("/storage/batch-change")
    void batchChangeStorage(@RequestBody @Valid StorageChangeRequestDTO requestDTO);

    @GetMapping("/storage/info")
    List<StorageInfoResponseDTO> fetchStorageInfo(@RequestParam("skuIds") List<String> skuIds);
}
