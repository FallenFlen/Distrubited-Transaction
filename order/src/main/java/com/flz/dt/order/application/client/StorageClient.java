package com.flz.dt.order.application.client;

import com.flz.dt.order.infrastructure.client.StorageFeignClient;
import com.flz.storage.dto.StorageChangeRequestDTO;
import com.flz.storage.dto.response.StorageInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StorageClient {
    private final StorageFeignClient storageFeignClient;

    public void batchChangeStorage(StorageChangeRequestDTO requestDTO) {
        storageFeignClient.batchChangeStorage(requestDTO);
    }

    public List<StorageInfoResponseDTO> fetchStorageInfo(List<String> skuIds) {
        return storageFeignClient.fetchStorageInfo(skuIds);
    }
}
