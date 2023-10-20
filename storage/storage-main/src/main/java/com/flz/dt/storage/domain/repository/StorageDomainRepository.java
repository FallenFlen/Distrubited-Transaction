package com.flz.dt.storage.domain.repository;

import com.flz.dt.storage.domain.aggrgate.Storage;
import com.flz.dt.storage.infrasture.converter.StorageDOConverter;
import com.flz.dt.storage.infrasture.dataobject.StorageDO;
import com.flz.dt.storage.infrasture.repository.StorageJDBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StorageDomainRepository {
    private final StorageJDBCRepository storageJDBCRepository;
    private final StorageDOConverter storageDOConverter = StorageDOConverter.INSTANCE;

    public List<Storage> findAllBySkuIds(List<String> skuIds) {
        return storageJDBCRepository.findAllBySkuIdIn(skuIds).stream()
                .map(storageDOConverter::toDomain)
                .collect(Collectors.toList());
    }

    public void saveAll(List<Storage> storages) {
        List<StorageDO> storageEntities = storages.stream()
                .map(storageDOConverter::toDO)
                .collect(Collectors.toList());
        storageJDBCRepository.saveAll(storageEntities);
    }
}
