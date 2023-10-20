package com.flz.dt.storage.infrasture.repository;

import com.flz.dt.storage.infrasture.dataobject.StorageDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StorageJDBCRepository extends CrudRepository<StorageDO, String> {
    List<StorageDO> findAllBySkuIdIn(List<String> skuIds);
}
