package com.flz.dt.storage.application.service;

import com.flz.dt.common.exception.BusinessException;
import com.flz.dt.storage.domain.aggrgate.Storage;
import com.flz.dt.storage.domain.repository.StorageDomainRepository;
import com.flz.storage.dto.StorageChangeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageDomainRepository storageDomainRepository;

    @Transactional
    public void batchChangeStorage(StorageChangeRequestDTO requestDTO) {
        List<StorageChangeRequestDTO.SkuStorage> skuStorages = requestDTO.getSkuStorages();
        // 库存未找到或不足，报异常
        List<String> skuIds = skuStorages.stream()
                .map(StorageChangeRequestDTO.SkuStorage::getSkuId)
                .distinct()
                .collect(Collectors.toList());
        Map<String, Storage> storageMap = storageDomainRepository.findAllBySkuIds(skuIds).stream()
                .collect(Collectors.toMap(Storage::getSkuId, Function.identity()));
        skuStorages.forEach(it -> {
            String skuId = it.getSkuId();
            Long count = it.getCount();
            Storage storage = storageMap.get(skuId);
            if (storage == null) {
                throw new BusinessException("storage not found with sku id:" + skuId);
            }
            if (count < 0 && storage.getCount() < count) {
                throw new BusinessException(String.format("storage[%s] of sku[%s] is not enough for change:%s",
                        storage.getCount(), skuId, count));
            }

            // 扣减
            storage.change(count);
        });

        storageDomainRepository.saveAll(new ArrayList<>(storageMap.values()));
    }
}
