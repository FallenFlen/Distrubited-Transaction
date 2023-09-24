package com.flz.storage.api;

import com.flz.storage.dto.StorageChangeRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface StorageApi {

    @PostMapping("/storage/batch-change")
    void batchChangeStorage(@RequestBody @Valid StorageChangeRequestDTO requestDTO);
}
