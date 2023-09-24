package com.flz.dt.order.application.client;

import com.flz.dt.order.infrastructure.client.StorageFeignClient;
import com.flz.storage.dto.StorageChangeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StorageClient {
    private final StorageFeignClient storageFeignClient;

    public void batchChangeStorage(StorageChangeRequestDTO requestDTO) {
        storageFeignClient.batchChangeStorage(requestDTO);
    }
}
