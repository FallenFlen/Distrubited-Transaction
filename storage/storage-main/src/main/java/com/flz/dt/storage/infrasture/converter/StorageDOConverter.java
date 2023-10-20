package com.flz.dt.storage.infrasture.converter;

import com.flz.dt.storage.domain.aggrgate.Storage;
import com.flz.dt.storage.infrasture.dataobject.StorageDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StorageDOConverter {
    StorageDOConverter INSTANCE = Mappers.getMapper(StorageDOConverter.class);

    Storage toDomain(StorageDO storageEntity);

    StorageDO toEntity(Storage storage);
}
