package com.flz.dt.storage.infrasture.converter;

import com.flz.dt.storage.domain.aggrgate.Storage;
import com.flz.dt.storage.infrasture.entity.StorageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StorageDOConverter {
    StorageDOConverter INSTANCE = Mappers.getMapper(StorageDOConverter.class);

    Storage toDomain(StorageEntity storageEntity);

    StorageEntity toEntity(Storage storage);
}
