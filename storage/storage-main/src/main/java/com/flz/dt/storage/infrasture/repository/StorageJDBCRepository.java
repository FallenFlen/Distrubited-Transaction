package com.flz.dt.storage.infrasture.repository;

import com.flz.dt.storage.infrasture.entity.StorageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StorageJDBCRepository extends CrudRepository<StorageEntity, String> {
    List<StorageEntity> findAllBySkuIdIn(List<String> skuIds);
}
